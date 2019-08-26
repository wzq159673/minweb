package com.tensquare_base.mapper;

import com.tensquare_base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LabelMapper extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label> {
}
