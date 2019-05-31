package com.example.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;


public class Login215042931 extends AppCompatActivity {

    EditText emails , passwords;
    private Button LoginButton ;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emails = findViewById(R.id.email);
        passwords = findViewById(R.id.password);
        LoginButton = (Button)findViewById(R.id.login);


        realm.init(this);
        realm = Realm.getDefaultInstance();


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (emails.getText().toString().isEmpty() | passwords.getText().toString().isEmpty())
                {
                    Toast.makeText(Login215042931.this, "field Can't be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //  realm.beginTransaction();


                    RealmResults<Helper> realmResults=realm.where(Helper.class).findAll();
                    String email="";
                    String pass="";

                    for (Helper helperModal:realmResults)
                    {
                        email+=helperModal.getInputEmail();
                        pass+=helperModal.getInputPassword();



                    }


                    if (email.contains(emails.getText().toString()) && pass.contains(passwords.getText().toString()))
                    {
                        Intent intent = new Intent(Login215042931.this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(Login215042931.this, "invalid username or password", Toast.LENGTH_LONG).show();
                    }




                    //  realm.commitTransaction();

                }
            }
        });
    }
}
