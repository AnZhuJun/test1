package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.PsScoreAve;
import test1.test1.service.PsScoreAveService;

import java.util.List;

@RestController
@RequestMapping("/psscoreave")
public class PsScoreAveController {
    @Autowired
    PsScoreAveService psScoreAveService;

    @GetMapping("/all")
    public @ResponseBody
    List<PsScoreAve> getAllPsScoreAve(){
        return psScoreAveService.findAll();
    }

    @PutMapping
    public PsScoreAve addPsScoreAve(@RequestBody PsScoreAve psScoreAve){
        return psScoreAveService.addPsScoreAve(psScoreAve);
    }

    @DeleteMapping("/{id}")
    public PsScoreAve deletePsScoreAve(@PathVariable int id){
        return psScoreAveService.deleteById(id);
    }
}
