package com.jt.getdunked2;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class GuidesFragment extends Fragment {
	
	int position = ChampionPage.position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View v = inflater.inflate(R.layout.guides_fragment, container, false);
    	
    	WebView webView = (WebView)v.findViewById(R.id.webView1);
    	webView.setWebViewClient(new MyWebViewClient());
    	String[] champNames = getResources().getStringArray(R.array.ChampNames);
    	webView.loadUrl("http://www.solomid.net/guides.php?champ=" + champNames[position] + "&sort=2&display=0");
    	
    	
		return v;
    }
    
}


