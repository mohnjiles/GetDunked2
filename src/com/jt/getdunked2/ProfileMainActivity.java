package com.jt.getdunked2;

import java.util.ArrayList;
import java.util.Vector;

import android.location.LocationManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileMainActivity extends ActionBarActivity{

	SearchView mSearchView;
    TextView mStatusView;
	
	ViewPager mViewPager;
	LocationManager lm;
	FragmentAdapter adapter;
	public static ArrayList<GameStatistics> someArrayList = new ArrayList();
	LazyAdapter lazyAdapter;

	ListView lv;
	TextView loadingText;
	public static EditText etSummName;
	String url;
	String urlTwo;
	Button btnSearch;
	TextView tvOne;
	TextView tvDebug;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summoner_lookup);
		
		etSummName = (EditText) findViewById(R.id.etSummName);
		lv = (ListView) findViewById(android.R.id.list);
		tvDebug = ProfileFragment.tvDebugOne;
		
		
		
		Vector<Fragment> fragments = new Vector<Fragment>();
		  ProfileFragment fragmentOne = new ProfileFragment();
		  Bundle bundle = new Bundle();
		  fragmentOne.setArguments(bundle);
		  fragments.add(fragmentOne);


		  MatchHistoryFragment fragmenttwo = new MatchHistoryFragment();
		  fragmenttwo.setArguments(bundle);
		  fragments.add(fragmenttwo);

		  EPopup fragmenthree = new EPopup();
		  fragmenthree.setArguments(bundle);
		  fragments.add(fragmenthree);
		  
		  RPopup fragmentfour = new RPopup();
		  fragmenthree.setArguments(bundle);
		  fragments.add(fragmentfour);

		  ViewPager myPager = (ViewPager) findViewById(R.id.profileMainPager);
		  adapter = new FragmentAdapter(
		    getSupportFragmentManager(), fragments);
		  myPager.setAdapter(adapter);
		  myPager.setCurrentItem(0);
		  
		 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_profile_main, menu);
		return true;
	}
	
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
		    	 return "Profile";
		     case 1:
		    	 return "Match History";
		     case 2:
		    	 return "Masteries";
		     case 3:
		    	 return "Runes";
		     }
			 return null;
		    }
	}
	

}