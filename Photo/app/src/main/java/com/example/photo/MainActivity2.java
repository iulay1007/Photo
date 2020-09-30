package com.example.photo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import static com.example.photo.adapter.RecyclerviewAdapter.pic_position;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.photo.adapter.PictureSlideAdapter;
import com.example.photo.fragment.LeftFragment;
import com.example.photo.fragment.RightFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private List<ImageBean> list = new ArrayList<>();
  //  private List<Fragment> fragmentlist=new ArrayList<>();;
    ImageView imageView;
    private ViewPager viewPager;
    private PictureSlideAdapter pictureSlideAdapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // imageView=(ImageView)findViewById(R.id.imageview2);
        viewPager=(ViewPager)findViewById(R.id.viewpager);



   /*     Fragment leftFragment = new LeftFragment();
        Fragment centerFragment=new ShowPictureFragment();
        Fragment rightFragment = new RightFragment();
        fragmentlist.add(centerFragment);
        fragmentlist.add(leftFragment);

        fragmentlist.add(rightFragment);
*/


        Intent intent=getIntent();
        final int  preposition=intent.getIntExtra("position",0);


        pictureSlideAdapter=new PictureSlideAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pictureSlideAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position>preposition)
                {
                    pic_position++;
                    Log.d("TAG","change1!!!");
                    viewPager.setCurrentItem(position);
                }
                else if(position<preposition)
                    pic_position--;
                Log.d("TAG","change2!!!");
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

      //  viewPager.addOnPageChangeListener();
      // viewPager.setOffscreenPageLimit(list.size()/2);
       // viewPager.setCurrentItem((list.size()) * 100);

        viewPager.setCurrentItem(preposition);     //!!!!!(List<ImageBean>)
        //list=imageBeanList;
        //imageBeanList =  MediaApplication.getInstance().getPhotoList();

      //  Glide.with(imageView.getContext()).load(list.get(position).getPath()).into(imageView);


  //  imageBeanList=(List<ImageBean>) intent.<Parcelable>getSerializableExtra("list");

    }


}