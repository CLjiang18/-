package com.chen.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.chen.service.ILookhouseService;
import com.chen.pojo.Lookhouse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 看房信息表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"看房信息表"})
@RestController
@RequestMapping("/lookhouse")
public class LookhouseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ILookhouseService lookhouseService;


    @ApiOperation(value = "新增看房信息表")
    @PostMapping()
    public int add(@RequestBody Lookhouse lookhouse){
        return lookhouseService.add(lookhouse);
    }

    @ApiOperation(value = "删除看房信息表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return lookhouseService.delete(id);
    }

    @ApiOperation(value = "更新看房信息表")
    @PutMapping()
    public int update(@RequestBody Lookhouse lookhouse){
        return lookhouseService.updateData(lookhouse);
    }

    @ApiOperation(value = "查询看房信息表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Lookhouse> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return lookhouseService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询看房信息表")
    @GetMapping("{id}")
    public Lookhouse findById(@PathVariable Long id){
        return lookhouseService.findById(id);
    }

}
