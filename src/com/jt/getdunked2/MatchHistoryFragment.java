package com.jt.getdunked2;

import java.util.ArrayList;
import com.jt.getdunked2.AnotherAsyncTask.PostFetcherTwo;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import android.content.Context;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;;

public class MatchHistoryFragment extends ListFragment {
// paige jones object oriented programming *** remember plz ***
	LocationManager lm;

	ArrayList<GameStatistics> someArrayList = null;
	LazyAdapter lazyAdapter;
	
	public static TextView tvDamageDone;
	public static TextView dDealt;
	public static TextView dRec;
	public static TextView hDone;
	public static TextView goldValue;
	public static TextView lrgMultiKill;
	public static TextView timeSpentDead;
	public static TextView wards;
	public static TextView minions;

	public static Typeface tf;
	public static ListView lv;
	public static int pos;
	TextView loadingText;
	static EditText etSummName;
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
	    
		etSummName = (EditText) getActivity().findViewById(R.id.etSummName);
		tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-BoldCondensed.ttf");
		url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
		
		
		return V;	
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		btnSearch = (Button) getActivity().findViewById(R.id.button2);
		lv = getListView();
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
			// convert px to dips
			int dipsWidth = (int) TypedValue.applyDimension(
	        	    TypedValue.COMPLEX_UNIT_DIP, 
	        	    200 , 
	        	    getActivity().getResources().getDisplayMetrics()); 
			int dipsHeight = (int) TypedValue.applyDimension(
	        	    TypedValue.COMPLEX_UNIT_DIP, 
	        	    300 , 
	        	    getActivity().getResources().getDisplayMetrics()); 
			
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.popup_window, null);
			
			pos = 9 - position;
			
			// Make a new popupwindow, 200 x 300 dp
			pwindo = new PopupWindow(layout, dipsWidth, dipsHeight, true);
			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
			pwindo.setFocusable(true);
			
			// Set TextView variables
			tvDamageDone = (TextView) pwindo.getContentView().findViewById(R.id.tvDDealtNum);
			dRec = (TextView) pwindo.getContentView().findViewById(R.id.tvDRecNum);
			hDone = (TextView) pwindo.getContentView().findViewById(R.id.tvHDoneNum);
			goldValue = (TextView) pwindo.getContentView().findViewById(R.id.tvGold);
			lrgMultiKill = (TextView) pwindo.getContentView().findViewById(R.id.tvMultiKillValue);
			timeSpentDead = (TextView) pwindo.getContentView().findViewById(R.id.tvTimeDeadValue);
			wards = (TextView) pwindo.getContentView().findViewById(R.id.tvWardsPlacedValue);
			minions = (TextView) pwindo.getContentView().findViewById(R.id.tvMinionsValue);
			
			// Start up dat asynctask
			AnotherAsyncTask anotherAsyncTask = new AnotherAsyncTask();
			PostFetcherTwo pft = anotherAsyncTask.new PostFetcherTwo(getActivity(), getActivity());
			pft.execute(url);
		
			// Set close button
			Button btnClosePopup = (Button) pwindo.getContentView().findViewById(R.id.btn_close_popup);
			btnClosePopup.setOnClickListener(cancel_button_click_listener);
			
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

}

