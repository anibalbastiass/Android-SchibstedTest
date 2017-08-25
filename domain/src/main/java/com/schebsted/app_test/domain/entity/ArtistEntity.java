/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.domain.entity;

import java.util.ArrayList;

/**
 * Created by anibalbastias on 25/08/17.
 * Artist Class entity
 */

public class ArtistEntity {

    private int resultCount;
    private String artist_name = "";
    private ArrayList<ArtistResultEntity> results;

    public ArtistEntity() {
    }

    public ArtistEntity(String artist_name) {
        this.artist_name = artist_name;
    }

    public ArtistEntity(int resultCount, ArrayList<ArtistResultEntity> results) {
        this.resultCount = resultCount;
        this.results = results;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public ArrayList<ArtistResultEntity> getResults() {
        return results;
    }

    public void setResults(ArrayList<ArtistResultEntity> results) {
        this.results = results;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }
}
