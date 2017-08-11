package com.example.admin1.jugaad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class DeliveryActivity extends AppCompatActivity {

    public RadioGroup modeOfPayment, deliveryTime;
    String mop = " ", delivery = " ", time = " ";
    EditText text;
    private String uid;
    private FirebaseUser user;
    private DatabaseReference mDatabase;
    private FirebaseAuth.AuthStateListener authListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        text = (EditText) findViewById(R.id.editText9);
        modeOfPayment = (RadioGroup) findViewById(R.id.mop);
        deliveryTime = (RadioGroup) findViewById(R.id.drop_detail);
        final Button proceed = (Button) findViewById(R.id.button7);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(DeliveryActivity.this, RegisterActivity.class));
                    finish();
                }
                uid = user.getUid();
            }
        };
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modeOfPayment.getCheckedRadioButtonId() == R.id.cod)
                    mop = "Cash On Delivery";
                else
                    mop = "Paytm";

                if(deliveryTime.getCheckedRadioButtonId() == R.id.now) {
                    delivery = "Now";
                    mDatabase.child(uid).child("Time").removeValue();
                }
                else
                {
                    delivery = "Later";
                    time = text.getText().toString();
                    mDatabase.child(uid).child("Time").setValue(time);
                }
                mDatabase.child(uid).child("ModeOfPayment").setValue(mop);
                mDatabase.child(uid).child("DeliveryMode").setValue(delivery);
                Log.d("ValueSet", mDatabase.child(uid).getKey());

                Intent proceedIntent = new Intent(DeliveryActivity.this,ServiceActivity.class);
                DeliveryActivity.this.startActivity(proceedIntent);
            }
        });



    }
}
