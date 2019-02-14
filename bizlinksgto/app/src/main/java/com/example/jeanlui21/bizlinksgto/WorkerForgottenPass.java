package com.example.jeanlui21.bizlinksgto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WorkerForgottenPass extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_forgotten_pass);
        findViewById(R.id.text_goBack).setOnClickListener(this); }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        { case R.id.text_goBack:
            finish();
            Intent i= new Intent(this, MainActivity.class);
            startActivity(i);
            break; }

    }
}
