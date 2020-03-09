package com.example.ontap3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private List<post> PostList;
    public PostAdapter(List<post> PostList){
        this.PostList = PostList;
    }


    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int i) {

        View view = LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.row,ViewGroup,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder PostHolder, int i) {
        PostHolder.tvuserId.setText(PostList.get(i).getUserId());
    }

    @Override
    public int getItemCount() {
        return PostList.size();
    }

    public static class PostHolder extends RecyclerView.ViewHolder {
        public TextView tvuserId, tvid, tvtitle, tvcompleted;
        public PostHolder(@NonNull View itemView) {
            super(itemView);
            tvuserId = itemView.findViewById(R.id.userid);
            tvid = itemView.findViewById(R.id.id);
            tvtitle = itemView.findViewById(R.id.title);
            tvcompleted = itemView.findViewById(R.id.completed);

        }
    }
}
