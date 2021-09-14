package com.chen.service;

import com.chen.pojo.Owner;
import com.github.pagehelper.PageInfo;

public interface OwnerService {

    /**
     * 分页查询户主信息
     */
    PageInfo<Owner> findOwnerAll(int page,int limit,Owner owner);

    /**
     * 增加用户
     */
    int addOwner(Owner owner);

    /**
     * 删除用户
     */

    int deleteOwner(Long id);

    /**
     * 修改用户
     */
     int updateOwner(Owner owner);
}
