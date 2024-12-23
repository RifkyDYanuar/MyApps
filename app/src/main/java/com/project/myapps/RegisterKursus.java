package com.project.myapps;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.project.myapps.sampledata.ItemNama;
import com.project.myapps.sampledata.ItemProdi;

import java.util.List;

public class RegisterKursus extends AppCompatActivity implements TextWatcher {
     EditText  kelas, prodi;
    AutoCompleteTextView nama;
    Button daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_kursus);
        nama = findViewById(R.id.listNama);
        kelas = findViewById(R.id.kelas);


        List<ItemNama> items = ItemNama.getDataNama();
        ArrayAdapter<ItemNama> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line,
                items
        );
        nama.setAdapter(adapter);
        nama.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public void ListProdi(View v) {
        prodi = findViewById(R.id.listProdi);

        List<ItemProdi> items = ItemProdi.getDataProdi();
        ArrayAdapter<ItemProdi> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, items
        );

        ListView listView = new ListView(this);
        listView.setAdapter(adapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih Prodi yang diinginkan");
        builder.setView(listView);

        AlertDialog dialog = builder.create();
        dialog.show();
        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            String selectedProdi = items.get(position).getProdi();
            prodi.setText(selectedProdi);
            dialog.dismiss();
        });
    }



}