package com.dokgo.junkiproj.Activity;

/**
 * Created by JawsGeun on 2018-01-30.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dokgo.junkiproj.R;

public class LoginActivity extends AppCompatActivity {

    private Button button1, button2;
    private EditText Etext1, Etext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        Etext1 = (EditText) findViewById(R.id.editText1);
        Etext2 = (EditText) findViewById(R.id.editText2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id, pass;
                id = "junki";
                pass = "1234";
                Log.e(Etext1.getText().toString(),Etext2.getText().toString());
                if (Etext1.getText().toString().equals(id) && Etext2.getText().toString().equals(pass)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else Toast.makeText(getApplicationContext(),"등록된 정보 없음",Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
