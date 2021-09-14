package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.CustomerMapper;
import com.chen.pojo.Customer;
import com.chen.pojo.Owner;
import com.chen.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 租户信息表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public PageInfo<Customer> queryAll(int page, int limit, Customer customer) {
        //分页
        PageHelper.startPage(page,limit);
        //查询所有用户信息
        List<Customer> list=customerMapper.queryAll(customer);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public  IPage<Customer> findListByPage(Integer page, Integer pageCount){
        IPage<Customer> wherePage = new Page<>(page, pageCount);
        Customer where = new Customer();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Customer customer){
        return baseMapper.insert(customer);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Customer customer){
        return baseMapper.updateById(customer);
    }

    @Override
    public Customer findById(Long id){
        return  baseMapper.selectById(id);
    }
    @Override
    public Customer queryUserByNameAndPwd(String username, String pwd) {
        return customerMapper.queryUserByNameAndPwd(username,pwd);
    }
}
