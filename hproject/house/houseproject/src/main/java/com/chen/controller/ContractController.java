package com.chen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.pojo.*;
import com.chen.service.IContractService;
import com.chen.service.IHousesService;
import com.chen.service.ILookhouseService;
import com.chen.service.IRentinfoService;
import com.chen.util.R;
import io.jsonwebtoken.Header;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Date;

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
    @Resource
    private IRentinfoService rentinfoService;
    @Resource
    private IHousesService housesService;
    @Resource
    private ILookhouseService lookhouseService;
    @ApiOperation(value = "新增合同信息表")
    @RequestMapping("/addContract")
    public R add(@RequestBody Contract contract){
        //合同信息
        contractService.add(contract);
        //增加租赁记录
        Rentinfo rentinfo=new Rentinfo();
        rentinfo.setCustomerId(contract.getCustomerId());
        rentinfo.setContractId(contract.getId());
        rentinfo.setHousesId(contract.getHousesId());
        rentinfo.setCreateTime(new Date());
        rentinfoService.add(rentinfo);
        //修改房子状态为租赁
        Houses houses=new Houses();
        Houses byId = housesService.findById(new Long(contract.getHousesId()));
        houses.setPrice(byId.getPrice());
        houses.setArea(byId.getArea());
        houses.setId(contract.getHousesId());
        houses.setStatus(1);
        housesService.updateData(houses);
        //更改看房状态
        Lookhouse lookhouse=new Lookhouse();
        lookhouse.setId(contract.getRentId());
        lookhouse.setStutas(1);//更改为已看房，不租赁
        lookhouseService.updateData(lookhouse);
        return R.ok();
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
    @RequestMapping("/queryID")
    public HeTong queryById(Integer id){
        return contractService.findByID(id);
    }
}
