package com.project.myapps.sampledata;

import java.util.ArrayList;
import java.util.List;

public class ItemNama {
    public String nama;


    public ItemNama(String nama) {
        this.nama = nama;

    }

    public String getNama() {
        return nama;
    }


    public String toString() {
        return nama ;
    }
    public static List<ItemNama> getDataNama() {
        List<ItemNama> items = new ArrayList<>();
        items.add(new ItemNama("Rifky Dewani Yanuar"));
        items.add(new ItemNama("Natanael Ruswandi"));
        items.add(new ItemNama("Muhammad Nurlatif"));
        items.add(new ItemNama("Yusuf Septiana"));
        items.add(new ItemNama("Dicky Mahendra"));
        items.add(new ItemNama("Rifky Budi"));
        items.add(new ItemNama("Yusuf Rizieq"));
        return items;
    }
}

