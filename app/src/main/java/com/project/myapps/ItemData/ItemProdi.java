package com.project.myapps.ItemData;

import java.util.ArrayList;
import java.util.List;

public class ItemProdi {
    public String Prodi;


    public ItemProdi(String Prodi) {
        this.Prodi = Prodi;

    }
    public String getProdi() {
        return Prodi;
    }
    public String toString() {
        return Prodi ;
    }
    public static List<ItemProdi> getDataProdi() {
        List<ItemProdi> items = new ArrayList<>();
        items.add(new ItemProdi("Teknik Informatika"));
        items.add(new ItemProdi("Sistem Informasi"));
        items.add(new ItemProdi("Manajemen Informatika"));
        items.add(new ItemProdi("Desain Komunikasi Visual"));
        items.add(new ItemProdi("Teknik Sipil"));
        return  items;
    }


}
