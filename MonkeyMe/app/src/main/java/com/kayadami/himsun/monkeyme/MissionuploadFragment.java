package com.kayadami.himsun.monkeyme;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
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

    TextView pagenametext;

    ImageView keyword1img, keyword2img, keyword3img;

    EditText mongsang_comment_edittext;

    public MissionuploadFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView called");


        View view = getActivity().getLayoutInflater().inflate(R.layout.mission_upload, container, false);

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

        return view;

        //return inflater.inflate(R.layout.today_keyword, container, false);
    }

    @Override
    public void onClick(View v) {

    }
}