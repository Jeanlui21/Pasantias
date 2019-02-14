package com.example.jeanlui21.bizlinksgto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class tasksAdapter extends RecyclerView.Adapter<tasksAdapter.ViewHolder> {

    private List<Task> tasks;

    public tasksAdapter(){
        this.tasks = new ArrayList<>();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView evidence;
        TextView taskname;
        TextView taskdesc;
        TextView state;

        public ViewHolder(View itemView) {
            super(itemView);
            taskname = (TextView) itemView.findViewById(R.id.text_taskname);
            taskdesc = (TextView) itemView.findViewById(R.id.text_taskdesc);
            state = (TextView) itemView.findViewById(R.id.text_state);
        }
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Task task = this.tasks.get(position);
        viewHolder.taskname.setText(task.getTaskname());
        viewHolder.taskdesc.setText(task.getTaskdesc());
        viewHolder.state.setText(task.getState());



    }

    @Override
    public int getItemCount() {
        return this.tasks.size();
    }

}
