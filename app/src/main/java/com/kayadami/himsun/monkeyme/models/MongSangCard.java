package com.kayadami.himsun.monkeyme.models;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/**
 * Created by himsun on 2015. 10. 1..
 */
public class MongSangCard {

    private Drawable userIcon;
    private String userName, cardDate, cardRanking;
    private Drawable cardThumbnail;
    private String keyword, hanmadi;
    private Uri videoUri;

    private int viewCount, comment, likesCount;

    public MongSangCard(Drawable userIcon, String userName, String cardDate, String cardRanking,
                 Drawable cardThumbnail, String keyword, String hanmadi,
                 int viewCount, int comment, int likesCount, Uri videoUri) {
        this.userIcon = userIcon;
        this.userName = userName;
        this.cardDate = cardDate;
        this.cardRanking = cardRanking;

        this.cardThumbnail = cardThumbnail;

        this.keyword = keyword;
        this.hanmadi = hanmadi;
        this.viewCount = viewCount;
        this.comment = comment;
        this.likesCount = likesCount;

        this.videoUri = videoUri;
    }

    public Drawable getUserIcon() {
        return userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public String getCardDate() {
        return cardDate;
    }

    public String getCardRanking() {
        return cardRanking;
    }

    public Drawable getCardThumbnail() {
        return cardThumbnail;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getHanmadi() {
        return hanmadi;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getComment() {
        return comment;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public Uri getVideoUri() {
        return videoUri;
    }


    public void setLikesCount(int like)
    {
        likesCount = like;
    }

}
