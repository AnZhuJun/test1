package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.Outline;
import test1.test1.bean.PsScore;
import test1.test1.dao.OutlineDao;

import java.util.List;

@Service
public class OutlineService {
    @Autowired
    OutlineDao outlineDao;

    public List<Outline> findAll(){
        return outlineDao.findAll();
    }

    public Outline getById(int id){
        return outlineDao.findById(id).orElse(new Outline(-1,"null"));
    }

    public Outline addOutline(Outline outline){
        return outlineDao.save(outline);
    }

    public Outline deleteById(int id){
        Outline outline = getById(id);
        if(outline.getOutlineid() > -1){
            outlineDao.deleteById(id);
        }
        return outline;
    }
}
