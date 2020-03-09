package com.example.ontap3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvList ;
    private PostAdapter postAdapter;
   List<post> posts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList =  findViewById(R.id.rvList);
        


        rvList.setHasFixedSize(true);


        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi =  retrofit.create(JsonPlaceHolderApi.class);
        Call<List<post>> call =jsonPlaceHolderApi.getPost();
        call.enqueue(new Callback<List<post>>() {
            @Override
            public void onResponse(Call<List<post>> call, Response<List<post>> response) {
                posts.addAll(response.body());
                postAdapter = new PostAdapter(MainActivity.this,posts);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                rvList.setLayoutManager(linearLayoutManager);
                rvList.setAdapter(postAdapter);


            }

            @Override
            public void onFailure(Call<List<post>> call, Throwable t) {

            }
        });
    }
}
