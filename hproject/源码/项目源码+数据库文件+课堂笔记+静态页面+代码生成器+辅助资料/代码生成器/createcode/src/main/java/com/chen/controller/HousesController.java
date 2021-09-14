package com.chen.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.chen.service.IHousesService;
import com.chen.pojo.Houses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 房屋信息管理 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"房屋信息管理"})
@RestController
@RequestMapping("/houses")
public class HousesController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IHousesService housesService;


    @ApiOperation(value = "新增房屋信息管理")
    @PostMapping()
    public int add(@RequestBody Houses houses){
        return housesService.add(houses);
    }

    @ApiOperation(value = "删除房屋信息管理")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return housesService.delete(id);
    }

    @ApiOperation(value = "更新房屋信息管理")
    @PutMapping()
    public int update(@RequestBody Houses houses){
        return housesService.updateData(houses);
    }

    @ApiOperation(value = "查询房屋信息管理分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Houses> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return housesService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询房屋信息管理")
    @GetMapping("{id}")
    public Houses findById(@PathVariable Long id){
        return housesService.findById(id);
    }

}
