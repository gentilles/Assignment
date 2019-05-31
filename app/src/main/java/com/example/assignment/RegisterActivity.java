package com.example.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;

public class RegisterActivity extends AppCompatActivity {


    private EditText userEmail , userPassword;
    private Button loginButton;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        userEmail = (EditText)findViewById(R.id.R_email);
        userPassword = (EditText)findViewById(R.id.R_password);
        loginButton = (Button)findViewById(R.id.R_login);

        realm.init(this);
        realm = Realm.getDefaultInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = userEmail.getText().toString();
                String password = userPassword.getText().toString();

                if (TextUtils.isEmpty(email))
                {
                    Toast.makeText(RegisterActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password))
                {
                    Toast.makeText(RegisterActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    realm.beginTransaction();

                    Helper helperModal = realm.createObject(Helper.class);
                    helperModal.setInputEmail(email);
                    helperModal.setInputPassword(password);

                    realm.commitTransaction();
                    Toast.makeText(RegisterActivity.this, email+ "successfully registered", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
