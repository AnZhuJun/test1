package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinalScore;
import test1.test1.bean.MidScore;
import test1.test1.service.MidScoreService;

import java.util.List;

@RestController
@RequestMapping("/midscore")
public class MidScoreController {
    @Autowired
    MidScoreService midScoreService;

    @GetMapping("/all")
    public @ResponseBody
    List<MidScore> getAllMidScore(){
        return midScoreService.findAll();
    }

    @PutMapping
    public MidScore addMidScore(@RequestBody MidScore midScore){
        return midScoreService.addMidScore(midScore);
    }

    @DeleteMapping("/{id}")
    public MidScore deleteMidScore(@PathVariable int id){
        return midScoreService.deleteById(id);
    }
}
