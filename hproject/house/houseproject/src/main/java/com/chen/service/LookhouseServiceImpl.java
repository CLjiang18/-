package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.LookhouseMapper;
import com.chen.pojo.Customer;
import com.chen.pojo.Houses;
import com.chen.pojo.Lookhouse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 看房信息表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Service
public class LookhouseServiceImpl extends ServiceImpl<LookhouseMapper, Lookhouse> implements ILookhouseService {
    @Autowired
    private LookhouseMapper lookhouseMapper;
    @Override
    public PageInfo<Lookhouse> queryLookHouseAll(Integer page, Integer limit, Lookhouse lookhouse) {
        //分页
        PageHelper.startPage(page,limit);
        //查询所有用户信息
        List<Lookhouse> list=lookhouseMapper.queryLookHouseAll(lookhouse);
        PageInfo<Lookhouse> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
    public Lookhouse queryById(Integer id){
        return lookhouseMapper.queryById(id);
    }

    @Override
    public  IPage<Lookhouse> findListByPage(Integer page, Integer pageCount){
        IPage<Lookhouse> wherePage = new Page<>(page, pageCount);
        Lookhouse where = new Lookhouse();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Lookhouse lookhouse){
        return baseMapper.insert(lookhouse);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Lookhouse lookhouse){
        return baseMapper.updateById(lookhouse);
    }

    @Override
    public Lookhouse findById(Long id){
        return  baseMapper.selectById(id);
    }
}
