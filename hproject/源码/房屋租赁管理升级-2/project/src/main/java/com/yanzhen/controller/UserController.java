package com.yanzhen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yanzhen.model.Customer;
import com.yanzhen.model.Houses;
import com.yanzhen.model.Lookhouse;
import com.yanzhen.model.User;
import com.yanzhen.service.IUserService;
import com.yanzhen.util.JsonObject;
import com.yanzhen.util.R;
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
 * @author kappy
 * @since 2020-09-19
 */
@Api(tags = {"用户信息表"})
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService userService;


    @RequestMapping("/queryUserAll")
    public Object queryUserAll( @RequestParam(defaultValue = "1") Integer page ,
                                    @RequestParam(defaultValue = "10") Integer limit){

        JsonObject object=new JsonObject();
        PageInfo<User> pageInfo=userService.findUserAll(page,limit,null);
        object.setMsg("ok");
        object.setData(pageInfo.getList());
        object.setCode(0);
        object.setCount(pageInfo.getTotal());
        return object;
    }



    @ApiOperation(value = "新增用户信息表")
    @PostMapping("/add")
    public R add(@RequestBody User user){
         userService.add(user);
         return R.ok();
    }

    @ApiOperation(value = "删除用户信息表")
    @RequestMapping("/deleteByIds")
    public R delete(String ids){
        //获取前端传过来的ids集合   "1,2,3,4,5"
        List<String> list= Arrays.asList(ids.split(","));
        //遍历list集合进行删除操作
        for(String id:list){
            Long idLong=Long.parseLong(id);
            userService.delete(idLong);
        }
        return R.ok();
    }


    @ApiOperation(value = "修改密码")
    @RequestMapping("/updatePassword")
    public R update(String oldPwd,String newPwd,Integer id){
        //根据id获取当前的数据记录
        User user=userService.findById(new Long(id));
        if(oldPwd.equals(user.getPassword())){//输入的老密码和原密码一致
            user.setPassword(newPwd);
            userService.updateData(user);
            return R.ok();
        }else{
            return R.fail("两次密码不一致");
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
