package com.tensquare_spit.main.service;

import com.tensquare_common.utils.IdWorker;
import com.tensquare_spit.main.mapper.SpitMapper;
import com.tensquare_spit.main.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpitService {
    @Autowired
    private SpitMapper spitMapper;
    @Autowired
    private IdWorker idWorker;
    public List<Spit> findAll(){
        return spitMapper.findAll();
    }
    public Page<Spit> findByParentid(String Parentid, int page, int size){
        Pageable pageable= PageRequest.of(page - 1, size);
        return spitMapper.findByParentid(Parentid,pageable);
    }
    public Spit findById(String id){
        return spitMapper.findById(id).get();
    }
    public void save(Spit spit){
        spit.set_id(idWorker.nextId()+"");
        spitMapper.save(spit);
    }
    public void update(Spit spit){
        spitMapper.save(spit);
    }
    public void deleteById(String id){
        spitMapper.deleteById(id);
    }
}
