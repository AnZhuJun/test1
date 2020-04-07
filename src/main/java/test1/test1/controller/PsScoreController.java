package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinalScore;
import test1.test1.bean.PsScore;
import test1.test1.service.PsScoreService;

import java.util.List;

@RestController
@RequestMapping("/psscore")
public class PsScoreController {
    @Autowired
    PsScoreService psScoreService;

    @GetMapping("/all")
    public @ResponseBody
    List<PsScore> getAllPsScore(){
        return psScoreService.findAll();
    }

    @PutMapping
    public PsScore addPsScore(@RequestBody PsScore psScoreAve){
        return psScoreService.addPsScore(psScoreAve);
    }

    @DeleteMapping("/{id}")
    public PsScore deletePsScore(@PathVariable int id){
        return psScoreService.deleteById(id);
    }
}
