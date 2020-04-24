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
import test1.test1.bean.Examways;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.Teacher;
import test1.test1.service.ExamScoreWaysService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/examscoreways")
public class ExamScoreWaysController {
    @Autowired
    ExamScoreWaysService examScoreWaysService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllExamScoreWays(String username, ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"scorewayid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<ExamScoreWays> examScoreWay = examScoreWaysService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("eswTeacherId",teacher);


//        List<ExamScoreWays> examScoreWay = examScoreWaysService.findAllByUsername(username);
        modelMap.addAttribute("examscoreway",examScoreWay);
        return "teacher/examscoreways";
    }

    @PostMapping("/examscoreways")
    public String addAndGetExamScoreWays(int teacherid,int courseid,String best,String good,String soso,String worse,ModelMap modelMap){
        ExamScoreWays examScoreWays = new ExamScoreWays();
        examScoreWays.setTeacherid(teacherid);
        examScoreWays.setCourseid(courseid);
        examScoreWays.setBest(best);
        examScoreWays.setGood(good);
        examScoreWays.setSoso(soso);
        examScoreWays.setWorse(worse);
        examScoreWaysService.addExamScoreWays(examScoreWays);

        List<ExamScoreWays> examscoreway = examScoreWaysService.findByTeacherid(teacherid);
        modelMap.put("examscoreway",examscoreway);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = examScoreWaysService.getById(id).getTeacherid();
        examScoreWaysService.deleteById(id);
        List<ExamScoreWays> examscoreway = examScoreWaysService.findByTeacherid(teacid);
        modelMap.put("examscoreway",examscoreway);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        ExamScoreWays esw = examScoreWaysService.getById(id);
        modelMap.addAttribute("esw",esw);
        return "teacher/editExamscoreways";
    }

    @PutMapping
    public ExamScoreWays addExamScoreWays(@RequestBody ExamScoreWays examscoreway){
        return examScoreWaysService.addExamScoreWays(examscoreway);
    }

    @DeleteMapping("/{id}")
    public ExamScoreWays deleteExamScoreWays(@PathVariable int id){
        return examScoreWaysService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(ExamScoreWays examScoreWays,ModelMap modelMap){
        examScoreWays.setScorewayid(examScoreWays.getScorewayid());
        examScoreWaysService.addExamScoreWays(examScoreWays);
        List<ExamScoreWays> examscoreway = examScoreWaysService.findByTeacherid(examScoreWays.getTeacherid());
        modelMap.put("examscoreway",examscoreway);
        return "teacher/teachermain/adminNavigator";
    }
}
