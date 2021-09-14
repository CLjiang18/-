package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.RentalsMapper;
import com.chen.pojo.Customer;
import com.chen.pojo.Rentals;
import com.chen.pojo.RentalsVo;
import com.chen.pojo.TongJi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private RentalsMapper rentalsMapper;
    @Override
    public PageInfo<RentalsVo> queryAll(int page, int limit, RentalsVo rentalsVo) {
        //分页
        PageHelper.startPage(page,limit);
        //查询所有用户信息
        List<RentalsVo> list=rentalsMapper.queryList(rentalsVo);
        PageInfo<RentalsVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

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

    @Override
    public List<TongJi> queryCounts() {
        return rentalsMapper.queryCounts();
    }
}
