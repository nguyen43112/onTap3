package com.example.ontap3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private List<post> postList;
    private Context context;
    public PostAdapter(Context context,List<post> postList){
        this.postList = postList;
        this.context = context;
    }


    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int i) {

        View view = LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.row,ViewGroup,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder PostHolder, int i) {
        post post = postList.get(i);
        String userId = String.valueOf(post.getUserId());
        String id = String.valueOf(post.getId());
        String title = String.valueOf(post.getTitle());
        String completed = String.valueOf(post.getCompleted());
        PostHolder.tvuserId.setText(userId);
        PostHolder.tvid.setText(id);
        PostHolder.tvtitle.setText(title);
        PostHolder.tvcompleted.setText(completed);
        if (post.getCompleted()){
            PostHolder.tvuserId.setTextColor(Color.BLUE);
            PostHolder.tvid.setTextColor(Color.BLUE);
            PostHolder.tvtitle.setTextColor(Color.BLUE);
            PostHolder.tvcompleted.setTextColor(Color.BLUE);
        }
        else   {
            PostHolder.tvuserId.setTextColor(Color.RED);
            PostHolder.tvid.setTextColor(Color.RED);
            PostHolder.tvtitle.setTextColor(Color.RED);
            PostHolder.tvcompleted.setTextColor(Color.RED);
        }
        PostHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= "userId: "+ userId +"\nId: "+ id+ "\nTitle: " + title
                        + "\nCompleted: " + completed;
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle( "Hello" )
                        .setMessage(message)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface, int i) {
                                dialoginterface.dismiss();
                            }
                        }).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
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
