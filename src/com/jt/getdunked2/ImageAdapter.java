package com.jt.getdunked2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.ahrisquare, R.drawable.akalisquare, 
            R.drawable.alistarsquare, R.drawable.amumusquare,
            R.drawable.aniviasquare, R.drawable.anniesquare,
            R.drawable.ashesquare, R.drawable.blitzcranksquare,
            R.drawable.brandsquare, R.drawable.caitlynsquare,
            R.drawable.cassiopeiasquare, R.drawable.chogathsquare,
            R.drawable.corkisquare, R.drawable.dariussquare,
            R.drawable.dianasquare, R.drawable.drmundosquare,
            R.drawable.dravensquare, R.drawable.elisesquare,
            R.drawable.evelynnsquare, R.drawable.ezrealsquare,
            R.drawable.fiddlestickssquare, R.drawable.fiorasquare,
            R.drawable.fizzsquare, R.drawable.galiosquare,
            R.drawable.gangplanksquare
    };
}