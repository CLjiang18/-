package com.chen.service.impl;

import com.chen.pojo.Houses;
import com.chen.dao.HousesMapper;
import com.chen.service.IHousesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 房屋信息管理 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Service
public class HousesServiceImpl extends ServiceImpl<HousesMapper, Houses> implements IHousesService {

    @Override
    public  IPage<Houses> findListByPage(Integer page, Integer pageCount){
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
        return  baseMapper.selectById(id);
    }
}
