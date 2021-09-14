package com.chen.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.chen.service.IRepairService;
import com.chen.pojo.Repair;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 报修信息表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"报修信息表"})
@RestController
@RequestMapping("/repair")
public class RepairController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRepairService repairService;


    @ApiOperation(value = "新增报修信息表")
    @PostMapping()
    public int add(@RequestBody Repair repair){
        return repairService.add(repair);
    }

    @ApiOperation(value = "删除报修信息表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return repairService.delete(id);
    }

    @ApiOperation(value = "更新报修信息表")
    @PutMapping()
    public int update(@RequestBody Repair repair){
        return repairService.updateData(repair);
    }

    @ApiOperation(value = "查询报修信息表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Repair> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return repairService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询报修信息表")
    @GetMapping("{id}")
    public Repair findById(@PathVariable Long id){
        return repairService.findById(id);
    }

}
