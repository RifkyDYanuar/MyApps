package com.project.myapps;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TabMainActivity extends TabActivity {
    TabHost tabHost ;
    TabHost.TabSpec tabSpec ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tabHost = getTabHost();
        this.setNewTab(this, tabHost,"tab1", "Tab 1",R.drawable.ic_launcher_background, new Intent(this, Tab1.class));
        this.setNewTab(this, tabHost,"tab2", "Tab 2",R.drawable.ic_launcher_background, new Intent(this, Tab2.class));
        this.setNewTab(this, tabHost,"tab3", "Tab 3",R.drawable.ic_launcher_background, new Intent(this, Tab3.class));


    }
    private void setNewTab(Context context,TabHost tabHost , String tag, String title, int icon, Intent intentid) {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(title, ContextCompat.getDrawable(this,icon));
        tabSpec.setContent(intentid);
        tabHost.addTab(tabSpec);

  }



}