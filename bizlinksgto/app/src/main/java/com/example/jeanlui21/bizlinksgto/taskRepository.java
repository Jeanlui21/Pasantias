package com.example.jeanlui21.bizlinksgto;

import java.util.ArrayList;
import java.util.List;

public class taskRepository {


    private static List<Task> tasks;

    static {

        tasks = new ArrayList<>();

        tasks.add( new Task(1, "Tarea 1", "Descripcion 1", "pendiente","photo1") );
        tasks.add( new Task(2, "Tarea 2", "Descripcion 2", "pendiente","photo2") );
        tasks.add( new Task(3, "Tarea 3", "Descripcion 3", "pendiente","photo3") );

    }

    public static List<Task> getTasks(){
        return tasks;
    }

}


