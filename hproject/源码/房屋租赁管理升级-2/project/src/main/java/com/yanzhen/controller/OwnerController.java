package com.yanzhen.controller;

import com.github.pagehelper.PageInfo;
import com.yanzhen.model.Owner;
import com.yanzhen.service.OwnerService;
import com.yanzhen.util.JsonObject;
import com.yanzhen.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    /**
     * 按条件查询房主信息
     */
    @RequestMapping("/queryOwnerAll")
    @ResponseBody
    public Object queryOwnerAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer limit, Owner owner){
        JsonObject object=new JsonObject();
        //分页查询所有的记录信息
        PageInfo<Owner> pageInfo= ownerService.findOwnerAll(page,limit,owner);
        object.setCode(0);
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        object.setMsg("ok");
        return object;
    }

    @RequestMapping("/findOwnerAll")
    @ResponseBody
    public Object findOwnerAll(){
        PageInfo<Owner> pageInfo= ownerService.findOwnerAll(1,300,null);
        return pageInfo.getList();
    }

    /**
     * 添加房主信息
     */
    @RequestMapping("/addOwner")
    @ResponseBody
    public R add(@RequestBody Owner owner){
       int num=ownerService.add(owner);
       if (num>0){
          return  R.ok();
       }
       return R.fail(400,"添加失败");
    }

    /**
     * 删除功能
     */
    @RequestMapping("/deleteOwner")
    @ResponseBody
    public R delete(String ids){
        //获取前端传过来的ids集合   "1,2,3,4,5"
        List<String> list=Arrays.asList(ids.split(","));
        //遍历list集合进行删除操作
        for(String id:list){
            Long idLong=Long.parseLong(id);
            ownerService.delete(idLong);
        }
        return R.ok();
    }

    /**
     * 添加房主信息
     */
    @RequestMapping("/updateOwner")
    @ResponseBody
    public R update(@RequestBody Owner owner){
        int num=ownerService.updateData(owner);
        if (num>0){
            return  R.ok();
        }
        return R.fail(400,"添加失败");
    }

}
