package com.example.recicler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsList = (RecyclerView) findViewById(R.id.contacts_list);

        contactsList.setLayoutManager(new LinearLayoutManager(this));

        ContactsAdapter adapter = new ContactsAdapter();

        List<Person> persons = PersonRepository.getPersons();
        adapter.setPersons(persons);

        contactsList.setAdapter(adapter);
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