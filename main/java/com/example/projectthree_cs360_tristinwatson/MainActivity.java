package com.example.projectthree_cs360_tristinwatson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variables
    EditText username, password, repassword;
    Button signup, signin;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sets variables
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);

        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);

        DB = new DBHelper(this);

        // signup onclick listener
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sets variables to user input
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                // conditionals
                if (user.equals("")||pass.equals("")||repass.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkUsername(user);
                        if (checkuser==false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert = true) {
                                // redirects to loginactivity
                                Toast.makeText(MainActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "User already exists!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // signin onclick listener
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // redirects to loginactivity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}