package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.FinScoreAve;
import test1.test1.bean.MidScoreAve;
import test1.test1.bean.Teacher;
import test1.test1.service.FinScoreAveService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/finscoreave")
public class FinScoreAveController {
    @Autowired
    FinScoreAveService finScoreAveService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllFinScoreAve(String username, ModelMap modelMap){
        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("fsavTeacherId",teacher);

        List<FinScoreAve> finscoreaves = finScoreAveService.findAllByUsername(username);
        modelMap.addAttribute("finscoreaves",finscoreaves);
        return "teacher/finscoreave";
    }

    @PostMapping("/finscoreave")
    public String addAndGetFinScoreAve(int courseid,int dt,int xt,int averange,int teacherid,int classid,ModelMap modelMap){
        FinScoreAve finScoreAve = new FinScoreAve();
        finScoreAve.setTeacherid(teacherid);
        finScoreAve.setCourseid(courseid);
        finScoreAve.setClassid(classid);
        finScoreAve.setDt(dt);
        finScoreAve.setXt(xt);
        finScoreAve.setAverange(averange);
        finScoreAveService.addFinScoreAve(finScoreAve);

        List<FinScoreAve> finscoreaves = finScoreAveService.findByTeacherid(teacherid);
        modelMap.put("finscoreaves",finscoreaves);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = finScoreAveService.getById(id).getTeacherid();
        finScoreAveService.deleteById(id);
        List<FinScoreAve> finscoreaves = finScoreAveService.findByTeacherid(teacid);
        modelMap.put("finscoreaves",finscoreaves);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        FinScoreAve fsav = finScoreAveService.getById(id);
        modelMap.addAttribute("fsav",fsav);
        return "teacher/editFinscoreave";
    }

    @PutMapping
    public FinScoreAve addfinScoreAve(@RequestBody FinScoreAve finScoreAve){
        return finScoreAveService.addFinScoreAve(finScoreAve);
    }

    @DeleteMapping("/{id}")
    public FinScoreAve deletefinScoreAve(@PathVariable int id){
        return finScoreAveService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(FinScoreAve finScoreAve,ModelMap modelMap){
        finScoreAve.setFsavid(finScoreAve.getFsavid());
        finScoreAveService.addFinScoreAve(finScoreAve);
        List<FinScoreAve> finscoreaves = finScoreAveService.findByTeacherid(finScoreAve.getTeacherid());
        modelMap.put("finscoreaves",finscoreaves);
        return "teacher/finscoreave";
    }
}
