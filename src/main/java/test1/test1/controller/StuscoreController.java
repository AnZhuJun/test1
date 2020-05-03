package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Stuscore;
import test1.test1.bean.Teacher;
import test1.test1.service.StuscoreService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/stuscore")
public class StuscoreController {
    @Autowired
    StuscoreService stuscoreService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllStuscore(String username, ModelMap modelMap, @RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"stuscoreid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Stuscore> stuscores = stuscoreService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("ssTeacherId",teacher);

        modelMap.addAttribute("stuscores",stuscores);
        return "teacher/stuscore";
    }

    @PostMapping("/stuscore")
    public String addAndGetStuscore(int teacherid,int courseid,int studentid,int sscore,String year,String term,ModelMap modelMap){
        Stuscore stuscore = new Stuscore();
        stuscore.setTeacherid(teacherid);
        stuscore.setCourseid(courseid);
        stuscore.setStudentid(studentid);
        stuscore.setSscore(sscore);
        stuscore.setYear(year);
        stuscore.setTerm(term);
        stuscoreService.addStuscore(stuscore);

        List<Stuscore> stuscores = stuscoreService.findByTeacherid(teacherid);
        modelMap.put("stuscores",stuscores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, ModelMap modelMap){
        int teacid = stuscoreService.getById(id).getTeacherid();
        stuscoreService.deleteById(id);
        List<Stuscore> stuscores = stuscoreService.findByTeacherid(teacid);
        modelMap.put("stuscores",stuscores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        Stuscore ss = stuscoreService.getById(id);
        modelMap.addAttribute("ss",ss);
        return "teacher/editStuscore";
    }

    @PutMapping
    public Stuscore addStuscore(@RequestBody Stuscore stuscore){
        return stuscoreService.addStuscore(stuscore);
    }

    @DeleteMapping("/{id}")
    public Stuscore deleteStuscore(@PathVariable int id){
        return stuscoreService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(Stuscore stuscore,ModelMap modelMap){
        stuscore.setStuscoreid(stuscore.getStuscoreid());
        stuscoreService.addStuscore(stuscore);
        List<Stuscore> stuscores = stuscoreService.findByTeacherid(stuscore.getTeacherid());
        modelMap.put("stuscores",stuscores);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int teacherid,int studentid,ModelMap modelMap){
        List<Stuscore> sss = stuscoreService.findById(teacherid,studentid);
        modelMap.addAttribute("sss",sss);
        return "teacher/searchStuscore";
    }
}
