package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinalScore;
import test1.test1.bean.MidScore;
import test1.test1.bean.PsScore;
import test1.test1.bean.Teacher;
import test1.test1.service.PsScoreService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/psscore")
public class PsScoreController {
    @Autowired
    PsScoreService psScoreService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllPsScore(String username, ModelMap modelMap){
        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("psTeacherId",teacher);


        List<PsScore> psscores = psScoreService.findAllByUsername(username);
        modelMap.addAttribute("psscores",psscores);
        return "teacher/psscore";
    }

    @PostMapping("/psscore")
    public String addAndGetPsScore( String year, String term, String time, int studentid, int classid, int courseid, int teacherid, String name, int kaoqin, int zuoye, int shiyan,ModelMap modelMap){
        PsScore psScore = new PsScore();
        psScore.setTeacherid(teacherid);
        psScore.setCourseid(courseid);
        psScore.setYear(year);
        psScore.setTerm(term);
        psScore.setTime(time);
        psScore.setStudentid(studentid);
        psScore.setClassid(classid);
        psScore.setZuoye(zuoye);
        psScore.setShiyan(shiyan);
        psScore.setName(name);
        psScore.setKaoqin(kaoqin);

        psScoreService.addPsScore(psScore);

        List<PsScore> psscores = psScoreService.findByTeacherid(teacherid);
        modelMap.put("psscores",psscores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = psScoreService.getById(id).getTeacherid();
        psScoreService.deleteById(id);
        List<PsScore> psscores = psScoreService.findByTeacherid(teacid);
        modelMap.put("psscores",psscores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        PsScore ps = psScoreService.getById(id);
        modelMap.addAttribute("ps",ps);
        return "teacher/editPsscore";
    }

    @PutMapping
    public PsScore addPsScore(@RequestBody PsScore psScore){
        return psScoreService.addPsScore(psScore);
    }

    @DeleteMapping("/{id}")
    public PsScore deletePsScore(@PathVariable int id){
        return psScoreService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(PsScore psScore,ModelMap modelMap){
        psScore.setPsscoreid(psScore.getPsscoreid());
        psScoreService.addPsScore(psScore);
        List<PsScore> psscores = psScoreService.findByTeacherid(psScore.getTeacherid());
        modelMap.put("psscores",psscores);
        return "teacher/psscore";
    }
}
