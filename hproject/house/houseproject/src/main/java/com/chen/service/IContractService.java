package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pojo.Contract;
import com.chen.pojo.HeTong;

/**
 * <p>
 * 合同信息表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
public interface IContractService extends IService<Contract> {

    /**
     * 查询合同信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Contract>
     */
    IPage<Contract> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加合同信息表
     *
     * @param contract 合同信息表
     * @return int
     */
    int add(Contract contract);

    /**
     * 删除合同信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改合同信息表
     *
     * @param contract 合同信息表
     * @return int
     */
    int updateData(Contract contract);

    /**
     * id查询数据
     *
     * @param id id
     * @return Contract
     */
    Contract findById(Long id);

    HeTong findByID(Integer id);
}
