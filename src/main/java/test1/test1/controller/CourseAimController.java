package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.CourseAim;
import test1.test1.bean.FinalScore;
import test1.test1.bean.Teacher;
import test1.test1.service.CourseAimService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/courseAim")
public class CourseAimController {
    @Autowired
    CourseAimService aimService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllStudent(String username,ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"aimid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<CourseAim> courseAim = aimService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("caTeacherId",teacher);

        modelMap.addAttribute("courseAims",courseAim);
        return "teacher/courseAim";
    }

    @PostMapping("/courseAim")
    public String addAndGetStudent(int courseid,int teacherid,String aim,String zbpoint,ModelMap modelMap){
        CourseAim courseAim = new CourseAim();
        courseAim.setCourseid(courseid);
        courseAim.setTeacherid(teacherid);
        courseAim.setAim(aim);
        courseAim.setZbpoint(zbpoint);
        aimService.addAim(courseAim);

        List<CourseAim> courseAims = aimService.findByTeacherid(teacherid);
        modelMap.put("courseAims", courseAims);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        int teacid = aimService.getById(id).getTeacherid();
        aimService.deleteById(id);
        List<CourseAim> courseAims = aimService.findByTeacherid(teacid);
        map.put("courseAims", courseAims);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        CourseAim ca = aimService.getById(id);
        modelMap.addAttribute("ca",ca);
        return "teacher/editCourseAim";
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
        List<CourseAim> courseAims = aimService.findByTeacherid(courseAim.getTeacherid());
        map.put("courseAims", courseAims);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int teacherid,int courseid,ModelMap modelMap){
        List<CourseAim> sca = aimService.findById(teacherid,courseid);
        modelMap.addAttribute("sca",sca);
        return "teacher/searchCourseAim";
    }
}
