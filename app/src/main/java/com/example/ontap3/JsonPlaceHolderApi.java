package com.example.ontap3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("/todos")
    Call<List<post>> getPost();
}
