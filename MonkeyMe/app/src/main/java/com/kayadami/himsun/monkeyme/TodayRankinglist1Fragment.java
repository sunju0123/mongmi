package com.kayadami.himsun.monkeyme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by himsun on 2015. 9. 28..
 */
public class TodayRankinglist1Fragment extends Fragment {

    final String TAG = "TodayRankinglist1";

    TextView top;

    public TodayRankinglist1Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = getArguments();
        Log.d(TAG, "onCreateView called");


        View view = getActivity().getLayoutInflater().inflate(R.layout.today_ranking, container, false);

        top=(TextView)view.findViewById(R.id.today_ranking_topmenu);

      //  top.setText("aa");
        top.setText(args.getString("id"));

        return view;

    }
}