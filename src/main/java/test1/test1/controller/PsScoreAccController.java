package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.MidScoreAve;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.Teacher;
import test1.test1.service.PsScoreAccService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/psscoreacc")
public class PsScoreAccController {
    @Autowired
    PsScoreAccService psScoreAccService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllPsScoreAcc(String username, ModelMap modelMap){
        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("psaTeacherId",teacher);

        List<PsScoreAcc> psscoreaccs = psScoreAccService.findAllByUsername(username);
        modelMap.addAttribute("psscoreaccs",psscoreaccs);
        return "teacher/psscoreacc";
    }

    @PostMapping("/psscoreacc")
    public String addAndGetPsScoreAcc(int courseid,int score,int teacherid,int classid,ModelMap modelMap){
        PsScoreAcc finScoreAcc = new PsScoreAcc();
        finScoreAcc.setTeacherid(teacherid);
        finScoreAcc.setCourseid(courseid);
        finScoreAcc.setClassid(classid);
        finScoreAcc.setScore(score);
        psScoreAccService.addPsScoreAcc(finScoreAcc);

        List<PsScoreAcc> psscoreaccs = psScoreAccService.findByTeacherid(teacherid);
        modelMap.put("psscoreaccs",psscoreaccs);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = psScoreAccService.getById(id).getTeacherid();
        psScoreAccService.deleteById(id);
        List<PsScoreAcc> psscoreaccs = psScoreAccService.findByTeacherid(teacid);
        modelMap.put("psscoreaccs",psscoreaccs);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        PsScoreAcc psa = psScoreAccService.getById(id);
        modelMap.addAttribute("psa",psa);
        return "teacher/editPsscoreacc";
    }

    @PutMapping
    public PsScoreAcc addPsScoreAcc(@RequestBody PsScoreAcc psScoreAcc){
        return psScoreAccService.addPsScoreAcc(psScoreAcc);
    }

    @DeleteMapping("/{id}")
    public PsScoreAcc deletePsScoreAcc(@PathVariable int id){
        return psScoreAccService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(PsScoreAcc psScoreAcc,ModelMap modelMap){
        psScoreAcc.setPsaid(psScoreAcc.getPsaid());
        psScoreAccService.addPsScoreAcc(psScoreAcc);
        List<PsScoreAcc> psscoreaccs = psScoreAccService.findByTeacherid(psScoreAcc.getTeacherid());
        modelMap.put("psscoreaccs",psscoreaccs);
        return "teacher/psscoreacc";
    }
}
