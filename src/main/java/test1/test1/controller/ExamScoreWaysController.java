package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.ExamScoreWays;
import test1.test1.service.ExamScoreWaysService;

import java.util.List;

@RestController
@RequestMapping("/examscoreways")
public class ExamScoreWaysController {
    @Autowired
    ExamScoreWaysService examScoreWaysService;

    @GetMapping("/all")
    public @ResponseBody
    List<ExamScoreWays> getAllExamScoreWays(){
        return examScoreWaysService.findAll();
    }

    @PutMapping
    public ExamScoreWays addExamScoreWays(@RequestBody ExamScoreWays examScoreWays){
        return examScoreWaysService.addExamScoreWays(examScoreWays);
    }

    @DeleteMapping("/{id}")
    public ExamScoreWays deleteExamScoreWays(@PathVariable int id){
        return examScoreWaysService.deleteById(id);
    }
}
