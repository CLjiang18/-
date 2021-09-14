package com.chen.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.chen.service.IRentalsService;
import com.chen.pojo.Rentals;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 收租信息表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"收租信息表"})
@RestController
@RequestMapping("/rentals")
public class RentalsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRentalsService rentalsService;


    @ApiOperation(value = "新增收租信息表")
    @PostMapping()
    public int add(@RequestBody Rentals rentals){
        return rentalsService.add(rentals);
    }

    @ApiOperation(value = "删除收租信息表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return rentalsService.delete(id);
    }

    @ApiOperation(value = "更新收租信息表")
    @PutMapping()
    public int update(@RequestBody Rentals rentals){
        return rentalsService.updateData(rentals);
    }

    @ApiOperation(value = "查询收租信息表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Rentals> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return rentalsService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询收租信息表")
    @GetMapping("{id}")
    public Rentals findById(@PathVariable Long id){
        return rentalsService.findById(id);
    }

}
