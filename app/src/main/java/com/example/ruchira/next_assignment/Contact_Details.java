package com.example.ruchira.next_assignment;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class Contact_Details extends AppCompatActivity implements View.OnClickListener{
    String name,phone,message;
    SQLiteDatabase mydatabase;
    ConstraintLayout cl;
    public void onClick(View view){
        if(view.getId()==R.id.cons){
            InputMethodManager i=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            i.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

        }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__details);
        cl=(ConstraintLayout)findViewById(R.id.cons);
        cl.setOnClickListener(this);


    }
    public void saveit(View view){
        EditText name2=(EditText)findViewById(R.id.editText);
        EditText phone2=(EditText)findViewById(R.id.editText2);
        EditText message2=(EditText)findViewById(R.id.editText3);
        name=name2.getText().toString();
        phone=phone2.getText().toString();
        message=message2.getText().toString();
        try{
            mydatabase=this.openOrCreateDatabase("MyContacts",MODE_PRIVATE,null);
            mydatabase.execSQL("CREATE TABLE IF NOT EXISTS MyContacts(name varchar,phone long,message varchar)");
            String q="INSERT INTO MyContacts VALUES ('"+name+"','"+phone+"','"+message+"'"+")";
            mydatabase.execSQL(q);
            Toast.makeText(this, "Successfully closed", Toast.LENGTH_SHORT).show();

        }

        catch(Exception e) {
            Toast.makeText(this,"Unsuccessful", Toast.LENGTH_SHORT).show();

        }}
    public void viewit(View view){
        AlertDialog.Builder alert=new AlertDialog.Builder(Contact_Details.this);
        alert.setMessage("Need to wish him happy birthday!!!!!").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(getApplicationContext(),View_Contacts.class);
                startActivity(intent);
            }
        }).setNegativeButton("Cancel",null);
        AlertDialog a=alert.create();
        a.show();


    }


    }

