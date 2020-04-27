package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Course;
import test1.test1.bean.ExamScoreWays;
import test1.test1.bean.Examways;
import test1.test1.bean.Teacher;
import test1.test1.service.ExamwaysService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/examways")
public class ExamwaysController {
    @Autowired
    ExamwaysService examwaysService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllExamways(String username, ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"examwaysid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Examways> examways = examwaysService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("ewsTeacherId",teacher);


//        List<Examways> examways = examwaysService.findAllByUsername(username);
        modelMap.addAttribute("examway",examways);
        return "teacher/examways";
    }

    @PostMapping("/examways")
    public String addAndGetExamway(int teacherid,int courseid,int psper,int midper,int finper,String orderpoint,ModelMap modelMap){
        Examways examway = new Examways();
        examway.setTeacherid(teacherid);
        examway.setCourseid(courseid);
        examway.setPsper(psper);
        examway.setMidper(midper);
        examway.setFinper(finper);
        examway.setOrderpoint(orderpoint);
        examwaysService.addExamways(examway);

        List<Examways> examways = examwaysService.findByTeacherid(teacherid);
        modelMap.put("examway",examways);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = examwaysService.getById(id).getTeacherid();
        examwaysService.deleteById(id);
        List<Examways> examways = examwaysService.findByTeacherid(teacid);
        modelMap.put("examway",examways);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        Examways ews = examwaysService.getById(id);
        modelMap.addAttribute("ews",ews);
        return "teacher/editExamways";
    }

    @PutMapping
    public Examways addExamways(@RequestBody Examways examways){
        return examwaysService.addExamways(examways);
    }

    @DeleteMapping("/{id}")
    public Examways deleteExamways(@PathVariable int id){
        return examwaysService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(Examways examway,ModelMap modelMap){
        examway.setExamwaysid(examway.getExamwaysid());
        examwaysService.addExamways(examway);
        List<Examways> examways = examwaysService.findByTeacherid(examway.getTeacherid());
        modelMap.put("examway",examways);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int teacherid,int examwaysid,ModelMap modelMap){
        Examways sew = examwaysService.findById(teacherid,examwaysid);
        modelMap.addAttribute("sew",sew);
        return "teacher/searchExamways";
    }
}
