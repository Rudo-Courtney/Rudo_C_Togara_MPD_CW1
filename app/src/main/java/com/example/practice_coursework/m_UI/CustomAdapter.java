package com.example.practice_coursework.m_UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice_coursework.R;
import com.example.practice_coursework.m_DataObject.Roadwork;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Roadwork> roadworkList;


    public CustomAdapter(Context c, ArrayList<Roadwork> roadworkList) {
        this.c = c;
        this.roadworkList = roadworkList;
    }

    @Override
    public int getCount() {
        return roadworkList.size();
    }

    @Override
    public Object getItem(int position) {
        return roadworkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }

        TextView titleTxt = (TextView) convertView.findViewById(R.id.titleTxt);
        TextView descTxt = (TextView) convertView.findViewById(R.id.descTxt);
        TextView roadTxt = (TextView) convertView.findViewById(R.id.roadTxt);
        TextView pubDate = (TextView) convertView.findViewById(R.id.pubDate);

        Roadwork roadwork= (Roadwork) this.getItem(position);

        titleTxt.setText(roadwork.getTitle());
        descTxt.setText(roadwork.getDescription().substring(0,150));
        roadTxt.setText(roadwork.getRoad());
        pubDate.setText(roadwork.getPubDate());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(c, ShowDefinition.class);
                //c.startActivity(intent);
                Toast.makeText(c,roadwork.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

}
