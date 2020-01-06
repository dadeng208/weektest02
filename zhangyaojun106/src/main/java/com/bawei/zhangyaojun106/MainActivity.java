package com.bawei.zhangyaojun106;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.zhangyaojun106.adapter.LeftAdapter;
import com.bawei.zhangyaojun106.adapter.RightAdapter;
import com.bawei.zhangyaojun106.app.MyApp;
import com.bawei.zhangyaojun106.base.BaseActivity;
import com.bawei.zhangyaojun106.base.BasePresenter;
import com.bawei.zhangyaojun106.dao.DaoSession;
import com.bawei.zhangyaojun106.entity.DaoBean;
import com.bawei.zhangyaojun106.entity.LeftBean;
import com.bawei.zhangyaojun106.entity.RightBean;
import com.bawei.zhangyaojun106.presenter.MyPresenter;
import com.bawei.zhangyaojun106.util.NetUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.recycler_left)
    RecyclerView recyclerLeft;
    @BindView(R.id.recycler_right)
    RecyclerView recyclerRight;
    private DaoSession daoSession;

    @Override
    protected void initData() {
        if (NetUtil.getInstance().getNetState(this)) {
            p.getLeft();
        } else {
            List<DaoBean> daoBeans = daoSession.loadAll(DaoBean.class);
            String json = daoBeans.get(0).getJson();
            LeftBean bean = new Gson().fromJson(json, LeftBean.class);
            LeftAdapter adapter = new LeftAdapter(this, bean.getCategory());
            recyclerLeft.setAdapter(adapter);
        }
    }

    @Override
    protected void initView() {
        daoSession = MyApp.getDaoSession();
        recyclerLeft.setLayoutManager(new LinearLayoutManager(this));
        recyclerRight.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    protected BasePresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void viewSuccess(Object o) {
        if (o instanceof LeftBean) {
            LeftBean bean = (LeftBean) o;
            LeftAdapter adapter = new LeftAdapter(this, bean.getCategory());
            recyclerLeft.setAdapter(adapter);
            DaoBean daoBean = new DaoBean(new Gson().toJson(bean));
            daoSession.insertOrReplace(daoBean);
        } else if (o instanceof RightBean) {
            RightBean bean = (RightBean) o;
            RightAdapter adapter = new RightAdapter(this, bean.getData());
            recyclerRight.setAdapter(adapter);
        }
    }

    @Override
    public void viewError(String e) {

    }

    @Subscribe
    public void getName(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("category", name);
        p.getRight(map);
    }
}
