package com.jt.getdunked2;

import java.util.Vector;

import com.jfeinstein.jazzyviewpager.JazzyViewPager;
import com.jfeinstein.jazzyviewpager.JazzyViewPager.TransitionEffect;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class AbilityDetails extends ActionBarActivity{

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	JazzyViewPager myPager;
	int position = ChampsActivity.myInt;
	Integer[] mThumbIds = ImageAdapter.mThumbIds;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ability_details);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		String[] champNames = getResources().getStringArray(R.array.ChampNames);
		setTitle(champNames[position]);
		actionBar.setIcon(mThumbIds[position]);
		
		Vector<Fragment> fragments = new Vector<Fragment>();
		QPopup fragmentOne = new QPopup();
		Bundle bundle = new Bundle();
		fragmentOne.setArguments(bundle);
		fragments.add(fragmentOne);
		
		WPopup fragmenttwo = new WPopup();
		fragmenttwo.setArguments(bundle);
		fragments.add(fragmenttwo);
		
		EPopup fragmenthree = new EPopup();
		fragmenthree.setArguments(bundle);
		fragments.add(fragmenthree);
		
		RPopup fragmentfour = new RPopup();
		fragmenthree.setArguments(bundle);
		fragments.add(fragmentfour);
		
		myPager = (JazzyViewPager) findViewById(R.id.pager);
		FragmentAdapter adapter = new FragmentAdapter(
		getSupportFragmentManager(), fragments);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);
		myPager.setTransitionEffect(TransitionEffect.CubeOut);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.activity_ability_details, (Menu) menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // This is called when the Home (Up) button is pressed
	            // in the Action Bar.
	            Intent parentActivityIntent = new Intent(this, ChampionPage.class);
	            parentActivityIntent.addFlags(
	                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
	                    Intent.FLAG_ACTIVITY_NEW_TASK);
	            startActivity(parentActivityIntent);
	            finish();
	            return true;
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
		    	 return "Q";
		     case 1:
		    	 return "W";
		     case 2:
		    	 return "E";
		     case 3:
		    	 return "R";
		     }
			 return null;
		    }

		}
}
