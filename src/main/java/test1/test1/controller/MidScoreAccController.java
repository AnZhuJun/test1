package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Examways;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.MidScoreAcc;
import test1.test1.bean.Teacher;
import test1.test1.service.MidScoreAccService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/midscoreacc")
public class MidScoreAccController {
    @Autowired
    MidScoreAccService midScoreAccService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllMidScoreAcc(String username, ModelMap modelMap){
        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("msaTeacherId",teacher);

        List<MidScoreAcc> midscoreaccs = midScoreAccService.findAllByUsername(username);
        modelMap.addAttribute("midscoreaccs",midscoreaccs);
        return "teacher/midscoreacc";
    }

    @PostMapping("/midscoreacc")
    public String addAndGetMidScoreAcc(int courseid,int dt,int xt,int score,int teacherid,int classid,ModelMap modelMap){
        MidScoreAcc midScoreAcc = new MidScoreAcc();
        midScoreAcc.setTeacherid(teacherid);
        midScoreAcc.setCourseid(courseid);
        midScoreAcc.setClassid(classid);
        midScoreAcc.setDt(dt);
        midScoreAcc.setXt(xt);
        midScoreAcc.setScore(score);
        midScoreAccService.addMidScoreAcc(midScoreAcc);

        List<MidScoreAcc> midscoreaccs = midScoreAccService.findByTeacherid(teacherid);
        modelMap.put("midscoreaccs",midscoreaccs);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = midScoreAccService.getById(id).getTeacherid();
        midScoreAccService.deleteById(id);
        List<MidScoreAcc> midscoreaccs = midScoreAccService.findByTeacherid(teacid);
        modelMap.put("midscoreaccs",midscoreaccs);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        MidScoreAcc msa = midScoreAccService.getById(id);
        modelMap.addAttribute("msa",msa);
        return "teacher/editMidscoreacc";
    }

    @PutMapping
    public MidScoreAcc addMidScoreAcc(@RequestBody MidScoreAcc midScoreAcc){
        return midScoreAccService.addMidScoreAcc(midScoreAcc);
    }

    @DeleteMapping("/{id}")
    public MidScoreAcc deleteMidScoreAcc(@PathVariable int id){
        return midScoreAccService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(MidScoreAcc midScoreAcc,ModelMap modelMap){
        midScoreAcc.setMsaid(midScoreAcc.getMsaid());
        midScoreAccService.addMidScoreAcc(midScoreAcc);
        List<MidScoreAcc> midscoreaccs = midScoreAccService.findByTeacherid(midScoreAcc.getTeacherid());
        modelMap.put("midscoreaccs",midscoreaccs);
        return "teacher/midscoreacc";
    }

}
