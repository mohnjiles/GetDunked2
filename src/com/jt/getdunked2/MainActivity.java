package com.jt.getdunked2;


import com.jt.getdunked2.FreeWeekAsync.PostFetcher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.*;

public class MainActivity extends ActionBarActivity {
	
	private String[] mChampNames;
	private ListView mDrawerList;
	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		mChampNames = getResources().getStringArray(R.array.drawerStuff);
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.sliding_list, mChampNames));
		mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch (arg2) {
				case 0:
					startActivity(new Intent(MainActivity.this, ChampsActivity.class));
					break;
				case 1:
					startActivity(new Intent(MainActivity.this, ProfileMainActivity.class));
					break;
				case 2:
					startActivity(new Intent(MainActivity.this, JungleTimerSelector.class));
					break;
				case 3:
					startActivity(new Intent(MainActivity.this, FreeWeekActivity.class));
					break;
				}			
			}
		});	
	}

	@Override
	public void onDestroy() {
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.activity_main, menu);
		
		return true;
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.menu_settings:
			startActivity(new Intent(MainActivity.this, SettingsActivity.class));
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
	
	
	public void champButtonPressed(View view) {
		startActivity(new Intent(MainActivity.this, ChampsActivity.class));
	}
	
	public void profileButtonPressed(View view) {
		startActivity(new Intent(MainActivity.this, ProfileMainActivity.class));  
	}
	
	public void timersButtonPressed(View view) {
		startActivity(new Intent(MainActivity.this, JungleTimerSelector.class));  
	}
	public void freeWeekPressed(View view) {
		startActivity(new Intent(MainActivity.this, FreeWeekActivity.class));  
	}
	
	

}
