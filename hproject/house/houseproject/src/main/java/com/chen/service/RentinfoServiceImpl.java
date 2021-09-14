package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.RentinfoMapper;
import com.chen.pojo.Houses;
import com.chen.pojo.Rentinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private RentinfoMapper rentinfoMapper;
    @Override
    public PageInfo<Rentinfo> queryAll(Integer page, Integer limit, Rentinfo rentinfo) {
        PageHelper.startPage(page,limit);
        //查询所有的房屋信息
        List<Rentinfo> list=rentinfoMapper.queryRentInfoALL(rentinfo);
        PageInfo<Rentinfo> pageInfo=new PageInfo<>(list);

        return pageInfo;
    }

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

    @Override
    public Rentinfo queryByHId(Integer id) {
        return rentinfoMapper.queryByHId(id);
    }
}
