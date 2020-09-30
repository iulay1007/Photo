package com.example.photo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import static com.example.photo.MainActivity.imageBeanList;
import static com.example.photo.adapter.RecyclerviewAdapter.pic_position;

import com.bumptech.glide.Glide;

import uk.co.senab.photoview.PhotoView;

public class ShowPictureFragment extends Fragment {
    private ImageView imageView;
    private GestureDetector gestureDetector=null;
    private PhotoView photoView;
    private static final String TAG = "ShowPictureFragment";
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout,container,false);
       // imageView=(ImageView) view.findViewById(R.id.imageview2);
        photoView=(PhotoView) view.findViewById(R.id.photo_view);

        Glide.with(photoView.getContext()).load(imageBeanList.get(pic_position).getPath()).into(photoView);
        //pic_position++;
      //  photoView.setOnScrollChangeListener();

    /*  gestureDetector=new GestureDetector(getContext(), new GestureDetector.OnGestureListener() {

            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                Log.d("TAG","onon");
                if(v>0){

                    Log.d("TAG","--->left");

                }
                else if(v<0){
                    Log.d("TAG","--->right");
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }
        });
      */


        //Glide.with(imageView.getContext()).load(imageBeanList.get(pic_position).getPath()).into(imageView);
        return view;
    }

}
