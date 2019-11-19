package com.uoii.test;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.base.BaseActivity;
import com.base.BaseAdapter;
import com.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * @author guozq
 */
public class TestMainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.test_activity_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestMainActivity.this, "", Toast.LENGTH_LONG).show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rv_test);
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("111");
        list.add("111");
        recyclerView.setAdapter(new MyAdapter(R.layout.item_test, list));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    class MyAdapter extends BaseAdapter<String, BaseViewHolder> {

        public MyAdapter(int layout, List list) {
            super(layout, list);
        }

        @Override
        public void onBindViewHolder(@NonNull BaseViewHolder holder, int i) {
            holder.setText(R.id.textView, list.get(i));
        }
    }
}
