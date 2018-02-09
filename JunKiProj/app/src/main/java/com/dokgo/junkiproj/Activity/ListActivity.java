package com.dokgo.junkiproj.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.dokgo.junkiproj.Adapter.MyAdapter;
import com.dokgo.junkiproj.Data.ListData;
import com.dokgo.junkiproj.R;

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
        adapter = new MyAdapter(getDataFromDB());
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private ArrayList<ListData> getDataFromDB(){
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
}
