package com.jt.getdunked2;

import java.util.ArrayList;
import java.util.Vector;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.jt.getdunked2.MatchHistoryFragment.PostFetcher;
import com.jt.getdunked2.ProfileFragment.PostFetcherTwo;

import android.location.LocationManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileMainActivity extends SherlockFragmentActivity {

	ViewPager mViewPager;
	LocationManager lm;
	FragmentAdapter adapter;
	public static ArrayList<GameStatistics> someArrayList = new ArrayList();
	LazyAdapter lazyAdapter;

	ListView lv;
	TextView loadingText;
	static EditText etSummName;
	String url;
	String urlTwo;
	Button btnSearch;
	TextView tvOne;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_main);
		
		etSummName = (EditText) findViewById(R.id.etSummName);
		lv = (ListView) findViewById(android.R.id.list);
		
		
		
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
		  
		  
		  btnSearch = (Button) findViewById(R.id.button2);
//		  btnSearch.setOnClickListener(this);
//			url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
//					+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
//
//			btnSearch.setOnClickListener(new View.OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					ProfileActivity pfa = new ProfileActivity();
//					PostFetcher pf = pfa.new PostFetcher(ProfileMainActivity.this);
//					pf.execute(url);
//					pfa.setListAdapter(lazyAdapter);
//				}
//			});
					
	}
		
//		@Override
//		public void onClick(View v) {
//			url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
//					+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
//			urlTwo = "http://api.elophant.com/v2/NA/in_progress_game_info/"
//					+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
//			 MatchHistoryFragment mf = new MatchHistoryFragment();
//		      ProfileFragment pf = new ProfileFragment();
//		      PostFetcher pFetcher = mf.new PostFetcher(ProfileMainActivity.this);
//		      PostFetcherTwo pFetcher2 = pf.new PostFetcherTwo(ProfileMainActivity.this);
//		      pFetcher.execute(url);
//		      pFetcher2.execute(urlTwo);			
//		}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_profile_main, menu);
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
