package com.jt.getdunked2;

import java.util.Vector;

import com.jfeinstein.jazzyviewpager.JazzyViewPager;
import com.jfeinstein.jazzyviewpager.JazzyViewPager.TransitionEffect;


import android.R.integer;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ChampionPage extends ActionBarActivity {

	int screenSize;
	public static int position;
	Integer[] mThumbIds = ImageAdapter.mThumbIds;
	JazzyViewPager myPager;
	int currentPage = 0;
	public static boolean fromFreeWeek = false;
	TransitionEffect tf;
	SharedPreferences prefs;
	
	@Override
	 protected void onCreate(Bundle arg0) {
		
	  super.onCreate(arg0);
	  
	  String[] champNames = getResources().getStringArray(R.array.ChampNames);
	  
	  Intent intent = getIntent();
	  currentPage = intent.getIntExtra("page", 0);
	  position = intent.getIntExtra("position", 0);
	  fromFreeWeek = intent.getBooleanExtra("from_free_week", false);
	  
	  setTitle(champNames[position]);
	  setContentView(R.layout.activity_champion_page);
	  
	  ActionBar aBar = getSupportActionBar();
	  aBar.setDisplayHomeAsUpEnabled(true);
	  aBar.setIcon(mThumbIds[position]);
	  
	  prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	  
	  if (prefs.getString("transition_effect", "Stack").equals("Accordion")) {
		  tf = TransitionEffect.Accordion;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Cube Out")) {
		  tf = TransitionEffect.CubeOut;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Cube In")) {
		  tf = TransitionEffect.CubeIn;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Flip Horizontal")) {
		  tf = TransitionEffect.FlipHorizontal;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Flip Vertical")) {
		  tf = TransitionEffect.FlipVertical;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Rotate Down")) {
		  tf = TransitionEffect.RotateDown;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Rotate Up")) {
		  tf = TransitionEffect.RotateUp;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Stack")) {
		  tf = TransitionEffect.Stack;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Standard")) {
		  tf = TransitionEffect.Standard;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Tablet")) {
		  tf = TransitionEffect.Tablet;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Zoom In")) {
		  tf = TransitionEffect.ZoomIn;
	  } else if (prefs.getString("transition_effect", "Stack").equals("Zoom Out")) {
		  tf = TransitionEffect.ZoomOut;
	  } 
	    

	  screenSize = getResources().getConfiguration().screenLayout &
		        Configuration.SCREENLAYOUT_SIZE_MASK;
	  
	  Vector<Fragment> fragments = new Vector<Fragment>();
	  StatsActivity fragmentOne = new StatsActivity();
	  fragments.add(fragmentOne);

	  AbilityFragment fragmenttwo = new AbilityFragment();
	  fragments.add(fragmenttwo);

	  LoreFragment fragmenthree = new LoreFragment();
	  fragments.add(fragmenthree);
	  
	  if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
		  GuidesFragment fragmentfour = new GuidesFragment();
		  fragments.add(fragmentfour);
	  }

	  myPager = (JazzyViewPager) findViewById(R.id.pager);
	  FragmentAdapter adapter = new FragmentAdapter(
	    getSupportFragmentManager(), fragments);
	  myPager.setAdapter(adapter);
	  myPager.setCurrentItem(currentPage);
	  myPager.setTransitionEffect(tf);
	 

	  myPager.setOnPageChangeListener(new OnPageChangeListener() {

	   @Override
	   public void onPageSelected(int arg0) {
	    AbilityDetails.previousPage = arg0;
	   }

	   @Override
	   public void onPageScrolled(int arg0, float arg1, int arg2) {
	   }

	   @Override
	   public void onPageScrollStateChanged(int arg0) {
	   }
	  });
	  
	  
	 }
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_champion_page, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // This is called when the Home (Up) button is pressed
	            // in the Action Bar.
	        	if (fromFreeWeek) {
	        		Intent parentActivityIntent = new Intent(this, FreeWeekActivity.class);
		            parentActivityIntent.addFlags(
		                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
		                    Intent.FLAG_ACTIVITY_NEW_TASK);
		            startActivity(parentActivityIntent);
		            finish();
		            return true;
	        	} else {
	        		Intent parentActivityIntent = new Intent(this, ChampsActivity.class);
		            parentActivityIntent.addFlags(
		                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
		                    Intent.FLAG_ACTIVITY_NEW_TASK);
		            startActivity(parentActivityIntent);
		            finish();
		            return true;
	        	}
	            
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class FragmentAdapter extends FragmentPagerAdapter {

		 FragmentManager mManager;
		 Vector<Fragment> localFragmentArray;

		 public FragmentAdapter(FragmentManager fm, Vector<Fragment> loadFragment) {
		  super(fm);
		  localFragmentArray = loadFragment;
		  mManager = fm;
		 }

		 @Override
		 public Fragment getItem(int arg0) {
		  return localFragmentArray.get(arg0);
		 }

		 @Override
		 public int getCount() {
		  return localFragmentArray.size();
		 }

		 @Override
		 public void destroyItem(ViewGroup container, int position, Object object) {
		  this.notifyDataSetChanged();
		 }

		 @Override
		 public Object instantiateItem(ViewGroup container, int position) {
			 Object obj = super.instantiateItem(container, position);
			    myPager.setObjectForPosition(obj, position);
			    return obj;
		 }

		 @Override
		 public boolean isViewFromObject(View arg0, Object arg1) {
		  return super.isViewFromObject(arg0, arg1);
		 }

		 @Override
		 public Parcelable saveState() {
		  return super.saveState();
		 }
		 @Override
		    public CharSequence getPageTitle(int position) {
		     switch (position)
		     {
		     case 0:
		    	 return "STATISTICS";
		     case 1:
		    	 return "ABILITIES";
		     case 2:
		    	 return "LORE";
		     case 3:
		    	 if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
		   		 return "GUIDES";
		   	  }
		     }
			 return null;
		    }

		}
}
