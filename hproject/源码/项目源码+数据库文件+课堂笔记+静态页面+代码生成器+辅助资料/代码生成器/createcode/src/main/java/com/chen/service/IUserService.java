package com.chen.service;

import com.chen.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
public interface IUserService extends IService<User> {

    /**
     * 查询用户信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<User>
     */
    IPage<User> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加用户信息表
     *
     * @param user 用户信息表
     * @return int
     */
    int add(User user);

    /**
     * 删除用户信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改用户信息表
     *
     * @param user 用户信息表
     * @return int
     */
    int updateData(User user);

    /**
     * id查询数据
     *
     * @param id id
     * @return User
     */
    User findById(Long id);
}
