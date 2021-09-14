package com.chen.service.impl;

import com.chen.pojo.Rentals;
import com.chen.dao.RentalsMapper;
import com.chen.service.IRentalsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 收租信息表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Service
public class RentalsServiceImpl extends ServiceImpl<RentalsMapper, Rentals> implements IRentalsService {

    @Override
    public  IPage<Rentals> findListByPage(Integer page, Integer pageCount){
        IPage<Rentals> wherePage = new Page<>(page, pageCount);
        Rentals where = new Rentals();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Rentals rentals){
        return baseMapper.insert(rentals);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Rentals rentals){
        return baseMapper.updateById(rentals);
    }

    @Override
    public Rentals findById(Long id){
        return  baseMapper.selectById(id);
    }
}
