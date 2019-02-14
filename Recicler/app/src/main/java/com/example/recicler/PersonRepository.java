package com.example.recicler;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private static List<Person> persons;

    static {
        persons = new ArrayList<>();
        persons.add( new Person(1, "Tarea 1", "descripcion 1", "jperez") );
        persons.add( new Person(2, "Tarea 2", "descripcion 2", "mchavez") );
        persons.add( new Person(3, "Tarea 3", "descripcion 3", "mprado") );

    }

    public static List<Person> getPersons(){
        return persons;
    }

}