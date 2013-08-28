package com.jt.getdunked2;

import javax.security.auth.PrivateCredentialPermission;

import de.keyboardsurfer.android.widget.crouton.Crouton;

import android.R.integer;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;

public class JungleTimers extends ActionBarActivity {
	
	ImageView ivFriendlyBlue;
	ImageView ivFriendlyRed;
	ImageView ivFriendlyWolf;
	ImageView ivFriendlyWraith;
	ImageView ivFriendlyGolem;
	ImageView ivFriendlyInhib1;
	ImageView ivFriendlyInhib2;
	ImageView ivFriendlyInhib3;
	ImageView ivEnemyBlue;
	ImageView ivEnemyRed;
	ImageView ivEnemyWraith;
	ImageView ivEnemyWolf;
	ImageView ivEnemyGolem;
	ImageView ivEnemyInhib1;
	ImageView ivEnemyInhib2;
	ImageView ivEnemyInhib3;
	ImageView ivDragon;
	ImageView ivBaron;
	ImageView ivFlash1;
	ImageView ivFlashTwo;

	TextView tvFriendlyBlue;
	TextView tvFriendlyRed;
	TextView tvFriendlyWolf;
	TextView tvFriendlyWraith;
	TextView tvFriendlyGolem;
	TextView tvFriendlyInhib1;
	TextView tvFriendlyInhib2;
	TextView tvFriendlyInhib3;
	TextView tvEnemyBlue;
	TextView tvEnemyRed;
	TextView tvEnemyWraith;
	TextView tvEnemyWolf;
	TextView tvEnemyGolem;
	TextView tvEnemyInhib1;
	TextView tvEnemyInhib2;
	TextView tvEnemyInhib3;
	TextView tvDragon;
	TextView tvBaron;
	TextView tvFlash1;
	TextView tvFlash2;
	
	PendingIntent pIntent;
	NotificationManager manager;
	
	SharedPreferences prefs;
	Uri ringtoneUri;
	
