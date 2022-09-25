package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {
    RecyclerView r1;
    ArrayList<String> vname,rno,pno;
    MyCoreDatabase myData;
    MyOwnAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        r1=(RecyclerView) findViewById(R.id.myRecycler);
        myData = new MyCoreDatabase(this);
        vname = new ArrayList<>();
        rno = new ArrayList<>();
        pno = new ArrayList<>();
        adapter = new MyOwnAdapter(this,vname,rno,pno);
        r1.setAdapter(adapter);
        r1.setLayoutManager(new LinearLayoutManager(this));
        displayData();

    }

    private void displayData() {
        Cursor cr = myData.getData();
        if(cr.getCount()==0){
            Toast.makeText(this, "Table Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while (cr.moveToNext())
            {
                vname.add(cr.getString(1));
                rno.add(cr.getString(2));
                pno.add(cr.getString(3));
            }
        }
    }
}