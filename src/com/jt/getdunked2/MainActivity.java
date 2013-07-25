package com.jt.getdunked2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
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
