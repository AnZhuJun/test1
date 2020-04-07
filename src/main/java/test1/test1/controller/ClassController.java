package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Class;
import test1.test1.bean.Student;
import test1.test1.service.ClassService;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @GetMapping("/all")
    public String getAllClass(ModelMap modelMap){
        modelMap.addAttribute("classes",classService.findAll());
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
        return "admin/class";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        classService.deleteById(id);
        List<Class> classes = classService.findAll();
        map.put("classes",classes);
        return "admin/class";
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
        return "admin/class";
    }
}
