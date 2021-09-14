package com.chen.controller;

import com.chen.pojo.Owner;
import com.chen.service.OwnerService;
import com.chen.util.JsonObject;
import com.chen.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    /**
     * 查询所有用户信息并分页处理--
     * And--动态sql实现 通过identity或name单一查询
     * @param page
     * @param limit
     * @param owner
     * @return
     */
    @RequestMapping("/queryOwnerAll")
    @ResponseBody
    public Object queryOwnerAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer limit, Owner owner){
        JsonObject<Owner> ownerJsonObject=new JsonObject<>();
        PageInfo<Owner> ownerAll = ownerService.findOwnerAll(page, limit, owner);
        ownerJsonObject.setCode(0);
        ownerJsonObject.setCount(ownerAll.getTotal());
        ownerJsonObject.setData(ownerAll.getList());
        ownerJsonObject.setMsg("ok");
        return ownerJsonObject;
    }

    /**
     * 查询所有用户返回到房屋管理的添加房主下拉框中
     * @return
     */
    @RequestMapping("/findOwnerAll")
    @ResponseBody
    public Object findOwnerAll(){
        PageInfo<Owner> ownerAll = ownerService.findOwnerAll(1, 300, null);
        return ownerAll.getList();
    }
    /**
     * 添加用户信息
     */
    @RequestMapping("/addOwner")
    @ResponseBody
    public R add(@RequestBody Owner owner){
        int num=ownerService.addOwner(owner);
        if(num>0) {
            return R.ok();
        }
        return R.fail(400,"添加失败");
    }

    /**
     * 删除用户
     * @param ids 前端传递过来id集合{1,2,3,4}
     * @return
     */
    @RequestMapping("/deleteOwner")
    @ResponseBody
    public R delete(String ids){
        if(ids == null){
            return R.fail(400,"无数据提供错误");
        }
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list) {
            Long idLong=Long.parseLong(id);
            ownerService.deleteOwner(idLong);
        }
        return R.ok();
    }

    /**
     * 修改用户信息
     * @param owner
     * @return chen
     */
    @RequestMapping("/updateOwner")
    @ResponseBody
    public R update(@RequestBody Owner owner){
        int num=ownerService.updateOwner(owner);
        if(num>0) {
            return R.ok();
        }
        return R.fail(400,"修改失败");
    }
}
