package com.kayadami.himsun.monkeyme.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.kayadami.himsun.monkeyme.models.MongSangCard;
import com.kayadami.himsun.monkeyme.R;
import com.kayadami.himsun.monkeyme.activities.MainActivity;

import java.util.ArrayList;

/**
 * Created by himsun on 2015. 10. 5..
 */
public class MongSangAdapter extends BaseAdapter implements View.OnClickListener

{

   private RelativeLayout rl;
    private MongSangCard mMongCard;
    private Context mContext;

    private ArrayList<MongSangCard> mMongSangList;

    private ImageView usericon,thumbnail,likebtn;
    private TextView username,date,rank,keyword,hanmadi,likesnum;
    private VideoView videoview;
    int likescnt=0;

    public MongSangAdapter(Context context)
    {
        super();
        mContext = context;
        mMongSangList = new ArrayList<MongSangCard>();

        videoview = new VideoView(mContext);
        videoview.setLayoutParams(new ViewGroup.LayoutParams(300,300));

    }

    @Override
    public int getCount()
    {
        return mMongSangList.size();
    }

    @Override
    public MongSangCard getItem(int position) {
        return mMongSangList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {


        View v = convertView;



        if(v==null)
        {
            v=((LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_card_layout,null);
        }

        usericon=(ImageView)v.findViewById(R.id.card_usericon_img);
        username= (TextView) v.findViewById(R.id.card_username_text);
        date=(TextView)v.findViewById(R.id.card_date_text);
        rank=(TextView)v.findViewById(R.id.card_rank);
        keyword=(TextView)v.findViewById(R.id.card_keyword);
        hanmadi=(TextView)v.findViewById(R.id.card_hanmadi);
        likesnum=(TextView)v.findViewById(R.id.card_likecount);
        thumbnail=(ImageView)v.findViewById(R.id.card_thumbnail_img);
        likebtn=(ImageView)v.findViewById(R.id.card_likebtn_img);
    //    videoview=(VideoView)v.findViewById(R.id.card_videoview);

        rl= (RelativeLayout) v.findViewById(R.id.card_relativelayout);

        rank.setTypeface(MainActivity.baemin_font);
        likesnum.setTypeface(MainActivity.baemin_font);


        videoview.setVisibility(View.INVISIBLE);


        mMongCard = getItem(position);


        if(mMongCard!=null)
        {
            if(mMongCard.getM_user_icon()!=null)
            {
                usericon.setImageDrawable(mMongCard.getM_user_icon());
            }
            if(mMongCard.getM_thumbnail()!=null)
            {
                thumbnail.setImageDrawable(mMongCard.getM_thumbnail());
            }

            username.setText(mMongCard.getM_user_name());
            date.setText(mMongCard.getM_date());
            rank.setText(mMongCard.getM_ranking());
            keyword.setText(mMongCard.getM_keyword());
            hanmadi.setText(mMongCard.getM_hanmadi());


            likescnt=mMongCard.getM_likes_count();
            likesnum.setText(String.valueOf(likescnt));
            keyword.setTypeface(MainActivity.baemin_font);

 //           likesnum.setText(mMongCard.getM_likes_count());

            thumbnail.setTag(position);
            likebtn.setTag(position);
            videoview.setTag(position);



           thumbnail.setOnClickListener(this);
            likebtn.setOnClickListener(this);
            videoview.setOnClickListener(this);

        //    videoview.destroyDrawingCache();
        }



        return v;
    }

    public void add(MongSangCard mongsangcard)
    {
        mMongSangList.add(mongsangcard);
    }


    @Override
    public void onClick(View v) {


//        int a = Integer.parseInt((String) v.getTag());
//        MongSangCard mc = mMongSangList.get(a);

      //  mMongSangList.getChile


        switch (v.getId())
        {
            case R.id.card_usericon_img:
                break;
            case R.id.card_thumbnail_img:

                Log.d("thumb", "clicked");

             //   thumbnail.setVisibility(View.GONE);




                videoview=new VideoView(mContext);

                android.widget.FrameLayout.LayoutParams fl = new FrameLayout.LayoutParams(300, 300);

                videoview.setLayoutParams(fl);


//                videoview.setVisibility(View.VISIBLE);

                String path = "/storage/sdcard0/DCIM/Camera"
                        + "/VID_20151002_223214.mp4";

                videoview.setVideoPath(path);

                MediaController mediacontrol = new MediaController(mContext);
                videoview.setMediaController(mediacontrol);
                videoview.requestFocus();

                //     videoview.setOnPreparedListener(this);
                videoview.seekTo(0);
               videoview.start();

                rl.addView(videoview);

                break;
            case R.id.card_likebtn_img:
                Log.d("likecnt", String.valueOf(likescnt + 1));
                likescnt++;
                mMongCard.setM_likes_count(likescnt);

               likesnum.setText(String.valueOf(likescnt));
                break;

            /*
            case R.id.card_videoview:

                Log.d("video", "clicked");


                break;*/
        }

    }

    /*
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        switch (v.getId())
        {
            case R.id.card_usericon_img:
                break;
            case R.id.card_thumbnail_img:

                Log.d("thumb", "clicked");

                //     thumbnail.setVisibility(View.GONE);
                videoview.setVisibility(View.VISIBLE);

                String path = "/storage/sdcard0/DCIM/Camera"
                        + "/VID_20151002_223214.mp4";

                videoview.setVideoPath(path);

                MediaController mediacontrol = new MediaController(mContext);
                videoview.setMediaController(mediacontrol);
                videoview.requestFocus();

                //     videoview.setOnPreparedListener(this);
                videoview.seekTo(0);
                videoview.start();

                break;
            case R.id.card_likebtn_img:
                Log.d("likecnt", String.valueOf(likescnt + 1));
                likescnt++;

                likesnum.setText(String.valueOf(likescnt));
                break;
            case R.id.card_videoview:

                Log.d("video", "clicked");


                break;
        }
    }*/
}
