

	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc
	 *	@file 		register_frame
	 *	@date 		Monday 04th of November 2024 12:15:27 PM
	 *	@title 		Page 3
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


	import android.renderscript.ScriptGroup;
	import android.view.View;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.TextView;
	import android.widget.ImageView;
	import android.widget.Toast;

	import androidx.appcompat.app.AppCompatActivity;

	public class RegisterActivity extends AppCompatActivity {


		private EditText txtEmail, txtUsername, txtPassword;
		private Button btnRegister;
		private SharedPreferences sharedPreferences;



		@Override
		public void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_register);


			txtEmail = findViewById(R.id.email);
			txtUsername = findViewById(R.id.username);
			txtPassword = findViewById(R.id.password);
			btnRegister = findViewById(R.id.btnRegister);

			sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);

			btnRegister.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					String username = txtUsername.getText().toString();
					String password = txtPassword.getText().toString();
					String email = txtEmail.getText().toString();

					sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);

					if (!username.isEmpty() && !password.isEmpty()){
							SharedPreferences.Editor editor =sharedPreferences.edit();
							editor.putString("username" ,username);
							editor.putString("password",password);
							editor.putString("email",email);
							editor.apply();
						Toast.makeText(RegisterActivity.this, "Register Berhasil", Toast.LENGTH_SHORT).show();

						Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
						intent.putExtra("USERNAME", username);
						intent.putExtra("PASSWORD", password);

						startActivity(intent);
						finish();;

					}else{
						Toast.makeText(RegisterActivity.this, "Semua field harus diisi, Login Gagal ", Toast.LENGTH_SHORT).show();
					}
				}
			});



		}
	}

