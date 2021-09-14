package com.chen.pojo;

import lombok.Data;

@Data
public class TongJi implements Comparable<TongJi>{
    private String months;//月
    private Integer counts;//数据值

    @Override
    public int compareTo(TongJi o) {
        //按月份有小到大排序
        int months=Integer.parseInt(this.getMonths());
        int omonths=Integer.parseInt(o.getMonths());
        int i=months-omonths;//按月份

        return i;
    }
}
