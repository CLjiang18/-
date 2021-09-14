package com.yanzhen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yanzhen.model.Lookhouse;
import com.yanzhen.model.Rentinfo;

/**
 * <p>
 * 租赁信息表 服务类
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
 */
public interface IRentinfoService extends IService<Rentinfo> {

    /**
     * 分页查询看租赁信息
     */
    PageInfo<Rentinfo> findRentinfoAll(int page, int limit, Rentinfo rentinfo);

    /**
     * 查询租赁信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Rentinfo>
     */
    IPage<Rentinfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加租赁信息表
     *
     * @param rentinfo 租赁信息表
     * @return int
     */
    int add(Rentinfo rentinfo);

    /**
     * 删除租赁信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改租赁信息表
     *
     * @param rentinfo 租赁信息表
     * @return int
     */
    int updateData(Rentinfo rentinfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return Rentinfo
     */
    Rentinfo findById(Long id);

    //根据房子id查询客户信息
    Rentinfo queryRentInfoByHouId(Integer houId);
}
