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
    public String getAllTeacherCourse(ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"tcid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<TeacherCourse> teacherCourses = teacherCourseService.findAll(pageable);

        modelMap.addAttribute("teacherCourses",teacherCourses);
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
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        teacherCourseService.deleteById(id);
        List<TeacherCourse> teacherCourses = teacherCourseService.findAll();
        map.put("teacherCourses",teacherCourses);
        return "admin/common/adminNavigator";
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
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int tcid,ModelMap modelMap){
        TeacherCourse stc = teacherCourseService.getById(tcid);
        modelMap.addAttribute("stc",stc);
        return "admin/searchTeacherCourse";
    }
}
