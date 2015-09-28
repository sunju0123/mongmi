package com.kayadami.himsun.monkeyme;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by himsun on 2015. 9. 18..
 */
public class TodayFragment extends Fragment implements  View.OnClickListener{

    OnHeadlineSelectedListener mListener;

    final String TAG = "TodayFragment";
    TextView keyword1,keyword2,keyword3;
    TextView keyword1cnt,keyword2cnt,keyword3cnt;

    TextView topmenu;

    ImageView keyword1img,keyword2img,keyword3img;

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(Uri articleUri);
    }

    public TodayFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView called");

        View view = getActivity().getLayoutInflater().inflate(R.layout.today_keyword,container,false);

        topmenu = (TextView) view.findViewById(R.id.today_keyword_topmenu);
        topmenu.setTypeface(MainActivity.baemin_font);

        keyword1=(TextView) view.findViewById(R.id.today_keyword1_text);
        keyword2=(TextView) view.findViewById(R.id.today_keyword2_text);
        keyword3=(TextView) view.findViewById(R.id.today_keyword3_text);

        keyword1cnt=(TextView)view.findViewById(R.id.today_keyword1_cnt);
        keyword2cnt=(TextView)view.findViewById(R.id.today_keyword2_cnt);
        keyword3cnt=(TextView)view.findViewById(R.id.today_keyword3_cnt);

        keyword1img=(ImageView)view.findViewById(R.id.today_keyword1_imgview);
        keyword2img=(ImageView)view.findViewById(R.id.today_keyword2_imgview);
        keyword3img=(ImageView)view.findViewById(R.id.today_keyword3_imgview);

        keyword1img.setOnClickListener(this);
        keyword2img.setOnClickListener(this);
        keyword3img.setOnClickListener(this);

        /*
        오늘의 키워드랑 영상수 받아와서 찍기
         */

        keyword1.setText("쓰레기기");


        return view;

        //return inflater.inflate(R.layout.today_keyword, container, false);
    }

    @Override
    public void onClick(View v)
    {

        Bundle bundle = new Bundle();

        TodayRankinglist1Fragment rankinglist1Fragment = new TodayRankinglist1Fragment();

        FragmentTransaction transaction =((FragmentActivity)getContext()).getSupportFragmentManager().beginTransaction();

        Log.d("img1","clickeddd");
        switch (v.getId())
        {
            case R.id.today_keyword1_imgview:
                Log.d("Img1", "clicked");

                bundle.putString("id", "keyword1");
                rankinglist1Fragment.setArguments(bundle);

                break;
            case R.id.today_keyword2_imgview:
                Log.d("Img2","clicked");

                bundle.putString("id", "keyword2");
                rankinglist1Fragment.setArguments(bundle);
                break;
            case R.id.today_keyword3_imgview:
                Log.d("Img3", "clicked");

                bundle.putString("id", "keyword3");
                rankinglist1Fragment.setArguments(bundle);

                break;
            default:
                break;

        }

        transaction.replace(R.id.mainLayout,rankinglist1Fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
/*
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        try
        {
            mListener = (OnHeadlineSelectedListener) activity;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+"must implenet");
        }

    }
*/
}
