package com.project.myapps;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class PerhitunganNilai extends AppCompatActivity {
    private EditText txtNama, txtNim, txtNilai;
    private Button cekBtn, clearBtn, backBtn;
    private TextView txthasil;
    private BottomSheetDialog bottomSheetDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perhitungan_nilai);

        bottomSheetDialog = new BottomSheetDialog(this);



        txtNama = findViewById(R.id.nama);
        txtNim = findViewById(R.id.nim);
        txtNilai = findViewById(R.id.nilai);


        cekBtn = findViewById(R.id.cekKelulusan);
        clearBtn = findViewById(R.id.clear);
        backBtn = findViewById(R.id.back);


        cekBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama = txtNama.getText().toString();
                String nim = txtNim.getText().toString();
                String nilai = txtNilai.getText().toString();

                if (Nama.isEmpty() || nim.isEmpty() || nilai.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Semua harus diisi", Toast.LENGTH_SHORT).show();
                    txtNama.setError("Nama harus diisi");
                    txtNim.setError("Nim harus diisi");
                    txtNilai.setError("Nilai harus diisi");
                }else {
                    showSheet(Nama,nim,nilai);
                }

           }

        });
        bottomSheetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNama.setText("");
                txtNim.setText("");
                txtNilai.setText("");
                bottomSheetDialog.dismiss();
                txtNama.clearFocus();
                txtNim.clearFocus();
                txtNilai.clearFocus();
            }
        });


    }


    private void showSheet(String Nama , String nim, String nilai){
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);

        TextView nama = view.findViewById(R.id.hasilnama);
        TextView Nim = view.findViewById(R.id.hasilnim);
        TextView Nilai = view.findViewById(R.id.hasilnilai);
        TextView Kelulusan = view.findViewById(R.id.hasilkelulusan);

                double nilaiInt = Double.parseDouble(nilai);


                nama.setText(Nama);
                Nim.setText(nim);
                Nilai.setText(nilai);
                Kelulusan.setText("");

                if (nilaiInt >= 80 && nilaiInt<=100){
                    Kelulusan.setText("LULUS !");
                    Nilai.setText("A");
                    Kelulusan.setTextColor(getResources().getColor(R.color.teal_700));
                }else if (nilaiInt >= 61 && nilaiInt <=79 ){
                    Kelulusan.setText("LULUS!");
                    Nilai.setText("B");
                    Kelulusan.setTextColor(getResources().getColor(R.color.teal_700));
                } else if (nilaiInt >= 50 && nilaiInt <= 60) {
                    Kelulusan.setText("LULUS!");
                    Nilai.setText("C");
                    Kelulusan.setTextColor(getResources().getColor(R.color.teal_700));
                } else if (nilaiInt >= 0 && nilaiInt <= 49) {
                    Kelulusan.setText("TIDAK LULUS !");
                    Nilai.setText("D");
                    Kelulusan.setTextColor(Color.RED);

                }
        bottomSheetDialog.setContentView(view);
        FrameLayout bottomSheet = bottomSheetDialog.findViewById(R.id.bottom_sheet);
        BottomSheetBehavior<FrameLayout> behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        bottomSheetDialog.show();

    }
}