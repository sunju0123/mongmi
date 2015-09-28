package com.kayadami.himsun.monkeyme;

import  android.support.v4.app.FragmentManager;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView pagenametext;

    //FragmentManager fm = getFragmentManager();

    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    MainActivityFragment mainFragment = new MainActivityFragment();
    MenuFragment menuFragment = new MenuFragment();
    TodayFragment todayFragment = new TodayFragment();
    MissionFragment missionFragment = new MissionFragment();
    MissionuploadFragment missionuploadFragment = new MissionuploadFragment();

    public static Typeface baemin_font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        baemin_font = Typeface.createFromAsset(this.getAssets(),"fonts/BMHANNA.otf");



        Log.d("dd", "start");

        transaction.add(R.id.mainLayout,todayFragment).commit();
        //getFragmentManager().beginTransaction().add(R.id.mainLayout, todayFragment).commit();
    }

    public void onArticleSelected(Uri articleUri)
    {
      //  TodayFragment articleFrag = (TodayFragment)getSupportFragmentManager().findFragmentById(R.id.)
    }

    public void onTodayClicked(View view)
    {
        Log.d("click","imgClick");

        transaction.replace(R.id.mainLayout,todayFragment).commit();

        /*
        fm.beginTransaction().replace(R.id.mainLayout,todayFragment).commit();
        fm.beginTransaction().addToBackStack(null);
*/

    }
    public void onMissionClicked(View view)
    {
        Log.d("click","imgClick");

        transaction.replace(R.id.mainLayout,missionFragment).commit();
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
