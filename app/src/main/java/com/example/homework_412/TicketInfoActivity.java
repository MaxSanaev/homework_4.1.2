package com.example.homework_412;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicketInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_info);
        Intent data = getIntent();
        String info = data.getStringExtra("info");
        TextView text =  findViewById(R.id.ticketInfo);
        text.setText(info);

        Button delete = findViewById(R.id.send);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);

            }
        });

    }
}