package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Class;
import test1.test1.bean.ExamScoreWays;
import test1.test1.bean.Student;
import test1.test1.service.ClassService;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @GetMapping("/all")
    public String getAllClass(ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"classid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Class> classes = classService.findAll(pageable);

        modelMap.addAttribute("classes",classes);
        return "admin/class";
    }

    @PostMapping("/class")
    public String addAndGetClass(String name,String department,ModelMap modelMap){
        Class classs = new Class();
        classs.setClassname(name);
        classs.setDepartment(department);
        classService.addClass(classs);

        List<Class> classes = classService.findAll();
        modelMap.put("classes",classes);
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        classService.deleteById(id);
        List<Class> classes = classService.findAll();
        map.put("classes",classes);
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        Class cl = classService.getById(id);
        modelMap.addAttribute("cl",cl);
        return "admin/editClass";
    }

    @PutMapping
    public Class addClass(@RequestBody Class classs){
        return classService.addClass(classs);
    }

    @DeleteMapping("/{id}")
    public Class deleteClass(@PathVariable int id){
        return classService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(Class classes,ModelMap map){
        classes.setClassid(classes.getClassid());
        classService.addClass(classes);
        List<Class> classes1 = classService.findAll();
        map.put("classes",classes1);
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int classid,ModelMap modelMap){
        Class scl = classService.findById(classid);
        modelMap.addAttribute("scl",scl);
        return "admin/searchClass";
    }
}
