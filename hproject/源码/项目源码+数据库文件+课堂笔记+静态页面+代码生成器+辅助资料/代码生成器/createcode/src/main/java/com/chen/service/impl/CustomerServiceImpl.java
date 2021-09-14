package com.chen.service.impl;

import com.chen.pojo.Customer;
import com.chen.dao.CustomerMapper;
import com.chen.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

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
}
