package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {
    EditText delete;
    MyCoreDatabase myData;
    DemoClass obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delete = (EditText) findViewById(R.id.eDelete);
        myData = new MyCoreDatabase(this);
    }

    public void dodelete(View view) {
        obj = new DemoClass(null,null,delete.getText().toString());
        myData.deleteData(obj);
    }
}