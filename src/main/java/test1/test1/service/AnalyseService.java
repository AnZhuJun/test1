package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.*;
import test1.test1.bean.Class;
import test1.test1.dao.*;

import java.util.List;

@Service
public class AnalyseService {
    @Autowired
    AnalyseDao analyseDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    CourseAimDao courseAimDao;

    @Autowired
    ClassDao classDao;

    @Autowired
    ExamwaysDao examwaysDao;

    @Autowired
    StuscoreDao stuscoreDao;

    @Autowired
    StuscoreService stuscoreService;

    @Autowired
    CourseAimService courseAimService;

    @Autowired
    ExamwaysService examwaysService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ClassService classService;

    @Autowired
    CourseService courseService;

    @Autowired
    FinScoreAveDao finScoreAveDao;

    @Autowired
    FinScoreAccDao finScoreAccDao;

    @Autowired
    MidScoreAveDao midScoreAveDao;

    @Autowired
    MidScoreAccDao midScoreAccDao;

    @Autowired
    PsScoreAccDao psScoreAccDao;

    @Autowired
    PsScoreAveDao psScoreAveDao;
    //启动分析需要输入，课程编码，教师编号（自动），班级编号,YEAR,TERM，通过课程id找aimid和zbpoint和examwaysid
    //通过算法得到achidegree达成度
    //通过courseid和classid找到最终成绩表，然后计算获得sumbest,sumgood,sumsoso,sumworse
    //通过teacherid,courseid获得学分
    //problem为存在的问题及改进（教师工作）
    //comment为对课程的分析（教务办工作）
    //teachername用teacherid得
    //

    public Analyse create(Analyse analyse){
        String year = analyse.getYear();
        String term = analyse.getTerm();
        int courseid = analyse.getCourseid();
        int teacherid = analyse.getTeacherid();
        int classid = analyse.getClassid();

        int sumbest = stuscoreService.sumbest(courseid,classid,year,term);
        int sumgood = stuscoreService.sumgood(courseid,classid,year,term);
        int sumsoso = stuscoreService.sumsoso(courseid,classid,year,term);
        int sumworse = stuscoreService.sumworse(courseid,classid,year,term);
        analyse.setSumbest(sumbest);
        analyse.setSumgood(sumgood);
        analyse.setSumsoso(sumsoso);
        analyse.setSumworse(sumworse);
        analyse.setSumselect(sumbest + sumgood + sumsoso + sumworse);

        CourseAim courseAim = courseAimService.findByTCid(teacherid,courseid);
        int aimid = courseAim.getAimid();
        String zbpoint  = courseAim.getZbpoint();
        analyse.setAimid(aimid);
        analyse.setZbpoint(zbpoint);

        int examwaysid = examwaysService.findByCourseid(courseid).getExamwaysid();
        analyse.setExamwaysid(examwaysid);

        String teachername = teacherService.getById(teacherid).getTeachername();
        analyse.setTeachername(teachername);

        analyse.setClassname(classService.getById(classid).getClassname());
        analyse.setCoursename(courseService.getById(courseid).getCoursename());


        Examways examways =examwaysService.findById(teacherid,examwaysid);
        List<FinScoreAve> finScoreAves = finScoreAveDao.findAllByTeacheridAndCourseidAndClassid(teacherid,courseid,classid);
        double fave = 0;
        for(int i = 0 ;i < finScoreAves.size();i++) {
            fave = fave + finScoreAves.get(i).getAverange();
        }
        List<FinScoreAcc> finScoreAccs = finScoreAccDao.findAllByTeacheridAndCourseidAndClassid(teacherid,courseid,classid);
        double facc = 0;
        for(int i = 0 ; i<finScoreAccs.size();i++){
            facc = facc + finScoreAccs.get(i).getScore();
        }
        List<MidScoreAve> midScoreAves = midScoreAveDao.findAllByTeacheridAndCourseidAndClassid(teacherid,courseid,classid);
        double mave = 0;
        for(int i = 0 ;i < midScoreAves.size();i++) {
            mave = mave + midScoreAves.get(i).getAverange();
        }
        List<MidScoreAcc> midScoreAccs = midScoreAccDao.findAllByTeacheridAndCourseidAndClassid(teacherid,courseid,classid);
        double macc = 0;
        for(int i = 0 ; i<midScoreAccs.size();i++){
            macc = macc + midScoreAccs.get(i).getScore();
        }
        List<PsScoreAve> psScoreAves = psScoreAveDao.findAllByTeacheridAndCourseidAndClassid(teacherid,courseid,classid);
        double pave = 0;
        for(int i = 0 ;i < psScoreAves.size();i++) {
            pave = pave + psScoreAves.get(i).getAverange();
        }
        List<PsScoreAcc> psScoreAccs = psScoreAccDao.findAllByTeacheridAndCourseidAndClassid(teacherid,courseid,classid);
        double pacc = 0;
        for(int i = 0 ; i<psScoreAccs.size();i++){
            pacc = pacc + psScoreAccs.get(i).getScore();
        }
        double achidegree = (((fave/facc)) + ((mave/macc)) + ((pave/pacc)))/3;
        analyse.setAchidegree(achidegree);

        String examwaysinfo = "期末占比%（" + examways.getFinper() + ") + 期中占比%（" + examways.getMidper() + ") + 平时成绩占比%(" + examways.getPsper() + ")";
        analyse.setExamwaysinfo(examwaysinfo);

        if(analyse.getProblem() == null)
            analyse.setProblem("还未填写分析与改进");

        if(analyse.getComment() == (null))
        analyse.setComment("质评办还未进行课程评价");
        return analyseDao.save(analyse);
    }

    public List<Analyse> findByTeacherid(int teacherid){
        return analyseDao.findAllByTeacherid(teacherid);
    }

    public Page<Analyse> findAllByUsername(Pageable pageable, String username){
        return analyseDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public Analyse getById(int id){
        return analyseDao.findById(id).orElse(new Analyse(-1,-1,-1,-1,-1,-1,"null",-1,-1,-1,-1,-1,-1,-1,"null","null","null","null","null","null","null","null","null"));
    }

    public Analyse deleteById(int id){
        Analyse analyse = getById(id);
        if(analyse.getAnalyseid() > -1){
            analyseDao.deleteById(id);
        }
        return analyse;
    }

    public Analyse findById(int teacherid,int courseid,int classid,String year,String term){
        return analyseDao.findAllByTeacheridAndCourseidAndClassidAndYearAndTerm(teacherid, courseid, classid, year, term);
    }
}
