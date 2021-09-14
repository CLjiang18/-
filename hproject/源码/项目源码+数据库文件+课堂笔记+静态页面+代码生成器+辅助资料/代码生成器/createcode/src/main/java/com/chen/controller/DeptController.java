package com.chen.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.chen.service.IDeptService;
import com.chen.pojo.Dept;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门信息表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"部门信息表"})
@RestController
@RequestMapping("/dept")
public class DeptController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDeptService deptService;


    @ApiOperation(value = "新增部门信息表")
    @PostMapping()
    public int add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @ApiOperation(value = "删除部门信息表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return deptService.delete(id);
    }

    @ApiOperation(value = "更新部门信息表")
    @PutMapping()
    public int update(@RequestBody Dept dept){
        return deptService.updateData(dept);
    }

    @ApiOperation(value = "查询部门信息表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Dept> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return deptService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询部门信息表")
    @GetMapping("{id}")
    public Dept findById(@PathVariable Long id){
        return deptService.findById(id);
    }

}
