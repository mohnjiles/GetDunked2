package com.jt.getdunked2;

import java.util.Vector;

import com.jfeinstein.jazzyviewpager.JazzyViewPager;
import com.jfeinstein.jazzyviewpager.JazzyViewPager.TransitionEffect;
import com.jt.getdunked2.AsyncTasks.PostFetcher;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.michaldabski.msqlite.MSQLiteOpenHelper;
import com.michaldabski.msqlite.queries.CreateTable;

public class ProfileMainActivity extends ActionBarActivity {

	SearchView mSearchView;
    TextView mStatusView;
    
	
	JazzyViewPager mViewPager;
	LocationManager lm;
	FragmentAdapter adapter;

	TextView loadingText;
	public static String name;
	public static EditText editTxt;
	public static MenuItem searchItem;
	public static ActionBar actionBar;
	String url;
	String urlTwo;
	Button btnSearch;
	TextView tvOne;
	TextView tvDebug;
	ListView lv;
	JazzyViewPager myPager;
	
	TransitionEffect tf;
	SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summoner_lookup);
		actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.show();
		setTitle("Summoner Search");
		

		
		tvDebug = ProfileFragment.tvDebugOne;

		Vector<Fragment> fragments = new Vector<Fragment>();
		
		ProfileFragment fragmentOne = new ProfileFragment();
		Bundle bundle = new Bundle();
		fragmentOne.setArguments(bundle);
		fragments.add(fragmentOne);
		
		MatchHistoryFragment fragmentTwo = new MatchHistoryFragment();
		fragments.add(fragmentTwo);
		
		LifetimeStatsFragment fragmentZero = new LifetimeStatsFragment();
		fragments.add(fragmentZero);
		
		EPopup fragmenthree = new EPopup();
		fragmenthree.setArguments(bundle);
		fragments.add(fragmenthree);
		
		RPopup fragmentfour = new RPopup();
		fragmenthree.setArguments(bundle);
		fragments.add(fragmentfour);
		
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
		
		myPager = (JazzyViewPager) findViewById(R.id.profileMainPager);
		myPager.setOffscreenPageLimit(4);
		adapter = new FragmentAdapter(
		getSupportFragmentManager(), fragments);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);
		myPager.setTransitionEffect(tf);
		  
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_profile_main, menu);
		searchItem = menu.findItem(R.id.action_search);
		SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
		
		
		searchView.setOnQueryTextListener(new OnQueryTextListener() {
			
			@Override
			public boolean onQueryTextSubmit(String arg0) {
				name = arg0;
				url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
						+ name + "?key=eS4XmrLVhc7EhPson8dV";
				AsyncTasks tasks = new AsyncTasks();
				PostFetcher pf = tasks.new PostFetcher(ProfileMainActivity.this, ProfileMainActivity.this, getApplicationContext());
				pf.execute(url);
				setTitle(name);
				return false;
				
			}
			
			@Override
			public boolean onQueryTextChange(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		});
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
		    	 return "Profile";
		     case 1:
		    	 return "Match History";
		     case 2:
		    	 return "Ranked Statistics";
		     case 3:
		    	 return "Masteries";
		     case 4:
		    	 return "Runes";
		     }
			 return null;
		    }
	}
	

}