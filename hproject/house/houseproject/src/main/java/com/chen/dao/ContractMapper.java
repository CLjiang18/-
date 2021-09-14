package com.chen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Contract;
import com.chen.pojo.HeTong;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 合同信息表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Repository
public interface ContractMapper extends BaseMapper<Contract> {

    /**
     * 根据合同id查询
     */
    HeTong queryByID(Integer id);
}
