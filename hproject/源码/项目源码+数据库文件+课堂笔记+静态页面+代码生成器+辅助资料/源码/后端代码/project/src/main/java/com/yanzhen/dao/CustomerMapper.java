package com.yanzhen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 租户信息表 Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
@Component("customerMapper")
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> queryAll(Customer customer);

    Customer queryUserByNameAndPwd(@Param("username") String username, @Param("password")String password);

}
