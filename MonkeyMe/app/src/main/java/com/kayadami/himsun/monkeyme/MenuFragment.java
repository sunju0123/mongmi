package com.kayadami.himsun.monkeyme;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by himsun on 2015. 9. 17..
 */
public class MenuFragment extends Fragment{
    final String TAG = "MenuFragment";

    public MenuFragment()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        Log.d(TAG, "onCreateView 호출됨");
        return inflater.inflate(R.layout.fragment_menu,container,false);
    }
}
