package com.bawei.zhangyaojun106.api;
import com.bawei.zhangyaojun106.entity.LeftBean;
import com.bawei.zhangyaojun106.entity.RightBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author 张耀军
 * @createTime 2020/1/6 8:55
 * @description
 */
public interface MyApi {

    @GET(Api.leftData)
    Observable<LeftBean> getLeft();

    @GET(Api.rightData)
    Observable<RightBean> getRight(@QueryMap Map<String, String> map);
}
