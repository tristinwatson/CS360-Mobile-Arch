package com.example.projectthree_cs360_tristinwatson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //variables
    EditText username, password;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // sets variables
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);

        btnlogin = (Button) findViewById(R.id.btnsignin1);

        DB = new DBHelper(this);

        // btnlogin onclick listener
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sets variables to user input
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please Enter All Fields.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkUserPass = DB.checkUsernamePassword(user, pass);
                    if (checkUserPass == true) {
                        // redirects to alert message
                        Toast.makeText(LoginActivity.this, "Sign-In Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), AlertMessage.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Invalid Login Information.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}