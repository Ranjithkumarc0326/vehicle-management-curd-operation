package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainPageActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnIn, btnDel, btnSel, btnUpd, btnSea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        btnIn = findViewById(R.id.btnMainInsert);
        btnIn.setOnClickListener(this);

        btnDel = findViewById(R.id.btnMainDelete);
        btnDel.setOnClickListener(this);

        btnUpd = findViewById(R.id.btnMainUpdate);
        btnUpd.setOnClickListener(this);

        btnSel = findViewById(R.id.btnMainSelection);
        btnSel.setOnClickListener(this);

        btnSea = findViewById(R.id.btnMainSearch);
        btnSea.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btnIn)) {
            Intent it = new Intent(this, InsertActivity.class);
            startActivity(it);
        } else if (view.equals(btnDel)) {
            Intent it = new Intent(this, DeleteActivity.class);
            startActivity(it);
        } else if (view.equals(btnSea)) {
            Intent it = new Intent(this, SearchActivity.class);
            startActivity(it);
        } else if (view.equals(btnUpd)) {
            Intent it = new Intent(this, UpdateActivity.class);
            startActivity(it);
        } else if (view.equals(btnSel)) {
            Intent it = new Intent(this, SelectActivity.class);
            startActivity(it);
        } else {
            Toast.makeText(getBaseContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
        }

    }
}
