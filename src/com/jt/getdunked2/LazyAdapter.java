package com.jt.getdunked2;
 
import java.util.List;

import android.content.Context;
import android.text.StaticLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
 
 
public class LazyAdapter extends ArrayAdapter {
 
    int resource;
    String response;
    Context context;
    private LayoutInflater mInflater;
 
    public LazyAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.resource = resource;
        mInflater = LayoutInflater.from(context);
    }
 
    static class ViewHolder {
        TextView gameType;
        TextView winOrLose;
        TextView kills;
        TextView deaths;
        TextView assists;
    }
 
    public View getView(int position, View convertView, ViewGroup parent)
    {
    	GameStatistics gs = (GameStatistics) getItem(position);
        ViewHolder holder;
        //Get the current location object
        
 
        //Inflate the view
        if(convertView==null)
        {
            convertView = mInflater.inflate(R.layout.custom_list_view, parent, false);
            holder = new ViewHolder();
            holder.gameType = (TextView) convertView
                    .findViewById(R.id.gameType);
            holder.winOrLose = (TextView) convertView
                    .findViewById(R.id.tvResult);
            holder.kills = (TextView) convertView
            		.findViewById(R.id.tvScoreKills);
            holder.deaths = (TextView) convertView
            		.findViewById(R.id.tvScoreDeaths);
            holder.assists = (TextView) convertView
            		.findViewById(R.id.tvScoreAssists);
            
 
            convertView.setTag(holder);
 
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
 
        // define some shit
        Number timeDead = null;
        Number win = null;
        Number killsValue = null;
        Number deathsValue = null;
        Number assistsValue = null;
        
        // Get Statistics
        for(Statistics statistic : gs.getStatistics()){
        	if(statistic.getStatType().equals("WIN")) {
				win = statistic.getValue();
			}
        	else if(statistic.getStatType().equals("CHAMPIONS_KILLED")) {
        		killsValue = statistic.getValue();
        	}
        	else if(statistic.getStatType().equals("NUM_DEATHS")) {
        		deathsValue = statistic.getValue();
        	}
        	else if(statistic.getStatType().equals("ASSISTS")) {
        		assistsValue = statistic.getValue();
        	}
        	
        	
		}
        //Set Game Mode
        
        if(gs.getGameMode() != null) {
        	holder.gameType.setText(gs.getGameMode());
        }
        
        
        // Set Victory/Defeat
        if(win != null)
        {
        	holder.winOrLose.setText("Victory");
        }
        else {
        	holder.winOrLose.setText("Defeat");
        }
        
        // Set Kills
        if(killsValue != null) {
        	holder.kills.setText(killsValue.toString());
        }
        
        // Set Deaths
        if(deathsValue != null) {
        	holder.deaths.setText(deathsValue.toString());
        }
        
        // Set Assists
        if(assistsValue != null) {
        	holder.assists.setText(assistsValue.toString());
        }
        
 
        return convertView;
    }
 
}