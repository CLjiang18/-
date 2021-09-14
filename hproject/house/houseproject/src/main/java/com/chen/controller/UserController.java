package com.chen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.pojo.Owner;
import com.chen.pojo.User;
import com.chen.service.IUserService;
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
 * 用户信息表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"用户信息表"})
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService userService;
    @RequestMapping("/queryUserAll")
    public JsonObject<User> queryOwnerAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer limit, User user){
        JsonObject<User> ownerJsonObject=new JsonObject<>();
        PageInfo<User> ownerAll = userService.queryAll(page,limit,user);
        ownerJsonObject.setCode(0);
        ownerJsonObject.setCount(ownerAll.getTotal());
        ownerJsonObject.setData(ownerAll.getList());
        ownerJsonObject.setMsg("ok");
        return ownerJsonObject;
    }


    @ApiOperation(value = "新增用户信息表")
    @RequestMapping("/addUser")
    public R add(@RequestBody User user){
        int num=userService.add(user);
        if(num>0){
            return R.ok();
        }
        return R.fail(400,"失败");
    }

    @ApiOperation(value = "删除用户信息表")
    @RequestMapping("/deleteUser")
    public R delete(String ids){
        List<String> strings = Arrays.asList(ids.split(","));
        for (String s : strings) {
            userService.delete(Long.parseLong(s));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新用户信息表")
    @RequestMapping(value = "/updateUser")
    public R update(String oldPwd,String newPwd,Integer id){
        User user = userService.findById(new Long(id));
        if((user.getPassword()).equals(oldPwd)){
            user.setPassword(newPwd);
            userService.updateData(user);
            return R.ok();
        }
        else {
            return R.fail(400,"原密码错误");
        }
    }

    @ApiOperation(value = "查询用户信息表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<User> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return userService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询用户信息表")
    @GetMapping("{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

}
