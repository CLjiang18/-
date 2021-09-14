package com.chen.service.impl;

import com.chen.pojo.Rentinfo;
import com.chen.dao.RentinfoMapper;
import com.chen.service.IRentinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 租赁信息表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Service
public class RentinfoServiceImpl extends ServiceImpl<RentinfoMapper, Rentinfo> implements IRentinfoService {

    @Override
    public  IPage<Rentinfo> findListByPage(Integer page, Integer pageCount){
        IPage<Rentinfo> wherePage = new Page<>(page, pageCount);
        Rentinfo where = new Rentinfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Rentinfo rentinfo){
        return baseMapper.insert(rentinfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Rentinfo rentinfo){
        return baseMapper.updateById(rentinfo);
    }

    @Override
    public Rentinfo findById(Long id){
        return  baseMapper.selectById(id);
    }
}
