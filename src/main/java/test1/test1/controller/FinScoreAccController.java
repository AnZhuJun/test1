package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.*;
import test1.test1.service.FinScoreAccService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/finscoreacc")
public class FinScoreAccController {
    @Autowired
    FinScoreAccService finScoreAccService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllFinalScoreAcc(String username, ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"fsaid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<FinScoreAcc> finscoreaccs = finScoreAccService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("fsaTeacherId",teacher);

//        List<FinScoreAcc> finscoreaccs = finScoreAccService.findAllByUsername(username);
        modelMap.addAttribute("finscoreaccs",finscoreaccs);
        return "teacher/finscoreacc";
    }

    @PostMapping("/finscoreacc")
    public String addAndGetFinalScoreAcc(int courseid,int dt,int xt,int score,int teacherid,int classid,ModelMap modelMap){
        FinScoreAcc finScoreAcc = new FinScoreAcc();
        finScoreAcc.setTeacherid(teacherid);
        finScoreAcc.setCourseid(courseid);
        finScoreAcc.setClassid(classid);
        finScoreAcc.setDt(dt);
        finScoreAcc.setXt(xt);
        finScoreAcc.setScore(score);
        finScoreAccService.addFinalScoreAcc(finScoreAcc);

        List<FinScoreAcc> finscoreaccs = finScoreAccService.findByTeacherid(teacherid);
        modelMap.put("finscoreaccs",finscoreaccs);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = finScoreAccService.getById(id).getTeacherid();
        finScoreAccService.deleteById(id);
        List<FinScoreAcc> finscoreaccs = finScoreAccService.findByTeacherid(teacid);
        modelMap.put("finscoreaccs",finscoreaccs);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        FinScoreAcc fsa = finScoreAccService.getById(id);
        modelMap.addAttribute("fsa",fsa);
        return "teacher/editFinscoreacc";
    }

    @PutMapping
    public FinScoreAcc addFinalScoreAcc(@RequestBody FinScoreAcc finScoreAcc){
        return finScoreAccService.addFinalScoreAcc(finScoreAcc);
    }

    @DeleteMapping("/{id}")
    public FinScoreAcc deleteFinalScoreAcc(@PathVariable int id){
        return finScoreAccService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(FinScoreAcc finScoreAcc,ModelMap modelMap){
        finScoreAcc.setFsaid(finScoreAcc.getFsaid());
        finScoreAccService.addFinalScoreAcc(finScoreAcc);
        List<FinScoreAcc> finscoreaccs = finScoreAccService.findByTeacherid(finScoreAcc.getTeacherid());
        modelMap.put("finscoreaccs",finscoreaccs);
        return "teacher/teachermain/adminNavigator";
    }


    @RequestMapping("/search")
    public String search(int teacherid,int courseid,ModelMap modelMap){
        List<FinScoreAcc> sfsa = finScoreAccService.findById(teacherid,courseid);
        modelMap.addAttribute("sfsa",sfsa);
        return "teacher/searchFinscoreacc";
    }
}
