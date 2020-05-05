package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Analyse;
import test1.test1.bean.Stuscore;
import test1.test1.bean.Teacher;
import test1.test1.service.AnalyseService;
import test1.test1.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/analyse")
public class AnalyseController {
    @Autowired
    AnalyseService analyseService;

    @Autowired
    TeacherService teacherService;


    @GetMapping("/all")
    public String getAllAnalyse(String username, ModelMap modelMap, @RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"analyseid");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Analyse> analyses = analyseService.findAllByUsername(pageable,username);

        Teacher teacher = teacherService.findByUsername(username);
        modelMap.addAttribute("anTeacherId",teacher);

        modelMap.addAttribute("analyses",analyses);

        return "teacher/analyse";
    }

    @PostMapping("/analyse")
    public String addAndGetAnalyse(int teacherid,int courseid,int classid,String year,String term,ModelMap modelMap){
        Analyse analyse = new Analyse();
        analyse.setTeacherid(teacherid);
        analyse.setCourseid(courseid);
        analyse.setClassid(classid);
        analyse.setYear(year);
        analyse.setTerm(term);
        analyseService.create(analyse);

        List<Analyse> analyses = analyseService.findByTeacherid(teacherid);
        modelMap.put("analyses",analyses);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, ModelMap modelMap){
        int teacid = analyseService.getById(id).getTeacherid();
        analyseService.deleteById(id);
        List<Analyse> analyses = analyseService.findByTeacherid(teacid);
        modelMap.put("analyses",analyses);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/edit")
    public String edit(int id,ModelMap modelMap){
        Analyse ans = analyseService.getById(id);
        modelMap.addAttribute("ans",ans);
        return "teacher/editAnalyse";
    }

    @PutMapping
    public Analyse addAnalyse(@RequestBody Analyse stuscore){
        return analyseService.create(stuscore);
    }

    @DeleteMapping("/{id}")
    public Analyse deleteAnalyse(@PathVariable int id){
        return analyseService.deleteById(id);
    }

    @RequestMapping("/update")
    public String update(Analyse analyse,ModelMap modelMap){
        analyse.setAnalyseid(analyse.getAnalyseid());
        analyseService.create(analyse);
        List<Analyse> analyses = analyseService.findByTeacherid(analyse.getTeacherid());
        modelMap.put("analyses",analyses);
        return "teacher/teachermain/adminNavigator";
    }

    @RequestMapping("/search")
    public String search(int teacherid,int courseid,int classid,String year,String term,ModelMap modelMap){
        Analyse san = analyseService.findById(teacherid,courseid,classid,year,term);
        modelMap.addAttribute("san",san);
        return "teacher/searchAnalyse";
    }
}
