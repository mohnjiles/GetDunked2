package com.jt.getdunked2;

import java.util.ArrayList;
import com.jt.getdunked2.AnotherAsyncTask.PostFetcherTwo;

import android.R.integer;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MatchHistoryFragment extends Fragment {
// paige jones object oriented programming *** remember plz ***
	LocationManager lm;

	ArrayList<GameStatistics> someArrayList = null;
	LazyAdapter lazyAdapter;
	
	public static TextView tvDamageDone;
	public static TextView tvChampKills;
	public static TextView tvDeaths;
	public static TextView tvAssists;
	public static TextView tvKillingSpree;
	public static TextView tvDamageToChamps;
	public static TextView tvPhysicalToChamps;
	public static TextView tvMagicToChamps;
	public static TextView tvDamageDealt;
	public static TextView tvPhysicalDamage;
	public static TextView tvPhysicalTaken;
	public static TextView tvMagicTaken;
	public static TextView tvMagicDamage;
	public static TextView tvLargestCrit;
	public static TextView tvTurrets;
	public static TextView tvInhibitors;
	public static TextView tvDamageTaken;
	public static TextView tvHealingDone;
	public static TextView tvGold;
	public static TextView tvMultiKill;
	public static TextView tvTimeDead;
	public static TextView tvWardsPlaced;
	public static TextView tvWardsKilled;
	public static TextView tvMinionsKilled;
	public static TextView tvNeutralMinionsKilled;
	public static TextView tvChampName;
	
	public static ImageView ivChampIcon;

	public static Typeface tf;
	public static ListView lv;
	public static int pos;
	TextView loadingText;
	String name = ProfileMainActivity.name;
	String url;
	String urlTwo;
	String urlThree;
	String urlFour;
	String urlFive;
	String urlSix;
	Button btnSearch;
	public static PopupWindow pwindo;
	public static TextView tvOne;
	TextView tvDebug = ProfileFragment.tvDebugOne;
	MatchHistoryFragment our_context;
	
	
	
	public static int matchNumber;
	public static Number champId[];
	public static Number teamId[];



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
		// Inflate the layout for this fragment    
	    View V = inflater.inflate(R.layout.match_history_fragment, container, false);
	    
	    
		tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
		url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ name + "?key=eS4XmrLVhc7EhPson8dV";
		
		
		
		return V;	
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		lv = (ListView) getView().findViewById(R.id.lvMatchHistory);
		btnSearch = (Button) getActivity().findViewById(R.id.button2);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				initiatePopupWindow(arg2);
				
			}
		});
		
		
		
	}
	
	private void initiatePopupWindow(int position) {
		try {
			// get screen size of device
			int screenSize = getResources().getConfiguration().screenLayout &
			        Configuration.SCREENLAYOUT_SIZE_MASK;
			
			// convert px to dips for multiple screens
			int dipsWidthPortrait_Normal = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 270, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightPortrait_Normal = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, getActivity().getResources().getDisplayMetrics());
			int dipsWidthLandscape_Normal = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightLandscape_Normal = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 270, getActivity().getResources().getDisplayMetrics());
			int dipsWidthPortrait_Large = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightPortrait_Large = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 550, getActivity().getResources().getDisplayMetrics());
			int dipsWidthLandscape_Large = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 550, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightLandscape_Large = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, getActivity().getResources().getDisplayMetrics());
			int dipsWidthPortrait_Small = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightPortrait_Small = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 350, getActivity().getResources().getDisplayMetrics());
			int dipsWidthLandscape_Small = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 350, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightLandscape_Small = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getActivity().getResources().getDisplayMetrics());
			
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.popup_window, null);
			
			pos = 9 - position;
			
			// make different popupwindows for different screen sizes
			switch (screenSize) {
				case Configuration.SCREENLAYOUT_SIZE_XLARGE:
					doSomeWindow(
			        		layout, 
			        		dipsWidthLandscape_Large, 
			        		dipsHeightLandscape_Large,
			        		dipsWidthPortrait_Large,  
			        		dipsHeightPortrait_Large); 
					break;
				case Configuration.SCREENLAYOUT_SIZE_LARGE:
					doSomeWindow(
			        		layout, // View of the popupwindow
			        		dipsWidthLandscape_Large, // Width for landscape orientation
			        		dipsHeightLandscape_Large, // Height for landscape
			        		dipsWidthPortrait_Large,  // Width for portrait orientation
			        		dipsHeightPortrait_Large); // Height for portrait
					break;
			    case Configuration.SCREENLAYOUT_SIZE_NORMAL:
			        doSomeWindow(
			        		layout, 
			        		dipsWidthLandscape_Normal, 
			        		dipsHeightLandscape_Normal,
			        		dipsWidthPortrait_Normal, 
			        		dipsHeightPortrait_Normal);
			        break;
			    default:
			    	doSomeWindow(
			        		layout, 
			        		dipsWidthLandscape_Small, 
			        		dipsHeightLandscape_Small,
			        		dipsWidthPortrait_Small, 
			        		dipsHeightPortrait_Small);
			        break;
			}
			
			
			
			
			// If we ran in to a problem
			} catch (Exception e) {
				Log.w("PopupWindow", "" + e.getMessage() + e.getStackTrace()[2].getLineNumber());
			}
		}
	

	private OnClickListener cancel_button_click_listener = new OnClickListener() {
		public void onClick(View v) {
		pwindo.dismiss();
		
		}

		};
		
		// Runs the popupwindow, getting view from inflater & dimensions based on screen size
		private void doSomeWindow(View layout, int widthLandscape, int heightLandscape, 
				int widthPortrait, int heightPortrait) {
			
			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
				pwindo = new PopupWindow(layout, widthLandscape, heightLandscape, true);
				pwindo.setBackgroundDrawable(new BitmapDrawable());
				pwindo.setOutsideTouchable(true);
				pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
				pwindo.setFocusable(true);
				
			} else {
				pwindo = new PopupWindow(layout, widthPortrait, heightPortrait, true);
				pwindo.setBackgroundDrawable(new BitmapDrawable());
				pwindo.setOutsideTouchable(true);
				pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
				pwindo.setFocusable(true);
				
			}
			
			// Set TextView variables
			tvChampKills = (TextView) pwindo.getContentView().findViewById(R.id.tvChampKills);
			tvDeaths = (TextView) pwindo.getContentView().findViewById(R.id.tvDeaths);
			tvAssists = (TextView) pwindo.getContentView().findViewById(R.id.tvAssists);
			tvKillingSpree = (TextView) pwindo.getContentView().findViewById(R.id.tvKillingSpree);
			tvDamageToChamps = (TextView) pwindo.getContentView().findViewById(R.id.tvDamageToChamps);
			tvPhysicalToChamps = (TextView) pwindo.getContentView().findViewById(R.id.tvPhysicalToChamps);
			tvMagicToChamps = (TextView) pwindo.getContentView().findViewById(R.id.tvMagicToChamps);
			tvDamageDealt = (TextView) pwindo.getContentView().findViewById(R.id.tvDamageDealt);
			tvPhysicalDamage = (TextView) pwindo.getContentView().findViewById(R.id.tvPhysicalDealt);
			tvMagicDamage = (TextView) pwindo.getContentView().findViewById(R.id.tvMagicDealt);
			tvLargestCrit = (TextView) pwindo.getContentView().findViewById(R.id.tvLargestCrit);
			tvDamageTaken = (TextView) pwindo.getContentView().findViewById(R.id.tvDamageTaken);
			tvMagicTaken = (TextView) pwindo.getContentView().findViewById(R.id.tvMagicDamage);
			tvPhysicalTaken = (TextView) pwindo.getContentView().findViewById(R.id.tvPhysicalTaken);
			tvTurrets = (TextView) pwindo.getContentView().findViewById(R.id.tvTurrets);
			tvInhibitors = (TextView) pwindo.getContentView().findViewById(R.id.tvInhibitors);
			tvHealingDone = (TextView) pwindo.getContentView().findViewById(R.id.tvHealingValue);
			tvGold = (TextView) pwindo.getContentView().findViewById(R.id.tvGoldEarned);
			tvMultiKill = (TextView) pwindo.getContentView().findViewById(R.id.tvMultiKill);
			tvTimeDead = (TextView) pwindo.getContentView().findViewById(R.id.tvTimeDead);
			tvWardsPlaced = (TextView) pwindo.getContentView().findViewById(R.id.tvWardsPlaced);
			tvWardsKilled = (TextView) pwindo.getContentView().findViewById(R.id.tvWardsKilled);
			tvMinionsKilled = (TextView) pwindo.getContentView().findViewById(R.id.tvMinionsSlain);
			tvNeutralMinionsKilled = (TextView) pwindo.getContentView().findViewById(R.id.tvNeutralMonsters);
			tvChampName = (TextView) pwindo.getContentView().findViewById(R.id.tvChampName);
			
			ivChampIcon = (ImageView) pwindo.getContentView().findViewById(R.id.ivChampIcon);
			
			// Start up dat asynctask
			AnotherAsyncTask anotherAsyncTask = new AnotherAsyncTask();
			PostFetcherTwo pft = anotherAsyncTask.new PostFetcherTwo(getActivity(), getActivity());
			pft.execute(url);
		
			// Set close button
			//Button btnClosePopup = (Button) pwindo.getContentView().findViewById(R.id.btn_close_popup);
			Button btnCloseTwo = (Button) pwindo.getContentView().findViewById(R.id.Button01);
			//btnClosePopup.setOnClickListener(cancel_button_click_listener);
			btnCloseTwo.setOnClickListener(cancel_button_click_listener);
			
		}

}
	

