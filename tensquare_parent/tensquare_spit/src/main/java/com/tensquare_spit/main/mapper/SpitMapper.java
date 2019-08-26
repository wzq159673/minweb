package com.tensquare_spit.main.mapper;

import com.tensquare_spit.main.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpitMapper extends MongoRepository<Spit, String> {

    // 查询吐槽列表
    public Page<Spit> findByParentid(String Parentid, Pageable pageable);


}
