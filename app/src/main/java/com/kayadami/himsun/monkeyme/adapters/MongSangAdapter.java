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
import com.kayadami.himsun.monkeyme.views.MongSangCardView;

import java.util.ArrayList;

/**
 * Created by himsun on 2015. 10. 5..
 */
public class MongSangAdapter extends BaseAdapter
{
    private Context mContext;

    private ArrayList<MongSangCard> mMongSangList;

    public MongSangAdapter(Context context)
    {
        super();
        mContext = context;
        mMongSangList = new ArrayList<>();
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
        MongSangCardView v;

        if (convertView != null && convertView instanceof MongSangCardView) {
            v = (MongSangCardView) convertView;
        } else {
            v = new MongSangCardView(mContext);
        }

        MongSangCard card = getItem(position);
        v.setCard(card);

        return v;
    }

    public void add(MongSangCard mongsangcard)
    {
        mMongSangList.add(mongsangcard);
    }
}
