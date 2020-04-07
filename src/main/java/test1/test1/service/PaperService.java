package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.Paper;
import test1.test1.dao.PaperDao;

import java.util.List;

@Service
public class PaperService {
    @Autowired
    PaperDao paperDao;

    public List<Paper> findAll(){
        return paperDao.findAll();
    }

    public Paper getById(int id){
        return paperDao.findById(id).orElse(new Paper(-1,-1,-1,-1,-1,-1));
    }

    public Paper addPaper(Paper paper){
        return paperDao.save(paper);
    }

    public Paper deleteById(int id){
        Paper paper = getById(id);
        if(paper.getPaperid() > -1){
            paperDao.deleteById(id);
        }
        return paper;
    }
}
