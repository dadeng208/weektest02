package com.bawei.zhangyaojun106.presenter;


import com.bawei.zhangyaojun106.base.BasePresenter;
import com.bawei.zhangyaojun106.contract.IContract;
import com.bawei.zhangyaojun106.model.MyModel;

import java.util.Map;

/**
 * @author 张耀军
 * @createTime 2020/1/6 9:34
 * @description P 层
 */
public class MyPresenter extends BasePresenter {
    @Override
    public void getLeft() {
        new MyModel().modelGetLeft(new IContract.ModelCallback() {
            @Override
            public void modelSuccess(Object o) {
                getView().viewSuccess(o);
            }

            @Override
            public void modelError(String e) {
                getView().viewError(e);
            }
        });
    }

    @Override
    public void getRight(Map<String, String> map) {
        new MyModel().modelGetRight(map, new IContract.ModelCallback() {
            @Override
            public void modelSuccess(Object o) {
                getView().viewSuccess(o);
            }

            @Override
            public void modelError(String e) {
                getView().viewError(e);
            }
        });
    }
}
