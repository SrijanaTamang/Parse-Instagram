package com.codepath.sampleinstagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvHandle;
        private ImageView ivImage;
        private TextView tvDescription;

        public ViewHolder(@NonNull View view) {
            super(view);
            tvHandle = view.findViewById(R.id.tvHandle);
            tvDescription = view.findViewById(R.id.tvDescription);
            ivImage = view.findViewById(R.id.ivImage);
        }

        public void bind(Post post) {
            //ToDo bind the view elements o the post
            tvHandle.setText(post.getUSer().getUsername());
            ParseFile image = post.getImage();
            if (image != null) {
                //Glide.with(context).load(image.getUrl()).into(ivImage);
                Glide.with(context).load(image.getUrl().replace("http", "https")).into(ivImage);


            }
            tvDescription.setText(post.getDescription());
        }
    }
}
