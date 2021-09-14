package com.chen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.pojo.Customer;
import com.chen.pojo.Houses;
import com.chen.pojo.Owner;
import com.chen.service.ICustomerService;
import com.chen.util.JsonObject;
import com.chen.util.R;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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

    @RequestMapping("/queryCustomerAll")
    public Object queryCustomerAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer limit, Customer customer){
        JsonObject<Customer> customerJsonObject=new JsonObject<>();
        PageInfo<Customer> customerAll = customerService.queryAll(page, limit, customer);
        customerJsonObject.setCode(0);
        customerJsonObject.setCount(customerAll.getTotal());
        customerJsonObject.setData(customerAll.getList());
        customerJsonObject.setMsg("ok");
        return customerJsonObject;
    }
    @ApiOperation(value = "新增租户信息表")
    @PostMapping("/addCustomer")
    public R add(@RequestBody Customer customer){
        int num = customerService.add(customer);
        if(num>0){
            return R.ok();
        }
        return R.fail("添加租客信息失败，请重新添加");
    }

    @ApiOperation(value = "删除租户信息表")
    @RequestMapping("/deleteCustomer")
    @ResponseBody
    public R delete(String ids){
        if(ids == null){
            return R.fail(400,"无数据提供错误");
        }
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list) {
            Long idLong=Long.parseLong(id);
            customerService.delete(idLong);
        }
        return R.ok();
    }
    @ApiOperation(value = "更新租户信息表")
    @RequestMapping("/updateCustomer")
    @ResponseBody
    public R update(@RequestBody Customer customer){
        int num = customerService.updateData(customer);
        if(num>0){
            return R.ok();
        }
        return R.fail("失败");
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
    //查询固定数量的租客信息提供给pay页面的交租功能使用
    @RequestMapping("/customerByNumbers")
    public Object customerByNumbers(){
        PageInfo<Customer> pageInfo=customerService.queryAll(1,100,null);
        return pageInfo.getList();
    }
}
