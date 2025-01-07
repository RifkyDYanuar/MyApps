package com.project.myapps;

import static android.app.ProgressDialog.show;
import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private String mUsername;
    private DatabaseReference database;
    public HomeFragment() {

    }


    public static HomeFragment newInstance(String username) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView usernameTextView = view.findViewById(R.id.username);
        ImageView btnLogout = view.findViewById(R.id.alert);



        showName(usernameTextView);




        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDefaultDialog();
            }
        });

        ImageView notification = view.findViewById(R.id.notif);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), TabMainActivity.class);
                startActivity(intent);
            }
        });

        ImageView Kotlin = view.findViewById(R.id.kotlin);

        Kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailKelas();
            }
        });

        ImageView Java = view.findViewById(R.id.java);
        Java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailJava();
            }
        });
        return view;


    }
    public void showDefaultDialog() {
        new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah anda akan logout ?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(),MenuActivity.class);
                        startActivity(intent);

                        getActivity().finish();

                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


    public void detailKelas() {
        new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Detail Kelas Kotlin")
                .setIcon(R.drawable.kotlin)
                .setMessage("Memuat pembelajaran untuk memahami bahasa pemrogaman kotlin untuk android studio")
                .show();
    }

    public void detailJava(){
        new MaterialAlertDialogBuilder(requireContext())

                .setTitle("Detail Kelas Java")
                .setIcon(R.drawable.java)
                .setMessage("Memuat pembelajaran untuk memahami bahasa pemrogaman Java untuk android studio")
                .show();


    }

    public void showName(TextView usernameTextView){
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("name");
        usernameTextView.setText(name);
    }








}


