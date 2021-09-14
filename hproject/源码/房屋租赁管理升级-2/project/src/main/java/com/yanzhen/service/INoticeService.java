package com.yanzhen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yanzhen.model.Notice;
import com.yanzhen.model.User;

import java.util.List;

/**
 * <p>
 * 公告信息表 公布最新优质房源 服务类
 * </p>
 *
 * @author kappy
 * @since 2020-09-19
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

    /**
     * 分页查询看房信息列表
     */
    PageInfo<Notice> queryNoticeAll(int page, int limit,String content);
}
