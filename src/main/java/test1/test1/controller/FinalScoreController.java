package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.ExamScoreWays;
import test1.test1.bean.FinalScore;
import test1.test1.bean.Teacher;
import test1.test1.service.FinalScoreService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/finalscore")
public class FinalScoreController {
    @Autowired
    FinalScoreService finalScoreService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllFinalScore(String username, ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"finalscoreid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<FinalScore> finalscores = finalScoreService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("fsTeacherId",teacher);


//        List<FinalScore> finalscores = finalScoreService.findAllByUsername(username);
        modelMap.addAttribute("finalscores",finalscores);
        return "teacher/finalscore";
    }

    @PostMapping("/finalscore")
    public String addAndGetFinalScore( String year, String term, String time, int point, int studentid, int classid, int courseid, int teacherid, String name, int first, int second, int third, int fourth,ModelMap modelMap){
        FinalScore finalScore = new FinalScore();
        finalScore.setTeacherid(teacherid);
        finalScore.setCourseid(courseid);
        finalScore.setYear(year);
        finalScore.setTerm(term);
        finalScore.setTime(time);
        finalScore.setPoint(point);
        finalScore.setStudentid(studentid);
        finalScore.setClassid(classid);
        finalScore.setName(name);
        finalScore.setFirst(first);
        finalScore.setSecond(second);
        finalScore.setThird(third);
        finalScore.setFourth(fourth);
        finalScoreService.addFinalScore(finalScore);

        List<FinalScore> finalscores = finalScoreService.findByTeacherid(teacherid);
        modelMap.put("finalscores",finalscores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = finalScoreService.getById(id).getTeacherid();
        finalScoreService.deleteById(id);
        List<FinalScore> finalscores = finalScoreService.findByTeacherid(teacid);
        modelMap.put("finalscores",finalscores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        FinalScore fs = finalScoreService.getById(id);
        modelMap.addAttribute("fs",fs);
        return "teacher/editFinalscore";
    }

    @PutMapping
    public FinalScore addFinalScore(@RequestBody FinalScore finalScore){
        return finalScoreService.addFinalScore(finalScore);
    }

    @DeleteMapping("/{id}")
    public FinalScore deleteFinalScore(@PathVariable int id){
        return finalScoreService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(FinalScore finalScore,ModelMap modelMap){
        finalScore.setFinalscoreid(finalScore.getFinalscoreid());
        finalScoreService.addFinalScore(finalScore);
        List<FinalScore> finalscores = finalScoreService.findByTeacherid(finalScore.getTeacherid());
        modelMap.put("finalscores",finalscores);
        return "teacher/teachermain/adminNavigator";
    }
}
