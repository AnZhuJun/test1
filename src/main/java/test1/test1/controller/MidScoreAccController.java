package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Examways;
import test1.test1.bean.MidScoreAcc;
import test1.test1.service.MidScoreAccService;

import java.util.List;

@RestController
@RequestMapping("/midscoreacc")
public class MidScoreAccController {
    @Autowired
    MidScoreAccService midScoreAccService;

    @GetMapping("/all")
    public @ResponseBody
    List<MidScoreAcc> getAllMidScoreAcc(){
        return midScoreAccService.findAll();
    }

    @PutMapping
    public MidScoreAcc addMidScoreAcc(@RequestBody MidScoreAcc midScoreAcc){
        return midScoreAccService.addMidScoreAcc(midScoreAcc);
    }

    @DeleteMapping("/{id}")
    public MidScoreAcc deleteMidScoreAcc(@PathVariable int id){
        return midScoreAccService.deleteById(id);
    }
}
