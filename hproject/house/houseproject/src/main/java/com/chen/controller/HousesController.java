package com.chen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.pojo.Customer;
import com.chen.pojo.Houses;
import com.chen.pojo.Lookhouse;
import com.chen.service.IHousesService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 房屋信息管理 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Api(tags = {"房屋信息管理"})
@RestController
@RequestMapping("/houses")
public class HousesController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IHousesService housesService;

    @RequestMapping("/queryHousesAll")
    public Object queryHousesAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer limit, Houses houses){
        JsonObject<Houses> housesJsonObject=new JsonObject<>();
        PageInfo<Houses> housesAll = housesService.queryAll(page, limit, houses);
        housesJsonObject.setCode(0);
        housesJsonObject.setCount(housesAll.getTotal());
        housesJsonObject.setData(housesAll.getList());
        housesJsonObject.setMsg("ok");
        return  housesJsonObject;
    }
    @RequestMapping("/queryHouseAll2")
    public Object queryHouseAll2(HttpServletRequest request , @RequestParam(defaultValue = "1") Integer page ,
                                 @RequestParam(defaultValue = "10") Integer limit){
        String token=request.getHeader("token");
        Integer userId=  JwtUtils2.getUserId(token);
        JsonObject object=new JsonObject();
        //获取记录信息
        PageInfo<Houses> pageInfo= housesService.findHouseAll2(page,limit,userId);
        object.setMsg("ok");
        object.setData(pageInfo.getList());
        object.setCode(0);
        object.setCount(pageInfo.getTotal());
        return object;
    }



    /**
     * 图片上传功能
     * @param file
     * @return
     */
    @PostMapping("/fileUpload")
    public R fileUpload(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            System.out.println("图片不存在");
        }
        //获取文件名字
        String fileName = file.getOriginalFilename();
        //获取后缀名字
        String substr = fileName.substring(fileName.lastIndexOf("."));
        //更新文件名称
        fileName = UUID.randomUUID()+substr;
        //设置路径
        String filePath = "D://images//";
        //上传
        File dest = new File(filePath,fileName);
        if(!dest.getParentFile().exists()){
            //如果路径不存在需要创建
            dest.getParentFile().mkdirs();
        }
        try{
            file.transferTo(dest);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        String filename="images/"+fileName;
        return R.ok(filename,null);
    }
    @ApiOperation(value = "新增房屋信息管理")
    @PostMapping("/addHouses")
    public R add(@RequestBody Houses houses){
        int num=housesService.add(houses);
        if(num>0){
            return R.ok();
        }
        return R.fail("房屋信息添加失败");
    }

    @ApiOperation(value = "删除房屋信息管理")
    @RequestMapping("/deleteHouses")
    public R delete(String ids){
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list) {
            Long idLong=Long.parseLong(id);
            housesService.delete(idLong);
        }
        return R.ok();
    }

    @ApiOperation(value = "更新房屋信息管理")
    @RequestMapping("/updateHouses")
    public R update(@RequestBody Houses houses){
        System.out.println(houses);
        int num=housesService.updateData(houses);
        if(num>0){
            return R.ok();
        }
        return R.fail("房屋信息添加失败");
    }

    @ApiOperation(value = "查询房屋信息管理分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Houses> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return housesService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询房屋信息管理")
    @GetMapping("{id}")
    public Houses findById(@PathVariable Long id){
        return housesService.findById(id);
    }
    //查询固定数量的房屋信息提供给pay页面的交租功能使用
    @RequestMapping("/housesByNumbers")
    public Object housesByNumbers(){
        PageInfo<Houses> pageInfo=housesService.queryAll(1,100,null);
        return pageInfo.getList();
    }

}
