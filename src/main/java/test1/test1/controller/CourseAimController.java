package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.CourseAim;
import test1.test1.service.CourseAimService;

import java.util.List;

@Controller
@RequestMapping("/courseAim")
public class CourseAimController {
    @Autowired
    CourseAimService aimService;

    @GetMapping("/all")
    public String getAllStudent(ModelMap modelMap){
        modelMap.addAttribute("courseAims",aimService.findAll());
        return "admin/courseAim";
    }

    @PostMapping("/courseAim")
    public String addAndGetStudent(int courseid,int teacherid,String aim,ModelMap modelMap){
        CourseAim courseAim = new CourseAim();
        courseAim.setCourseid(courseid);
        courseAim.setTeacherid(teacherid);
        courseAim.setAim(aim);
        aimService.addAim(courseAim);

        List<CourseAim> courseAims = aimService.findAll();
        modelMap.put("courseAims", courseAims);
        return "admin/courseAim";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        aimService.deleteById(id);
        List<CourseAim> courseAims = aimService.findAll();
        map.put("courseAims", courseAims);
        return "admin/courseAim";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        CourseAim ca = aimService.getById(id);
        modelMap.addAttribute("ca",ca);
        return "admin/editCourseAim";
    }

    @PutMapping
    public CourseAim addAim(@RequestBody CourseAim courseAim){
        return aimService.addAim(courseAim);
    }

    @DeleteMapping("/{id}")
    public CourseAim deleteAim(@PathVariable int id){
        return aimService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(CourseAim courseAim, ModelMap map){
        courseAim.setAimid(courseAim.getAimid());
        aimService.addAim(courseAim);
        List<CourseAim> courseAims = aimService.findAll();
        map.put("courseAims", courseAims);
        return "admin/courseAim";
    }
}
