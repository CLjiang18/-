package com.yanzhen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yanzhen.model.Rentinfo;
import com.yanzhen.model.Repair;
import com.yanzhen.model.TongJi;

import java.util.List;

/**
 * <p>
 * 报修信息表 服务类
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
public interface IRepairService extends IService<Repair> {

    PageInfo<Repair> findRepairAll(int page, int limit, Repair repair);
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

    List<TongJi> queryCounts();

}
