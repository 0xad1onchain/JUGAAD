package com.example.admin1.jugaad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        final Button pcd = (Button) findViewById(R.id.button3);

        pcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttonIntent = new Intent(AddressActivity.this,ServiceActivity.class);
                AddressActivity.this.startActivity(buttonIntent);
            }
        });





    }
}
