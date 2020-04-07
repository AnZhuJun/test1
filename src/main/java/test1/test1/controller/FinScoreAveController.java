package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinScoreAve;
import test1.test1.bean.MidScoreAve;
import test1.test1.service.FinScoreAveService;

import java.util.List;

@RestController
@RequestMapping("/finscoreave")
public class FinScoreAveController {
    @Autowired
    FinScoreAveService finScoreAveService;

    @GetMapping("/all")
    public @ResponseBody
    List<FinScoreAve> getAllFinScoreAve(){
        return finScoreAveService.findAll();
    }

    @PutMapping
    public FinScoreAve addFinScoreAve(@RequestBody FinScoreAve finScoreAve){
        return finScoreAveService.addFinScoreAve(finScoreAve);
    }

    @DeleteMapping("/{id}")
    public FinScoreAve deleteFinScoreAve(@PathVariable int id){
        return finScoreAveService.deleteById(id);
    }

}
