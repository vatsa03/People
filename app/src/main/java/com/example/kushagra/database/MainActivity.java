package com.example.kushagra.database;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Databasehelper myDb;
    EditText editname,editpass,editmarks;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb =new Databasehelper(this);


        editname=(EditText)findViewById(R.id.username);
        editpass=(EditText)findViewById(R.id.password);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);

    }

    public void button1(View view){

        EditText a =(EditText)findViewById(R.id.username);
        String str=a.getText().toString();
        EditText b=(EditText)findViewById(R.id.password);
        String pass=b.getText().toString();

        String password=myDb.searchPass(str);
        if(pass.equals(password))
        {
            Intent i=new Intent(this,Main.class);
            startActivity(i);
        }
        else
        {
            Toast temp= Toast.makeText(MainActivity.this, "Invalid username or Password",Toast.LENGTH_LONG);
            temp.show();
        }




       /**boolean isinserted= myDb.insertData(editname.getText().toString(),editpass.getText().toString(),editmarks.getText().toString());
       if(isinserted=true)
           Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();
       else
           Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();*/


    }
    public void button2(View view){

        Intent j=new Intent(this,Sign_Up.class);
        startActivity(j);

        /**Cursor res=myDb.getAllData();
        if(res.getCount()==0){
            showMessage("Error","nothing found");
            return;
        }
        StringBuffer buffer =new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");
            buffer.append("Surname :"+ res.getString(2)+"\n");
            buffer.append("Marks :"+ res.getString(3)+"\n\n");

        }
        showMessage("Data",buffer.toString());*/
    }

    /**public void button4(View view){
        Cursor res=myDb.getAllData();
        if(res.getCount()==0){
            showMessage("Error","nothing found");
            return;
        }
        StringBuffer buffer =new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");
            buffer.append("Surname :"+ res.getString(2)+"\n");
            buffer.append("Marks :"+ res.getString(3)+"\n\n");

        }
        showMessage("Data",buffer.toString());

    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }*/
}
