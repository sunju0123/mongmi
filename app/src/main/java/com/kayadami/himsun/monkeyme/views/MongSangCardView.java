package com.kayadami.himsun.monkeyme.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.kayadami.himsun.monkeyme.R;
import com.kayadami.himsun.monkeyme.activities.MainActivity;
import com.kayadami.himsun.monkeyme.models.MongSangCard;

/**
 * Created by bbarm on 2015. 10. 12..
 */
public class MongSangCardView extends LinearLayout {

    private RelativeLayout rl;
    private ImageView userIcon, thumbnail, likeBtn;
    private TextView username, date, rank, keyword, hanmadi, likesNum;
    private VideoView videoView;
    
    private Context context;
    
    private MongSangCard card;
    
    private int likesCnt = 0;
    
    public MongSangCardView(Context context) {
        this(context, null);
    }

    public MongSangCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MongSangCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        
        this.context = context;
        
        setOrientation(VERTICAL);
        
        inflate();
    }
    
    private void inflate() {
        LayoutInflater.from(getContext()).inflate(R.layout.list_card_layout, this);
        
        userIcon = (ImageView) findViewById(R.id.card_usericon_img);
        username = (TextView) findViewById(R.id.card_username_text);
        date = (TextView) findViewById(R.id.card_date_text);
        rank = (TextView) findViewById(R.id.card_rank);
        keyword = (TextView) findViewById(R.id.card_keyword);
        hanmadi = (TextView) findViewById(R.id.card_hanmadi);
        likesNum = (TextView) findViewById(R.id.card_likecount);
        thumbnail = (ImageView) findViewById(R.id.card_thumbnail_img);
        likeBtn = (ImageView) findViewById(R.id.card_likebtn_img);
        videoView = (VideoView)findViewById(R.id.card_videoview);
        rl = (RelativeLayout) findViewById(R.id.card_relativelayout);
        
        initialize();
    }
    
    private void initialize() {
        rank.setTypeface(MainActivity.baemin_font);
        likesNum.setTypeface(MainActivity.baemin_font);
        keyword.setTypeface(MainActivity.baemin_font);
        
        thumbnail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.setVisibility(VISIBLE);

                String path = "/storage/sdcard0/DCIM/Camera"
                        + "/VID_20151002_223214.mp4";

                videoView.setVideoPath(path);

                MediaController mediacontrol = new MediaController(context);
                videoView.setMediaController(mediacontrol);
                videoView.requestFocus();

                videoView.seekTo(0);
                videoView.start();
            }
        });
        
        likeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("likecnt", String.valueOf(likesCnt + 1));
                likesCnt++;
                card.setLikesCount(likesCnt);

                likesNum.setText(String.valueOf(likesCnt));
            }
        });
    }
    
    public void setCard(MongSangCard card) {
        this.card = card;
        
        updateView();
    }
    
    private void updateView() {
        videoView.setVisibility(INVISIBLE);

        if (card.getUserIcon() != null) {
            userIcon.setImageDrawable(card.getUserIcon());
        }
        
        if (card.getCardThumbnail() != null) {
            thumbnail.setImageDrawable(card.getCardThumbnail());
        }

        username.setText(card.getUserName());
        date.setText(card.getCardDate());
        rank.setText(card.getCardRanking());
        keyword.setText(card.getKeyword());
        hanmadi.setText(card.getHanmadi());

        likesCnt = card.getLikesCount();
        likesNum.setText(String.valueOf(card.getLikesCount()));

        videoView.destroyDrawingCache();
    }
}
