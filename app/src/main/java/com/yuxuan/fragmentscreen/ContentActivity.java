package com.yuxuan.fragmentscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Fragment.ContentFragment;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_content);

        Intent intent = this.getIntent();
        String content = intent.getStringExtra("content");

        ContentFragment contentFragment = (ContentFragment) this.getSupportFragmentManager().findFragmentById(R.id.fm_content);
        contentFragment.settext(content);
    }
}
