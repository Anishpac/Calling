package com.example.mycoontacts2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context;
    private DBHandler dbHandler;
    private ListView contactsList;
    private EditText searchText;
    private Button search, add;

    private List<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        dbHandler = new DBHandler(context);



        contactsList =(ListView)findViewById(R.id.contact_List);
        searchText = (EditText)findViewById(R.id.search_text);
        search = (Button)findViewById(R.id.search);
        add = (Button)findViewById(R.id.add);

        contacts = new ArrayList<>();
        contacts = dbHandler.getAllContacts();

        String[] namesArray = new String[contacts.size()];

        for(int x = 0; x<contacts.size();x++){
            namesArray[x] = contacts.get[x].getName();
            Log.d("array_names","onCreate:"+namesArray[x]+contacts.size());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,namesArray);
        contactsList.setAdapter(adapter);

        contactsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onClick(AdapterView<?> adapterView, View view, int i, long 1)
                 Contact contact = contacts.get(i);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(contact.getName())
                    .setMessage(contact.getNumber()
            + "\n" + contact.getOrganisation() + "" +
                    "\n"+ contact.getRelationship());

        ).show();
    });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            }
        });


        add.setOnClickListener(new View.OnClickListener(){
            {
                @Override
                public void onClick (View view){
                Intent intent = new Intent(MainActivity.this, AddContact.class);
                startActivity(intent);
                }
            });
    }
    }