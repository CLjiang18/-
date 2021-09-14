package com.yanzhen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanzhen.dao.DeptMapper;
import com.yanzhen.model.Dept;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门信息表 服务实现类
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    public IPage<Dept> findListByPage(Integer page, Integer pageCount){
        IPage<Dept> wherePage = new Page<>(page, pageCount);
        Dept where = new Dept();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Dept dept){
        return baseMapper.insert(dept);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Dept dept){
        return baseMapper.updateById(dept);
    }

    @Override
    public Dept findById(Long id){
        return  baseMapper.selectById(id);
    }
}
