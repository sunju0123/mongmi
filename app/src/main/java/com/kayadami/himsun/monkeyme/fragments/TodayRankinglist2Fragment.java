package com.kayadami.himsun.monkeyme.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.kayadami.himsun.monkeyme.adapters.MongSangAdapter;
import com.kayadami.himsun.monkeyme.models.MongSangCard;
import com.kayadami.himsun.monkeyme.R;
import com.kayadami.himsun.monkeyme.activities.MainActivity;

/**
 * Created by himsun on 2015. 10. 6..
 */
public class TodayRankinglist2Fragment extends Fragment implements View.OnClickListener{
    final String TAG = "TodayRankinglist1";

    private ListView MongSangList;
    private MongSangAdapter adapter;
    // private ListView_Adapter adapter;

    private String keyword;
    TextView top,ranktext,newtext;
    Button rankbtn, newbtn;

    public TodayRankinglist2Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = getArguments();
        Log.d(TAG, "onCreateView called");

        View view = getActivity().getLayoutInflater().inflate(R.layout.today_ranking2, container, false);

        adapter = new MongSangAdapter(getActivity().getApplicationContext());
        MongSangList=(ListView)view.findViewById(R.id.today_ranking2_list);
        MongSangList.setAdapter(adapter);

        top=(TextView)view.findViewById(R.id.today_ranking2_topmenu);
        top.setTypeface(MainActivity.baemin_font);

    //    ranktext.setTypeface(MainActivity.baemin_font);
    //    newtext.setTypeface(MainActivity.baemin_font);


        Uri urii=null;

        MongSangCard m1 = new MongSangCard(null,"힘선주","2015.09.17 ㅇㅇ","131위",null,"쓰레기","뀨뀨",100, 100, 123123,urii);
       /*
        MongSangCard(Drawable user_icon, String user_name, String card_date, String card_ranking,
                Drawable card_thumbnail, String keyword, String hanmadi,
        int view_count, int comment, int likes_count)
        */

        adapter.add(m1);
        adapter.notifyDataSetChanged();

        top=(TextView)view.findViewById(R.id.today_ranking2_topmenu);
        rankbtn=(Button)view.findViewById(R.id.ranking2_rankbtn);

        rankbtn.setOnClickListener(this);

        //  top.setText("aa");
        keyword = args.getString("id");
        top.setText(keyword);

        return view;

    }

    @Override
    public void onClick(View v)
    {
        Bundle bundle = new Bundle();

        TodayRankinglist1Fragment todayRankinglist1Fragment = new TodayRankinglist1Fragment();
        switch (v.getId())
        {
            case R.id.ranking2_rankbtn:
                bundle.putString("id",keyword);
                todayRankinglist1Fragment.setArguments(bundle);
                FragmentTransaction transaction =((FragmentActivity)getContext()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, todayRankinglist1Fragment);
       //         transaction.addToBackStack(null);
                transaction.commit();
        }
    }
}
