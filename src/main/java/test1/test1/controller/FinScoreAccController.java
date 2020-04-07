package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.MidScoreAcc;
import test1.test1.service.FinScoreAccService;

import java.util.List;

@RestController
@RequestMapping("/finscoreacc")
public class FinScoreAccController {
    @Autowired
    FinScoreAccService finScoreAccService;

    @GetMapping("/all")
    public @ResponseBody
    List<FinScoreAcc> getAllFinScoreAcc(){
        return finScoreAccService.findAll();
    }

    @PutMapping
    public FinScoreAcc addFinScoreAcc(@RequestBody FinScoreAcc finScoreAcc){
        return finScoreAccService.addFinScoreAcc(finScoreAcc);
    }

    @DeleteMapping("/{id}")
    public FinScoreAcc deleteFinScoreAcc(@PathVariable int id){
        return finScoreAccService.deleteById(id);
    }
}
