package com.project.myapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class MenuActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister, btnPenilaian, btnGaji;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        btnLogin = findViewById(R.id.login);
        btnRegister = findViewById(R.id.register);
        btnPenilaian = findViewById(R.id.penilaian);
        btnGaji = findViewById(R.id.Gajih);





        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnPenilaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, PerhitunganNilai.class);
                startActivity(intent);
            }
        });
        btnGaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, PerhitunganGajih.class);
                startActivity(intent);
            }
        });




    }
}