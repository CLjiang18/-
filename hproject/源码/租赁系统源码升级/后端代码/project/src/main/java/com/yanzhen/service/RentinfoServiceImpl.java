package com.yanzhen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanzhen.dao.RentalsMapper;
import com.yanzhen.dao.RentinfoMapper;
import com.yanzhen.model.Lookhouse;
import com.yanzhen.model.Rentinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 租赁信息表 服务实现类
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
@Service
public class RentinfoServiceImpl extends ServiceImpl<RentinfoMapper, Rentinfo> implements IRentinfoService {

    @Autowired
    private RentinfoMapper rentinfoDao;

    @Override
    public PageInfo<Rentinfo> findRentinfoAll(int page, int limit, Rentinfo rentinfo) {
        PageHelper.startPage(page,limit);
        List<Rentinfo> list=rentinfoDao.queryRentinfoAll(rentinfo);
        PageInfo<Rentinfo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public IPage<Rentinfo> findListByPage(Integer page, Integer pageCount){
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

    @Override
    public Rentinfo queryRentInfoByHouId(Integer houId) {
        return rentinfoDao.queryRentInfoByHouId(houId);
    }
}
