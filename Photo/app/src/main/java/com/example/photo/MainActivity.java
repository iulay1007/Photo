package com.example.photo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.photo.adapter.RecyclerviewAdapter;
import com.example.photo.utils.ItemDecoration;

import java.util.ArrayList;
import java.util.List;
@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity {

    public static int PERMISSION_REQUEST_CODE=1;
    public static int LOADER_ID =1;
    private   RecyclerviewAdapter recyclerviewAdapter;
    private MainActivity2 mainActivity2;
    public static List<ImageBean> imageBeanList=new ArrayList<>();
    private static String TAG="MainActivity";
    private final static int SCAN_OK=1;
    @SuppressLint("HandlerLeak")
    private  Handler mHandler = new Handler() {


        @Override
        public void handleMessage(Message msg) {
           super.handleMessage(msg);

            switch (msg.what) {
                case SCAN_OK:
                    Log.d(TAG,"handlermsg");


                  //  MediaApplication.getInstance().setPhotoList(imageBeanList);
                    recyclerviewAdapter.setData(imageBeanList);

                recyclerviewAdapter.notifyDataSetChanged();

                    Log.d(TAG,"handlermsg");
                    break;
                default:Log.d(TAG,"handler_error");
            }
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();
        initView();
        initImage();


        }


    private void checkPermission() {
        int readExternalStoragePermissionResult = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        if(readExternalStoragePermissionResult != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==PERMISSION_REQUEST_CODE){
            if (grantResults.length==0&&grantResults[0]== PackageManager.PERMISSION_GRANTED) {

            }else{

            }


        }

    }

    private void initImage() {
        imageBeanList.clear();

        new Thread(new Runnable() {
            @Override
            public void run() {


                ContentResolver contentResolver = MainActivity.this.getContentResolver();
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Cursor mCursor = contentResolver.query(uri, new String[]{"_data","date_added"}, null, null, "date_added DESC");
                String[] columnNames = mCursor.getColumnNames();
                if(mCursor==null) return;
                    while (mCursor.moveToNext()) {
                        String path=mCursor.getString(0);
                        long date=mCursor.getLong(1);
                        ImageBean imageBean=new ImageBean(path,date);
                        imageBeanList.add(imageBean);
                      // for(ImageBean imageBean1:imageBeanList){

                       //    Log.d(TAG,"==="+imageBean1);
                    //   }


                    }
                    Log.d(TAG,"qwq");
                  mHandler.sendEmptyMessage(SCAN_OK);
                    mCursor.close();






            }
        }).start();
    }



    private void initView() {

        RecyclerView recyclerView = this.findViewById(R.id.image_list_view);

       // recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
       // recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
       recyclerView.setLayoutManager(new GridLayoutManager(this,4));
       recyclerviewAdapter=new RecyclerviewAdapter();
        int space =5;
      //  recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL),5);
        recyclerView.addItemDecoration(new ItemDecoration(space));

        recyclerView.setAdapter(recyclerviewAdapter);

    }


}
