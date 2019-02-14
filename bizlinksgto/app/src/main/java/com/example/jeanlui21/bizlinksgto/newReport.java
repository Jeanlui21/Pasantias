package com.example.jeanlui21.bizlinksgto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import java.util.List;

public class newReport extends AppCompatActivity {

    private RecyclerView taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_report);

        taskList = (RecyclerView) findViewById(R.id.tasks_list);

        taskList.setLayoutManager(new LinearLayoutManager(this));

        tasksAdapter adapter = new tasksAdapter();

        List<Task> tasks = taskRepository.getTasks();
        adapter.setTasks(tasks);

        taskList.setAdapter(adapter);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_norealizado:
                if (checked)
                    break;
            case R.id.radio_parcial:
                if (checked)
                    break;
            case R.id.radio_realizado:
                if (checked)
                    break;
        }
    }
}
