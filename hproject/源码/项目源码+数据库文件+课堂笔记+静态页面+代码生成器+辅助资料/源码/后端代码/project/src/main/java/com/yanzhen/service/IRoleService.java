package com.yanzhen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yanzhen.model.Role;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
public interface IRoleService extends IService<Role> {

    /**
     * 查询角色信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Role>
     */
    IPage<Role> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加角色信息表
     *
     * @param role 角色信息表
     * @return int
     */
    int add(Role role);

    /**
     * 删除角色信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改角色信息表
     *
     * @param role 角色信息表
     * @return int
     */
    int updateData(Role role);

    /**
     * id查询数据
     *
     * @param id id
     * @return Role
     */
    Role findById(Long id);
}
