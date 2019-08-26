package com.tensquare_base.controller;

import com.tensquare_base.pojo.Label;
import com.tensquare_base.service.LabelService;
import com.tensquare_common.entity.Result;
import com.tensquare_common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签模块
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
public class LabelController {
    @Autowired
    private LabelService labelService;
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Label> labelList = labelService.findAll();
        return new Result(StatusCode.OK,true,"查询成功",labelList);
    } @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable  String id){
        Label label = labelService.findById(id);
        return new Result(StatusCode.OK,true,"查询成功",label);
    } @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(StatusCode.OK,true,"保存成功");
    } @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody Label label){
        labelService.update(label);
        return new Result(StatusCode.OK,true,"更新成功");
    } @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id){
        labelService.deleteById(id);
        return new Result(StatusCode.OK,true,"删除成功");
    }
}
