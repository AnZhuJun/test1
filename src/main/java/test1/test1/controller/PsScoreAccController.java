package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.MidScoreAve;
import test1.test1.bean.PsScoreAcc;
import test1.test1.service.PsScoreAccService;

import java.util.List;

@RestController
@RequestMapping("/psscoreacc")
public class PsScoreAccController {
    @Autowired
    PsScoreAccService psScoreAccService;

    @GetMapping("/all")
    public @ResponseBody
    List<PsScoreAcc> getAllPsScoreAcc(){
        return psScoreAccService.findAll();
    }

    @PutMapping
    public PsScoreAcc addPsScoreAcc(@RequestBody PsScoreAcc psScoreAcc){
        return psScoreAccService.addPsScoreAcc(psScoreAcc);
    }

    @DeleteMapping("/{id}")
    public PsScoreAcc deletePsScoreAcc(@PathVariable int id){
        return psScoreAccService.deleteById(id);
    }
}
