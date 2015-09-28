package com.kayadami.himsun.monkeyme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by himsun on 2015. 9. 28..
 */
public class TodayRankinglist1Fragment extends Fragment {

    final String TAG = "TodayRankinglist1";


    public TodayRankinglist1Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView called");


        View view = getActivity().getLayoutInflater().inflate(R.layout.today_ranking, container, false);

        return view;

    }
}