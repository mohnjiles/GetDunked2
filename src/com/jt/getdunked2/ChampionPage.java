package com.jt.getdunked2;

import java.util.Vector;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ChampionPage extends FragmentActivity {


	@Override
	 protected void onCreate(Bundle arg0) {
		
	  super.onCreate(arg0);
	  setContentView(R.layout.activity_champion_page);
	  getActionBar().setDisplayHomeAsUpEnabled(true);

	  Vector<Fragment> fragments = new Vector<Fragment>();
	  StatsActivity fragmentOne = new StatsActivity();
	  Bundle bundle = new Bundle();
	  bundle.putString(
	    "url",
	    "https://lh6.googleusercontent.com/-jZgveEqb6pg/"
	      + "T3R4kXScycI/AAAAAAAAAE0/xQ7CvpfXDzc/s1024/sample_image_01.jpg");
	  fragmentOne.setArguments(bundle);
	  fragments.add(fragmentOne);

	  AbilityFragment fragmenttwo = new AbilityFragment();
	  bundle.putString(
	    "url",
	    "https://lh3.googleusercontent.com/"
	      + "-WujkdYfcyZ8/T3R4qrIMGUI/AAAAAAAAAGk/277LIdgvnjg/s1024/sample_image_15.jpg");
	  fragmenttwo.setArguments(bundle);
	  fragments.add(fragmenttwo);

	  LoreFragment fragmenthree = new LoreFragment();
	  fragmenthree.setArguments(bundle);
	  fragments.add(fragmenthree);

	  ViewPager myPager = (ViewPager) findViewById(R.id.pager);
	  FragmentAdapter adapter = new FragmentAdapter(
	    getSupportFragmentManager(), fragments);
	  myPager.setAdapter(adapter);
	  myPager.setCurrentItem(0);

	  myPager.setOnPageChangeListener(new OnPageChangeListener() {

	   @Override
	   public void onPageSelected(int arg0) {
	    Toast.makeText(ChampionPage.this,
	      "Page Selected " + arg0, Toast.LENGTH_LONG).show();
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
	            Intent parentActivityIntent = new Intent(this, ChampsActivity.class);
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
		  return super.instantiateItem(container, position);
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
		    	 return "OTHER";
		     }
			 return null;
		    }

		}
	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			
			return null;
			
		}
	}

}
