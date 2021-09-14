package com.chen.service;

import com.chen.pojo.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 公告信息表 公布最新优质房源 服务类
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
public interface INoticeService extends IService<Notice> {

    /**
     * 查询公告信息表 公布最新优质房源分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Notice>
     */
    IPage<Notice> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加公告信息表 公布最新优质房源
     *
     * @param notice 公告信息表 公布最新优质房源
     * @return int
     */
    int add(Notice notice);

    /**
     * 删除公告信息表 公布最新优质房源
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改公告信息表 公布最新优质房源
     *
     * @param notice 公告信息表 公布最新优质房源
     * @return int
     */
    int updateData(Notice notice);

    /**
     * id查询数据
     *
     * @param id id
     * @return Notice
     */
    Notice findById(Long id);
}
