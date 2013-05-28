package com.jt.getdunked2;

import java.util.ArrayList;
import java.util.HashMap;

import com.jt.getdunked2.R.string;
 
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class LazyAdapter extends BaseAdapter {
 
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
 
    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.custom_list_view, null);
 
        TextView gameType = (TextView)vi.findViewById(R.id.gameType); // title
        TextView tvResult = (TextView)vi.findViewById(R.id.tvResult); // artist name
        TextView tvKills = (TextView)vi.findViewById(R.id.tvScoreKills); // duration
        TextView tvDeaths = (TextView)vi.findViewById(R.id.tvScoreDeaths);
        TextView tvAssists = (TextView)vi.findViewById(R.id.tvScoreAssists);
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
 
        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);
 
        // Setting all values in listview
        tvDeaths.setText(song.get(ProfileActivity.KEY_DEATHS));
        tvKills.setText(song.get(ProfileActivity.KEY_KILLS));
        //gameType.setText(song.get(ProfileActivity.KEY_GAME_TYPE));
        //tvResult.setText(song.get(ProfileActivity.KEY_RESULT));
        

        return vi;
    }
}