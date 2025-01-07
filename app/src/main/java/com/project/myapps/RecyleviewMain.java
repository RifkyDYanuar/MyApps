package com.project.myapps;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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


    private String title = "Mode List";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_heroes, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedItem) {
        switch (selectedItem){
            case R.id.list :
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.grid :
                title = "Mode Grid";

                break;
            case R.id.card :
                title = "Mode CardView";
                break;
            default:
        }



    }

}