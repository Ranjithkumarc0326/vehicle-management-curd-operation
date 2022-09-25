package com.example.madminiproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOwnAdapter  extends RecyclerView.Adapter<MyOwnAdapter.MyOwnHolder> {

    private Context context;
    private ArrayList vname,rno,pno;

    public MyOwnAdapter(Context context, ArrayList vname, ArrayList rno, ArrayList pno) {
        this.context = context;
        this.vname = vname;
        this.rno = rno;
        this.pno = pno;
    }

    @NonNull
    @Override
    public MyOwnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.my_layout,parent,false);
        return new MyOwnHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOwnHolder holder, int position) {
        holder.vname.setText(String.valueOf(vname.get(position)));
        holder.rno.setText(String.valueOf(rno.get(position)));
        holder.pno.setText(String.valueOf(pno.get(position)));

    }

    @Override
    public int getItemCount() {
        return vname.size();
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder{
        TextView vname,rno,pno;
        public MyOwnHolder(@NonNull View itemView) {
            super(itemView);
            vname = itemView.findViewById(R.id.text1);
            rno = itemView.findViewById(R.id.text02);
            pno = itemView.findViewById(R.id.text3);
        }
    }
}
