package com.kayadami.himsun.monkeyme;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by himsun on 2015. 9. 23..
 */

public class MissionuploadFragment extends Fragment implements View.OnClickListener {

    final String TAG = "MissionUploadFragment";
    TextView keyword1, keyword2, keyword3;

    ImageView thumbnailimg;
    ImageView back_btn, upload_btn;

    EditText mongsang_comment_edittext;
    Bundle args;

    public MissionuploadFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView called");


        View view = getActivity().getLayoutInflater().inflate(R.layout.mission_upload, container, false);

        back_btn=(ImageView)view.findViewById(R.id.mission_upload_backbtn);
        upload_btn=(ImageView)view.findViewById(R.id.mission_upload_btn);

        thumbnailimg=(ImageView)view.findViewById(R.id.mission_upload_thumbnail_img);
        mongsang_comment_edittext = (EditText)view.findViewById(R.id.mongsang_commnet_edit);


        back_btn.setOnClickListener(this);
        upload_btn.setOnClickListener(this);



        args = getArguments();

        String videopath = args.getString("videoid");

        //videopath = "/sdcard/DCIM/Camera/VID_20150930_164124.mp4";

  //      Long vid = Long.parseLong(videoid);

//        Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(videoid, MediaStore.Video.Thumbnails.MINI_KIND);

//        Bitmap thumb = ThumbnailUtils.createVideoThumbnail(filePath, Thumbnails.MINI_KIND);


        Log.d("path", videopath);

        MediaMetadataRetriever m = new MediaMetadataRetriever();
        m.setDataSource(videopath);
        Bitmap bitmap = m.getFrameAtTime(0);// 시간은 uSec단위

        thumbnailimg.setImageBitmap(bitmap);




        // SaveBitmapToJPG(bitmap, /sdcard/Pictures/, bitmap + nCount + .jpg);

/*
        Uri video = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projection = new String[]{MediaStore.Video.Media._ID};
        String where = MediaStore.Video.Media.DATA+"=?";
        String[] whereArgs;// = new String[]{videoPath};
     //   Cursor media = getActivity().getContentResolver().query(video, projection, where, whereArgs, null);

     //   media.moveToFirst();
        //String videoId = media.getString(0);

        Uri thumbnail = MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI;
        projection = new String[]{MediaStore.Video.Thumbnails.DATA};
        where = MediaStore.Video.Thumbnails.VIDEO_ID+"=?";
        whereArgs = new String[]{videoid};

        Cursor thumb = getActivity().getContentResolver().query(thumbnail, projection, where, whereArgs, null);
*/


        /*
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;


        Bitmap bitmapthumb= MediaStore.Video.Thumbnails.getThumbnail(getActivity().getContentResolver(), vid, MediaStore.Images.Thumbnails.MICRO_KIND, options);


       thumbnailimg.setImageBitmap(bitmapthumb);
*/


        //mongsang_comment_edittext = (EditText)view.findViewById(R.id.mongsang_commnet_edit);
        //mongsang_comment_edittext.requestFocus();

        //InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);


      //  pagenametext = (TextView) getActivity().getLayoutInflater().inflate(R.layout.activity_main, container, false).findViewById(R.id.pagename_text);
     //   pagenametext.setText("몽상 한마디");



      //  keyword1img = (ImageView) view.findViewById(R.id.mission_keyword1_btn);

 //       keyword1img.setOnClickListener(this);


        /*
        오늘의 키워드랑 영상수 받아와서 찍기
         */



        mongsang_comment_edittext.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mongsang_comment_edittext, InputMethodManager.SHOW_IMPLICIT);
        return view;

    }

    @Override
    public void onClick(View v) {

        TodayRankinglist1Fragment rankinglist1Fragment = new TodayRankinglist1Fragment();
        FragmentTransaction transaction = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.mission_upload_backbtn:
                getFragmentManager().popBackStack();
                break;
            case R.id.mission_upload_btn:
                Log.d("Img2", "clicked");

                //업로등
                rankinglist1Fragment.setArguments(args);
                transaction.replace(R.id.mainLayout, rankinglist1Fragment);
                transaction.commit();

                break;

        }
    }
}