package com.jt.getdunked2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class StatsActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	
    	View V = inflater.inflate(R.layout.activity_stats, container, false);
        return V;
        
        
    }
}


