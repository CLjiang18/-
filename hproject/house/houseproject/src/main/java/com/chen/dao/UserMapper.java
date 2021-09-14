package com.chen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Owner;
import com.chen.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询管理员信息
     */
    List<User> queryUserAll(User user);
    /**
     * 根据用户名密码判断获取用户信息
     */
    User queryUserByNameAndPwd(@Param("username") String username, @Param("password")String password);
}
