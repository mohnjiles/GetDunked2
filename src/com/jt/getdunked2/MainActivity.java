package com.jt.getdunked2;


import com.jt.getdunked2.FreeWeekAsync.PostFetcher;

import android.R.anim;
import android.R.integer;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
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

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String url = "http://leagueoflegends.wikia.com/wiki/Free_champion_rotation";
		
		
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
		PostFetcher pFetcher = fwa.new PostFetcher();
		pFetcher.execute(url);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
		
	}
	
	public void champButtonPressed(View view) {
		startActivity(new Intent(MainActivity.this, ChampsActivity.class));
	}
	
	public void profileButtonPressed(View view) {
		startActivity(new Intent(MainActivity.this, ProfileMainActivity.class));  
	}
	

}
