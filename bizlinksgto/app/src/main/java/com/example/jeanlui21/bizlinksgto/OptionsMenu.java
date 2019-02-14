package com.example.jeanlui21.bizlinksgto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OptionsMenu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
        findViewById(R.id.btn_newReport).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        { case R.id.btn_newReport:
                Intent a= new Intent(this, newReport.class);
                startActivity(a);
                break;
        }
    }
}