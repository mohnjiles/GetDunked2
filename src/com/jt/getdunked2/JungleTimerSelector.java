package com.jt.getdunked2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class JungleTimerSelector extends ActionBarActivity {

	ImageView ivSummonersRift;
	ImageView ivTwistedTreeline;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jungle_timer_selector);
		setTitle("Jungle Timers");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		ivSummonersRift = (ImageView) findViewById(R.id.ivSummonersRift);
		ivTwistedTreeline = (ImageView) findViewById(R.id.ivTwistedTreeline);
		
		ivSummonersRift.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(JungleTimerSelector.this, JungleTimers.class));
			}
		});
		ivTwistedTreeline.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(JungleTimerSelector.this, JungleTimersTT.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jungle_timer_selector, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent parentActivity = new Intent(JungleTimerSelector.this, MainActivity.class);
			startActivity(parentActivity);
			return true;
		case R.id.action_settings:
			startActivity(new Intent(JungleTimerSelector.this, SettingsActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
