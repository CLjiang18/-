package com.chen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.pojo.Customer;
import com.chen.pojo.Houses;
import com.chen.pojo.Lookhouse;
import com.chen.service.ILookhouseService;
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
import java.util.Date;
import java.util.List;

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

    @RequestMapping("/queryLookHouseAll")
    public Object queryLookHouseAll(String numbers,String identity,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer limit, Lookhouse lookhouse) {
        /**
         * setCustomer\setHouses
         * LookhouseMapper.xml中查询条件是 where house.id=lookhouse.house_id 和 Customer.id=LookHouse.customer_id
         * 所以说应该传入三个对象，==>LookHouse、Customer和House对象,但是Customer和House对象不需要那么多值，只需要 number和identity.
         * 所议把number和identity传进来即可，再创建并赋值到对象(Customer和House对象)中
         */
        lookhouse.setCustomer(new Customer().setIdentity(identity));
        lookhouse.setHouses(new Houses().setNumbers(numbers));
        JsonObject<Lookhouse> lookhouseJsonObject = new JsonObject<>();
        PageInfo<Lookhouse> lookhouseAll = lookhouseService.queryLookHouseAll(page, limit, lookhouse);
        lookhouseJsonObject.setCode(0);
        lookhouseJsonObject.setCount(lookhouseAll.getTotal());
        lookhouseJsonObject.setData(lookhouseAll.getList());
        lookhouseJsonObject.setMsg("ok");
        return lookhouseJsonObject;
    }

    @ApiOperation(value = "新增看房信息表")
    @PostMapping("/add")
    public R add(@RequestBody Lookhouse lookhouse, HttpServletRequest request){
        String token=request.getHeader("token");
        Integer userId=  JwtUtils2.getUserId(token);
        lookhouse.setCustomerId(userId);
        lookhouse.setDate(new Date());
        lookhouse.setStutas(0);
        lookhouseService.add(lookhouse);
        return R.ok();
    }

    @ApiOperation(value = "删除看房信息表")
    @PostMapping("/deleteByIds")
    public R delete(String ids){
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list) {
            Long idLong=Long.parseLong(id);
            lookhouseService.delete(idLong);
        }
        return R.ok();
    }

    @ApiOperation(value = "更新看房信息表")
    @RequestMapping("/update")
    public R update(Integer id){
        Lookhouse lookhouse = new Lookhouse();
        lookhouse.setId(id);
        lookhouse.setStutas(1);//更改为一看房，但不租赁
        lookhouseService.updateData(lookhouse);
        return R.ok();
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
    @PostMapping("/queryByID")
    public Lookhouse findById(Integer id){
        return lookhouseService.queryById(id);
    }

}
