package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.RepairMapper;
import com.chen.pojo.RentalsVo;
import com.chen.pojo.Repair;
import com.chen.pojo.TongJi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 报修信息表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Service("repairService")
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements IRepairService {
    @Resource
    private RepairMapper repairMapper;
    @Override
    public PageInfo<Repair> queryAll(int page, int limit, Repair repair) {
        PageHelper.startPage(page,limit);
        //查询所有用户信息
        List<Repair> list=repairMapper.queryList(repair);
        PageInfo<Repair> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public  IPage<Repair> findListByPage(Integer page, Integer pageCount){
        IPage<Repair> wherePage = new Page<>(page, pageCount);
        Repair where = new Repair();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Repair repair){
        return baseMapper.insert(repair);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Repair repair){
        return baseMapper.updateById(repair);
    }

    @Override
    public Repair findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<TongJi> queryCounts() {
        return repairMapper.queryCount();
    }
}
