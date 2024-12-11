
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

	import com.google.firebase.database.DatabaseReference;
	import com.google.firebase.database.FirebaseDatabase;

	public class RegisterActivity extends AppCompatActivity {


		private EditText txtEmail, txtUsername, txtPassword, txtName,txtTelepon;
		private Button btnRegister;
		private SharedPreferences sharedPreferences;
		private DatabaseReference database;



		@Override
		public void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_register);

			txtName = findViewById(R.id.nama);
			txtUsername = findViewById(R.id.username);
			txtPassword = findViewById(R.id.password);
			btnRegister = findViewById(R.id.btnRegister);
			txtTelepon = findViewById(R.id.telepon);
			txtEmail = findViewById(R.id.email);

			database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://my-project-db-53507-default-rtdb.firebaseio.com/");
			sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);

			btnRegister.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					String name = txtName.getText().toString();
					String username = txtUsername.getText().toString();
					String password = txtPassword.getText().toString();
					String telepon = txtTelepon.getText().toString();
					String email = txtEmail.getText().toString();


					if (username.isEmpty() || password.isEmpty() || name.isEmpty() || telepon.isEmpty() || email.isEmpty()) {
						Toast.makeText(getApplicationContext(), "Semua data harus diisi", Toast.LENGTH_SHORT).show();
						txtName.setError("Nama harus diisi");
						txtUsername.setError("Username harus diisi");
						txtPassword.setError("Password harus diisi");
						txtTelepon.setError("Telepon harus diisi");
						txtEmail.setError("Email harus diisi");



					} else {
						database = FirebaseDatabase.getInstance().getReference("user");
						database.child(name).child("name").setValue(name);
						database.child(name).child("username").setValue(username);
						database.child(name).child("password").setValue(password);
						database.child(name).child("telepon").setValue(telepon);
						database.child(name).child("email").setValue(email);
						Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
						startActivity(intent);
						finish();

					}

				}
			});



		}
	}

