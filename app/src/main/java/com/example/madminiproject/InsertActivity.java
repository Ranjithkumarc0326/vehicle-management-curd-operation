package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    EditText name,phone,rno;
    MyCoreDatabase myData;
    DemoClass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        name=(EditText) findViewById(R.id.eName);
        phone=(EditText) findViewById(R.id.ePno);
        rno=(EditText) findViewById(R.id.eRno);

        myData = new MyCoreDatabase(this);
    }

    public void doSave(View view) {
        obj = new DemoClass(name.getText().toString(),rno.getText().toString(),phone.getText().toString());
        myData.insertData(obj);
    }
}