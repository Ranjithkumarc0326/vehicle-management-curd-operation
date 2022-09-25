package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText old,dom,newV;
    MyCoreDatabase myData;
    DemoClass oldObj,newObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        old = (EditText) findViewById(R.id.eoldpno);
        dom = (EditText)findViewById(R.id.eUpdate);
        newV = (EditText) findViewById(R.id.enewpno);
        myData = new MyCoreDatabase(this);


    }

    public void doUpdate(View view) {
        oldObj = new DemoClass(null,null,old.getText().toString());
        if (dom.getText().toString().equals("vname"))
            newObj = new DemoClass(newV.getText().toString(),null,null);
        else if (dom.getText().toString().equals("rno"))
            newObj = new DemoClass(null,newV.getText().toString(),null);
        else
            newObj = new DemoClass(null,null,dom.getText().toString());
        myData.updateData(oldObj,newObj);
    }
}