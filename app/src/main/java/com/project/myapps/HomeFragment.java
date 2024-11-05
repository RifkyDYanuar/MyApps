package com.project.myapps;

import static android.app.ProgressDialog.show;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private static final String ARG_USERNAME = "username";
    private String mUsername;
    public HomeFragment() {

    }


    public static HomeFragment newInstance(String username) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USERNAME, username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUsername = getArguments().getString(ARG_USERNAME);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView usernameTextView = view.findViewById(R.id.username);

        if (mUsername!=null){
            usernameTextView.setText("Welcome, " + mUsername);
        }

        ImageView btnLogout = view.findViewById(R.id.alert);
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
                Notifikasi();
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
    public void Notifikasi() {
        new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Notifikasi")
                .setMessage("Ini adalah isi notifikasi - notifikasi aplikasi ini")
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






}

