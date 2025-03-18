package com.example.signmeup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.registration.MESSAGE";
    Button btn;
    EditText first_name;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = findViewById(R.id.signupButton);
        first_name = findViewById(R.id.firstName);
        EditText last_name = findViewById(R.id.lastName);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        EditText password_confirmation = findViewById(R.id.passwordConfirmation);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            String fName = first_name.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, fName);
            startActivity(intent);
        });
    }


}