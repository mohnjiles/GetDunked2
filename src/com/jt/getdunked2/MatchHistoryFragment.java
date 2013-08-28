package com.jt.getdunked2;

import java.util.ArrayList;
import com.jt.getdunked2.AnotherAsyncTask.PostFetcherTwo;

import android.R.anim;
import android.R.integer;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
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

	// values TextViews
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
	public static TextView tvKDA;
	public static TextView tvTeamOnePlayerOne;
	public static TextView tvTeamOnePlayerTwo;
	public static TextView tvTeamOnePlayerThree;
	public static TextView tvTeamOnePlayerFour;
	public static TextView tvTeamOnePlayerFive;
	public static TextView tvTeamTwoPlayerOne;
	public static TextView tvTeamTwoPlayerTwo;
	public static TextView tvTeamTwoPlayerThree;
	public static TextView tvTeamTwoPlayerFour;
	public static TextView tvTeamTwoPlayerFive;
	public static TextView tvVsTextMiddleThing;
	
	// titles TextViews
	public static TextView tvKillsTitle;
	public static TextView tvDeathsTitle;
	public static TextView tvAssistTitle;
	public static TextView tvKSTitle;
	public static TextView tvMultiTitle;
	public static TextView tvDamageChampTitle;
	public static TextView tvPhysChampTitle;
	public static TextView tvMagicChampTitle;
	public static TextView tvDmgDealtTitle;
	public static TextView tvPhysDealtTitle;
	public static TextView tvMagicDealtTitle;
	public static TextView tvCritTitle;
	public static TextView tvHealTitle;
	public static TextView tvDmgTakenTitle;
	public static TextView tvPhysTakenTitle;
	public static TextView tvMagicTakenTitle;
	public static TextView tvGoldTitle;
	public static TextView tvTurretsTitle;
	public static TextView tvInhibsTitle;
	public static TextView tvMinionsTitle;
	public static TextView tvNeutralTitle;
	public static TextView tvTimeDeadTitle;
	public static TextView tvWardPlacedTitle;
	public static TextView tvWardKilledTitle;
	
	// all da ImageViews
	public static ImageView ivTeamOneChampOne;
	public static ImageView ivTeamOneChampTwo;
	public static ImageView ivTeamOneChampThree;
	public static ImageView ivTeamOneChampFour;
	public static ImageView ivTeamOneChampFive;
	public static ImageView ivTeamTwoChampOne;
	public static ImageView ivTeamTwoChampTwo;
	public static ImageView ivTeamTwoChampThree;
	public static ImageView ivTeamTwoChampFour;
	public static ImageView ivTeamTwoChampFive;
	public static ImageView ivChampIcon;
	
	// aaaaaaand a button
	public static Button btnClose;

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
	
	LazyAdapter lazyAdapter;
	
	
	
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
			int dipsWidthPortrait_Normal = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightPortrait_Normal = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 450, getActivity().getResources().getDisplayMetrics());
			int dipsWidthLandscape_Normal = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 450, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightLandscape_Normal = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getActivity().getResources().getDisplayMetrics());
			int dipsWidthPortrait_Large = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 425, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightPortrait_Large = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 550, getActivity().getResources().getDisplayMetrics());
			int dipsWidthLandscape_Large = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 550, getActivity().getResources().getDisplayMetrics()); 
			int dipsHeightLandscape_Large = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 425, getActivity().getResources().getDisplayMetrics());
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
				Log.w("PopupWindow", "" + e.getMessage() + e.getStackTrace()[0].getLineNumber());
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
			
			// Set value TextView variables
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
			tvKDA = (TextView) pwindo.getContentView().findViewById(R.id.tvKDA);
			
			// set team TextView variables
			tvTeamOnePlayerOne = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamOnePlayerOne); 
			tvTeamOnePlayerTwo = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamOnePlayerTwo); 
			tvTeamOnePlayerThree = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamOnePlayerThree); 
			tvTeamOnePlayerFour = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamOnePlayerFour); 
			tvTeamOnePlayerFive = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamOnePlayerFive); 
			tvTeamTwoPlayerOne = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamTwoPlayerOne); 
			tvTeamTwoPlayerTwo = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamTwoPlayerTwo); 
			tvTeamTwoPlayerThree = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamTwoPlayerThree); 
			tvTeamTwoPlayerFour = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamTwoPlayerFour); 
			tvTeamTwoPlayerFive = (TextView) pwindo.getContentView().findViewById(R.id.tvTeamTwoPlayerFive); 
			
			// set team ImageView variables
			ivTeamOneChampOne = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamOneChampOne); 
			ivTeamOneChampTwo = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamOneChampTwo); 
			ivTeamOneChampThree = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamOneChampThree); 
			ivTeamOneChampFour = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamOneChampFour); 
			ivTeamOneChampFive = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamOneChampFive); 
			ivTeamTwoChampOne = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamTwoChampOne); 
			ivTeamTwoChampTwo = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamTwoChampTwo); 
			ivTeamTwoChampThree = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamTwoChampThree); 
			ivTeamTwoChampFour = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamTwoChampFour); 
			ivTeamTwoChampFive = (ImageView) pwindo.getContentView().findViewById(R.id.ivTeamTwoChampFive); 
			
			// champ icon variable
			ivChampIcon = (ImageView) pwindo.getContentView().findViewById(R.id.ivChampIcon);
			
			// Title TextView variables
			tvKillsTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvFriendlyRed);
			tvDeathsTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvDamageRec);
			tvAssistTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvHealingDone);
			tvKSTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvGoldTitle);
			tvMultiTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvMultiKillTitle);
			tvDamageChampTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvEnemyInhib1);
			tvPhysChampTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvEnemyInhib2);
			tvMagicChampTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvEnemyInhib3);
			tvDmgDealtTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvTimeDeadTitle);
			tvPhysDealtTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvWardsTitle);
			tvMagicDealtTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvMinionsTitle);
			tvCritTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvFriendlyWolf);
			tvHealTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvFriendlyWraith);
			tvDmgTakenTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvFriendlyGolem);
			tvPhysTakenTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvFriendlyInhib1);
			tvMagicTakenTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvFriendlyInhib2);
			tvGoldTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvFriendlyInhib3);
			tvTurretsTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvBaron);
			tvInhibsTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvDragon);
			tvMinionsTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvEnemyBlue);
			tvNeutralTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvEnemyRed);
			tvTimeDeadTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvEnemyWolf);
			tvWardPlacedTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvEnemyWraith);
			tvWardKilledTitle = (TextView) pwindo.getContentView().findViewById(R.id.tvEnemyGolem);
			
			// some other stuff
			tvVsTextMiddleThing = (TextView) pwindo.getContentView().findViewById(R.id.tvVsText);
			btnClose = (Button) pwindo.getContentView().findViewById(R.id.Button01);
			
			// Start up dat asynctask
			AnotherAsyncTask anotherAsyncTask = new AnotherAsyncTask();
			PostFetcherTwo pft = anotherAsyncTask.new PostFetcherTwo(getActivity(), getActivity());
			pft.execute(url);
			
		
			// Set close button
			//Button btnClosePopup = (Button) pwindo.getContentView().findViewById(R.id.btn_close_popup);
			//btnClosePopup.setOnClickListener(cancel_button_click_listener);
			btnClose.setOnClickListener(cancel_button_click_listener);
			
		}

}
	

