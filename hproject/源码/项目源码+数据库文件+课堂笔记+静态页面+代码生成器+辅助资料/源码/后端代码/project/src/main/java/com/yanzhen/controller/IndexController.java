package com.yanzhen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yanzhen.model.Notice;
import com.yanzhen.model.User;
import com.yanzhen.service.*;
import com.yanzhen.util.JsonObject;
import com.yanzhen.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/index")
public class IndexController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICustomerService customerService;
    @Resource
    private IHousesService housesService;

    @Resource
    private INoticeService noticeService;

    @Resource
    private IRepairService repairService;

    @RequestMapping("/queryIndexTongji")
    public Object queryIndexTongji(){
        Map map=new HashMap();
        //租客
        int zk= customerService.count();
       //房子
        int fz=housesService.count();
        //公告
        int gg=noticeService.count();
        //维护
        int wx=repairService.count();
        map.put("khCount",zk);
        map.put("fzCount",fz);
        map.put("ggCount",gg);
        map.put("wxCount",wx);
       return map;
    }


    /**
     * 查询公告列表
     */
    @RequestMapping("/queryNoticeAll")
     public Map queryNoticeAll(@RequestParam(defaultValue = "1") Integer page ,
                                @RequestParam(defaultValue = "10")Integer limit,String content){
         Map map=new HashMap();
         PageInfo<Notice> pageInfo=noticeService.queryNoticeAll(1,10,null);
         map.put("list",pageInfo.getList());
         return map;
     }


}
