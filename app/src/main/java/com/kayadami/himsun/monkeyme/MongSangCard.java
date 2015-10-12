package com.kayadami.himsun.monkeyme;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.net.URI;

/**
 * Created by himsun on 2015. 10. 1..
 */
public class MongSangCard {

    private Drawable m_user_icon;
    private String m_user_name, m_card_date, m_card_ranking;
    private Drawable m_card_thumbnail;
    private String m_keyword, m_hanmadi;
    private Uri m_videouri;

    private int m_view_count, m_comment, m_likes_count;

    MongSangCard(Drawable user_icon, String user_name, String card_date, String card_ranking,
                 Drawable card_thumbnail, String keyword, String hanmadi,
                 int view_count, int comment, int likes_count, Uri videouri) {
        m_user_icon = user_icon;
        m_user_name = user_name;
        m_card_date = card_date;
        m_card_ranking = card_ranking;

        m_card_thumbnail = card_thumbnail;

        m_keyword = keyword;
        m_hanmadi = hanmadi;
        m_view_count = view_count;
        m_comment = comment;
        m_likes_count = likes_count;

        m_videouri = videouri;
    }

    public Drawable getM_user_icon() {
        return m_user_icon;
    }

    public String getM_user_name() {
        return m_user_name;
    }

    public String getM_date() {
        return m_card_date;
    }

    public String getM_ranking() {
        return m_card_ranking;
    }

    public Drawable getM_thumbnail() {
        return m_card_thumbnail;
    }

    public String getM_keyword() {
        return m_keyword;
    }

    public String getM_hanmadi() {
        return m_hanmadi;
    }

    public int getM_view_count() {
        return m_view_count;
    }

    public int getM_comment() {
        return m_comment;
    }

    public int getM_likes_count() {
        return m_likes_count;
    }

    public Uri getM_videouri() {
        return m_videouri;
    }


    public void setM_likes_count(int like)
    {
        m_likes_count=like;
    }

}
