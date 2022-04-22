package com.example.practice_coursework.m_UI;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice_coursework.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView titleTxt,descTxt,pubDate;


    public MyViewHolder(View itemView) {
        super(itemView);

        titleTxt=(TextView) itemView.findViewById(R.id.titleTxt);
        descTxt=(TextView) itemView.findViewById(R.id.descTxt);
        pubDate=(TextView) itemView.findViewById(R.id.pubDate);
    }


}
