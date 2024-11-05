
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		login_frame
	 *	@date 		Monday 04th of November 2024 11:04:11 AM
	 *	@title 		Page 2
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

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

import androidx.appcompat.app.AppCompatActivity;

	public class LoginActivity extends AppCompatActivity {

	
	private Button btnLogin;
	private EditText txtUsername, txtPassword;



	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		btnLogin = findViewById(R.id.login);
		txtUsername = findViewById(R.id.username);
		txtPassword = findViewById(R.id.password);

		SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String username = txtUsername.getText().toString();
				String password = txtPassword.getText().toString();

				String saveUsername = sharedPreferences.getString("username", "");
				String savePassword = sharedPreferences.getString("password", "");


				if (!username.isEmpty() && !password.isEmpty()){
					if(username.equals(saveUsername) && password.equals(savePassword)){
						Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

						Intent intent = new Intent(LoginActivity.this, MainActivity.class);
						intent.putExtra("USERNAME",username);
						intent.putExtra("PASSWORD",password);
						startActivity(intent);
					}else {
						Toast.makeText(LoginActivity.this, "Username dan password salah", Toast.LENGTH_SHORT).show();
					}

				}else{
					Toast.makeText(LoginActivity.this, "Username & Password tidak boleh kosong! ", Toast.LENGTH_SHORT).show();
				}



			}
		});

	}
}
	
	