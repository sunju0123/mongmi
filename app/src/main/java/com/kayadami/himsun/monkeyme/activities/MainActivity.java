package com.kayadami.himsun.monkeyme.activities;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kayadami.himsun.monkeyme.fragments.MissionFragment;
import com.kayadami.himsun.monkeyme.R;
import com.kayadami.himsun.monkeyme.fragments.TodayFragment;

public class MainActivity extends AppCompatActivity {

    public TextView pagenametext;

    //FragmentManager fm = getFragmentManager();

    FragmentTransaction transaction=((FragmentActivity)this).getSupportFragmentManager().beginTransaction(); //= this.getSupportFragmentManager().beginTransaction();

    TodayFragment todayFragment = new TodayFragment();
    MissionFragment missionFragment = new MissionFragment();

    public static Typeface baemin_font;
    private ImageView todayimg,missionimg,rankingimg,meimg;
    Drawable todayactive,todayinactive, missionactive, missioninactive, rankactive, rankinactive, meactive,meinactive;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        baemin_font = Typeface.createFromAsset(this.getAssets(),"fonts/BMHANNA.otf");


        Log.d("dd", "start");

        todayimg=(ImageView)findViewById(R.id.tab_today_img);
        missionimg=(ImageView)findViewById(R.id.tab_mission_img);
        rankingimg=(ImageView)findViewById(R.id.tab_ranking_img);
        meimg=(ImageView)findViewById(R.id.tab_mypage_img);

        todayactive = getResources().getDrawable(R.mipmap.tab_banana_active3x);
        todayinactive=getResources().getDrawable(R.mipmap.tab_banana_inactive3x);
        missionactive = getResources().getDrawable(R.mipmap.tab_mission_active3x);
        missioninactive=getResources().getDrawable(R.mipmap.tab_mission_inactive3x);


        todayimg.setImageDrawable(todayactive);
        getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, todayFragment).commit();

//        transaction.add(R.id.mainLayout,todayFragment).commit();
        //getFragmentManager().beginTransaction().add(R.id.mainLayout, todayFragment).commit();
    }

    public void onArticleSelected(Uri articleUri)
    {
      //  TodayFragment articleFrag = (TodayFragment)getSupportFragmentManager().findFragmentById(R.id.)
    }

    public void onTodayClicked(View view)
    {
        Log.d("click", "imgClick");


        todayimg.setImageDrawable(todayactive);
        missionimg.setImageDrawable(missioninactive);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, todayFragment).addToBackStack(null).commit();

//        transaction.replace(R.id.mainLayout,todayFragment).commit();

        /*
        fm.beginTransaction().replace(R.id.mainLayout,todayFragment).commit();
        fm.beginTransaction().addToBackStack(null);
*/

    }
    public void onMissionClicked(View view)
    {
        Log.d("click", "imgClick");

        todayimg.setImageDrawable(todayinactive);
        missionimg.setImageDrawable(missionactive);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, missionFragment).addToBackStack(null).commit();

//        transaction.replace(R.id.mainLayout,missionFragment).commit();
        /*
        fm.beginTransaction().replace(R.id.mainLayout,missionFragment).commit();
        fm.beginTransaction().addToBackStack(null);
*/
    }
    public void onRankingClicked(View view)
    {
        Log.d("click", "imgClick");
//        fm.beginTransaction().replace(R.id.mainLayout,todayFragment).commit();

    }
    public void onMypageClicked(View view)
    {
        Log.d("click", "imgClick");
  //      fm.beginTransaction().replace(R.id.mainLayout,missionFragment).commit();

    }


}
