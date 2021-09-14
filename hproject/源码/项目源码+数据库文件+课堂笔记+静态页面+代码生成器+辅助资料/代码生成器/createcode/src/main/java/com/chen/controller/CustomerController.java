package com.chen.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.chen.service.ICustomerService;
import com.chen.pojo.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 租户信息表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"租户信息表"})
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICustomerService customerService;


    @ApiOperation(value = "新增租户信息表")
    @PostMapping()
    public int add(@RequestBody Customer customer){
        return customerService.add(customer);
    }

    @ApiOperation(value = "删除租户信息表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return customerService.delete(id);
    }

    @ApiOperation(value = "更新租户信息表")
    @PutMapping()
    public int update(@RequestBody Customer customer){
        return customerService.updateData(customer);
    }

    @ApiOperation(value = "查询租户信息表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Customer> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return customerService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询租户信息表")
    @GetMapping("{id}")
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }

}
