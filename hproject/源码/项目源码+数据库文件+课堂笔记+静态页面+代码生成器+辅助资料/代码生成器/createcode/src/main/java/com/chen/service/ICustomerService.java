package com.chen.service;

import com.chen.pojo.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 租户信息表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
public interface ICustomerService extends IService<Customer> {

    /**
     * 查询租户信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Customer>
     */
    IPage<Customer> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加租户信息表
     *
     * @param customer 租户信息表
     * @return int
     */
    int add(Customer customer);

    /**
     * 删除租户信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改租户信息表
     *
     * @param customer 租户信息表
     * @return int
     */
    int updateData(Customer customer);

    /**
     * id查询数据
     *
     * @param id id
     * @return Customer
     */
    Customer findById(Long id);
}
