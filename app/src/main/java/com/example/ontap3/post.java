package com.example.ontap3;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

public class post {
    private int userId;
    private  int  id;
    private String title;
    private Boolean completed;
    @SerializedName("body")

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

}
