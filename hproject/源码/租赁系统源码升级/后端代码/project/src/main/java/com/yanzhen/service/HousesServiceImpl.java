package com.yanzhen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanzhen.dao.HousesMapper;
import com.yanzhen.model.Houses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 房屋信息管理 服务实现类
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
@Service
public class HousesServiceImpl extends ServiceImpl<HousesMapper, Houses> implements IHousesService {

    @Autowired
    private HousesMapper housesDao;
    @Override
    public PageInfo<Houses> findHouseAll(Integer page, Integer pageSize, Houses houses) {

        PageHelper.startPage(page,pageSize);
        //查询所有的房屋信息
        List<Houses> list=housesDao.queryHouseAll(houses);
        System.out.println(list);
        PageInfo<Houses> pageInfo=new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public PageInfo<Houses> findHouseAll2(Integer page, Integer pageSize, Integer id) {
        PageHelper.startPage(page,pageSize);
        //查询所有的房屋信息
        List<Houses> list=housesDao.queryHouseAll2(id);

        PageInfo<Houses> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public IPage<Houses> findListByPage(Integer page, Integer pageCount){
        IPage<Houses> wherePage = new Page<>(page, pageCount);
        Houses where = new Houses();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Houses houses){
        return baseMapper.insert(houses);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Houses houses){
        return baseMapper.updateById(houses);
    }

    @Override
    public Houses findById(Long id){
        QueryWrapper<Houses> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(Houses.class, info -> !info.getColumn().equals("zt")
                && !info.getColumn().equals("look_id") && !info.getColumn().equals("owner"));
        queryWrapper.eq("id",id);
        Houses houses = baseMapper.selectOne(queryWrapper);
        return houses;
    }
}
