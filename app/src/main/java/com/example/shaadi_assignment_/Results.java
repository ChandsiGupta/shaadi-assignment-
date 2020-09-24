package com.example.shaadi_assignment_;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results
{
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @SerializedName("gender")
    @Expose
    private String gender;
   
    }