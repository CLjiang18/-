package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pojo.Customer;
import com.chen.pojo.Owner;
import com.chen.pojo.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

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
     * 高级查询,支持分页效果
     * @param page
     * @param limit
     * @param customer
     * @return PageInfo<Owner>
     */
    PageInfo<Customer> queryAll(int page, int limit, Customer customer);
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

    Customer queryUserByNameAndPwd(String username, String pwd);
}
