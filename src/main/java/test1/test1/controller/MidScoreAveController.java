package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.MidScoreAcc;
import test1.test1.bean.MidScoreAve;
import test1.test1.service.MidScoreAveService;

import java.util.List;

@RestController
@RequestMapping("/midscoreave")
public class MidScoreAveController {
    @Autowired
    MidScoreAveService midScoreAveService;

    @GetMapping("/all")
    public @ResponseBody
    List<MidScoreAve> getAllMidScoreAve(){
        return midScoreAveService.findAll();
    }

    @PutMapping
    public MidScoreAve addMidScoreAve(@RequestBody MidScoreAve midScoreAve){
        return midScoreAveService.addMidScoreAve(midScoreAve);
    }

    @DeleteMapping("/{id}")
    public MidScoreAve deleteMidScoreAve(@PathVariable int id){
        return midScoreAveService.deleteById(id);
    }
}
