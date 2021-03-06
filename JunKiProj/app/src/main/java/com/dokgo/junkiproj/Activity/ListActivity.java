package com.dokgo.junkiproj.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.dokgo.junkiproj.Adapter.MyAdapter;
import com.dokgo.junkiproj.Data.ListData;
import com.dokgo.junkiproj.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by JawsGeun on 2018-01-30.
 */

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = (RecyclerView)findViewById(R.id.list_recycle);
        Task task = new Task();
        task.execute("http://ec2-18-220-255-40.us-east-2.compute.amazonaws.com/senior.php");

    }
    private class Task extends AsyncTask<String,Void,Void>{
        String str="null";
        @Override
        protected Void doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("POST"); // URL 요청에 대한 메소드 설정 : POST.
                conn.setRequestProperty("Accept-Charset", "UTF-8"); // Accept-Charset 설정.
                conn.setRequestProperty("Context_Type", "application/x-www-form-urlencoded;cahrset=UTF-8");
                if(conn.getResponseCode() == conn.HTTP_OK){
                    Log.e("http","ok");
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(),"UTF-8");
                    BufferedReader br = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();
                    while ((str = br.readLine()) != null) {
                        buffer.append(str);
                    }
                    br.close();
                    tmp.close();
                }
            }catch (MalformedURLException e){
             return null;
            }catch (IOException e){
                return null;
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {

            adapter = new MyAdapter(getDataFromDB(this.str));
            layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
    }
    }
    private ArrayList<ListData> getDataFromDB(String str){
        Log.e("내용",str);
        ArrayList<ListData> finalData = new ArrayList<ListData>();
        ListData listViewData = new ListData();
        listViewData.setName("송준기");
        listViewData.setAddr("군대");
        finalData.add(listViewData);
        listViewData = new ListData();
        listViewData.setName("김준기");
        listViewData.setAddr("송도");
        finalData.add(listViewData);
        listViewData = new ListData();
        listViewData.setName("조수근");
        listViewData.setAddr("인천");
        finalData.add(listViewData);
        listViewData = new ListData();
        listViewData.setName("이수근");
        listViewData.setAddr("이천");
        finalData.add(listViewData);
        listViewData = new ListData();
        listViewData.setName("박준기");
        listViewData.setAddr("대천");
        finalData.add(listViewData);
        listViewData = new ListData();
        listViewData.setName("호호호");
        listViewData.setAddr("없음");
        finalData.add(listViewData);

        return finalData;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ListActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
