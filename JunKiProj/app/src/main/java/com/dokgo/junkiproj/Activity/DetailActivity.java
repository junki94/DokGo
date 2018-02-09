package com.dokgo.junkiproj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dokgo.junkiproj.R;

/**
 * Created by JawsGeun on 2018-01-30.
 */

public class DetailActivity extends AppCompatActivity {

    private ImageView img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img = (ImageView)findViewById(R.id.modifyImg);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, ModifyActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"수정하기",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
