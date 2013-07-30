package com.jt.getdunked2;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;;

public class ProfileFragment extends Fragment {
// paige jones object oriented programming *** remember plz ***
	LocationManager lm;

	public static ArrayList<GameStatistics> someArrayList;
	LazyAdapter lazyAdapter;

	ListView lv = MatchHistoryFragment.lv;
	TextView loadingText;
	String url;
	String urlTwo;
	Button btnSearch;
	TextView tvOne;
	MatchHistoryFragment our_context;
	
	public static ImageView ivTeamFive;
	public static ImageView ivSoloFive;
	public static ImageView ivTeamThree;
	public static TextView tvDebugOne;
	public static TextView tvDebugTwo;
	public static TextView tvDebugThree;
	public static TextView tvThreeDivision;
	public static TextView tvFiveDivision;
	public static TextView tvSoloDivision;
	public static TextView tvThreeLP;
	public static TextView tvSoloLP;
	public static TextView tvFiveLP;
	public static TextView tvThreeWins;
	public static TextView tvThreeLosses;
	public static TextView tvSoloWins;
	public static TextView tvSoloLosses;
	public static TextView tvFiveWins;
	public static TextView tvFiveLosses;
	public static TextView winsThree;
	public static TextView winsSolo;
	public static TextView winsFive;
	public static TextView lossesFive;
	public static TextView lossesThree;
	public static TextView lossesSolo;
	
	public static int matchNumber;
	public static Number champId[];
	public static Number teamId[];

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	    	
	    
	    View V = inflater.inflate(R.layout.profile_fragment, container, false);
		ivSoloFive = (ImageView) V.findViewById(R.id.ivSoloFiveIcon);
		ivTeamFive = (ImageView) V.findViewById(R.id.ivTeamFiveIcon);
		ivTeamThree = (ImageView) V.findViewById(R.id.ivTeamThreeIcon);
		tvDebugOne = (TextView) V.findViewById(R.id.TextView01);
		tvDebugTwo = (TextView) V.findViewById(R.id.tvWeekNum);
		tvDebugThree = (TextView) V.findViewById(R.id.tvNameTwo);
		tvThreeDivision = (TextView) V.findViewById(R.id.tvThreeLeague);
		tvSoloDivision = (TextView) V.findViewById(R.id.tvSoloLeague);
		tvFiveDivision = (TextView) V.findViewById(R.id.tvFiveLeague);
		tvThreeLP = (TextView) V.findViewById(R.id.tvThreeLP);
		tvFiveLP = (TextView) V.findViewById(R.id.tvFiveLP);
		tvSoloLP = (TextView) V.findViewById(R.id.tvSoloLP);
		tvThreeWins = (TextView) V.findViewById(R.id.tvThreeWins);
		tvThreeLosses = (TextView) V.findViewById(R.id.tvThreeLosses);
		tvSoloWins = (TextView) V.findViewById(R.id.tvSoloWins);
		tvSoloLosses = (TextView) V.findViewById(R.id.tvSoloLosses);
		tvFiveWins = (TextView) V.findViewById(R.id.tvFiveWins);
		tvFiveLosses = (TextView) V.findViewById(R.id.tvFiveLosses);
		winsThree = (TextView) V.findViewById(R.id.tvWins);
		winsSolo = (TextView) V.findViewById(R.id.tvNameFour);
		winsFive = (TextView) V.findViewById(R.id.TextView04);
		lossesFive = (TextView) V.findViewById(R.id.TextView05);
		lossesThree = (TextView) V.findViewById(R.id.TextView06);
		lossesSolo = (TextView) V.findViewById(R.id.TextView08);
		
			  

		return V;

		
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		ivSoloFive.setVisibility(View.GONE);
		ivTeamFive.setVisibility(View.GONE);
		ivTeamThree.setVisibility(View.GONE);
		tvDebugOne.setVisibility(View.GONE);
		tvDebugTwo.setVisibility(View.GONE);
		tvDebugThree.setVisibility(View.GONE);
		tvThreeDivision.setVisibility(View.GONE);
		tvSoloDivision.setVisibility(View.GONE);
		tvFiveDivision.setVisibility(View.GONE);
		tvThreeLP.setVisibility(View.GONE);
		tvSoloLP.setVisibility(View.GONE);
		tvFiveLP.setVisibility(View.GONE);
		tvThreeWins.setVisibility(View.GONE);
		tvSoloWins.setVisibility(View.GONE);
		tvFiveWins.setVisibility(View.GONE);
		tvFiveLosses.setVisibility(View.GONE);
		tvThreeLosses.setVisibility(View.GONE);
		tvSoloLosses.setVisibility(View.GONE);
		winsThree.setVisibility(View.GONE);
		winsSolo.setVisibility(View.GONE);
		winsFive.setVisibility(View.GONE);
		lossesFive.setVisibility(View.GONE);
		lossesThree.setVisibility(View.GONE);
		lossesSolo.setVisibility(View.GONE);
		
	}




}
