package com.afterquestion.criminalintent;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mac on 16/11/26.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();
    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
        setContentView(getLayoutResId());
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit(); }
    }
}

//    传递到 add() 的第一个参数是 ViewGroup，即应该放置片段的位置，由资源 ID 指定，第二个参数是要添加的片段。
//        一旦您通过 FragmentTransaction 做出了更改，就必须调用 commit() 以使更改生效。

