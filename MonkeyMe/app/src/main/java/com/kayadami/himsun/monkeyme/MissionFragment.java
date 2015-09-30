package com.kayadami.himsun.monkeyme;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by himsun on 2015. 9. 21..
 */

public class MissionFragment extends Fragment implements View.OnClickListener {

    FragmentManager fm = getFragmentManager();
    MissionuploadFragment missionuploadFragment = new MissionuploadFragment();


    boolean flag=false;

    Bundle bundle = new Bundle();

    final String TAG = "MissionFragment";
    TextView keyword1, keyword2, keyword3;
    TextView mong_say, mong_time;


    ImageView keyword1img, keyword2img, keyword3img;

    public MissionFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView called");


        View view = getActivity().getLayoutInflater().inflate(R.layout.mission_keyword, container, false);


        keyword1 = (TextView) view.findViewById(R.id.mission_keyword1_text);
        keyword2 = (TextView) view.findViewById(R.id.mission_keyword2_text);
        keyword3 = (TextView) view.findViewById(R.id.mission_keyword3_text);

        mong_say = (TextView) view.findViewById(R.id.mongmi_say_text);
        mong_time = (TextView) view.findViewById(R.id.mongmi_time_text);

        keyword1.setTypeface(MainActivity.baemin_font);
        keyword2.setTypeface(MainActivity.baemin_font);
        keyword3.setTypeface(MainActivity.baemin_font);
        mong_say.setTypeface(MainActivity.baemin_font);
        mong_time.setTypeface(MainActivity.baemin_font);

        String calctime;
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        int hour, min, sec;
        int calcsec, calcmin, calchour;
        hour = date.getHours();
        min = date.getMinutes();
        sec = date.getSeconds();

        calcsec = hour * 3600 + min * 60 + sec;
        calcsec = 34 * 3600 - calcsec;

        Log.d("DD", String.valueOf(calcsec));

        calchour = calcsec / 3600;
        calcsec %= 3600;
        Log.d("DD", String.valueOf(calcsec));

        calcmin = calcsec / 60;
        calcsec %= 60;
        Log.d("DD", String.valueOf(calcsec));

        calctime = "남은시간 ";
        if (calchour < 10) calctime += "0";
        calctime += calchour + ":";
        if (calcmin < 10) calctime += "0";
        calctime += calcmin + ":";
        if (calcsec < 10) calctime += "0";
        calctime += calcsec;


        Log.d("date", date.toString());
        Log.d("date", calctime);


        mong_time.setText(calctime);

        keyword1img = (ImageView) view.findViewById(R.id.mission_keyword1_btn);
        keyword2img = (ImageView) view.findViewById(R.id.mission_keyword2_btn);
        keyword3img = (ImageView) view.findViewById(R.id.mission_keyword3_btn);

        keyword1img.setOnClickListener(this);
        keyword2img.setOnClickListener(this);
        keyword3img.setOnClickListener(this);

        //   keyword1img.setOnTouchListener(this,);
        //    keyword2img.setOnTouchListener(this);
        //     keyword3img.setOnTouchListener(this);

        /*
        오늘의 키워드랑 영상수 받아와서 찍기
         */

        keyword1.setText("쓰레기기");


        return view;

        //return inflater.inflate(R.layout.today_keyword, container, false);
    }


/*
    @Override
    public void onTouch(View v,MotionEvent motionEvent)
    {
        Log.d("t","touched");

        switch (v.getId())
        {
            case R.id.mission_keyword1_btn:
                keyword1img.setImageResource(R.mipmap.keyword_button_pressed);
                break;
            case R.id.mission_keyword2_btn:
                keyword2img.setImageResource(R.mipmap.keyword_button_pressed);
                break;
            case R.id.mission_keyword3_btn:
                keyword3img.setImageResource(R.mipmap.keyword_button_pressed);
            default:
                break;
        }
    }
*/

    @Override
    public void onClick(View v) {
        Log.d("img1", "clickeddd");


        //     MissionuploadFragment missionuploadFragment = new MissionuploadFragment();

        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 3);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 9);

        startActivityForResult(intent, 2);

    //    if(flag ==true) {
            switch (v.getId()) {
                case R.id.mission_keyword1_btn:
                    Log.d("Img1", "clicked");

                    bundle.putString("id", "keyword1");
                    missionuploadFragment.setArguments(bundle);

                    break;
                case R.id.mission_keyword2_btn:
                    Log.d("Img2", "clicked");

                    bundle.putString("id", "keyword2");
                    missionuploadFragment.setArguments(bundle);


                    break;
                case R.id.mission_keyword3_btn:
                    Log.d("Img3", "clicked");

                    bundle.putString("id", "keyword3");
                    missionuploadFragment.setArguments(bundle);
                    break;

            }

      //  }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        getVideoInfo(data.getData());

        FragmentTransaction transaction = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.mainLayout, missionuploadFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void getVideoInfo(Uri uri) {

        String filePath = uri.getPath();

        Log.d("video",filePath);
        Log.d("videoname", uri.getLastPathSegment());

        Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();

        String path = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA));
        Log.d("path", path);

        /*
        Uri video = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projection = new String[]{MediaStore.Video.Media._ID};
        String where = MediaStore.Video.Media.DATA+"=?";
        String[] whereArgs = new String[]{path};
        Cursor media = getActivity().getContentResolver().query(video, projection, where, whereArgs, null);

        media.moveToFirst();
        String videoId = media.getString(0);

        Log.d("videoid",videoId);


*/



        bundle.putString("videoid", path);



        Cursor thumb;
        /*
        thumb = getActivity().getApplicationContext().getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                projection,
                where,
                whereArgs,
                null);*/
        /*

        String result = null;
        long imageId = -1;

        Uri thumbnail = MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI;
        String[] projection = new String[]{MediaStore.Video.Thumbnails.DATA};
        String where = MediaStore.Video.Thumbnails.VIDEO_ID+"=?";
        String[] whereargs = new String[] {uri.getLastPathSegment()};


        //Cursor thumb= getActivity().getContentResolver().query(thumbnail,projection,where,whereargs,null);

        //thumb.moveToFirst();
        //String tpath = thumb.getString(0);
        //Log.d("tpath",tpath);

*/

        /*
        try
        {
            String[] projection = new String[] { MediaStore.MediaColumns._ID };
            String selection = MediaStore.MediaColumns.DATA + "=?";
            String[] selectionArgs = new String[] { path };
            Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst())
            {
                imageId = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
            }
            cursor.close();

            cursor = MediaStore.Images.Thumbnails.queryMiniThumbnail(context.getContentResolver(), imageId, MediaStore.Images.Thumbnails.MINI_KIND, null);
            if (cursor != null && cursor.getCount() > 0)
            {
                cursor.moveToFirst();
                result = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails.DATA));
            }
            cursor.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
*/

    }
/*
    // 실제 경로 찾기
    private String getPath(Uri uri)
    {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    // 파일명 찾기
    private String getName(Uri uri)
    {
        String[] projection = { MediaStore.Images.ImageColumns.DISPLAY_NAME };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DISPLAY_NAME);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    // uri 아이디 찾기
    private String getUriId(Uri uri)
    {
        String[] projection = {MediaStore.Images.ImageColumns._ID };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    */
}
