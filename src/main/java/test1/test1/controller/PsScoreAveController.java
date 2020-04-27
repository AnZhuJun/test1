package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.ExamScoreWays;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.PsScoreAve;
import test1.test1.bean.Teacher;
import test1.test1.service.PsScoreAveService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/psscoreave")
public class PsScoreAveController {
    @Autowired
    PsScoreAveService psScoreAveService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllPsScoreAve(String username, ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"psavid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<PsScoreAve> psscoreaves = psScoreAveService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("psavTeacherId",teacher);

//        List<PsScoreAve> psscoreaves = psScoreAveService.findAllByUsername(username);
        modelMap.addAttribute("psscoreaves",psscoreaves);
        return "teacher/psscoreave";
    }

    @PostMapping("/psscoreave")
    public String addAndGetPsScoreAve(int courseid,int averange,int teacherid,int classid,ModelMap modelMap){
        PsScoreAve psScoreAve = new PsScoreAve();
        psScoreAve.setTeacherid(teacherid);
        psScoreAve.setCourseid(courseid);
        psScoreAve.setClassid(classid);
        psScoreAve.setAverange(averange);
        psScoreAveService.addPsScoreAve(psScoreAve);

        List<PsScoreAve> psscoreaves = psScoreAveService.findByTeacherid(teacherid);
        modelMap.put("psscoreaves",psscoreaves);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = psScoreAveService.getById(id).getTeacherid();
        psScoreAveService.deleteById(id);
        List<PsScoreAve> psscoreaves = psScoreAveService.findByTeacherid(teacid);
        modelMap.put("psscoreaves",psscoreaves);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        PsScoreAve psav = psScoreAveService.getById(id);
        modelMap.addAttribute("psav",psav);
        return "teacher/editPsscoreave";
    }

    @PutMapping
    public PsScoreAve addpsScoreAve(@RequestBody PsScoreAve psScoreAve){
        return psScoreAveService.addPsScoreAve(psScoreAve);
    }

    @DeleteMapping("/{id}")
    public PsScoreAve deletepsScoreAve(@PathVariable int id){
        return psScoreAveService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(PsScoreAve psScoreAve,ModelMap modelMap){
        psScoreAve.setPsavid(psScoreAve.getPsavid());
        psScoreAveService.addPsScoreAve(psScoreAve);
        List<PsScoreAve> psscoreaves = psScoreAveService.findByTeacherid(psScoreAve.getTeacherid());
        modelMap.put("psscoreaves",psscoreaves);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int teacherid,int courseid,ModelMap modelMap){
        List<PsScoreAve> spsav = psScoreAveService.findById(teacherid,courseid);
        modelMap.addAttribute("spsav",spsav);
        return "teacher/searchPsscoreave";
    }
}
