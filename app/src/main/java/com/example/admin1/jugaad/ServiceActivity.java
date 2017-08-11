package com.example.admin1.jugaad;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        final Button proceed = (Button) findViewById(R.id.button5);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceedIntent = new Intent(ServiceActivity.this,LocationActivity.class);
                ServiceActivity.this.startActivity(proceedIntent);
            }
        });



    }
}
