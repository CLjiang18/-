package com.chen.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.chen.service.IRentinfoService;
import com.chen.pojo.Rentinfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 租赁信息表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"租赁信息表"})
@RestController
@RequestMapping("/rentinfo")
public class RentinfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRentinfoService rentinfoService;


    @ApiOperation(value = "新增租赁信息表")
    @PostMapping()
    public int add(@RequestBody Rentinfo rentinfo){
        return rentinfoService.add(rentinfo);
    }

    @ApiOperation(value = "删除租赁信息表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return rentinfoService.delete(id);
    }

    @ApiOperation(value = "更新租赁信息表")
    @PutMapping()
    public int update(@RequestBody Rentinfo rentinfo){
        return rentinfoService.updateData(rentinfo);
    }

    @ApiOperation(value = "查询租赁信息表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Rentinfo> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return rentinfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询租赁信息表")
    @GetMapping("{id}")
    public Rentinfo findById(@PathVariable Long id){
        return rentinfoService.findById(id);
    }

}
