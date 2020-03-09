package com.example.ontap3;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

public class post {
    private int userId;
    private  int  id;
    private String title;
    private String completed;
    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompleted() {
        return completed;
    }

    public String getText() {
        return text;
    }
}
