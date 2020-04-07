package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test1.test1.bean.Outline;
import test1.test1.bean.PsScore;
import test1.test1.service.OutlineService;

import java.util.List;

@RestController
@RequestMapping("/outline")
public class OutlineController {
    @Autowired
    OutlineService outlineService;

    @GetMapping("/all")
    public @ResponseBody
    List<Outline> getAllOutline(){
        return outlineService.findAll();
    }

    @PutMapping
    public Outline addOutline(@RequestBody Outline outline){
        return outlineService.addOutline(outline);
    }

    @DeleteMapping("/{id}")
    public Outline deleteOutline(@PathVariable int id){
        return outlineService.deleteById(id);
    }
}
