package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinScoreAve;
import test1.test1.bean.MidScoreAcc;
import test1.test1.bean.MidScoreAve;
import test1.test1.bean.Teacher;
import test1.test1.service.MidScoreAveService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/midscoreave")
public class MidScoreAveController {
    @Autowired
    MidScoreAveService midScoreAveService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public String getAllMidScoreAve(String username, ModelMap modelMap,@RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"msavid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<MidScoreAve> midscoreaves = midScoreAveService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("msavTeacherId",teacher);

//        List<MidScoreAve> midscoreaves = midScoreAveService.findAllByUsername(username);
        modelMap.addAttribute("midscoreaves",midscoreaves);
        return "teacher/midscoreave";
    }

    @PostMapping("/midscoreave")
    public String addAndGetMidScoreAve(int courseid,int dt,int xt,int averange,int teacherid,int classid,ModelMap modelMap){
        MidScoreAve midScoreAve = new MidScoreAve();
        midScoreAve.setTeacherid(teacherid);
        midScoreAve.setCourseid(courseid);
        midScoreAve.setClassid(classid);
        midScoreAve.setDt(dt);
        midScoreAve.setXt(xt);
        midScoreAve.setAverange(averange);
        midScoreAveService.addMidScoreAve(midScoreAve);

        List<MidScoreAve> midscoreaves = midScoreAveService.findByTeacherid(teacherid);
        modelMap.put("midscoreaves",midscoreaves);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap modelMap){
        int teacid = midScoreAveService.getById(id).getTeacherid();
        midScoreAveService.deleteById(id);
        List<MidScoreAve> midscoreaves = midScoreAveService.findByTeacherid(teacid);
        modelMap.put("midscoreaves",midscoreaves);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        MidScoreAve msav = midScoreAveService.getById(id);
        modelMap.addAttribute("msav",msav);
        return "teacher/editMidscoreave";
    }

    @PutMapping
    public MidScoreAve addMidScoreAve(@RequestBody MidScoreAve midScoreAve){
        return midScoreAveService.addMidScoreAve(midScoreAve);
    }

    @DeleteMapping("/{id}")
    public MidScoreAve deleteMidScoreAve(@PathVariable int id){
        return midScoreAveService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(MidScoreAve midScoreAve,ModelMap modelMap){
        midScoreAve.setMsavid(midScoreAve.getMsavid());
        midScoreAveService.addMidScoreAve(midScoreAve);
        List<MidScoreAve> midscoreaves = midScoreAveService.findByTeacherid(midScoreAve.getTeacherid());
        modelMap.put("midscoreaves",midscoreaves);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int teacherid,int courseid,ModelMap modelMap){
        List<MidScoreAve> smsav = midScoreAveService.findById(teacherid,courseid);
        modelMap.addAttribute("smsav",smsav);
        return "teacher/searchMidscoreave";
    }
}
