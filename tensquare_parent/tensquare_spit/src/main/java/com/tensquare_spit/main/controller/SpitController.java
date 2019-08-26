package com.tensquare_spit.main.controller;

import com.tensquare_common.entity.PageResult;
import com.tensquare_common.entity.Result;
import com.tensquare_common.entity.StatusCode;
import com.tensquare_spit.main.pojo.Spit;
import com.tensquare_spit.main.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 吐槽模块
 */
@RestController
@RequestMapping("/spit")
@CrossOrigin
public class SpitController {
    @Autowired
    private SpitService spitService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        int a=2/0;
        List<Spit> spitList = spitService.findAll();
        return new Result(StatusCode.OK, true, "查询成功", spitList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        Spit spit = spitService.findById(id);
        return new Result(StatusCode.OK, true, "查询成功", spit);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Spit spit) {
        spitService.save(spit);
        return new Result(StatusCode.OK, true, "保存成功");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody Spit spit) {
        spitService.update(spit);
        return new Result(StatusCode.OK, true, "更新成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        spitService.deleteById(id);
        return new Result(StatusCode.OK, true, "删除成功");
    }

    @RequestMapping(value = "/{id}/{page}/{size}",method = RequestMethod.GET)
    public Result findParentId(@PathVariable String id,
                               @PathVariable int page,
                               @PathVariable int size) {
        Page<Spit> spitPage = spitService.findByParentid(id, page, size);

        return new Result(StatusCode.OK, true, "查询成功", new PageResult<>(spitPage.getTotalElements(),spitPage.getContent()));
    }

}
