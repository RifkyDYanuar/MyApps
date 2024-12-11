package com.project.myapps;

import static android.content.Intent.getIntent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    private String mUsername,tusername;
    private DatabaseReference database;
    private SharedPreferences sharedPreferences;
    private BottomSheetDialog bottomSheetDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomSheetDialog = new BottomSheetDialog(getActivity());



    }
    public static ProfileFragment newInstance(String username) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView txtName = view.findViewById(R.id.nama);
        TextView txtEmail = view.findViewById(R.id.email);
        TextView txtUsername = view.findViewById(R.id.username);
        TextView txtPassword = view.findViewById(R.id.password);
        TextView txtTelepon = view.findViewById(R.id.telepon);

        showData(txtName,txtEmail,txtUsername,txtPassword,txtTelepon);

        ImageView instagram = view.findViewById(R.id.ig_generate);
        ImageView whatsapp = view.findViewById(R.id.wa_generate);
        ImageView writing = view.findViewById(R.id.writing);
        String phoneNumber = "6289657786880";
        String url = "https://wa.me/" + phoneNumber;

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/rfkydewani98_"));
                startActivity(intent);
            }
        });

        writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showSheet();
            }
        });



        return view;
    }
    private void showSheet(){
        View view = getLayoutInflater().inflate(R.layout.bs_profile, null);
        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://my-project-db-53507-default-rtdb.firebaseio.com/");

        TextInputEditText Email = view.findViewById(R.id.email);
        TextInputEditText Telepon = view.findViewById(R.id.Telepon);
        Button Simpan = view.findViewById(R.id.simpan);

        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String telepon = Telepon.getText().toString();


                if (email.isEmpty() || telepon.isEmpty()) {
                    Toast.makeText(getActivity(), "Semua data harus diisi", Toast.LENGTH_SHORT).show();
                    Email.setError("Email harus diisi");
                    Telepon.setError("Telepon harus diisi");



                } else {
                    database = FirebaseDatabase.getInstance().getReference("user");
                    database.child(tusername).child("email").setValue(email);
                    database.child(tusername).child("telepon").setValue(telepon);

                    Toast.makeText(getActivity(), "Register Berhasil", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();

                }


            }
        });

        bottomSheetDialog.setContentView(view);
        FrameLayout bottomSheet = bottomSheetDialog.findViewById(R.id.bottom_sheet);
        BottomSheetBehavior<FrameLayout> behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        bottomSheetDialog.show();



    }

    public void showData(TextView txtNama,TextView txtEmail, TextView txtUsername, TextView txtPassword, TextView txtTelepon){


        Intent intent = getActivity().getIntent();

        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        String telepon = intent.getStringExtra("telepon");

        txtNama.setText(name);
        txtEmail.setText(email);
        txtUsername.setText(username);
        txtPassword.setText(password);
        txtTelepon.setText(telepon);
    }

}