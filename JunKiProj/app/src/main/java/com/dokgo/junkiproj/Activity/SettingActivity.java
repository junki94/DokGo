package com.dokgo.junkiproj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dokgo.junkiproj.R;

/**
 * Created by JawsGeun on 2018-01-30.
 */

public class SettingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SettingActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
