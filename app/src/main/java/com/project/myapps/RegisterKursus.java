package com.project.myapps;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.project.myapps.ItemData.ItemNama;
import com.project.myapps.ItemData.ItemProdi;

import java.util.Calendar;
import java.util.List;

public class RegisterKursus extends AppCompatActivity implements TextWatcher {
     EditText  kelas, prodi,Tanggal,Waktu;
    AutoCompleteTextView nama;
    Button daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_kursus);
        nama = findViewById(R.id.listNama);
        kelas = findViewById(R.id.kelas);
        prodi = findViewById(R.id.listProdi);

        daftar = findViewById(R.id.daftar);


        List<ItemNama> items = ItemNama.getDataNama();
        ArrayAdapter<ItemNama> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line,
                items
        );
        nama.setAdapter(adapter);
        nama.addTextChangedListener(this);

        Tanggal = findViewById(R.id.tanggal);
        Waktu = findViewById(R.id.waktu);
        Tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTanggal();
            }
        });
        Waktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWaktu();
            }
        });

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

    public void setWaktu(){
        final Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(RegisterKursus.this,
                new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hours, int minute) {
                Waktu.setText(hours + ":" + minute);
            }
        }, hours, minute, true);
        timePickerDialog.show();

    }
    public void setTanggal(){
        final Calendar calendar =Calendar.getInstance();
        int tahun = calendar.get(Calendar.YEAR);
        int bulan = calendar.get(Calendar.MONTH);
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterKursus.this,
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int tahun, int bulan, int tanggal) {
                Tanggal.setText(tanggal + "-" + (bulan + 1) + "-" + tahun);
            }
        }, tahun, bulan, tanggal);
        datePickerDialog.show();
    }




}