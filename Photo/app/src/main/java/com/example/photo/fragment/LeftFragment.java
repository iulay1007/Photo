package com.example.photo.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.photo.R;

import uk.co.senab.photoview.PhotoView;

import static com.example.photo.MainActivity.imageBeanList;
import static com.example.photo.adapter.RecyclerviewAdapter.pic_position;

public class LeftFragment extends Fragment {
    private PhotoView photoView;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment_layout, container, false);

        photoView = (PhotoView) view.findViewById(R.id.photo_view);
        pic_position--;
        Glide.with(photoView.getContext()).load(imageBeanList.get(pic_position).getPath()).into(photoView);

        return view;
    }
}