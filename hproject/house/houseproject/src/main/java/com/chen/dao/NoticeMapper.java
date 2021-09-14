package com.chen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Lookhouse;
import com.chen.pojo.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 公告信息表 公布最新优质房源 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2021-09-01
 */
@Repository
public interface NoticeMapper extends BaseMapper<Notice> {
    /**
     *查询所有的公告记录 支持高级查询
     */
    List<Notice> queryNoticeAll(Notice notice);


}
