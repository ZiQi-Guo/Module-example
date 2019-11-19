package com;

import android.content.Intent;
import android.view.View;


import com.base.BaseActivity;
import com.uoii.app.R;
import com.uoii.test.TestMainActivity;


/**
 * @author guozq
 * @date 2019/7/4
 * @desc 外壳
 */
public class ShellMainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShellMainActivity.this, TestMainActivity.class);
//                intent.setClass(ShellMainActivity.this, CommMainActivity.class);
                startActivity(intent);
            }
        });
    }

}
