package com.jt.getdunked2;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockFragment;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;;

public class ProfileFragment extends SherlockFragment {
// paige jones object oriented programming *** remember plz ***
	LocationManager lm;

	ArrayList<GameStatistics> someArrayList;
	LazyAdapter lazyAdapter;

	ListView lv;
	TextView loadingText;
	static EditText etSummName;
	String url;
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
	
	public static int matchNumber;
	public static Number champId[];
	public static Number teamId[];

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	    	
	    
	    View V = inflater.inflate(R.layout.profile_fragment, container, false);
		etSummName = (EditText) getSherlockActivity().findViewById(R.id.etSummName);
		url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
		ivSoloFive = (ImageView) V.findViewById(R.id.ivSoloFiveIcon);
		ivTeamFive = (ImageView) V.findViewById(R.id.ivTeamFiveIcon);
		ivTeamThree = (ImageView) V.findViewById(R.id.ivTeamThreeIcon);
		tvDebugOne = (TextView) V.findViewById(R.id.TextView01);
		tvDebugTwo = (TextView) V.findViewById(R.id.textView1);
		tvDebugThree = (TextView) V.findViewById(R.id.TextView02);
		tvDebugThree = (TextView) V.findViewById(R.id.TextView02);
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
		
			  

		return V;

		
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		
	}
	
	
//	private static class PostFetchResult {
//		InGameStats igs;
//		Summoner summoner;
//		List<SummonerLeagues> recentGames;
//	}
//	
//	public static class SoData {
//		public Data data;
//	}
//	
//	
//	public class PostFetcherTwo extends AsyncTask<String, Void, PostFetchResult> {
//		private ProgressDialog dialog;
//		private Context context;
//		public final String SERVER_URL_IN_GAME_STATS = "http://api.elophant.com/v2/NA/in_progress_game_info/"
//				+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
//		public final String SERVER_URL_SUMMONER = "http://api.elophant.com/v2/NA/summoner/"
//				+ etSummName.getText().toString().replace(" ", "") + "?key=eS4XmrLVhc7EhPson8dV";
//		
//		String soloFiveLeague;
//		String soloFiveTier;
//		String soloFiveRank;
//		String teamFiveLeague;
//		String teamFiveTier;
//		String teamFiveRank;
//		String teamThreeLeague;
//		String teamThreeTier;
//		String teamThreeRank;
//		
//		
//		
//		public PostFetcherTwo(Context cxt) {
//			context = cxt;
//			dialog = new ProgressDialog(context);
//		}

//		@Override
//		protected PostFetchResult doInBackground(String... urls) {
//			PostFetchResult result = new PostFetchResult();
//
//			result.igs = JsonUtil.fromJsonUrl(SERVER_URL_IN_GAME_STATS,
//					InGameStats.class);
//			result.summoner = JsonUtil.fromJsonUrl(SERVER_URL_SUMMONER,
//					Summoner.class);			
//			try {
//				result.recentGames = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/NA/leagues/" + result.summoner.getData().getSummonerId().toString() 
//						+ "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getSummonerLeagues();
//				Log.w("Result", result.recentGames.toString());
//			} catch (Exception e) {
//				Log.w("doInBackground recentGames", "Recent Games error: " + e.getMessage());
//				
//			}
//			return result;
//			
//		}
//		
//		@Override
//		protected void onPreExecute(){
//			super.onPreExecute();
//			dialog = ProgressDialog.show(context, "", "Loading " + etSummName.getText().toString() + "'s match history...", true);
//			dialog.show();
//		}
//
//		@Override
//		protected void onPostExecute(PostFetchResult result) {
//			// TextView declarations -- may not keep
//
//			if(result == null) {
//				Toast.makeText(getSherlockActivity(), "Null result, aborting", Toast.LENGTH_LONG).show();
//			}
//			
//			
//			
//			someArrayList = new ArrayList<GameStatistics>();
//			dialog.dismiss();
//			try {
//				
//				
//					
//				}
//				
//				
//			} catch (Exception e){
//				
//				AlertDialog aDialog = new AlertDialog.Builder(context).create();
//				aDialog.setTitle("Error");
//				aDialog.setMessage("Unable to get summoner match history. Please try again in a few seconds.");
//				aDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {	
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						dialog.cancel();
//						
//					}
//				});
//				
//				aDialog.show();
//				
//				
//				Log.w("Oops", "An error occured: " + e.getMessage());
//				
//			}
//			
//		}
//	}



}
