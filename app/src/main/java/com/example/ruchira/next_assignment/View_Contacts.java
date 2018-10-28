package com.example.ruchira.next_assignment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class View_Contacts extends AppCompatActivity {
    SQLiteDatabase me;
    ArrayList<String> data;
    ArrayAdapter e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__contacts);
        ListView l=(ListView)findViewById(R.id.list);
        Intent intent=getIntent();
        data=new ArrayList<String>();
        try{
            me=this.openOrCreateDatabase("MyContacts",MODE_PRIVATE,null);
            Cursor c=me.rawQuery("SELECT * FROM MyContacts",null);
            c.moveToFirst();
            int nameIndex=c.getColumnIndex("name");
            int phoneIndex=c.getColumnIndex("phone");
            int messageIndex=c.getColumnIndex("message");
            while(c!=null) {
                String mydata=c.getString(nameIndex) + "\n" + c.getString(phoneIndex) + "\n" + c.getString(messageIndex);
                data.add(mydata);
                e=new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
                l.setAdapter(e);
                // t.setText(c.getString(nameIndex) + " " + c.getString(emailIndex) + " " + c.getString(phoneIndex));

                c.moveToNext();
            }
        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
    }


