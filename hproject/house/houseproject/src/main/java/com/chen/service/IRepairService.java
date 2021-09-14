package com.chen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pojo.RentalsVo;
import com.chen.pojo.Repair;
import com.chen.pojo.TongJi;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 * 报修信息表 服务类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
public interface IRepairService extends IService<Repair> {

    /**
     * 高级查询,支持分页效果
     * @param page
     * @param limit
     * @param repair
     * @return PageInfo<Repair>
     */
    PageInfo<Repair> queryAll(int page, int limit, Repair repair);
    /**
     * 查询报修信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Repair>
     */
    IPage<Repair> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加报修信息表
     *
     * @param repair 报修信息表
     * @return int
     */
    int add(Repair repair);

    /**
     * 删除报修信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改报修信息表
     *
     * @param repair 报修信息表
     * @return int
     */
    int updateData(Repair repair);

    /**
     * id查询数据
     *
     * @param id id
     * @return Repair
     */
    Repair findById(Long id);
    //统计信息
    List<TongJi> queryCounts();
}
