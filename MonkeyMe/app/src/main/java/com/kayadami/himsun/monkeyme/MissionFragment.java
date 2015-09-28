package com.kayadami.himsun.monkeyme;

import android.support.v4.app.Fragment;
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

    final String TAG = "MissionFragment";
    TextView keyword1,keyword2,keyword3;
    TextView mong_say,mong_time;


    ImageView keyword1img,keyword2img,keyword3img;

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
        int hour,min,sec;
        int calcsec,calcmin,calchour;
        hour = date.getHours(); min=date.getMinutes(); sec=date.getSeconds();

        calcsec=hour*3600+min*60+sec;
        calcsec=34*3600 - calcsec;

        Log.d("DD",String.valueOf(calcsec));

        calchour=calcsec/3600;
        calcsec%=3600;
        Log.d("DD",String.valueOf(calcsec));

        calcmin=calcsec/60;
        calcsec%=60;
        Log.d("DD",String.valueOf(calcsec));

        calctime="남은시간 ";
        if(calchour<10) calctime+="0";
        calctime+=calchour+":";
        if(calcmin<10) calctime+="0";
        calctime+=calcmin+":";
        if(calcsec<10) calctime+="0";
        calctime+=calcsec;


        Log.d("date",date.toString());
        Log.d("date",calctime);


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
        switch (v.getId()) {
            case R.id.mission_keyword1_btn:
                Log.d("Img1", "clicked");


                fm.beginTransaction().replace(R.id.mainLayout, missionuploadFragment).commit();
                break;
            case R.id.mission_keyword2_btn:
                Log.d("Img2", "clicked");
                fm.beginTransaction().replace(R.id.mainLayout, missionuploadFragment).commit();
                break;
            case R.id.mission_keyword3_btn:
                Log.d("Img3", "clicked");
                fm.beginTransaction().replace(R.id.mainLayout, missionuploadFragment).commit();
                break;

        }
    }

}
