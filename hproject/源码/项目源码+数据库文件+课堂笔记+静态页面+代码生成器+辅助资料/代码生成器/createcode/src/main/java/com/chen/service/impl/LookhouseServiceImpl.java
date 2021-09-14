package com.chen.service.impl;

import com.chen.pojo.Lookhouse;
import com.chen.dao.LookhouseMapper;
import com.chen.service.ILookhouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

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
