package com.jt.getdunked2;


import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Menu;

public class SettingsActivity extends PreferenceActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);	
		setTitle("Get Dunked Settings");
		addPreferencesFromResource(R.xml.settings);
		
	}
	

}
