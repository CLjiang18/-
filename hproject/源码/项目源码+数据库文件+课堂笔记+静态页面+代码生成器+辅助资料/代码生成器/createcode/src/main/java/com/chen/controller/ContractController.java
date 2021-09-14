package com.chen.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.chen.service.IContractService;
import com.chen.pojo.Contract;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 合同信息表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"合同信息表"})
@RestController
@RequestMapping("/contract")
public class ContractController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IContractService contractService;


    @ApiOperation(value = "新增合同信息表")
    @PostMapping()
    public int add(@RequestBody Contract contract){
        return contractService.add(contract);
    }

    @ApiOperation(value = "删除合同信息表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return contractService.delete(id);
    }

    @ApiOperation(value = "更新合同信息表")
    @PutMapping()
    public int update(@RequestBody Contract contract){
        return contractService.updateData(contract);
    }

    @ApiOperation(value = "查询合同信息表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Contract> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return contractService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询合同信息表")
    @GetMapping("{id}")
    public Contract findById(@PathVariable Long id){
        return contractService.findById(id);
    }

}
