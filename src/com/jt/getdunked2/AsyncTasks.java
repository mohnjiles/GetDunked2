package com.jt.getdunked2;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class AsyncTasks {
	
	
	LazyAdapter lazyAdapter;
	ArrayList<GameStatistics> someArrayList;
	EditText etSummName = ProfileMainActivity.etSummName;
	ListView lv = MatchHistoryFragment.lv;
	//TextView tvOne = MatchHistoryFragment.tvOne;
	TextView tvDebugOne = ProfileFragment.tvDebugOne;
	TextView tvDebugTwo = ProfileFragment.tvDebugTwo;
	TextView tvDebugThree = ProfileFragment.tvDebugThree;
	ImageView ivTeamFive = ProfileFragment.ivTeamFive;
	ImageView ivSoloFive = ProfileFragment.ivSoloFive;
	ImageView ivTeamThree = ProfileFragment.ivTeamThree;
	TextView tvThreeDivision = ProfileFragment.tvThreeDivision;
	TextView tvFiveDivision = ProfileFragment.tvFiveDivision;
	TextView tvSoloDivision = ProfileFragment.tvSoloDivision;
	TextView tvThreeLP = ProfileFragment.tvThreeLP;
	TextView tvSoloLP = ProfileFragment.tvSoloLP;
	TextView tvFiveLP = ProfileFragment.tvFiveLP;
	TextView tvThreeWins = ProfileFragment.tvThreeWins;
	TextView tvSoloWins = ProfileFragment.tvSoloWins;
	TextView tvSoloLosses = ProfileFragment.tvSoloLosses;
	TextView tvFiveWins = ProfileFragment.tvFiveWins;
	TextView tvFiveLosses = ProfileFragment.tvFiveLosses;
	TextView tvThreeLosses = ProfileFragment.tvThreeLosses;

	String soloFiveLeague;
	String soloFiveTier;
	String soloFiveRank;
	String teamFiveLeague;
	String teamFiveTier;
	String teamFiveRank;
	String teamThreeLeague;
	String teamThreeTier;
	String teamThreeRank;
	String soloFiveLP;
	String teamFiveLP;
	String teamThreeLP;
	
	private static class PostFetchResult {
		InGameStats igs;
		Summoner summoner;
		List<GameStatistics> recentGames;
		List<SummonerLeagues> sLeagues;
		List<Entries> entries;
	}
	
	public static class SoData {
		public Data data;
	}
	
	public class PostFetcher extends AsyncTask<String, Void, PostFetchResult> {
		private ProgressDialog dialog;
		private Context context;
		public PostFetcher(Context cxt) {
			context = cxt;
			dialog = new ProgressDialog(context);
		}
		
		
		public final String SERVER_URL_IN_GAME_STATS = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
		public final String SERVER_URL_SUMMONER = "http://api.elophant.com/v2/NA/summoner/"
				+ etSummName.getText().toString().replace(" ", "") + "?key=eS4XmrLVhc7EhPson8dV";
		

		@Override
		protected PostFetchResult doInBackground(String... urls) {
			PostFetchResult result = new PostFetchResult();

			result.igs = JsonUtil.fromJsonUrl(SERVER_URL_IN_GAME_STATS,
					InGameStats.class);
			result.summoner = JsonUtil.fromJsonUrl(SERVER_URL_SUMMONER,
					Summoner.class);			
			try {
				result.recentGames = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/NA/recent_games/" + result.summoner.getData().getAcctId().toString() 
						+ "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getGameStatistics();
				result.sLeagues = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/NA/leagues/" + result.summoner.getData().getSummonerId().toString() 
						+ "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getSummonerLeagues();
				result.entries = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/NA/leagues/" + result.summoner.getData().getSummonerId().toString() 
						+ "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getSummonerLeagues();
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

			someArrayList = new ArrayList<GameStatistics>();
			dialog.dismiss();
			try {
				if (result.recentGames.size() > 0)
				{		
					for(GameStatistics stats : result.recentGames)
					{
						someArrayList.add(stats);
					}					
					
				}
				
				if (result.sLeagues.size() > 0)
				{		
					for(SummonerLeagues summonerLeagues : result.sLeagues)
					{
						if(summonerLeagues.getQueue().equals("RANKED_TEAM_5x5")) {
							teamFiveLeague = summonerLeagues.getName().toString();
							teamFiveRank = summonerLeagues.getRequestorsRank().toString();
							teamFiveTier = summonerLeagues.getTier().toString();
							
							for(Entries entries : summonerLeagues.getEntries())
							{
								if(entries.getPlayerOrTeamName().equals(summonerLeagues.getRequestorsName().toString())) {
									teamFiveLP = entries.getLeaguePoints().toString();
									tvFiveLP.setText("" + teamFiveLP + " League Points");
									tvFiveWins.setText(entries.getWins().toString());
									tvFiveLosses.setText(entries.getLosses().toString());
								}
							}
	
							
							if(teamFiveTier.equals("BRONZE") && teamFiveRank.equals("I")) {
								ivTeamFive.setImageResource(R.drawable.bronze_1);
								tvFiveDivision.setText("Bronze I");
							}
							else if(teamFiveTier.equals("BRONZE") && teamFiveRank.equals("II")) {
								ivTeamFive.setImageResource(R.drawable.bronze_2);
								tvFiveDivision.setText("Bronze II");
							}
							else if(teamFiveTier.equals("BRONZE") && teamFiveRank.equals("III")) {
								ivTeamFive.setImageResource(R.drawable.bronze_3);
								tvFiveDivision.setText("Bronze III");
							}
							else if(teamFiveTier.equals("BRONZE") && teamFiveRank.equals("IV")) {
								ivTeamFive.setImageResource(R.drawable.bronze_4);
								tvFiveDivision.setText("Bronze IV");
							}
							else if(teamFiveTier.equals("BRONZE") && teamFiveRank.equals("V")) {
								ivTeamFive.setImageResource(R.drawable.bronze_5);
								tvFiveDivision.setText("Bronze V");
							}
							else if(teamFiveTier.equals("SILVER") && teamFiveRank.equals("I")) {
								ivTeamFive.setImageResource(R.drawable.silver_1);
								tvFiveDivision.setText("Silver I");
							}
							else if(teamFiveTier.equals("SILVER") && teamFiveRank.equals("II")) {
								ivTeamFive.setImageResource(R.drawable.silver_2);
								tvFiveDivision.setText("Silver II");
							}
							else if(teamFiveTier.equals("SILVER") && teamFiveRank.equals("III")) {
								ivTeamFive.setImageResource(R.drawable.silver_3);
								tvFiveDivision.setText("Silver III");
							}
							else if(teamFiveTier.equals("SILVER") && teamFiveRank.equals("IV")) {
								ivTeamFive.setImageResource(R.drawable.silver_4);
								tvFiveDivision.setText("Silver IV");
							}
							else if(teamFiveTier.equals("SILVER") && teamFiveRank.equals("V")) {
								ivTeamFive.setImageResource(R.drawable.silver_5);
								tvFiveDivision.setText("Silver V");
							}	
							else if(teamFiveTier.equals("GOLD") && teamFiveRank.equals("I")) {
								ivTeamFive.setImageResource(R.drawable.gold_1);
								tvFiveDivision.setText("Gold I");
							}
							else if(teamFiveTier.equals("GOLD") && teamFiveRank.equals("II")) {
								ivTeamFive.setImageResource(R.drawable.gold_2);
								tvFiveDivision.setText("Gold II");
							}
							else if(teamFiveTier.equals("GOLD") && teamFiveRank.equals("III")) {
								ivTeamFive.setImageResource(R.drawable.gold_3);
								tvFiveDivision.setText("Gold III");
							}
							else if(teamFiveTier.equals("GOLD") && teamFiveRank.equals("IV")) {
								ivTeamFive.setImageResource(R.drawable.gold_4);
								tvFiveDivision.setText("Gold IV");
							}
							else if(teamFiveTier.equals("GOLD") && teamFiveRank.equals("V")) {
								ivTeamFive.setImageResource(R.drawable.gold_5);
								tvFiveDivision.setText("Gold V");
							}	
							else if(teamFiveTier.equals("PLATINUM") && teamFiveRank.equals("I")) {
								ivTeamFive.setImageResource(R.drawable.platinum_1);
								tvFiveDivision.setText("Platinum I");
							}
							else if(teamFiveTier.equals("PLATINUM") && teamFiveRank.equals("II")) {
								ivTeamFive.setImageResource(R.drawable.platinum_2);
								tvFiveDivision.setText("Platinum II");
							}
							else if(teamFiveTier.equals("PLATINUM") && teamFiveRank.equals("III")) {
								ivTeamFive.setImageResource(R.drawable.platinum_3);
								tvFiveDivision.setText("Platinum III");
							}
							else if(teamFiveTier.equals("PLATINUM") && teamFiveRank.equals("IV")) {
								ivTeamFive.setImageResource(R.drawable.platinum_4);
								tvFiveDivision.setText("Platinum IV");
							}
							else if(teamFiveTier.equals("PLATINUM") && teamFiveRank.equals("V")) {
								ivTeamFive.setImageResource(R.drawable.platinum_5);
								tvFiveDivision.setText("Platinum V");
							}
							else if(teamFiveTier.equals("DIAMOND") && teamFiveRank.equals("I")) {
								ivTeamFive.setImageResource(R.drawable.diamond_1);
								tvFiveDivision.setText("Diamond I");
							}
							else if(teamFiveTier.equals("DIAMOND") && teamFiveRank.equals("II")) {
								ivTeamFive.setImageResource(R.drawable.diamond_2);
								tvFiveDivision.setText("Diamond II");
							}
							else if(teamFiveTier.equals("DIAMOND") && teamFiveRank.equals("III")) {
								ivTeamFive.setImageResource(R.drawable.diamond_3);
								tvFiveDivision.setText("Diamond III");
							}
							else if(teamFiveTier.equals("DIAMOND") && teamFiveRank.equals("IV")) {
								ivTeamFive.setImageResource(R.drawable.diamond_4);
								tvFiveDivision.setText("Diamond IV");
							}
							else if(teamFiveTier.equals("DIAMOND") && teamFiveRank.equals("V")) {
								ivTeamFive.setImageResource(R.drawable.diamond_5);
								tvFiveDivision.setText("Diamond V");
							}
							else if(teamFiveTier.equals("CHALLENGER")) {
								ivTeamFive.setImageResource(R.drawable.challenger_1);
								tvFiveDivision.setText("Challenger I");
							}
						}
						else if(summonerLeagues.getQueue().equals("RANKED_TEAM_3x3")) {
							teamThreeLeague = summonerLeagues.getName().toString();
							teamThreeRank = summonerLeagues.getRequestorsRank().toString();
							teamThreeTier = summonerLeagues.getTier().toString();
							
							for(Entries entries : summonerLeagues.getEntries())
							{
								if(entries.getPlayerOrTeamName().equals(summonerLeagues.getRequestorsName().toString())) {
									teamThreeLP = entries.getLeaguePoints().toString();
									tvThreeLP.setText("" + teamThreeLP + " League Points");
									tvThreeWins.setText(entries.getWins().toString());
									tvThreeLosses.setText(entries.getLosses().toString());
								}
							}
							
							if(teamThreeTier.equals("BRONZE") && teamThreeRank.equals("I")) {
								ivTeamThree.setImageResource(R.drawable.bronze_1);
								tvThreeDivision.setText("Bronze " + teamThreeRank);
								}
							else if(teamThreeTier.equals("BRONZE") && teamThreeRank.equals("II")) {
								ivTeamThree.setImageResource(R.drawable.bronze_2);
								tvThreeDivision.setText("Bronze " + teamThreeRank);
								}
							else if(teamThreeTier.equals("BRONZE") && teamThreeRank.equals("III")) {
								ivTeamThree.setImageResource(R.drawable.bronze_3);
								tvThreeDivision.setText("Bronze " + teamThreeRank);
							}
							else if(teamThreeTier.equals("BRONZE") && teamThreeRank.equals("IV")) {
								ivTeamThree.setImageResource(R.drawable.bronze_4);
								tvThreeDivision.setText("Bronze " + teamThreeRank);
							}
							else if(teamThreeTier.equals("BRONZE") && teamThreeRank.equals("V")) {
								ivTeamThree.setImageResource(R.drawable.bronze_5);
								tvThreeDivision.setText("Bronze " + teamThreeRank);
							}
							else if(teamThreeTier.equals("SILVER") && teamThreeRank.equals("I")) {
								ivTeamThree.setImageResource(R.drawable.silver_1);
								tvThreeDivision.setText("Silver " + teamThreeRank);
							}
							else if(teamThreeTier.equals("SILVER") && teamThreeRank.equals("II")) {
								ivTeamThree.setImageResource(R.drawable.silver_2);
								tvThreeDivision.setText("Silver " + teamThreeRank);
							}
							else if(teamThreeTier.equals("SILVER") && teamThreeRank.equals("III")) {
								ivTeamThree.setImageResource(R.drawable.silver_3);
								tvThreeDivision.setText("Silver " + teamThreeRank);
							}
							else if(teamThreeTier.equals("SILVER") && teamThreeRank.equals("IV")) {
								ivTeamThree.setImageResource(R.drawable.silver_4);
								tvThreeDivision.setText("Silver " + teamThreeRank);
							}
							else if(teamThreeTier.equals("SILVER") && teamThreeRank.equals("V")) {
								ivTeamThree.setImageResource(R.drawable.silver_5);
								tvThreeDivision.setText("Silver " + teamThreeRank);
							}	
							else if(teamThreeTier.equals("GOLD") && teamThreeRank.equals("I")) {
								ivTeamThree.setImageResource(R.drawable.gold_1);
								tvThreeDivision.setText("Gold " + teamThreeRank);
							}
							else if(teamThreeTier.equals("GOLD") && teamThreeRank.equals("II")) {
								ivTeamThree.setImageResource(R.drawable.gold_2);
								tvThreeDivision.setText("Gold " + teamThreeRank);
							}
							else if(teamThreeTier.equals("GOLD") && teamThreeRank.equals("III")) {
								ivTeamThree.setImageResource(R.drawable.gold_3);
								tvThreeDivision.setText("Gold " + teamThreeRank);
							}
							else if(teamThreeTier.equals("GOLD") && teamThreeRank.equals("IV")) {
								ivTeamThree.setImageResource(R.drawable.gold_4);
								tvThreeDivision.setText("Gold " + teamThreeRank);
							}
							else if(teamThreeTier.equals("GOLD") && teamThreeRank.equals("V")) {
								ivTeamThree.setImageResource(R.drawable.gold_5);
								tvThreeDivision.setText("Gold " + teamThreeRank);
							}	
							else if(teamThreeTier.equals("PLATINUM") && teamThreeRank.equals("I")) {
								ivTeamThree.setImageResource(R.drawable.platinum_1);
								tvThreeDivision.setText("Platinum " + teamThreeRank);
							}
							else if(teamThreeTier.equals("PLATINUM") && teamThreeRank.equals("II")) {
								ivTeamThree.setImageResource(R.drawable.platinum_2);
								tvThreeDivision.setText("Platinum " + teamThreeRank);
							}
							else if(teamThreeTier.equals("PLATINUM") && teamThreeRank.equals("III")) {
								ivTeamThree.setImageResource(R.drawable.platinum_3);
								tvThreeDivision.setText("Platinum " + teamThreeRank);
							}
							else if(teamThreeTier.equals("PLATINUM") && teamThreeRank.equals("IV")) {
								ivTeamThree.setImageResource(R.drawable.platinum_4);
								tvThreeDivision.setText("Platinum " + teamThreeRank);
							}
							else if(teamThreeTier.equals("PLATINUM") && teamThreeRank.equals("V")) {
								ivTeamThree.setImageResource(R.drawable.platinum_5);
								tvThreeDivision.setText("Platinum " + teamThreeRank);
							}
							else if(teamThreeTier.equals("DIAMOND") && teamThreeRank.equals("I")) {
								ivTeamThree.setImageResource(R.drawable.diamond_1);
								tvThreeDivision.setText("Diamond " + teamThreeRank);
							}
							else if(teamThreeTier.equals("DIAMOND") && teamThreeRank.equals("II")) {
								ivTeamThree.setImageResource(R.drawable.diamond_2);
								tvThreeDivision.setText("Diamond " + teamThreeRank);
							}
							else if(teamThreeTier.equals("DIAMOND") && teamThreeRank.equals("III")) {
								ivTeamThree.setImageResource(R.drawable.diamond_3);
								tvThreeDivision.setText("Diamond " + teamThreeRank);
							}
							else if(teamThreeTier.equals("DIAMOND") && teamThreeRank.equals("IV")) {
								ivTeamThree.setImageResource(R.drawable.diamond_4);
								tvThreeDivision.setText("Diamond " + teamThreeRank);
							}
							else if(teamThreeTier.equals("DIAMOND") && teamThreeRank.equals("V")) {
								ivTeamThree.setImageResource(R.drawable.diamond_5);
								tvThreeDivision.setText("Diamond " + teamThreeRank);
							}
							else if(teamThreeTier.equals("CHALLENGER")) {
								ivTeamThree.setImageResource(R.drawable.challenger_1);
								tvThreeDivision.setText("Challenger I");
							}
						}
						else if(summonerLeagues.getQueue().equals("RANKED_SOLO_5x5")) {
							soloFiveLeague = summonerLeagues.getName().toString();
							soloFiveRank = summonerLeagues.getRequestorsRank().toString();
							soloFiveTier = summonerLeagues.getTier().toString();
							
							for(Entries entries : summonerLeagues.getEntries())
							{
								if(entries.getPlayerOrTeamName().equals(summonerLeagues.getRequestorsName().toString())) {
									soloFiveLP = entries.getLeaguePoints().toString();
									tvSoloLP.setText("" + soloFiveLP + " League Points");
									tvSoloWins.setText(entries.getWins().toString());
									tvSoloLosses.setText(entries.getLosses().toString());
								}
							}
							
							if(soloFiveTier.equals("BRONZE") && soloFiveRank.equals("I")) {
								ivSoloFive.setImageResource(R.drawable.bronze_1);
								tvSoloDivision.setText("Bronze " + soloFiveRank);
							}
							else if(soloFiveTier.equals("BRONZE") && soloFiveRank.equals("II")) {
								ivSoloFive.setImageResource(R.drawable.bronze_2);
								tvSoloDivision.setText("Bronze " + soloFiveRank);
							}
							else if(soloFiveTier.equals("BRONZE") && soloFiveRank.equals("III")) {
								ivSoloFive.setImageResource(R.drawable.bronze_3);
								tvSoloDivision.setText("Bronze " + soloFiveRank);
							}
							else if(soloFiveTier.equals("BRONZE") && soloFiveRank.equals("IV")) {
								ivSoloFive.setImageResource(R.drawable.bronze_4);
								tvSoloDivision.setText("Bronze " + soloFiveRank);
							}
							else if(soloFiveTier.equals("BRONZE") && soloFiveRank.equals("V")) {
								ivSoloFive.setImageResource(R.drawable.bronze_5);
								tvSoloDivision.setText("Bronze " + soloFiveRank);
							}
							else if(soloFiveTier.equals("SILVER") && soloFiveRank.equals("I")) {
								ivSoloFive.setImageResource(R.drawable.silver_1);
								tvSoloDivision.setText("Silver " + soloFiveRank);
							}
							else if(soloFiveTier.equals("SILVER") && soloFiveRank.equals("II")) {
								ivSoloFive.setImageResource(R.drawable.silver_2);
								tvSoloDivision.setText("Silver " + soloFiveRank);
							}
							else if(soloFiveTier.equals("SILVER") && soloFiveRank.equals("III")) {
								ivSoloFive.setImageResource(R.drawable.silver_3);
								tvSoloDivision.setText("Silver " + soloFiveRank);
							}
							else if(soloFiveTier.equals("SILVER") && soloFiveRank.equals("IV")) {
								ivSoloFive.setImageResource(R.drawable.silver_4);
								tvSoloDivision.setText("Silver " + soloFiveRank);
							}
							else if(soloFiveTier.equals("SILVER") && soloFiveRank.equals("V")) {
								ivSoloFive.setImageResource(R.drawable.silver_5);
								tvSoloDivision.setText("Silver " + soloFiveRank);
							}	
							else if(soloFiveTier.equals("GOLD") && soloFiveRank.equals("I")) {
								ivSoloFive.setImageResource(R.drawable.gold_1);
								tvSoloDivision.setText("Gold " + soloFiveRank);
							}
							else if(soloFiveTier.equals("GOLD") && soloFiveRank.equals("II")) {
								ivSoloFive.setImageResource(R.drawable.gold_2);
								tvSoloDivision.setText("Gold " + soloFiveRank);
							}
							else if(soloFiveTier.equals("GOLD") && soloFiveRank.equals("III")) {
								ivSoloFive.setImageResource(R.drawable.gold_3);
								tvSoloDivision.setText("Gold " + soloFiveRank);
							}
							else if(soloFiveTier.equals("GOLD") && soloFiveRank.equals("IV")) {
								ivSoloFive.setImageResource(R.drawable.gold_4);
								tvSoloDivision.setText("Gold " + soloFiveRank);
							}
							else if(soloFiveTier.equals("GOLD") && soloFiveRank.equals("V")) {
								ivSoloFive.setImageResource(R.drawable.gold_5);
								tvSoloDivision.setText("Gold " + soloFiveRank);
							}	
							else if(soloFiveTier.equals("PLATINUM") && soloFiveRank.equals("I")) {
								ivSoloFive.setImageResource(R.drawable.platinum_1);
								tvSoloDivision.setText("Platinum " + soloFiveRank);
							}
							else if(soloFiveTier.equals("PLATINUM") && soloFiveRank.equals("II")) {
								ivSoloFive.setImageResource(R.drawable.platinum_2);
								tvSoloDivision.setText("Platinum " + soloFiveRank);
							}
							else if(soloFiveTier.equals("PLATINUM") && soloFiveRank.equals("III")) {
								ivSoloFive.setImageResource(R.drawable.platinum_3);
								tvSoloDivision.setText("Platinum " + soloFiveRank);
							}
							else if(soloFiveTier.equals("PLATINUM") && soloFiveRank.equals("IV")) {
								ivSoloFive.setImageResource(R.drawable.platinum_4);
								tvSoloDivision.setText("Platinum " + soloFiveRank);
							}
							else if(soloFiveTier.equals("PLATINUM") && soloFiveRank.equals("V")) {
								ivSoloFive.setImageResource(R.drawable.platinum_5);
								tvSoloDivision.setText("Platinum " + soloFiveRank);
							}
							else if(soloFiveTier.equals("DIAMOND") && soloFiveRank.equals("I")) {
								ivSoloFive.setImageResource(R.drawable.diamond_1);
								tvSoloDivision.setText("Diamond " + soloFiveRank);
							}
							else if(soloFiveTier.equals("DIAMOND") && soloFiveRank.equals("II")) {
								ivSoloFive.setImageResource(R.drawable.diamond_2);
								tvSoloDivision.setText("Diamond " + soloFiveRank);
							}
							else if(soloFiveTier.equals("DIAMOND") && soloFiveRank.equals("III")) {
								ivSoloFive.setImageResource(R.drawable.diamond_3);
								tvSoloDivision.setText("Diamond " + soloFiveRank);
							}
							else if(soloFiveTier.equals("DIAMOND") && soloFiveRank.equals("IV")) {
								ivSoloFive.setImageResource(R.drawable.diamond_4);
								tvSoloDivision.setText("Diamond " + soloFiveRank);
							}
							else if(soloFiveTier.equals("DIAMOND") && soloFiveRank.equals("V")) {
								ivSoloFive.setImageResource(R.drawable.diamond_5);
								tvSoloDivision.setText("Diamond " + soloFiveRank);
							}
							else if(soloFiveTier.equals("CHALLENGER")) {
								ivSoloFive.setImageResource(R.drawable.challenger_1);
								tvSoloDivision.setText("Challenger I");
							}
						}
					}	
				
				
				lazyAdapter = new LazyAdapter(context,
						R.layout.custom_list_view, someArrayList);

				lv.setAdapter(lazyAdapter);
				//tvOne.setText("Summoner Name:");
				lazyAdapter.notifyDataSetChanged();
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
				 InputMethodManager imm = (InputMethodManager)context.getSystemService(Activity.INPUT_METHOD_SERVICE);
						imm.hideSoftInputFromWindow(etSummName.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				aDialog.show();
				
				
				Log.w("Oops", "An error occured: " + e.getMessage());
				
			}
			
		}
	}
}
