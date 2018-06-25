package com.mationate.wineapp;

import com.mationate.wineapp.models.Wine;

import java.util.List;

public class Queries {

    public List<Wine> wines() {

        List<Wine> wineList = Wine.listAll(Wine.class);
        return wineList;
    }
}
