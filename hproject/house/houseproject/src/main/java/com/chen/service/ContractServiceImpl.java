package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.ContractMapper;
import com.chen.pojo.Contract;
import com.chen.pojo.HeTong;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 合同信息表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    @Resource
    private ContractMapper contractMapper;
    @Override
    public  IPage<Contract> findListByPage(Integer page, Integer pageCount){
        IPage<Contract> wherePage = new Page<>(page, pageCount);
        Contract where = new Contract();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Contract contract){
        return baseMapper.insert(contract);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Contract contract){
        return baseMapper.updateById(contract);
    }

    @Override
    public Contract findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public HeTong findByID(Integer id) {
        return contractMapper.queryByID(id);
    }
}
