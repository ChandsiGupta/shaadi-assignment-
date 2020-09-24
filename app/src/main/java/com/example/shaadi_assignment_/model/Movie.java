package com.example.shaadi_assignment_.model;

import java.util.ArrayList;
import java.util.List;

import com.example.shaadi_assignment_.Results;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {
    
  
    @Expose
    private List<Results> results = new ArrayList<Results>();
    
    public List<Results> getResults() {
        return results;
    }
    
    public void setResults(List<Results> results) {
        this.results = results;
    }
}