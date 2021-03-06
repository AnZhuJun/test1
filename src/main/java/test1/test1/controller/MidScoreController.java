package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinScoreAve;
import test1.test1.bean.FinalScore;
import test1.test1.bean.MidScore;
import test1.test1.bean.Teacher;
import test1.test1.service.MidScoreService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/midscore")
public class MidScoreController {
    @Autowired
    MidScoreService midScoreService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllMidScore(String username, ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"midscoreid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<MidScore> midscores = midScoreService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("msTeacherId",teacher);


//        List<MidScore> midscores = midScoreService.findAllByUsername(username);
        modelMap.addAttribute("midscores",midscores);
        return "teacher/midscore";
    }

    @PostMapping("/midscore")
    public String addAndGetMidScore( String year, String term, String time,int studentid, int classid, int courseid, int teacherid, String name, int first, int second, int third, int fourth,ModelMap modelMap){
        MidScore midScore = new MidScore();
        midScore.setTeacherid(teacherid);
        midScore.setCourseid(courseid);
        midScore.setYear(year);
        midScore.setTerm(term);
        midScore.setTime(time);
        midScore.setStudentid(studentid);
        midScore.setClassid(classid);
        midScore.setName(name);
        midScore.setFirst(first);
        midScore.setSecond(second);
        midScore.setThird(third);
        midScore.setFourth(fourth);
        midScoreService.addMidScore(midScore);

        List<MidScore> midScores = midScoreService.findByTeacherid(teacherid);
        modelMap.put("midscores",midScores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = midScoreService.getById(id).getTeacherid();
        midScoreService.deleteById(id);
        List<MidScore> midscores = midScoreService.findByTeacherid(teacid);
        modelMap.put("midscores",midscores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        MidScore ms = midScoreService.getById(id);
        modelMap.addAttribute("ms",ms);
        return "teacher/editMidscore";
    }

    @PutMapping
    public MidScore addMidScore(@RequestBody MidScore midScore){
        return midScoreService.addMidScore(midScore);
    }

    @DeleteMapping("/{id}")
    public MidScore deleteMidScore(@PathVariable int id){
        return midScoreService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(MidScore midScore,ModelMap modelMap){
        midScore.setMidscoreid(midScore.getMidscoreid());
        midScoreService.addMidScore(midScore);
        List<MidScore> midscores = midScoreService.findByTeacherid(midScore.getTeacherid());
        modelMap.put("midscores",midscores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int teacherid,String name,ModelMap modelMap){
        List<MidScore> sms = midScoreService.findByIdName(teacherid,name);
        modelMap.addAttribute("sms",sms);
        return "teacher/searchMidscore";
    }
}
