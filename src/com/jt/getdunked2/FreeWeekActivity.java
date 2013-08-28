package com.jt.getdunked2;

import com.jt.getdunked2.FreeWeekAsync.PostFetcher;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class FreeWeekActivity extends ActionBarActivity {
	
	public static ImageView ivFreeOne;
	public static ImageView ivFreeTwo;
	public static ImageView ivFreeThree;
	public static ImageView ivFreeFour;
	public static ImageView ivFreeFive;
	public static ImageView ivFreeSix;
	public static ImageView ivFreeSeven;
	public static ImageView ivFreeEight;
	public static ImageView ivFreeNine;
	public static ImageView ivFreeTen;
	public static TextView tvWeekNum;
	public static TextView tvFreeOne;
	public static TextView tvFreeTwo;
	public static TextView tvFreeThree;
	public static TextView tvFreeFour;
	public static TextView tvFreeFive;
	public static TextView tvFreeSix;
	public static TextView tvFreeSeven;
	public static TextView tvFreeEight;
	public static TextView tvFreeNine;
	public static TextView tvFreeTen;
	
	String url;
	int champNumber[] = FreeWeekAsync.champNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_free_week);
		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setTitle("Free Champion Rotation");
		
		url = "http://leagueoflegends.wikia.com/wiki/Free_champion_rotation";
		
		
		ivFreeOne = (ImageView) findViewById(R.id.ivFreeOne);
		ivFreeTwo = (ImageView) findViewById(R.id.ivFreeTwo);
		ivFreeThree = (ImageView) findViewById(R.id.ivFreeThree);
		ivFreeFour = (ImageView) findViewById(R.id.ivFreeFour);
		ivFreeFive = (ImageView) findViewById(R.id.ivFreeFive);
		ivFreeSix = (ImageView) findViewById(R.id.ivFreeSix);
		ivFreeSeven = (ImageView) findViewById(R.id.ivFreeSeven);
		ivFreeEight = (ImageView) findViewById(R.id.ivFreeEight);
		ivFreeNine = (ImageView) findViewById(R.id.ivFreeNine);
		ivFreeTen = (ImageView) findViewById(R.id.ivFreeTen);
		tvWeekNum = (TextView) findViewById(R.id.tvWeekNum);
		
		tvFreeOne = (TextView) findViewById(R.id.tvNameOne);
		tvFreeTwo = (TextView) findViewById(R.id.tvNameTwo);
		tvFreeThree = (TextView) findViewById(R.id.tvNameThree);
		tvFreeFour = (TextView) findViewById(R.id.tvNameFour);
		tvFreeFive = (TextView) findViewById(R.id.tvFreeNameFive);
		tvFreeSix = (TextView) findViewById(R.id.tvNameSix);
		tvFreeSeven = (TextView) findViewById(R.id.tvNameSeven);
		tvFreeEight = (TextView) findViewById(R.id.tvNameEight);
		tvFreeNine = (TextView) findViewById(R.id.tvNameNine);
		tvFreeTen = (TextView) findViewById(R.id.tvNameTen);
		
		FreeWeekAsync fwa = new FreeWeekAsync();
		PostFetcher pf = fwa.new PostFetcher(this);
		pf.execute(url);
		
		ivFreeOne.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[0]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
		ivFreeTwo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[1]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
		ivFreeThree.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[2]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
		ivFreeFour.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[3]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
		ivFreeFive.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[4]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
		ivFreeSix.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[5]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
		ivFreeSeven.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[6]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
		ivFreeEight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[7]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
		ivFreeNine.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[8]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
		ivFreeTen.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FreeWeekActivity.this, ChampionPage.class);
				intent.putExtra("position", champNumber[9]);
				intent.putExtra("from_free_week", true);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.free_week, menu);
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
			startActivity(new Intent(FreeWeekActivity.this, SettingsActivity.class));
			return true;
		case R.id.action_refresh:
			FreeWeekAsync fwa = new FreeWeekAsync();
			PostFetcher pf = fwa.new PostFetcher(this);
			pf.execute(url);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
