package com.jt.getdunked2;

<<<<<<< HEAD

=======
>>>>>>> d56ad557451e3c607625b5f9fbc5412b165fe61b
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PassivePopup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
<<<<<<< HEAD
		setContentView(R.layout.activity_q_popup);
=======
		setContentView(R.layout.activity_passive_popup);
>>>>>>> d56ad557451e3c607625b5f9fbc5412b165fe61b
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
<<<<<<< HEAD
		getMenuInflater().inflate(R.menu.activity_q_popup, menu);
=======
		getMenuInflater().inflate(R.menu.activity_passive_popup, menu);
>>>>>>> d56ad557451e3c607625b5f9fbc5412b165fe61b
		return true;
	}

}
