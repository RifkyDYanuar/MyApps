package com.project.myapps;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

	
	private Button btnLogin;
	private EditText txtUsername, txtPassword;
	private DatabaseReference database;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		btnLogin = findViewById(R.id.login);
		txtUsername = findViewById(R.id.username);
		txtPassword = findViewById(R.id.password);

		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (!validasiUsername() | !validasiPassword()) {
					return;
				} else {
					check();
				}
			}
		});

	}

	public boolean validasiUsername(){
		String val = txtUsername.getText().toString();
		if (val.isEmpty()){
			txtUsername.setError("Username harus diisi");
			return false;
		}else {
			txtUsername.setError(null);
			return true;
		}

	}
	public boolean validasiPassword(){
		String val = txtPassword.getText().toString();
		if (val.isEmpty()){
			txtPassword.setError("Password harus diisi");
			return false;
		}else {
			txtPassword.setError(null);
			return true;
		}

	}

	public void check(){
		String username = txtUsername.getText().toString().trim();
		String password = txtPassword.getText().toString().trim();

		DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");

		Query chekUser = reference.orderByChild("username").equalTo(username);

		chekUser.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot snapshot) {
				if (snapshot.exists()) {
					txtUsername.setError(null);

					// Ambil password dari database
					for (DataSnapshot userSnapshot : snapshot.getChildren()) {
						String passwordFromDb = userSnapshot.child("password").getValue(String.class);
						if (passwordFromDb != null && passwordFromDb.equals(password)) {

							String nameFromDB = userSnapshot.child("name").getValue(String.class);
							String emailFromDB = userSnapshot.child("email").getValue(String.class);
							String usernameFromDB = userSnapshot.child("username").getValue(String.class);
							String teleponFromDB = userSnapshot.child("telepon").getValue(String.class);
							// Jika password cocok, lanjut ke MainActivity


							Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
							Intent intent = new Intent(LoginActivity.this, MainActivity.class);
							intent.putExtra("name", nameFromDB);

							startActivity(intent);
						} else {
							// Jika password tidak cocok
							txtPassword.setError("Password Salah");
							txtPassword.requestFocus();
						}
					}
				} else {
					// Username tidak ditemukan
					txtUsername.setError("Username Tidak Ditemukan");
					txtUsername.requestFocus();
				}
			}

			@Override
			public void onCancelled(@NonNull DatabaseError error) {

			}
		});
	}
}
	
	