package com.example.admin1.jugaad;
//import android.manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText Email;
    private EditText Password;
    private EditText PhoneNumber;
    private EditText UserName;

    private Button buRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(this);

        firebaseAuth = FirebaseAuth.getInstance();


        UserName = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText4);
        PhoneNumber = (EditText) findViewById(R.id.editText5);
        Email = (EditText) findViewById(R.id.editText3);

        buRegister = (Button) findViewById(R.id.button2);


        buRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){
            registerUser();
        }
    });
}


    public void registerUser() {
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        String user = UserName.getText().toString().trim();
        String phone = PhoneNumber.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "email cant be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //password empty
            Toast.makeText(this, "password cant be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(user)) {
            //user name is empty
            Toast.makeText(this, "name cant be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            //phone number empty
            Toast.makeText(this, "phone number cant be empty", Toast.LENGTH_SHORT).show();
            return;
        }


        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Registration successful !!!", Toast.LENGTH_SHORT).show();
                    Intent RegisterIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                    RegisterActivity.this.startActivity(RegisterIntent);

                } else {
                    Toast.makeText(RegisterActivity.this, "failed to register..!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void onClick (View v){
        registerUser();
        }


}