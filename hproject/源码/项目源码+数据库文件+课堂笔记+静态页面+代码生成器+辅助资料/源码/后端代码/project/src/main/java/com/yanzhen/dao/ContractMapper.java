package com.yanzhen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.Contract;
import com.yanzhen.model.HeTong;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 合同信息表 Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
@Component("contractDao")
public interface ContractMapper extends BaseMapper<Contract> {
    /**
     * 查询合同相关详细信息
     */
    HeTong queryByHeTongId(Integer id);


}
