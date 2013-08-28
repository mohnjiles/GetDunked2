package com.jt.getdunked2;
import javax.security.auth.PrivateCredentialPermission;

import de.keyboardsurfer.android.widget.crouton.Crouton;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class JungleTimersTT extends ActionBarActivity {
	
	ImageView ivFriendlyWolves;
	ImageView ivFriendlyWraiths;
	ImageView ivFriendlyGolems;
	ImageView ivEnemyWolves;
	ImageView ivEnemyWraiths;
	ImageView ivEnemyGolems;
	ImageView ivWestAltar;
	ImageView ivEastAltar;
	ImageView ivVilemaw;
	
	TextView tvFriendlyWolves;
	TextView tvFriendlyWraiths;
	TextView tvFriendlyGolems;
	TextView tvEnemyWolves;
	TextView tvEnemyWraiths;
	TextView tvEnemyGolems;
	TextView tvWestAltar;
	TextView tvEastAltar;
	TextView tvVilemaw;
	
	boolean[] isTimerRunning = new boolean[9];
	
	PendingIntent pIntent;
	NotificationManager manager;
	
	SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jungle_timers_tt);
		setTitle("Jungle Timers - Twisted Treeline");
		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		final Timers timers = new Timers();
		
		manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Intent intent = new Intent(this, JungleTimersTT.class);
		pIntent = PendingIntent.getActivity(this, 0, intent, 0);
		
		ivFriendlyWolves = (ImageView) findViewById(R.id.ivFriendlyWolves);
		ivFriendlyWraiths = (ImageView) findViewById(R.id.ivFriendlyWraiths);
		ivFriendlyGolems = (ImageView) findViewById(R.id.ivFriendlyGolems);
		ivEnemyWolves = (ImageView) findViewById(R.id.ivEnemyWolves);
		ivEnemyWraiths = (ImageView) findViewById(R.id.ivEnemyWraiths);
		ivEnemyGolems = (ImageView) findViewById(R.id.ivEnemyGolems);
		ivWestAltar = (ImageView) findViewById(R.id.ivWestAltar);
		ivEastAltar = (ImageView) findViewById(R.id.ivEastAltar);
		ivVilemaw = (ImageView) findViewById(R.id.ivVilemaw);
		
		tvFriendlyWolves = (TextView) findViewById(R.id.tvFriendlyWolves);
		tvFriendlyWraiths = (TextView) findViewById(R.id.tvFriendlyWraiths);
		tvFriendlyGolems = (TextView) findViewById(R.id.tvFriendlyGolems);
		tvEnemyWolves = (TextView) findViewById(R.id.tvEnemyWolves);
		tvEnemyWraiths = (TextView) findViewById(R.id.tvEnemyWraiths);
		tvEnemyGolems = (TextView) findViewById(R.id.tvEnemyGolems);
		tvWestAltar = (TextView) findViewById(R.id.tvWestAltar);
		tvEastAltar = (TextView) findViewById(R.id.tvEastAltar);
		tvVilemaw = (TextView) findViewById(R.id.tvVilemaw);
		
		ivFriendlyWolves.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[0]) {
					timers.fWolvesTimer.start();
					isTimerRunning[0] = true;
				} else {
					timers.fWolvesTimer.cancel();
					isTimerRunning[0] = false;
					tvFriendlyWolves.setText("0:00");
				}
				
			}
		});
		ivFriendlyWraiths.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[1]) {
					timers.fWraithsTimer.start();
					isTimerRunning[1] = true;
				} else {
					timers.fWraithsTimer.cancel();
					isTimerRunning[1] = false;
					tvFriendlyWraiths.setText("0:00");
				}
				
			}
		});
		ivFriendlyGolems.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[2]) {
					timers.fGolemsTimer.start();
					isTimerRunning[2] = true;
				} else {
					timers.fGolemsTimer.cancel();
					isTimerRunning[2] = false;
					tvFriendlyGolems.setText("0:00");
				}
				
			}
		});
		ivEnemyWolves.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[3]) {
					timers.eWolvesTimer.start();
					isTimerRunning[3] = true;
				} else {
					timers.eWolvesTimer.cancel();
					isTimerRunning[3] = false;
					tvEnemyWolves.setText("0:00");
				}
				
			}
		});
		ivEnemyWraiths.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[4]) {
					timers.eWraithsTimer.start();
					isTimerRunning[4] = true;
				} else {
					timers.eWraithsTimer.cancel();
					isTimerRunning[4] = false;
					tvEnemyWraiths.setText("0:00");
				}
				
			}
		});
		ivEnemyGolems.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[5]) {
					timers.eGolemsTimer.start();
					isTimerRunning[5] = true;
				} else {
					timers.eGolemsTimer.cancel();
					isTimerRunning[5] = false;
					tvEnemyGolems.setText("0:00");
				}
				
			}
		});
		ivWestAltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[6]) {
					timers.wAltarTimer.start();
					isTimerRunning[6] = true;
				} else {
					timers.wAltarTimer.cancel();
					isTimerRunning[6] = false;
					tvWestAltar.setText("0:00");
				}
				
			}
		});
		ivEastAltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[7]) {
					timers.eAltarTimer.start();
					isTimerRunning[7] = true;
				} else {
					timers.eAltarTimer.cancel();
					isTimerRunning[7] = false;
					tvEastAltar.setText("0:00");
				}
				
			}
		});
		ivVilemaw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[8]) {
					timers.vilemawTimer.start();
					isTimerRunning[8] = true;
				} else {
					timers.vilemawTimer.cancel();
					isTimerRunning[8] = false;
					tvVilemaw.setText("0:00");
				}				
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jungle_timers_tt, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_settings:
			startActivity(new Intent(JungleTimersTT.this, SettingsActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class Timers {
		boolean enableNotifications = prefs.getBoolean("enable_notifications", false);
		
		final CountDownTimer eAltarTimer = new CountDownTimer(90000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEastAltar.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEastAltar.setText("0:00");
				Crouton.showText(JungleTimersTT.this, "East Altar has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[0] = false;
				if (enableNotifications) {
					makeNotification(0, "East Altar has respawned!", R.drawable.east_altar);
				}	
			}
		};
		final CountDownTimer wAltarTimer = new CountDownTimer(90000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvWestAltar.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvWestAltar.setText("0:00");
				Crouton.showText(JungleTimersTT.this, "West Altar has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[1] = false;
				if (enableNotifications) {
					makeNotification(1, "West Altar has respawned!", R.drawable.west_altar);
				}
			}
		};
		final CountDownTimer fWolvesTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyWolves.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyWolves.setText("0:00");
				Crouton.showText(JungleTimersTT.this, "Friendly Wolves have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[2] = false;
				if (enableNotifications) {
					makeNotification(2, "Friendly Wolves have respawned!", R.drawable.wolfsquare);
				}
			}
		};
		final CountDownTimer eWolvesTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyWolves.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEnemyWolves.setText("0:00");
				Crouton.showText(JungleTimersTT.this, "Enemy Wolves have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[3] = false;
				if (enableNotifications) {
					makeNotification(3, "Enemy Wolves have respawned!", R.drawable.wolfsquare);
				}
			}
		};
		final CountDownTimer fWraithsTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyWraiths.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyWraiths.setText("0:00");
				Crouton.showText(JungleTimersTT.this, "Friendly Wraiths have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[4] = false;
				if (enableNotifications) {
					makeNotification(4, "Friendly Wraiths have respawned!", R.drawable.wraithsquare);
				}
			}
		};
		final CountDownTimer eWraithsTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyWraiths.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEnemyWraiths.setText("0:00");
				Crouton.showText(JungleTimersTT.this, "Enemy Wraiths have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[5] = false;
				if (enableNotifications) {
					makeNotification(5, "Enemy Wraiths have respawned!", R.drawable.wraithsquare);
				}
			}
		};
		final CountDownTimer fGolemsTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyGolems.setText(formatTime(millisUntilFinished));	
			}
			
			@Override
			public void onFinish() {
				tvFriendlyGolems.setText("0:00");
				Crouton.showText(JungleTimersTT.this, "Friendly Golems have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[6] = false;
				if (enableNotifications) {
					makeNotification(6, "Friendly Golems have respawned!", R.drawable.golemsquare);
				}
			}
		};
		final CountDownTimer eGolemsTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyGolems.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEnemyGolems.setText("0:00");
				Crouton.showText(JungleTimersTT.this, "Enemy Golems have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[7] = false;
				if (enableNotifications) {
					makeNotification(7, "Enemy Golems have respawned!", R.drawable.golemsquare);
				}
			}
		};
		final CountDownTimer vilemawTimer = new CountDownTimer(300000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvVilemaw.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvVilemaw.setText("0:00");
				Crouton.showText(JungleTimersTT.this, "Vilemaw has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[8] = false;
				if (enableNotifications) {
					makeNotification(8, "Vilemaw has respawned!", R.drawable.vilemawsquare);
				}
			}
		};
	}

	private String formatTime(long millis) {  
	    String output = "0:00";  
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
	
	private void makeNotification(int id, String contentText, int smallIcon) { 
		NotificationCompat.Builder mNotification = new NotificationCompat.Builder(this)
		.setContentTitle("Jungle Timer")
		.setContentText(contentText)
		.setSmallIcon(smallIcon)
		.setContentIntent(pIntent)
		.setAutoCancel(true);
		manager.notify(id, mNotification.build());
	}
}
