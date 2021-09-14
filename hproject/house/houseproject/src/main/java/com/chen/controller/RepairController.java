package com.chen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.pojo.*;
import com.chen.service.IRentinfoService;
import com.chen.service.IRepairService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private IRentinfoService rentinfoService;
    @RequestMapping("/queryRepairAll")
    public JsonObject<Repair> queryRepairAll(String numbers,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit, Repair repair){
        repair.setHouses(new Houses().setNumbers(numbers));
        JsonObject<Repair> repairJsonObject=new JsonObject<>();
        PageInfo<Repair> repairAll =repairService.queryAll(page, limit, repair);
        repairJsonObject.setCode(0);
        repairJsonObject.setCount(repairAll.getTotal());
        repairJsonObject.setData(repairAll.getList());
        repairJsonObject.setMsg("ok");
        return repairJsonObject;
    }
    @RequestMapping("/queryRepairAll2")
    public Object queryRepairAll2(HttpServletRequest request , Repair repair, @RequestParam(defaultValue = "1") Integer page ,
                                  @RequestParam(defaultValue = "10") Integer limit){

        String token=request.getHeader("token");
        Integer userId=  JwtUtils2.getUserId(token);
        repair.setCustomerId(userId);
        JsonObject object=new JsonObject();
        PageInfo<Repair> pageInfo=repairService.queryAll(page,limit,repair);
        object.setMsg("ok");
        object.setData(pageInfo.getList());
        object.setCode(0);
        object.setCount(pageInfo.getTotal());
        return object;
    }
    @ApiOperation(value = "新增报修信息表")
    @RequestMapping("/add")
    public R add(@RequestBody Repair repair){
        Integer housesId = repair.getHousesId();
        Rentinfo byHId = rentinfoService.queryByHId(housesId);
        repair.setCustomerId(byHId.getCustomerId());
        repair.setStatus(0);
        repair.setDate(new Date());
        int num = repairService.add(repair);
        if(num>0){
           return R.ok();
        }
        return R.fail(400,"申请报修失败");
    }

    @ApiOperation(value = "删除报修信息表")
    @PostMapping("/deleteByIds")
    public R delete(String ids){
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list) {
            Long idLong=Long.parseLong(id);
            repairService.delete(idLong);
        }
        return R.ok();
    }

    @ApiOperation(value = "更新报修信息表")
    @RequestMapping("/update")
    public R update(@RequestBody Repair repair){
        int num = repairService.updateData(repair);
        if(num>0) {
            return R.ok();
        }
        return R.fail(400,"维修失败");
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
    @RequestMapping("/queryTongJi")
    public List<TongJi> queryTongJi() {
        //获取到数据
        List<TongJi> list = repairService.queryCounts();
        for (int i = 1; i <= 12; i++) {
            //定义标识
            boolean bs = false;
            for (TongJi info : list) {
                int month = Integer.parseInt(info.getMonths());
                if (month == i) {
                    bs = true;
                }
            }
            if (!bs) {
                TongJi tongji = new TongJi();
                tongji.setMonths(new Integer(i).toString());
                tongji.setCounts(0);
                list.add(tongji);
            }
            //排序
            Collections.sort(list);
        }
        return list;
    }
}
