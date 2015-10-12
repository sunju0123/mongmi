package com.kayadami.himsun.monkeyme;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;

/**
 * Created by himsun on 2015. 9. 28..
 */
public class TodayRankinglist1Fragment extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener{

    final String TAG = "TodayRankinglist1";

    private ListView userList;
    private MongSangAdapter adapter;
   // private ListView_Adapter adapter;

    TextView top;
    Button rankingbtn,newbtn;
    String keyword;

    public TodayRankinglist1Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = getArguments();
        Log.d(TAG, "onCreateView called");

        View view = getActivity().getLayoutInflater().inflate(R.layout.today_ranking1, container, false);

        adapter = new MongSangAdapter(getActivity().getApplicationContext());
        userList=(ListView)view.findViewById(R.id.today_ranking1_list);

        userList.setOnItemClickListener(this);

        userList.setAdapter(adapter);

        top=(TextView)view.findViewById(R.id.today_ranking1_topmenu);
        top.setTypeface(MainActivity.baemin_font);

        //   rankingbtn.setTypeface(MainActivity.baemin_font);
        //   newbtn.setTypeface(MainActivity.baemin_font);


        Uri urii = null;

        MongSangCard m1 = new MongSangCard(null,"담다미","2015.09.17 ㅇㅇ","131위",null,"난장판난장판","나는 누구 여긴 어디",100, 100, 123123,urii);
       /*
        MongSangCard(Drawable user_icon, String user_name, String card_date, String card_ranking,
                Drawable card_thumbnail, String keyword, String hanmadi,
        int view_count, int comment, int likes_count)
        */

        adapter.add(m1);
        adapter.add(m1);
        adapter.notifyDataSetChanged();

        top=(TextView)view.findViewById(R.id.today_ranking1_topmenu);
        rankingbtn=(Button)view.findViewById(R.id.ranking2_rankbtn);
        newbtn=(Button)view.findViewById(R.id.ranking1_newbtn);

        keyword=args.getString("id");

        top.setText(keyword);
        newbtn.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v)
    {
        Bundle bundle = new Bundle();

        TodayRankinglist2Fragment todayRankinglist2Fragment = new TodayRankinglist2Fragment();
        switch (v.getId())
        {
            case R.id.ranking1_newbtn:
                bundle.putString("id",keyword);
                todayRankinglist2Fragment.setArguments(bundle);
                FragmentTransaction transaction =((FragmentActivity)getContext()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, todayRankinglist2Fragment);
       //       transaction.addToBackStack(null);
                transaction.commit();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.d("itemclick",String.valueOf(position));

        Log.d("getid",String.valueOf(view.getId()));


        switch (view.getId())
        {
            case R.id.card_thumbnail_img:

                Log.d("thumb", "clicked");

                //   thumbnail.setVisibility(View.GONE);

                /*
                videoview.setVisibility(View.VISIBLE);

                String path = "/storage/sdcard0/DCIM/Camera"
                        + "/VID_20151002_223214.mp4";

                videoview.setVideoPath(path);

                MediaController mediacontrol = new MediaController(mContext);
                videoview.setMediaController(mediacontrol);
                videoview.requestFocus();

                //     videoview.setOnPreparedListener(this);
                videoview.seekTo(0);
                videoview.start();*/

                break;
            case R.id.card_likebtn_img:


                //Object vo = (Object)parent.getAdapter().getItem(position);

                MongSangCard mc= adapter.getItem(position);


                int likescnt = mc.getM_likes_count();

                Log.d("likecnt", String.valueOf(likescnt + 1));
                likescnt++;

                TextView lcnt;
                lcnt=(TextView)view.findViewById(R.id.card_likecount);
                lcnt.setText(String.valueOf(likescnt));

//                likesnum.setText(String.valueOf(likescnt));
                break;
            case R.id.card_videoview:

                Log.d("video", "clicked");

                break;
        }

    }
}