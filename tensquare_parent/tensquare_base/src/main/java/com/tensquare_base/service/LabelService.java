package com.tensquare_base.service;

import com.tensquare_base.mapper.LabelMapper;
import com.tensquare_base.pojo.Label;
import com.tensquare_common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private IdWorker idWorker;
    public List<Label> findAll(){
        return labelMapper.findAll();
    }

    public Label findById(String id){
        return labelMapper.findById(id).get();
    }

    public void update(Label label){
        labelMapper.save(label);
    }

    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelMapper.save(label);
    }

    public void deleteById(String id){
        labelMapper.deleteById(id);
    }

}
