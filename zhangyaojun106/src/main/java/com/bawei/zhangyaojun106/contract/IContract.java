package com.bawei.zhangyaojun106.contract;

import java.util.Map;

/**
 * @author 张耀军
 * @createTime 2020/1/6 9:17
 * @description 契约类统一管理接口
 */
public interface IContract {

    interface IModel {
        void modelGetLeft(ModelCallback callback);

        void modelGetRight(Map<String, String> map, ModelCallback callback);
    }

    interface ModelCallback {
        void modelSuccess(Object o);

        void modelError(String e);
    }

    interface IView {
        void viewSuccess(Object o);

        void viewError(String e);
    }

    interface IPresenter {
        void getLeft();

        void getRight(Map<String, String> map);
    }
}
