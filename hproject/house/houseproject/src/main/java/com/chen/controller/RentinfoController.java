package com.chen.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.pojo.Customer;
import com.chen.pojo.Houses;
import com.chen.pojo.Rentinfo;
import com.chen.service.IHousesService;
import com.chen.service.IRentinfoService;
import com.chen.util.JsonObject;
import com.chen.util.JwtUtils2;
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
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

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
    @Resource
    private IHousesService housesService;
    @RequestMapping("/queryRentInfoAll")
    public Object queryAll(String identity,String numbers,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer limit, Rentinfo rentinfo) {
        rentinfo.setHouses(new Houses().setNumbers(numbers));
        //组装
        rentinfo.setCustomer(new Customer().setIdentity(identity));
        JsonObject<Rentinfo> customerJsonObject = new JsonObject<>();
        PageInfo<Rentinfo> rentinfoAll = rentinfoService.queryAll(page, limit, rentinfo);
        customerJsonObject.setCode(0);
        customerJsonObject.setCount(rentinfoAll.getTotal());
        customerJsonObject.setData(rentinfoAll.getList());
        customerJsonObject.setMsg("ok");
        return customerJsonObject;
    }
    @RequestMapping("/queryRentinfoeAll2")
    public Object queryRentinfoeAll2(HttpServletRequest request , Rentinfo rentinfo, @RequestParam(defaultValue = "1") Integer page ,
                                     @RequestParam(defaultValue = "10") Integer limit){
        //登录账号
        String token=request.getHeader("token");
        Integer userId= JwtUtils2.getUserId(token);
        rentinfo.setCustomerId(userId);
        JsonObject object=new JsonObject();
        PageInfo<Rentinfo> pageInfo=rentinfoService.queryAll(page,limit,rentinfo);
        object.setMsg("ok");
        object.setData(pageInfo.getList());
        object.setCode(0);
        object.setCount(pageInfo.getTotal());
        return object;
    }
    @ApiOperation(value = "新增租赁信息表")
    @PostMapping()
    public int add(@RequestBody Rentinfo rentinfo){
        return rentinfoService.add(rentinfo);
    }

    @ApiOperation(value = "删除租赁信息表")
    @PostMapping("/deleteByIds")
    public R delete(String ids){
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list) {
            Long idLong=Long.parseLong(id);
            rentinfoService.delete(idLong);
        }
        return R.ok();
    }

    @ApiOperation(value = "更新租赁信息表")
    @RequestMapping("/update")
    public R update(Integer id){
        //更改租赁信息为退租
        Rentinfo rentinfo = new Rentinfo();
        rentinfo.setId(id);
        rentinfo.setStatus(1);//退租状态--》目前没有使用这个字段
        rentinfoService.updateData(rentinfo);
        //更改房屋状态为未出租
//      Rentinfo byId = rentinfoService.findById(new Long(id));
        //QueryWrapper-->来自mybatis-plus的方法
        QueryWrapper<Rentinfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.select(Rentinfo.class,info->!info.getColumn().equals("houses")&&
                !info.getColumn().equals("contract")&&!info.getColumn().equals("customer"));
        queryWrapper.eq("id",id);//传入id
        Rentinfo one = rentinfoService.getOne(queryWrapper);
        Integer housesId = one.getHousesId();
        Houses houses = new Houses();
        houses.setId(housesId);
        houses.setStatus(1);//退租(1.为退租状态,0为出租中)
        housesService.updateData(houses);
        return R.ok();
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
