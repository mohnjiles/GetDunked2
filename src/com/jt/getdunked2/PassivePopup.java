package com.jt.getdunked2;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PassivePopup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_q_popup);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_q_popup, menu);
		return true;
	}

}
