package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinalScore;
import test1.test1.service.FinalScoreService;

import java.util.List;

@RestController
@RequestMapping("/finalscore")
public class FinalScoreController {
    @Autowired
    FinalScoreService finalScoreService;

    @GetMapping("/all")
    public @ResponseBody
    List<FinalScore> getAllFinalScore(){
        return finalScoreService.findAll();
    }

    @PutMapping
    public FinalScore addFinalScore(@RequestBody FinalScore psScoreAve){
        return finalScoreService.addFinScore(psScoreAve);
    }

    @DeleteMapping("/{id}")
    public FinalScore deleteFinalScore(@PathVariable int id){
        return finalScoreService.deleteById(id);
    }
}
