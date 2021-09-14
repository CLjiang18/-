package com.yanzhen.service;

import com.github.pagehelper.PageInfo;
import com.yanzhen.model.Owner;

public interface OwnerService {

    /**
     * 分页查询户主信息
     */
    PageInfo<Owner> findOwnerAll(int page, int limit, Owner owner);

    /**
     * 添加功能
     */
    int add(Owner owner);

    /**
     * 删除房主信息
     */
    int delete(Long id);

    /**
     * 修改
     */
    int updateData(Owner owner);

}
