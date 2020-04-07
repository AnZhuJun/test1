package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Course;
import test1.test1.bean.Teacher;
import test1.test1.bean.TeacherCourse;
import test1.test1.service.TeacherCourseService;

import java.util.List;

@Controller
@RequestMapping("/teacherCourse")
public class TeacherCourseController {
    @Autowired
    TeacherCourseService teacherCourseService;

    @GetMapping("/all")
    public String getAllTeacherCourse(ModelMap modelMap){
        modelMap.addAttribute("teacherCourses",teacherCourseService.findAll());
        return "admin/teacherCourse";
    }

    @PostMapping("/teacherCourse")
    public String addAndGetTeacherCourse(int courseid,int teacherid,ModelMap modelMap){
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setCourseid(courseid);
        teacherCourse.setTeacherid(teacherid);
        teacherCourseService.addTeacherCourse(teacherCourse);

        List<TeacherCourse> teacherCourses = teacherCourseService.findAll();
        modelMap.put("teacherCourses",teacherCourses);
        return "admin/teacherCourse";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        teacherCourseService.deleteById(id);
        List<TeacherCourse> teacherCourses = teacherCourseService.findAll();
        map.put("teacherCourses",teacherCourses);
        return "admin/teacherCourse";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        TeacherCourse tc = teacherCourseService.getById(id);
        modelMap.addAttribute("tc",tc);
        return "admin/editTeacherCourse";
    }

    @PutMapping
    public TeacherCourse addTeacherCourse(@RequestBody TeacherCourse teacherCourse){
        return teacherCourseService.addTeacherCourse(teacherCourse);
    }

    @DeleteMapping("/{id}")
    public TeacherCourse deleteCourse(@PathVariable int id){
        return teacherCourseService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(TeacherCourse teacherCourse,ModelMap map){
        teacherCourse.setCourseid(teacherCourse.getCourseid());
        teacherCourseService.addTeacherCourse(teacherCourse);
        List<TeacherCourse> teacherCourses = teacherCourseService.findAll();
        map.put("teacherCourses",teacherCourses);
        return "admin/teacherCourse";
    }
}
