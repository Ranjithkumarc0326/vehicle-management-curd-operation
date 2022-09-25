package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {
    EditText search;
    MyCoreDatabase myData;
    DemoClass obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = (EditText) findViewById(R.id.eSearch);
        myData = new MyCoreDatabase(this);
    }

    public void dosearch(View view) {
        obj = new DemoClass(null,null,search.getText().toString());
        myData.searchData(obj);
    }
}