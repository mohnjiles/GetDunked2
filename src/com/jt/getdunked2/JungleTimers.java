package com.jt.getdunked2;

import de.keyboardsurfer.android.widget.crouton.Crouton;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;

public class JungleTimers extends ActionBarActivity {
	
	ImageView ivFriendlyBlue;
	ImageView ivFriendlyRed;
	ImageView ivEnemyBlue;
	ImageView ivEnemyRed;
	TextView tvFriendlyBlue;
	TextView tvFriendlyRed;
	TextView tvEnemyBlue;
	TextView tvEnemyRed;
	boolean isTimerRunningOne = false;
	boolean isTimerRunningTwo = false;
	boolean isTimerRunningThree = false;
	boolean isTimerRunningFour = false;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jungle_timers);
		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setTitle("Jungle Timers");
		final Timers timers = new Timers();
		
		
		ivFriendlyBlue = (ImageView) findViewById(R.id.ivFriendlyBlue);
		tvFriendlyBlue = (TextView) findViewById(R.id.tvFriendlyBlue);
		tvFriendlyRed = (TextView) findViewById(R.id.tvFriendlyRed);
		tvEnemyBlue = (TextView) findViewById(R.id.tvEnemyBlue);
		tvEnemyRed = (TextView) findViewById(R.id.tvEnemyRed);
		
		ivFriendlyBlue.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunningOne) {
					timers.fBlueTimer.start();
					isTimerRunningOne = true;
				} else {
					timers.fBlueTimer.cancel();
					isTimerRunningOne = false;
					tvFriendlyBlue.setText("0:00");
				}
				
			}
		});
		
		ivFriendlyRed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunningTwo) {
					timers.fRedTimer.start();
					isTimerRunningTwo = true;
				} else {
					timers.fRedTimer.cancel();
					isTimerRunningTwo = false;
					tvFriendlyRed.setText("0:00");
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jungle_timers, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent parentActivity = new Intent(JungleTimers.this, MainActivity.class);
			startActivity(parentActivity);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public String formatTime(long millis) {  
	    String output = "00:00";  
	    long seconds = millis / 1000;  
	    long minutes = seconds / 60;  

	    seconds = seconds % 60;  
	    minutes = minutes % 60;  

	    String sec = String.valueOf(seconds);  
	    String min = String.valueOf(minutes);  

	    if (seconds < 10)  
	        sec = "0" + seconds;    

	    output = min + ":" + sec;  
	    return output;
	}
	
	public class Timers {
		 final CountDownTimer fBlueTimer = new CountDownTimer(300000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyBlue.setText(formatTime(millisUntilFinished));
				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyBlue.setText("0:00");
				Crouton.showText(JungleTimers.this, "Friendly Blue Buff has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunningOne = false;
				
			}
		};
		final CountDownTimer fRedTimer = new CountDownTimer(300000, 1000) {
				
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyRed.setText(formatTime(millisUntilFinished));
				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyRed.setText("0:00");
				Crouton.showText(JungleTimers.this, "Friendly Red Buff has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunningTwo = false;
				
			}
		};
		final CountDownTimer eBlueTimer = new CountDownTimer(300000, 1000) {
				
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyBlue.setText(formatTime(millisUntilFinished));
				
			}
			
			@Override
			public void onFinish() {
				tvEnemyBlue.setText("0:00");
				Crouton.showText(JungleTimers.this, "Enemy Blue Buff has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunningThree = false;
				
			}
		};
		final CountDownTimer eRedTimer = new CountDownTimer(300000, 1000) {
				
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyRed.setText(formatTime(millisUntilFinished));
				
			}
			
			@Override
			public void onFinish() {
				tvEnemyRed.setText("0:00");
				Crouton.showText(JungleTimers.this, "Enemy Red Buff has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunningFour = false;
				
			}
		};
	}

}
