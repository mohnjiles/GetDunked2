package com.jt.getdunked2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.keyboardsurfer.android.widget.crouton.Crouton;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;


public class AnotherAsyncTask {

	ArrayList<GameStatistics> someArrayList;
	
	PopupWindow pWindow = MatchHistoryFragment.pwindo;

	TextView tvDamageDealt = MatchHistoryFragment.tvDamageDone;
	TextView tvDamageRec = MatchHistoryFragment.dRec;
	TextView tvHealingDone = MatchHistoryFragment.hDone;
	TextView tvGold = MatchHistoryFragment.goldValue;
	TextView tvMultiKill = MatchHistoryFragment.lrgMultiKill;
	TextView tvTimeDead = MatchHistoryFragment.timeSpentDead;
	TextView tvWardsPlaced = MatchHistoryFragment.wards;
	TextView tvMinionsKilled = MatchHistoryFragment.minions;
	
	String name = ProfileMainActivity.name;
	
	Number damageDealt = null;
	Number damageRec = null;
	Number healingDone = null;
	Number gold = null;
	Number multiKill = null;
	Number timeDead = null;
	Number wardsPlaced = null;
	Number minionsKilled = null;
	Number neutralMinionsKilled = null;
	
	ArrayList<HashMap<String, String>> anotherArrayList;
	int position = MatchHistoryFragment.pos;
	


	
	private static class PostFetchResult {
		Summoner summoner;
		List<GameStatistics> recentGames;
	}
	
	public static class SoData {
		public Data data;
	}
	
	public class PostFetcherTwo extends AsyncTask<String, Void, PostFetchResult> {
		private ProgressDialog dialog;
		private Context context;
		private Activity ownerActivity;
		public PostFetcherTwo(Context cxt, Activity activity) {
			context = cxt;
			dialog = new ProgressDialog(context);
			this.ownerActivity = activity;
		}
		
		
		public final String SERVER_URL_IN_GAME_STATS = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ name + "?key=eS4XmrLVhc7EhPson8dV";
		public final String SERVER_URL_SUMMONER = "http://api.elophant.com/v2/NA/summoner/"
				+ name.replace(" ", "") + "?key=eS4XmrLVhc7EhPson8dV";
		

		@Override
		protected PostFetchResult doInBackground(String... urls) {
			PostFetchResult result = new PostFetchResult();

			result.summoner = JsonUtil.fromJsonUrl(SERVER_URL_SUMMONER,
					Summoner.class);			
			try {
				result.recentGames = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/NA/recent_games/" + result.summoner.getData().getAcctId().toString() 
						+ "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getGameStatistics();
			} catch (Exception e) {
				Log.w("doInBackground recentGames", "Recent Games error: " + e.getMessage());
				
			}
			return result;
			
		}
		
		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			dialog = ProgressDialog.show(context, "", "Loading " + name + "'s match history...", true);
			dialog.show();
		}

		@Override
		protected void onPostExecute(PostFetchResult result) {
			// TextView declarations -- may not keep
			dialog.cancel();
			try {
				if (result.recentGames.size() > 0) {
					//tvDebug.setText(result.recentGames.get(position).getGameMode() + " / " + result.recentGames.get(position).getQueueType());
					for (Statistics stats : result.recentGames.get(position).getStatistics()) {
						
						if (stats.getStatType().equals("TOTAL_DAMAGE_DEALT")) {
							damageDealt = stats.getValue();
						}  else if (stats.getStatType().equals("TOTAL_DAMAGE_DEALT")) {
							damageDealt = stats.getValue();
						} else if (stats.getStatType().equals("TOTAL_DAMAGE_TAKEN")) {
							damageRec = stats.getValue();
						} else if (stats.getStatType().equals("TOTAL_HEAL")) {
							healingDone = stats.getValue();
						} else if (stats.getStatType().equals("GOLD_EARNED")) {
							gold = stats.getValue();
						} else if (stats.getStatType().equals("LARGEST_MULTI_KILL")) {
							multiKill = stats.getValue();
						} else if (stats.getStatType().equals("TOTAL_TIME_SPENT_DEAD")) {
							timeDead = stats.getValue();
						} else if (stats.getStatType().equals("WARD_PLACED")) {
							wardsPlaced = stats.getValue();
						} else if (stats.getStatType().equals("MINIONS_KILLED")) {
							minionsKilled = stats.getValue();
						} else if (stats.getStatType().equals("NEUTRAL_MINIONS_KILLED")) {
							neutralMinionsKilled = stats.getValue();
						}
						
						// Set Minions Killed
						if (minionsKilled != null && neutralMinionsKilled != null) {
							int totalMinions = minionsKilled.intValue() + neutralMinionsKilled.intValue();
							tvMinionsKilled.setText("" + totalMinions);
						}
						
						// Set Damage Dealt
						if (damageDealt != null) {
							String number = damageDealt.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvDamageDealt.setText(formatter.format(amount).toString());
						}

						// Set Damage Taken
						if (damageRec != null) {
							String number = damageRec.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvDamageRec.setText(formatter.format(amount).toString());
						}
						
						//Set Healing Done
						if (healingDone != null) {
							String number = healingDone.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvHealingDone.setText(formatter.format(amount).toString());
						}
						
						// Set Gold
						if (gold != null) {
							String number = gold.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvGold.setText(formatter.format(amount).toString());
						}
						
						// Set Largest Multi-Kill
						if (multiKill != null) {
							
							tvMultiKill.setText(multiKill.toString());
						}
						
						// Set Time Spent Dead
						if (timeDead != null) {
							tvTimeDead.setText(timeDead.toString());
						}
						
						// Set Wards Placed
						if (wardsPlaced != null) {
							tvWardsPlaced.setText(wardsPlaced.toString());
						}
					

					}
				}
			} catch (Exception e) {
				Crouton.showText(ownerActivity, "Error loading " + name + "'s match info." +
						" Please try again in a few seconds.", 
						de.keyboardsurfer.android.widget.crouton.Style.ALERT);
				Log.w("onPostExecute", "" + e.getMessage() + e.getStackTrace()[2].getLineNumber());
				pWindow.dismiss();
			}
		
		}
	}
}
