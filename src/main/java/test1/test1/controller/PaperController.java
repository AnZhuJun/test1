package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Paper;
import test1.test1.service.PaperService;

import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    PaperService paperService;

    @GetMapping("/all")
    public @ResponseBody List<Paper> getAllPaper(){
        return paperService.findAll();
    }

    @PutMapping
    public Paper addPaper(@RequestBody Paper paper){
        return paperService.addPaper(paper);
    }

    @DeleteMapping("/{id}")
    public Paper deletePaper(@PathVariable int id){
        return paperService.deleteById(id);
    }
}
