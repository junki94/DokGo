package com.dokgo.junkiproj.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dokgo.junkiproj.Data.ListData;
import com.dokgo.junkiproj.DetailActivity;
import com.dokgo.junkiproj.Holder.ListHolder;
import com.dokgo.junkiproj.R;

import java.util.ArrayList;

/**
 * Created by JawsGeun on 2018-01-30.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<ListData> SharedData = new ArrayList<>();
    public MyAdapter(ArrayList<ListData> SharedData) {
        this.SharedData=SharedData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View parentView = inflater.inflate(R.layout.layout_detail,parent,false);
        viewHolder = new ListHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ListHolder listHolder = (ListHolder)holder;
        listHolder.name.setText(SharedData.get(position).getName());
        listHolder.addr.setText(SharedData.get(position).getAddr());
        // TODO 홀더에서 이미지뷰 가져온다음 노인 이름에 매치해서 이미지 설정
//        if(노인이름)
//        listHolder.img.setImageResource(R.drawable.이미지이름);
        listHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(listHolder.parent.getContext(), DetailActivity.class);
                listHolder.parent.getContext().startActivity(intent);
                ((Activity)(listHolder.parent.getContext())).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return SharedData.size();
    }
}
