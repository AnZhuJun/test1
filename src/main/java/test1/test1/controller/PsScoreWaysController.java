package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.ExamScoreWays;
import test1.test1.bean.PsScoreWays;
import test1.test1.service.PsScoreWaysService;

import java.util.List;

@RestController
@RequestMapping("/psscoreways")
public class PsScoreWaysController {
    @Autowired
    PsScoreWaysService psScoreWaysService;

    @GetMapping("/all")
    public @ResponseBody
    List<PsScoreWays> getAllPsScoreWays(){
        return psScoreWaysService.findAll();
    }

    @PutMapping
    public PsScoreWays addExamScoreWays(@RequestBody PsScoreWays psScoreWays){
        return psScoreWaysService.addExamScoreWays(psScoreWays);
    }

    @DeleteMapping("/{id}")
    public PsScoreWays deletePsScoreWays(@PathVariable int id){
        return psScoreWaysService.deleteById(id);
    }
}
