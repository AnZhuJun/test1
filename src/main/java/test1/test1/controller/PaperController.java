package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.CourseAim;
import test1.test1.bean.Paper;
import test1.test1.bean.Teacher;
import test1.test1.service.PaperService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    PaperService paperService;



    @GetMapping("/all")
    public String getAllPaper(String username, ModelMap modelMap){

        List<Paper> papers = paperService.findAllByUsername(username);
        modelMap.addAttribute("papers",papers);
        return "teacher/paper";
    }

    @PostMapping("/paper")
    public String addAndGetPaper(int courseid,int dt,int xt,int scores,int classid,String username,ModelMap modelMap){
        Paper paper = new Paper();
        paper.setCourseid(courseid);
        paper.setDt(dt);
        paper.setXt(xt);
        paper.setScores(scores);
        paper.setClassid(classid);
        paper.setUsername(username);
        paperService.addPaper(paper);

        List<Paper> papers = paperService.findAllByUsername(username);
        modelMap.put("papers", papers);
        return "teacher/paper";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id,ModelMap map){
        String username = paperService.getById(id).getUsername();
        paperService.deleteById(id);
        List<Paper> papers = paperService.findAllByUsername(username);
        map.put("papers", papers);
        return "teacher/paper";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        Paper pap = paperService.getById(id);
        modelMap.addAttribute("pap",pap);
        return "teacher/editPaper";
    }

    @PutMapping
    public Paper addPaper(@RequestBody Paper paper){
        return paperService.addPaper(paper);
    }

    @DeleteMapping("/{id}")
    public Paper deletePaper(@PathVariable int id){
        return paperService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(Paper paper, ModelMap map){
        paper.setPaperid(paper.getPaperid());
        paperService.addPaper(paper);
        List<Paper> papers = paperService.findAllByUsername(paper.getUsername());
        map.put("papers", papers);
        return "teacher/paper";
    }
}
