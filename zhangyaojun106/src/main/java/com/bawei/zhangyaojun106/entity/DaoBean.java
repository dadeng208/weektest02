package com.bawei.zhangyaojun106.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author 张耀军
 * @createTime 2020/1/6 10:42
 * @description
 */
@Entity
public class DaoBean {
    String json;

    @Generated(hash = 1842370956)
    public DaoBean(String json) {
        this.json = json;
    }

    @Generated(hash = 405743142)
    public DaoBean() {
    }

    public String getJson() {
        return this.json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
