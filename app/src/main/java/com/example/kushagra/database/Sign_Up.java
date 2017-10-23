package com.example.kushagra.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_Up extends AppCompatActivity {

    Databasehelper helper;
    EditText name,contact,ward,email,pass1,pass2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);


        helper =new Databasehelper(this);

        name=(EditText)findViewById(R.id.editText2);
        contact=(EditText)findViewById(R.id.editText3);
        ward=(EditText)findViewById(R.id.editText4);
        email=(EditText)findViewById(R.id.editText5);
        pass1=(EditText)findViewById(R.id.editText6);
        pass2=(EditText)findViewById(R.id.editText7);
        button=(Button)findViewById(R.id.button);




    }


    public void Sign_Up_Button(View view) {

        String namestr = name.getText().toString();
        String contactstr = contact.getText().toString();
        String wardstr = ward.getText().toString();
        String emailstr = email.getText().toString();
        String passwordstr = pass1.getText().toString();
        String password2str = pass2.getText().toString();

        if (!passwordstr.equals(password2str)) {

            Toast pass = Toast.makeText(Sign_Up.this, "Password mismatch", Toast.LENGTH_LONG);
            pass.show();

        }
        else {
            boolean isinserted = helper.insertData(namestr, contactstr, wardstr, emailstr, passwordstr);
            if (isinserted = true)
                Toast.makeText(Sign_Up.this, "Registered successfully", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Sign_Up.this, "Data not inserted", Toast.LENGTH_LONG).show();

        }

        Intent k= new Intent(this,MainActivity.class);
        startActivity(k);
    }
}
