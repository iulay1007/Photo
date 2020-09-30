package com.example.photo.adapter;

import android.content.Intent;
import android.graphics.Point;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.photo.ImageBean;
import com.example.photo.MainActivity2;
import com.example.photo.R;
import com.example.photo.ShowPictureFragment;
import com.example.photo.utils.ScreenSizeUtils;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerviewAdapter";
    private List<ImageBean> imageBeanList = new ArrayList<>();
    public static int pic_position;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_view, parent, false);
        Point point= ScreenSizeUtils.getScreenSize(itemview.getContext());
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(point.x/4,point.x/4);
        itemview.setLayoutParams(layoutParams);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ImageView imageView = holder.itemView.findViewById(R.id.image_iv);
        Glide.with(imageView.getContext()).load(imageBeanList.get(position).getPath()).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(view.getContext(), MainActivity2.class);
              intent.putExtra("position",position);
                pic_position=position;
               // intent.putExtra("list", (Serializable) imageBeanList);
                view.getContext().startActivity(intent);
            }
        });
        Log.d(TAG,"load_image");
    }

    @Override
    public int getItemCount() {
        if (imageBeanList != null){
            Log.d(TAG,"listsize"+imageBeanList.size());
            return imageBeanList.size();

        }
        else return 10;
    }

    public void setData(List<ImageBean> imageBeans) {

        imageBeanList.clear();

     //   int size=0;
     //   size=imageBeans.size();
        imageBeanList.addAll(imageBeans);
        notifyDataSetChanged();
     //  notifyItemRangeInserted(0,size);
        Log.d(TAG, "setdata");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
