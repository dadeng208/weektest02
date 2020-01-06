package com.bawei.zhangyaojun106.base;


import com.bawei.zhangyaojun106.contract.IContract;

import java.lang.ref.WeakReference;

/**
 * @author 张耀军
 * @createTime 2020/1/6 9:26
 * @description 封装presenter基类
 */
public abstract class BasePresenter<V extends BaseActivity> implements IContract.IPresenter {

    protected WeakReference<V> v;

    protected void attachView(V v) {
        this.v = new WeakReference<>(v);
    }

    protected void detachView() {
        v.clear();
        v = null;
    }

    protected V getView() {
        return v.get();
    }
}
