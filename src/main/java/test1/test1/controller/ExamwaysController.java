package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Course;
import test1.test1.bean.Examways;
import test1.test1.service.ExamwaysService;

import java.util.List;

@RestController
@RequestMapping("/examways")
public class ExamwaysController {
    @Autowired
    ExamwaysService examwaysService;

    @GetMapping("/all")
    public @ResponseBody
    List<Examways> getAllExamways(){
        return examwaysService.findAll();
    }

    @PutMapping
    public Examways addExamways(@RequestBody Examways examways){
        return examwaysService.addExamways(examways);
    }

    @DeleteMapping("/{id}")
    public Examways deleteExamways(@PathVariable int id){
        return examwaysService.deleteById(id);
    }
}
