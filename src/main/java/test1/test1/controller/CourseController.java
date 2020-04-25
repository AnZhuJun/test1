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
import test1.test1.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/all")
    public String getAllCourse(ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"courseid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Course> courses = courseService.findAll(pageable);


        modelMap.addAttribute("courses",courses);
        return "admin/course";
    }

    @PostMapping("/course")
    public String addAndGetCourse(int courseid,String name,ModelMap modelMap){
        Course course = new Course();
        course.setCourseid(courseid);
        course.setCoursename(name);
        courseService.addCourse(course);

        List<Course> courses = courseService.findAll();
        modelMap.put("courses",courses);
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        courseService.deleteById(id);
        List<Course> courses = courseService.findAll();
        map.put("courses",courses);
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        Course co = courseService.getById(id);
        modelMap.addAttribute("co",co);
        return "admin/editCourse";
    }

    @PutMapping
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @DeleteMapping("/{id}")
    public Course deleteCourse(@PathVariable int id){
        return courseService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(Course course,ModelMap map){
        course.setCourseid(course.getCourseid());
        courseService.addCourse(course);
        List<Course> courses = courseService.findAll();
        map.put("courses",courses);
        return "admin/common/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int courseid,ModelMap modelMap){
        Course sco = courseService.getById(courseid);
        modelMap.addAttribute("sco",sco);
        return "admin/searchCourse";
    }
}
