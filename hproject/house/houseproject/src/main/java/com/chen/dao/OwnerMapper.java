package com.chen.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Owner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("ownerDao")
public interface OwnerMapper extends BaseMapper<Owner> {
    /**
     * 查询户主信息
     */
    List<Owner> queryOwnerAll(Owner owner);
}
