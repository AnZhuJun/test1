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
import test1.test1.bean.PsScore;
import test1.test1.bean.PsScoreWays;
import test1.test1.bean.Teacher;
import test1.test1.service.PsScoreWaysService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/psscoreways")
public class PsScoreWaysController {
    @Autowired
    PsScoreWaysService psScoreWaysService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllPsScoreWays(String username, ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"psswid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<PsScoreWays> psScoreWays = psScoreWaysService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("pswTeacherId",teacher);

//        List<PsScoreWays> psScoreWays = psScoreWaysService.findAllByUsername(username);
        modelMap.addAttribute("psscoreway",psScoreWays);
        return "teacher/psscoreways";
    }

    @PostMapping("/psscoreways")
    public String addAndGetPsScoreWays(int teacherid,int courseid,String best,String good,String soso,String worse,ModelMap modelMap){
        PsScoreWays psScoreWays = new PsScoreWays();
        psScoreWays.setTeacherid(teacherid);
        psScoreWays.setCourseid(courseid);
        psScoreWays.setBest(best);
        psScoreWays.setGood(good);
        psScoreWays.setSoso(soso);
        psScoreWays.setWorse(worse);
        psScoreWaysService.addPsScoreWays(psScoreWays);

        List<PsScoreWays> psscoreway = psScoreWaysService.findByTeacherid(teacherid);
        modelMap.put("psscoreway",psscoreway);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = psScoreWaysService.getById(id).getTeacherid();
        psScoreWaysService.deleteById(id);
        List<PsScoreWays> psscoreway = psScoreWaysService.findByTeacherid(teacid);
        modelMap.put("psscoreway",psscoreway);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        PsScoreWays psw = psScoreWaysService.getById(id);
        modelMap.addAttribute("psw",psw);
        return "teacher/editPsscoreways";
    }

    @PutMapping
    public PsScoreWays addPsScoreWays(@RequestBody PsScoreWays psScoreWays){
        return psScoreWaysService.addPsScoreWays(psScoreWays);
    }

    @DeleteMapping("/{id}")
    public PsScoreWays deletePsScoreWays(@PathVariable int id){
        return psScoreWaysService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(PsScoreWays psScoreWays,ModelMap modelMap){
        psScoreWays.setPsswid(psScoreWays.getPsswid());
        psScoreWaysService.addPsScoreWays(psScoreWays);
        List<PsScoreWays> psscoreway = psScoreWaysService.findByTeacherid(psScoreWays.getTeacherid());
        modelMap.put("psscoreway",psscoreway);
        return "teacher/teachermain/adminNavigator";
    }


    @RequestMapping("/search")
    public String search(int teacherid,int courseid,ModelMap modelMap){
        List<PsScoreWays> spsw = psScoreWaysService.findById(teacherid,courseid);
        modelMap.addAttribute("spsw",spsw);
        return "teacher/searchPsscoreways";
    }
}
