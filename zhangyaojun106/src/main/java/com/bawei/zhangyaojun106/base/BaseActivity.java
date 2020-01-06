package com.bawei.zhangyaojun106.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.zhangyaojun106.contract.IContract;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @author 张耀军
 * @createTime 2020/1/6 9:26
 * @description 封装activity基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContract.IView {
    protected P p;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        bind = ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        p = initPresenter();
        if (p != null) p.attachView(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p != null) {
            p.detachView();
            p = null;
        }
        if (bind != null) bind.unbind();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
