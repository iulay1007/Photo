package com.example.photo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.photo.ImageBean;
import com.example.photo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    private static final String TAG ="RecyclerviewAdapter" ;
    private List<ImageBean> imageBeanList=new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemview=LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_view,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView imageView =  holder.itemView.findViewById(R.id.image_iv);

        Glide.with(imageView.getContext()).load(imageBeanList.get(position).getPath()).into(imageView);
    }

    @Override
    public int getItemCount() {
        if(imageBeanList!=null)
         return imageBeanList.size();
        else return 1;
    }

    public void setData(List<ImageBean> imageBeanList) {

        imageBeanList.addAll(imageBeanList);
        notifyDataSetChanged();
        Log.d(TAG,"setdata");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
