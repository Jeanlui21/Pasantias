package com.example.recicler;

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

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Person> persons;

    public ContactsAdapter(){
        this.persons = new ArrayList<>();
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView picture;
        TextView fullname;
        TextView email;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture_image);
            fullname = (TextView) itemView.findViewById(R.id.fullname_text);
            email = (TextView) itemView.findViewById(R.id.email_text);
        }
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Person person = this.persons.get(position);
        viewHolder.fullname.setText(person.getFullname());
        viewHolder.email.setText(person.getEmail());

        Context context = viewHolder.itemView.getContext();
        int idRes = context.getResources().getIdentifier(person.getPicture(), "drawable", context.getPackageName());
        viewHolder.picture.setImageResource(idRes);

    }

    @Override
    public int getItemCount() {
        return this.persons.size();
    }

}
