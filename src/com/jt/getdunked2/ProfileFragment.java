package com.jt.getdunked2;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;
import com.jt.getdunked2.MatchHistoryFragment.PostFetcher;
import com.jt.getdunked2.R.string;

import android.R.anim;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
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
	ImageView ivTeamFive;
	ImageView ivSoloFive;
	ImageView ivTeamThree;
	TextView tvDebugOne;
	TextView tvDebugTwo;
	TextView tvDebugThree;
	
	
	public static int matchNumber;
	public static Number champId[];
	public static Number teamId[];

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	    	
	    
	    View V = inflater.inflate(R.layout.profile_fragment, container, false);
		tvOne = (TextView) V.findViewById(R.id.tvTitle);
		etSummName = (EditText) getSherlockActivity().findViewById(R.id.etSummName);
		url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
		ivSoloFive = (ImageView) V.findViewById(R.id.ivSoloFiveIcon);
		ivTeamFive = (ImageView) V.findViewById(R.id.ivTeamFiveIcon);
		ivTeamThree = (ImageView) V.findViewById(R.id.ivTeamThreeIcon);
		tvDebugOne = (TextView) V.findViewById(R.id.TextView01);
		tvDebugTwo = (TextView) V.findViewById(R.id.textView1);
		tvDebugThree = (TextView) V.findViewById(R.id.TextView02);
 		
		
		
			  

		return V;

		
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		btnSearch = (Button) getSherlockActivity().findViewById(R.id.button2);
		

		((Button)btnSearch).setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				PostFetcherTwo pf = new PostFetcherTwo(getSherlockActivity());
				pf.execute(url);
				
			}
		});
		
		
		
	}
	
	
	private static class PostFetchResult {
		InGameStats igs;
		Summoner summoner;
		List<SummonerLeagues> recentGames;
	}
	
	public static class SoData {
		public Data data;
	}
	
	
	public class PostFetcherTwo extends AsyncTask<String, Void, PostFetchResult> {
		private ProgressDialog dialog;
		private Context context;
		public final String SERVER_URL_IN_GAME_STATS = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
		public final String SERVER_URL_SUMMONER = "http://api.elophant.com/v2/NA/summoner/"
				+ etSummName.getText().toString().replace(" ", "") + "?key=eS4XmrLVhc7EhPson8dV";
		
		String soloFiveLeague;
		String soloFiveTier;
		String soloFiveRank;
		String teamFiveLeague;
		String teamFiveTier;
		String teamFiveRank;
		String teamThreeLeague;
		String teamThreeTier;
		String teamThreeRank;
		
		
		
		public PostFetcherTwo(Context cxt) {
			context = cxt;
			dialog = new ProgressDialog(context);
		}

		@Override
		protected PostFetchResult doInBackground(String... urls) {
			PostFetchResult result = new PostFetchResult();

			result.igs = JsonUtil.fromJsonUrl(SERVER_URL_IN_GAME_STATS,
					InGameStats.class);
			result.summoner = JsonUtil.fromJsonUrl(SERVER_URL_SUMMONER,
					Summoner.class);			
			try {
				result.recentGames = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/NA/leagues/" + result.summoner.getData().getSummonerId().toString() 
						+ "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getSummonerLeagues();
				Log.w("Result", result.recentGames.toString());
			} catch (Exception e) {
				Log.w("doInBackground recentGames", "Recent Games error: " + e.getMessage());
				
			}
			return result;
			
		}
		
		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			dialog = ProgressDialog.show(context, "", "Loading " + etSummName.getText().toString() + "'s match history...", true);
			dialog.show();
		}

		@Override
		protected void onPostExecute(PostFetchResult result) {
			// TextView declarations -- may not keep

			if(result == null) {
				Toast.makeText(getSherlockActivity(), "Null result, aborting", Toast.LENGTH_LONG).show();
			}
			
			
			
			someArrayList = new ArrayList<GameStatistics>();
			dialog.dismiss();
			try {
				
				if (result.recentGames.size() > 0)
				{		
					for(SummonerLeagues summonerLeagues : result.recentGames)
					{
						if(summonerLeagues.getQueue().equals("RANKED_TEAM_5x5")) {
							teamFiveLeague = summonerLeagues.getName().toString();
							teamFiveRank = summonerLeagues.getRequestorsRank().toString();
							teamFiveTier = summonerLeagues.getTier().toString();
							tvDebugOne.setText(teamFiveTier);
							tvDebugTwo.setText(teamFiveRank);
							
							if(teamFiveTier == "BRONZE" && teamFiveRank == "I") {
								ivTeamFive.setImageResource(R.drawable.bronze_1);
							}
							if(teamFiveTier == "BRONZE" && teamFiveRank == "II") {
								ivTeamFive.setImageResource(R.drawable.bronze_2);
							}
							if(teamFiveTier == "BRONZE" && teamFiveRank == "III") {
								ivTeamFive.setImageResource(R.drawable.bronze_3);
							}
							if(teamFiveTier == "BRONZE" && teamFiveRank == "IV") {
								ivTeamFive.setImageResource(R.drawable.bronze_4);
							}
							if(teamFiveTier == "BRONZE" && teamFiveRank == "V") {
								ivTeamFive.setImageResource(R.drawable.bronze_1);
							}
							if(teamFiveTier == "SILVER" && teamFiveRank == "I") {
								ivTeamFive.setImageResource(R.drawable.silver_1);
							}
							if(teamFiveTier == "SILVER" && teamFiveRank == "II") {
								ivTeamFive.setImageResource(R.drawable.silver_2);
							}
							if(teamFiveTier == "SILVER" && teamFiveRank == "III") {
								ivTeamFive.setImageResource(R.drawable.silver_3);
							}
							if(teamFiveTier == "SILVER" && teamFiveRank == "IV") {
								ivTeamFive.setImageResource(R.drawable.silver_4);
							}
							if(teamFiveTier == "SILVER" && teamFiveRank == "V") {
								ivTeamFive.setImageResource(R.drawable.silver_5);
							}	
							if(teamFiveTier == "GOLD" && teamFiveRank == "I") {
								ivTeamFive.setImageResource(R.drawable.gold_1);
							}
							if(teamFiveTier == "GOLD" && teamFiveRank == "II") {
								ivTeamFive.setImageResource(R.drawable.gold_2);
							}
							if(teamFiveTier == "GOLD" && teamFiveRank == "III") {
								ivTeamFive.setImageResource(R.drawable.gold_3);
							}
							if(teamFiveTier == "GOLD" && teamFiveRank == "IV") {
								ivTeamFive.setImageResource(R.drawable.gold_4);
							}
							if(teamFiveTier == "GOLD" && teamFiveRank == "V") {
								ivTeamFive.setImageResource(R.drawable.gold_5);
							}	
							if(teamFiveTier == "PLATINUM" && teamFiveRank == "I") {
								ivTeamFive.setImageResource(R.drawable.platinum_1);
							}
							if(teamFiveTier == "PLATINUM" && teamFiveRank == "II") {
								ivTeamFive.setImageResource(R.drawable.platinum_2);
							}
							if(teamFiveTier == "PLATINUM" && teamFiveRank == "III") {
								ivTeamFive.setImageResource(R.drawable.platinum_3);
							}
							if(teamFiveTier == "PLATINUM" && teamFiveRank == "IV") {
								ivTeamFive.setImageResource(R.drawable.platinum_4);
							}
							if(teamFiveTier == "PLATINUM" && teamFiveRank == "V") {
								ivTeamFive.setImageResource(R.drawable.platinum_5);
							}
							if(teamFiveTier == "DIAMOND" && teamFiveRank == "I") {
								ivTeamFive.setImageResource(R.drawable.diamond_1);
							}
							if(teamFiveTier == "DIAMOND" && teamFiveRank == "II") {
								ivTeamFive.setImageResource(R.drawable.diamond_2);
							}
							if(teamFiveTier == "DIAMOND" && teamFiveRank == "III") {
								ivTeamFive.setImageResource(R.drawable.diamond_3);
							}
							if(teamFiveTier == "DIAMOND" && teamFiveRank == "IV") {
								ivTeamFive.setImageResource(R.drawable.diamond_4);
							}
							if(teamFiveTier == "DIAMOND" && teamFiveRank == "V") {
								ivTeamFive.setImageResource(R.drawable.diamond_5);
							}
							if(teamFiveTier == "CHALLENGER") {
								ivTeamFive.setImageResource(R.drawable.challenger_1);
							}
						}
					}					
					
				}
				
				
			} catch (Exception e){
				
				AlertDialog aDialog = new AlertDialog.Builder(context).create();
				aDialog.setTitle("Error");
				aDialog.setMessage("Unable to get summoner match history. Please try again in a few seconds.");
				aDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {	
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						
					}
				});
				
				aDialog.show();
				
				
				Log.w("Oops", "An error occured: " + e.getMessage());
				
			}
			
		}
	}



}
