package com.chen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Customer;
import com.chen.pojo.Owner;
import com.chen.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 租户信息表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * 查询租客信息
     */
    List<Customer> queryAll(Customer customer);
    Customer queryUserByNameAndPwd(@Param("username") String username, @Param("password")String password);
}