	boolean[] isTimerRunning = new boolean[20];
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jungle_timers);
		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setTitle("Jungle Timers - Summoner's Rift");
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		String ringtonePref = prefs.getString("notification_sound", "DEFAULT_RINGTONE_URI");
		ringtoneUri = Uri.parse(ringtonePref);
		
		
		final Timers timers = new Timers();
		
		manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Intent intent = new Intent(this, JungleTimers.class);
		pIntent = PendingIntent.getActivity(this, 0, intent, 0);
		
		
		ivFriendlyBlue = (ImageView) findViewById(R.id.ivFriendlyBlue);
		ivFriendlyRed = (ImageView) findViewById(R.id.ivFriendlyRed);
		ivFriendlyWolf = (ImageView) findViewById(R.id.ivFriendlyWolf);
		ivFriendlyWraith = (ImageView) findViewById(R.id.ivFriendlyWraith);
		ivFriendlyGolem = (ImageView) findViewById(R.id.ivFriendlyGolem);
		ivFriendlyInhib1 = (ImageView) findViewById(R.id.ivFriendlyInhib1);
		ivFriendlyInhib2 = (ImageView) findViewById(R.id.ivFriendlyInhib2);
		ivFriendlyInhib3 = (ImageView) findViewById(R.id.ivFriendlyInhib3);
		ivEnemyBlue = (ImageView) findViewById(R.id.ivEnemyBlue);
		ivEnemyRed = (ImageView) findViewById(R.id.ivEnemyRed);
		ivEnemyWolf = (ImageView) findViewById(R.id.ivEnemyWolf);
		ivEnemyWraith = (ImageView) findViewById(R.id.ivEnemyWraith);
		ivEnemyGolem = (ImageView) findViewById(R.id.ivEnemyGolem);
		ivEnemyInhib1 = (ImageView) findViewById(R.id.ivEnemyInhib1);
		ivEnemyInhib2 = (ImageView) findViewById(R.id.ivEnemyInhib2);
		ivEnemyInhib3 = (ImageView) findViewById(R.id.ivEnemyInhib3);
		ivDragon = (ImageView) findViewById(R.id.ivDragon);
		ivBaron = (ImageView) findViewById(R.id.ivBaron);
		ivFlash1 = (ImageView) findViewById(R.id.ivFlash1);
		ivFlashTwo = (ImageView) findViewById(R.id.ivFlash2);
		
		tvFriendlyBlue = (TextView) findViewById(R.id.tvFriendlyBlue);
		tvFriendlyRed = (TextView) findViewById(R.id.tvFriendlyRed);
		tvFriendlyWolf = (TextView) findViewById(R.id.tvFriendlyWolf);
		tvFriendlyWraith = (TextView) findViewById(R.id.tvFriendlyWraith);
		tvFriendlyGolem = (TextView) findViewById(R.id.tvFriendlyGolem);
		tvFriendlyInhib1 = (TextView) findViewById(R.id.tvFriendlyInhib1);
		tvFriendlyInhib2 = (TextView) findViewById(R.id.tvFriendlyInhib2);
		tvFriendlyInhib3 = (TextView) findViewById(R.id.tvFriendlyInhib3);
		tvEnemyBlue = (TextView) findViewById(R.id.tvEnemyBlue);
		tvEnemyRed = (TextView) findViewById(R.id.tvEnemyRed);
		tvEnemyWolf = (TextView) findViewById(R.id.tvEnemyWolf);
		tvEnemyWraith = (TextView) findViewById(R.id.tvEnemyWraith);
		tvEnemyGolem = (TextView) findViewById(R.id.tvEnemyGolem);
		tvEnemyInhib1 = (TextView) findViewById(R.id.tvEnemyInhib1);
		tvEnemyInhib2 = (TextView) findViewById(R.id.tvEnemyInhib2);
		tvEnemyInhib3 = (TextView) findViewById(R.id.tvEnemyInhib3);
		tvDragon = (TextView) findViewById(R.id.tvDragon);
		tvBaron = (TextView) findViewById(R.id.tvBaron);
		tvFlash1 = (TextView) findViewById(R.id.tvFlash1);
		tvFlash2 = (TextView) findViewById(R.id.tvFlash2);
		
		ivFriendlyBlue.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[0]) {
					timers.fBlueTimer.start();
					isTimerRunning[0] = true;
				} else {
					timers.fBlueTimer.cancel();
					isTimerRunning[0] = false;
					tvFriendlyBlue.setText("0:00");
				}
				
			}
		});
		
		ivFriendlyRed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[1]) {
					timers.fRedTimer.start();
					isTimerRunning[1] = true;
				} else {
					timers.fRedTimer.cancel();
					isTimerRunning[1] = false;
					tvFriendlyRed.setText("0:00");
				}
				
			}
		});
		ivEnemyBlue.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[2]) {
					timers.eBlueTimer.start();
					isTimerRunning[2] = true;
				} else {
					timers.eBlueTimer.cancel();
					isTimerRunning[2] = false;
					tvEnemyBlue.setText("0:00");
				}
				
			}
		});
		
		ivEnemyRed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[3]) {
					timers.eRedTimer.start();
					isTimerRunning[3] = true;
				} else {
					timers.eRedTimer.cancel();
					isTimerRunning[3] = false;
					tvEnemyRed.setText("0:00");
				}
				
			}
		});
		ivDragon.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[4]) {
					timers.dragonTimer.start();
					isTimerRunning[4] = true;
				} else {
					timers.dragonTimer.cancel();
					isTimerRunning[4] = false;
					tvDragon.setText("0:00");
				}
				
			}
		});
		
		ivBaron.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[5]) {
					timers.baronTimer.start();
					isTimerRunning[5] = true;
				} else {
					timers.baronTimer.cancel();
					isTimerRunning[5] = false;
					tvBaron.setText("0:00");
				}
				
			}
		});
		ivFriendlyWolf.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[6]) {
					timers.fWolfTimer.start();
					isTimerRunning[6] = true;
				} else {
					timers.fWolfTimer.cancel();
					isTimerRunning[6] = false;
					tvFriendlyWolf.setText("0:00");
				}
				
			}
		});
		ivEnemyWolf.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[7]) {
					timers.eWolfTimer.start();
					isTimerRunning[7] = true;
				} else {
					timers.eWolfTimer.cancel();
					isTimerRunning[7] = false;
					tvEnemyWolf.setText("0:00");
				}
				
			}
		});
		ivFriendlyWraith.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[8]) {
					timers.fWraithTimer.start();
					isTimerRunning[8] = true;
				} else {
					timers.fWraithTimer.cancel();
					isTimerRunning[8] = false;
					tvFriendlyWraith.setText("0:00");
				}
				
			}
		});
		ivEnemyWraith.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[9]) {
					timers.eWraithTimer.start();
					isTimerRunning[9] = true;
				} else {
					timers.eWraithTimer.cancel();
					isTimerRunning[9] = false;
					tvEnemyWraith.setText("0:00");
				}
				
			}
		});
		ivFriendlyGolem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[10]) {
					timers.fGolemTimer.start();
					isTimerRunning[10] = true;
				} else {
					timers.fGolemTimer.cancel();
					isTimerRunning[10] = false;
					tvFriendlyGolem.setText("0:00");
				}
				
			}
		});
		ivEnemyGolem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[11]) {
					timers.eGolemTimer.start();
					isTimerRunning[11] = true;
				} else {
					timers.eGolemTimer.cancel();
					isTimerRunning[11] = false;
					tvEnemyGolem.setText("0:00");
				}
				
			}
		});
		ivFriendlyInhib1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[12]) {
					timers.fInhibTimer1.start();
					isTimerRunning[12] = true;
				} else {
					timers.fInhibTimer1.cancel();
					isTimerRunning[12] = false;
					tvFriendlyInhib1.setText("0:00");
				}
				
			}
		});
		ivFriendlyInhib2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[13]) {
					timers.fInhibTimer2.start();
					isTimerRunning[13] = true;
				} else {
					timers.fInhibTimer2.cancel();
					isTimerRunning[13] = false;
					tvFriendlyInhib2.setText("0:00");
				}
				
			}
		});
		ivFriendlyInhib3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[14]) {
					timers.fInhibTimer3.start();
					isTimerRunning[14] = true;
				} else {
					timers.fInhibTimer3.cancel();
					isTimerRunning[14] = false;
					tvFriendlyInhib3.setText("0:00");
				}
				
			}
		});
		ivEnemyInhib1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[15]) {
					timers.eInhibTimer1.start();
					isTimerRunning[15] = true;
				} else {
					timers.eInhibTimer1.cancel();
					isTimerRunning[15] = false;
					tvEnemyInhib1.setText("0:00");
				}
				
			}
		});
		ivEnemyInhib2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[16]) {
					timers.eInhibTimer2.start();
					isTimerRunning[16] = true;
				} else {
					timers.eInhibTimer2.cancel();
					isTimerRunning[16] = false;
					tvEnemyInhib2.setText("0:00");
				}
				
			}
		});
		ivEnemyInhib3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[17]) {
					timers.eInhibTimer3.start();
					isTimerRunning[17] = true;
				} else {
					timers.eInhibTimer3.cancel();
					isTimerRunning[17] = false;
					tvEnemyInhib3.setText("0:00");
				}
				
			}
		});
		ivFlash1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[18]) {
					timers.flashTimer1.start();
					isTimerRunning[18] = true;
				} else {
					timers.flashTimer1.cancel();
					isTimerRunning[18] = false;
					tvFlash1.setText("0:00");
				}
				
			}
		});
		ivFlashTwo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isTimerRunning[19]) {
					timers.flashTimer2.start();
					isTimerRunning[19] = true;
				} else {
					timers.flashTimer2.cancel();
					isTimerRunning[19] = false;
					tvFlash2.setText("0:00");
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
			Intent parentActivity = new Intent(JungleTimers.this, JungleTimerSelector.class);
			startActivity(parentActivity);
			return true;
		case R.id.action_settings:
			startActivity(new Intent(JungleTimers.this, SettingsActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
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
	
	public void makeNotification(int id, String contentText, int smallIcon) { 
		NotificationCompat.Builder mNotification = new NotificationCompat.Builder(this)
		.setContentTitle("Jungle Timer")
		.setContentText(contentText)
		.setSmallIcon(smallIcon)
		.setContentIntent(pIntent)
		.setSound(ringtoneUri)
		.setAutoCancel(true);
		manager.notify(id, mNotification.build());
	}
	
	
	private class Timers {	
		boolean enableNotifications = prefs.getBoolean("enable_notifications", false);
		
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
				isTimerRunning[0] = false;
				if (enableNotifications) {
					makeNotification(0, "Friendly Blue Buff has respawned!", R.drawable.blue_buff);
				}
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
				isTimerRunning[1] = false;
				if (enableNotifications) {
					makeNotification(1, "Friendly Red Buff has respawned!", R.drawable.red_buff);
				}				
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
				isTimerRunning[2] = false;
				if (enableNotifications) {
					makeNotification(2, "Enemy Blue Buff has respawned!", R.drawable.blue_buff);
				}
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
				isTimerRunning[3] = false;
				if (enableNotifications) {
					makeNotification(3, "Enemy Red Buff has respawned!", R.drawable.red_buff);
				}		
			}
		};
		final CountDownTimer dragonTimer = new CountDownTimer(360000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvDragon.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvDragon.setText("0:00");
				Crouton.showText(JungleTimers.this, "Dragon has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[4] = false;
				if (enableNotifications) {
					makeNotification(4, "Dragon has respawned!", R.drawable.dragon_square);
				}	
			}
		};
		final CountDownTimer baronTimer = new CountDownTimer(420000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvBaron.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvBaron.setText("0:00");
				Crouton.showText(JungleTimers.this, "Baron Nashor has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[5] = false;
				if (enableNotifications) {
					makeNotification(5, "Baron Nashor has respawned!", R.drawable.baron_nashor);
				}
			}
		};
		final CountDownTimer fWolfTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyWolf.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyWolf.setText("0:00");
				Crouton.showText(JungleTimers.this, "Friendly Wolves have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[6] = false;
				if (enableNotifications) {
					makeNotification(6, "Friendly Wolves have respawned!", R.drawable.wolfsquare);
				}
			}
		};
		final CountDownTimer eWolfTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyWolf.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEnemyWolf.setText("0:00");
				Crouton.showText(JungleTimers.this, "Enemy Wolves have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[7] = false;
				if (enableNotifications) {
					makeNotification(7, "Enemy Wolves have respawned!", R.drawable.wolfsquare);
				}
			}
		};
		final CountDownTimer fWraithTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyWraith.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyWraith.setText("0:00");
				Crouton.showText(JungleTimers.this, "Friendly Wraiths have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[8] = false;
				if (enableNotifications) {
					makeNotification(8, "Friendly Wraiths have respawned!", R.drawable.wraithsquare);
				}
			}
		};
		final CountDownTimer eWraithTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyWraith.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEnemyWraith.setText("0:00");
				Crouton.showText(JungleTimers.this, "Enemy Wraiths have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[9] = false;
				if (enableNotifications) {
					makeNotification(9, "Enemy Wraiths have respawned!", R.drawable.wraithsquare);
				}
			}
		};
		final CountDownTimer fGolemTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyGolem.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyGolem.setText("0:00");
				Crouton.showText(JungleTimers.this, "Friendly Golems have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[10] = false;
				if (enableNotifications) {
					makeNotification(10, "Friendly Golems have respawned!", R.drawable.golemsquare);
				}
			}
		};
		final CountDownTimer eGolemTimer = new CountDownTimer(50000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyGolem.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEnemyGolem.setText("0:00");
				Crouton.showText(JungleTimers.this, "Enemy Golems have respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[11] = false;
				if (enableNotifications) {
					makeNotification(11, "Enemy Golems have respawned!", R.drawable.golemsquare);
				}
			}
		};
		final CountDownTimer fInhibTimer1 = new CountDownTimer(300000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyInhib1.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyInhib1.setText("0:00");
				Crouton.showText(JungleTimers.this, "Friendly Inhibitor has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[12] = false;
				if (enableNotifications) {
					makeNotification(12, "Friendly Inhibitor has respawned!", R.drawable.blue_inhib);
				}
			}
		};
		final CountDownTimer fInhibTimer2 = new CountDownTimer(300000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyInhib2.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyInhib2.setText("0:00");
				Crouton.showText(JungleTimers.this, "Friendly Inhibitor has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[13] = false;
				if (enableNotifications) {
					makeNotification(13, "Friendly Inhibitor has respawned!", R.drawable.blue_inhib);
				}
			}
		};
		final CountDownTimer fInhibTimer3 = new CountDownTimer(300000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFriendlyInhib3.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFriendlyInhib3.setText("0:00");
				Crouton.showText(JungleTimers.this, "Friendly Inhibitor has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[14] = false;
				if (enableNotifications) {
					makeNotification(14, "Friendly Inhibitor has respawned!", R.drawable.blue_inhib);
				}
			}
		};
		final CountDownTimer eInhibTimer1 = new CountDownTimer(300000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyInhib1.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEnemyInhib1.setText("0:00");
				Crouton.showText(JungleTimers.this, "Enemy Inhibitor has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[15] = false;
				if (enableNotifications) {
					makeNotification(15, "Enemy Inhibitor has respawned!", R.drawable.purple_inhib);
				}
			}
		};
		final CountDownTimer eInhibTimer2 = new CountDownTimer(300000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyInhib2.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEnemyInhib2.setText("0:00");
				Crouton.showText(JungleTimers.this, "Enemy Inhibitor has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[16] = false;
				if (enableNotifications) {
					makeNotification(16, "Enemy Inhibitor has respawned!", R.drawable.purple_inhib);
				}
			}
		};
		final CountDownTimer eInhibTimer3 = new CountDownTimer(300000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvEnemyInhib3.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvEnemyInhib3.setText("0:00");
				Crouton.showText(JungleTimers.this, "Enemy Inhibitor has respawned!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[17] = false;
				if (enableNotifications) {
					makeNotification(17, "Enemy Inhibitor has respawned!", R.drawable.purple_inhib);
				}
			}
		};
		final CountDownTimer flashTimer1 = new CountDownTimer(255000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFlash1.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFlash1.setText("0:00");
				Crouton.showText(JungleTimers.this, "Flash #1 is up!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[18] = false;
				if (enableNotifications) {
					makeNotification(18, "Flash #1 is up!", R.drawable.flash);
				}
			}
		};
		final CountDownTimer flashTimer2 = new CountDownTimer(255000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tvFlash2.setText(formatTime(millisUntilFinished));				
			}
			
			@Override
			public void onFinish() {
				tvFlash2.setText("0:00");
				Crouton.showText(JungleTimers.this, "Flash #2 is up!", 
						de.keyboardsurfer.android.widget.crouton.Style.INFO);
				isTimerRunning[19] = false;
				if (enableNotifications) {
					makeNotification(19, "Flash #2 is up!", R.drawable.flash);
				}
			}
		};
	}

}
