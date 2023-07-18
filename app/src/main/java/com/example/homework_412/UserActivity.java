package com.example.homework_412;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    EditText family, name, fatherName, email;
    Button saveUser, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        family = findViewById(R.id.family);
        family.setText("");
        family.addTextChangedListener(new TextWatcher() {
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
        name = findViewById(R.id.name);
        name.setText("");
        name.addTextChangedListener(new TextWatcher() {
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
        fatherName = findViewById(R.id.fatherName);
        fatherName.setText("");
        fatherName.addTextChangedListener(new TextWatcher() {
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
        email = findViewById(R.id.email);
        email.setText("");
        email.addTextChangedListener(new TextWatcher() {
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
        saveUser = findViewById(R.id.saveUser);
        saveUser.setEnabled(false);
        saveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                User user = new User(family.getText().toString(),name.getText().toString(),fatherName.getText().toString(),email.getText().toString());
                int userId = user.save();
                myIntent.putExtra("userID", userId);
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });

    }
    private void checkRequiredFields() {
        boolean enabled = !family.getText().toString().isEmpty() &&
                !fatherName.getText().toString().isEmpty() && !name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !saveUser.getText().toString().isEmpty();
        if(saveUser != null)
            saveUser.setEnabled(enabled);
    }
}
