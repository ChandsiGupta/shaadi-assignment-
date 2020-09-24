package com.example.shaadi_assignment_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shaadi_assignment_.model.Movie;
import com.google.gson.JsonArray;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {
    
    Context context;
    List<JsonArray> movieList;
    
    public RecyclerAdapter(Context context, List<JsonArray> movieList) {
        this.context = context;
        this.movieList = movieList;
    }
    
    public void setMovieList(List<JsonArray> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }
    
    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter,parent,false);
        return new MyviewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(RecyclerAdapter.MyviewHolder holder, int position) {
//        holder.tvMovieName.setText(movieList.get(position).getInfo().getPage().toString());
//        Glide.with(context).load(movieList.get(position).getImageUrl()).apply(RequestOptions.centerCropTransform()).into(holder.image);
    }
    
    @Override
    public int getItemCount() {
        if(movieList != null){
            return movieList.size();
        }
        return 0;
        
    }
    
    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieName;
        ImageView image;
        
        public MyviewHolder(View itemView) {
            super(itemView);
            tvMovieName = (TextView)itemView.findViewById(R.id.title);
            image = (ImageView)itemView.findViewById(R.id.image);
        }
    }
}
