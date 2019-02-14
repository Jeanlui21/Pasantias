package com.example.jeanlui21.bizlinksgto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text_workerForgotpass).setOnClickListener(this);
        findViewById(R.id.button_workerLogin).setOnClickListener(this);}

    @Override
    public void onClick(View view) {
        switch (view.getId())
        { case R.id.text_workerForgotpass:
                finish();
                Intent i= new Intent(this, WorkerForgottenPass.class);
                startActivity(i);
                break;
            case R.id.button_workerLogin:
                finish();
                Intent b= new Intent(this, OptionsMenu.class);
                startActivity(b);
                break;
        }

    }
}