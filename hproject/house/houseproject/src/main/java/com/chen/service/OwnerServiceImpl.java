package com.chen.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.OwnerMapper;
import com.chen.pojo.Owner;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ownerService")
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper,Owner> implements OwnerService{
    @Autowired
    private OwnerMapper ownerDao;
    @Override
    public PageInfo<Owner> findOwnerAll(int page, int limit, Owner owner) {
        //分页
        PageHelper.startPage(page,limit);
        //查询所有用户信息
        List<Owner> list=ownerDao.queryOwnerAll(owner);
        PageInfo<Owner> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addOwner(Owner owner) {
        return baseMapper.insert(owner);
    }

    @Override
    public int deleteOwner(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateOwner(Owner owner) {
        return baseMapper.updateById(owner);
    }
}
