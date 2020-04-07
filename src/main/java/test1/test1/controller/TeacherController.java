package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Student;
import test1.test1.bean.Teacher;
import test1.test1.bean.TeacherCourse;
import test1.test1.service.StudentService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllTeacher(ModelMap modelMap){
        modelMap.addAttribute("teachers",teacherService.findAll());
        return "admin/teacher";
    }

    @PostMapping("/teacher")
    public String addAndGetTeacher(String teachername,String username,String password,ModelMap modelMap){
        Teacher teacher = new Teacher();
        teacher.setTeachername(teachername);
        teacher.setUsername(username);
        teacher.setPassword(password);
        teacherService.addTeacher(teacher);

        List<Teacher> teachers = teacherService.findAll();
        modelMap.put("teachers",teachers);
        return "admin/teacher";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        teacherService.deleteById(id);
        List<Teacher> teachers = teacherService.findAll();
        map.put("teachers",teachers);
        return "admin/teacher";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        Teacher te = teacherService.getById(id);
        modelMap.addAttribute("te",te);
        return "admin/editTeacher";
    }

    @PutMapping
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public Teacher deleteTeacher(@PathVariable int id){
        return teacherService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(Teacher teacher,ModelMap map){
        teacher.setTeacherid(teacher.getTeacherid());
        teacherService.addTeacher(teacher);
        List<Teacher> teachers = teacherService.findAll();
        map.put("teachers",teachers);
        return "admin/teacher";
    }
}
