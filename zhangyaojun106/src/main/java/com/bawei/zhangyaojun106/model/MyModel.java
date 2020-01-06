package com.bawei.zhangyaojun106.model;


import com.bawei.zhangyaojun106.api.MyApi;
import com.bawei.zhangyaojun106.contract.IContract;
import com.bawei.zhangyaojun106.entity.LeftBean;
import com.bawei.zhangyaojun106.entity.RightBean;
import com.bawei.zhangyaojun106.util.NetUtil;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 张耀军
 * @createTime 2020/1/6 9:22
 * @description M层请求数据
 */
public class MyModel implements IContract.IModel {

    @Override
    public void modelGetLeft(final IContract.ModelCallback callback) {
        NetUtil.getInstance().createService(MyApi.class).getLeft()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftBean leftBean) {
                        callback.modelSuccess(leftBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.modelError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void modelGetRight(Map<String, String> map, final IContract.ModelCallback callback) {
        NetUtil.getInstance().createService(MyApi.class).getRight(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightBean rightBean) {
                        callback.modelSuccess(rightBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.modelError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
