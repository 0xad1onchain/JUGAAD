package com.example.admin1.jugaad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.BuildConfig;
import android.util.Log;
import android.widget.Toast;



import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private final int RC_SIGN_IN =123;
    private EditText phone;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




                    final Button buSignIn = (Button) findViewById(R.id.button10);
                    final Button buRegisterHere = (Button) findViewById(R.id.button11);
                    buSignIn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent SignInIntent = new Intent(LoginActivity.this,MainActivity.class);
                            LoginActivity.this.startActivity(SignInIntent);
                        }

                    });

                    buRegisterHere.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent RegisterIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                            LoginActivity.this.startActivity(RegisterIntent);
                        }
                    });





    }
}