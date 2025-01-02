package com.project.myapps;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.myapps.HeroData.HeroClass;
import com.project.myapps.HeroData.HeroesData;
import com.project.myapps.HeroData.ListHeroAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyleviewMain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<HeroClass> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recyleview_main);

        recyclerView = findViewById(R.id.rv_heroes);
        recyclerView.setHasFixedSize(true);
        list.addAll(HeroesData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        recyclerView.setAdapter(listHeroAdapter);
        listHeroAdapter.notifyDataSetChanged();

    }
}