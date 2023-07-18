package com.example.homework_412;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button getUser, send;
    private EditText depature, dateDepature, arrival, dateArrival;
    private TextView userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        depature = findViewById(R.id.depature);
        depature.setText("");
        depature.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkRequiredFields();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dateDepature = findViewById(R.id.dateDepature);

        dateDepature.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkRequiredFields();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        dateDepature.setText("");
        arrival = findViewById(R.id.arrival);
        arrival.setText("");
        arrival.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkRequiredFields();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dateArrival = findViewById(R.id.dateArrival);
        dateArrival.setText("");
        dateArrival.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkRequiredFields();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        userID = findViewById(R.id.userID);
        userID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkRequiredFields();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        send = findViewById(R.id.send);
        send.setEnabled(false);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ticket ticket = new Ticket(depature.getText().toString(), dateDepature.getText().toString(), arrival.getText().toString(), dateArrival.getText().toString(), Integer.parseInt(userID.getText().toString()));
                int id = ticket.save();
                String strong = ticket.toString();
                Intent intent = new Intent(getApplicationContext(), TicketInfoActivity.class);
                intent.putExtra("info", strong);
                startActivity(intent);
            }
        });
        getUser = findViewById(R.id.getUser);
        getUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), UserActivity.class);
                //MainActivity.this.startActivity(myIntent);
                startActivityForResult(myIntent, 100);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            userID.setText("" + data.getIntExtra("userID", 0));

        }

    }

    private void checkRequiredFields() {
        boolean enabled = !depature.getText().toString().isEmpty() &&
                !dateDepature.getText().toString().isEmpty() && !arrival.getText().toString().isEmpty() && !dateArrival.getText().toString().isEmpty() && !userID.getText().toString().isEmpty();
        if(send != null)
            send.setEnabled(enabled);
    }
}

