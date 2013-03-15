package com.jt.getdunked2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View v = inflater.inflate(R.layout.lore_fragment, container, false);
    	
    	TextView tvLoreText = (TextView)v.findViewById(R.id.tvLore);
    	int position = ChampsActivity.myInt;
    	
    	
    	switch (position) {
    	
    		case 0:
    			tvLoreText.setText(R.string.AhriLore);
    			return v;
    		default:
    			return v;
    	}
    }
}


