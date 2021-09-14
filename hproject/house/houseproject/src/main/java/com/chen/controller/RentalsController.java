package com.chen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.pojo.Customer;
import com.chen.pojo.Rentals;
import com.chen.pojo.RentalsVo;
import com.chen.pojo.TongJi;
import com.chen.service.IRentalsService;
import com.chen.util.DateTimeCom;
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
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
    @RequestMapping("/queryRentalsAll")
    public JsonObject<RentalsVo> queryRentalsAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit, RentalsVo rentalsVo) {
        JsonObject<RentalsVo> RentalsVoJsonObject = new JsonObject<>();
        PageInfo<RentalsVo> RentalsVoAll = rentalsService.queryAll(page, limit, rentalsVo);
        RentalsVoJsonObject.setCode(0);
        RentalsVoJsonObject.setCount(RentalsVoAll.getTotal());
//        RentalsVoJsonObject.setData(RentalsVoAll.getList());
        RentalsVoJsonObject.setMsg("ok");
         /*
            交租状态
            1、如果截至日期小于当前天 超时
            2、如果截至日期小于5天 快缴费了
            3、否则已经缴费
          */
        //获取缴费列表信息
        List<RentalsVo> list = RentalsVoAll.getList();

        for (RentalsVo rentals : list) {
            //获取截至时间
            Date jzsj = rentals.getJzrq();
            int day = DateTimeCom.getBetweenDay(new Date(), jzsj);
            System.out.println(day);
            if (day <= 0) {
                //根据房屋编号查询是否是最新记录 如果是超时，否则可能是上月信息
                rentalsVo.setNumbers(rentals.getNumbers());
                PageInfo<RentalsVo> pageInfo2 = rentalsService.queryAll(1, 1, rentalsVo);
                if (pageInfo2.getList().get(0).getId() == rentals.getId()) {
                    rentals.setStatus("超时");
                } else {
                    rentals.setStatus("已经缴费");
                }
            } else if (day < 5) {
                rentals.setStatus("要缴费了");
            } else {
                rentals.setStatus("已经缴费");
            }
        }
        RentalsVoJsonObject.setData(list);
        return RentalsVoJsonObject;
    }


    @ApiOperation(value = "新增收租信息表")
    @PostMapping("/add")
    public R add(@RequestBody Rentals rentals){
        rentals.setDate(new Date());
        int i = rentalsService.add(rentals);
        if(i>0){
            return R.ok();
        }
        return R.fail(400,"添加失败");
    }

    @ApiOperation(value = "删除收租信息表")
    @RequestMapping("/deleteByIds")
    public R delete(String ids){
        if(ids == null){
            return R.fail(400,"无数据提供错误");
        }
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list) {
            Long idLong=Long.parseLong(id);
            rentalsService.delete(idLong);
        }
        return R.ok();
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

    @RequestMapping("/queryTongJi")
    public List<TongJi> queryTongJi(){
        //获取到数据
        List<TongJi> list=rentalsService.queryCounts();
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
