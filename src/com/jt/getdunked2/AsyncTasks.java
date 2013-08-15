package com.jt.getdunked2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class AsyncTasks {

	EditText searchView = ProfileMainActivity.editTxt;
	public static LazyAdapter lazyAdapter;
	ArrayList<GameStatistics> someArrayList;
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
	TextView winsThree = ProfileFragment.winsThree;
	TextView winsSolo = ProfileFragment.winsSolo;
	TextView winsFive = ProfileFragment.winsFive;
	TextView lossesFive = ProfileFragment.lossesFive;
	TextView lossesThree = ProfileFragment.lossesThree;
	TextView lossesSolo = ProfileFragment.lossesSolo;
	MenuItem searchItem = ProfileMainActivity.searchItem;
	
	TextView tvDoubleKills = LifetimeStatsFragment.tvDoubleKills;
	TextView tvTripleKills = LifetimeStatsFragment.tvTripleKills;
	TextView tvQuadraKills = LifetimeStatsFragment.tvQuadraKills;
	TextView tvPentaKills = LifetimeStatsFragment.tvPentaKills;
	TextView tvKills = LifetimeStatsFragment.tvKills;
	TextView tvDeaths = LifetimeStatsFragment.tvDeaths;
	TextView tvAssists = LifetimeStatsFragment.tvAssists;
	TextView tvKillingSprees = LifetimeStatsFragment.tvKillingSprees;
	TextView tvMostKills = LifetimeStatsFragment.tvMostKills;
	TextView tvMostDeaths = LifetimeStatsFragment.tvMostDeaths;
	TextView tvGold = LifetimeStatsFragment.tvGold;
	TextView tvMinions = LifetimeStatsFragment.tvMinions;
	TextView tvNeutralMonsters = LifetimeStatsFragment.tvNeutralMonsters;
	TextView tvDamageDealt = LifetimeStatsFragment.tvDamageDealt;
	TextView tvMagicDamage = LifetimeStatsFragment.tvMagicDamage;
	TextView tvPhysicalDamage = LifetimeStatsFragment.tvPhysicalDamage;
	TextView tvHealingDone = LifetimeStatsFragment.tvHealingDone;
	TextView tvDamageTaken = LifetimeStatsFragment.tvDamageTaken;
	TextView tvLargestCrit = LifetimeStatsFragment.tvLargestCrit;
	TextView tvKillingSpree = LifetimeStatsFragment.tvKillingSpree;
	TextView tvTimeDead = LifetimeStatsFragment.tvTimeDead;
	TextView tvLifespan = LifetimeStatsFragment.tvLifespan;
	TextView tvLongestGame = LifetimeStatsFragment.tvLongestGame;
	TextView tvGamesPlayed = LifetimeStatsFragment.tvGamesPlayed;
	TextView tvGamesWon = LifetimeStatsFragment.tvGamesWon;
	TextView tvGamesLost = LifetimeStatsFragment.tvGamesLost;
	
	String name = ProfileMainActivity.name;
	
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
	Document doc;
	Elements images;
	
	public static String summonerName;
	
	
	private static class PostFetchResult {
		//InGameStats igs;
		Summoner summoner;
		List<GameStatistics> recentGames;
		List<SummonerLeagues> sLeagues;
		List<LifetimeStatistics> stats;
	}
	
	public static class SoData {
		public Data data;
	}
	
	
	public class PostFetcher extends AsyncTask<String, Void, PostFetchResult> {
		private Activity ownerActivity;
		private Context context;
		private ProgressDialog dialog;
		private Context cxtTwo;
		SharedPreferences sharedPrefs;
		public PostFetcher(Context cxt, Activity activity, Context contextTwo) {
			context = cxt;
			dialog = new ProgressDialog(context);
			this.ownerActivity = activity;
			cxtTwo = contextTwo;
		};
		
		
		

		@Override
		protected PostFetchResult doInBackground(String... urls) {
			PostFetchResult result = new PostFetchResult();
			sharedPrefs = PreferenceManager.getDefaultSharedPreferences(cxtTwo);
			
			final String SERVER_URL_SUMMONER = "http://api.elophant.com/v2/" + sharedPrefs.getString("user_region", "NA") 
					+ "/summoner/" + name.replace(" ", "") + "?key=eS4XmrLVhc7EhPson8dV";

			result.summoner = JsonUtil.fromJsonUrl(SERVER_URL_SUMMONER, Summoner.class);
			
			
			try {
				if (result.summoner.getSuccess() == true) {
					String acctId = result.summoner.getData().getAcctId().toString();
					String summonerId = result.summoner.getData().getSummonerId().toString();
					
					result.recentGames = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/" + sharedPrefs.getString("user_region", "NA") 
							+ "/recent_games/" + acctId.toString() + "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getGameStatistics();
					result.sLeagues = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/" + sharedPrefs.getString("user_region", "NA") 
							+ "/leagues/" + summonerId.toString() + "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getSummonerLeagues();
					result.stats = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/" + sharedPrefs.getString("user_region", "NA") 
							+ "/ranked_stats/" + acctId.toString() + "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getLifetimeStatistics();
				
				}
				
			} catch (Exception e) {
				Log.w("doInBackground recentGames", "Recent Games error: " + e.getMessage());
				e.printStackTrace();
				
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
			ListView lv = MatchHistoryFragment.lv;

			someArrayList = new ArrayList<GameStatistics>();
			dialog.cancel();
			
			int gamesPlayed = 0;
			int gamesWon = 0;
			int gamesLost = 0;
			
			try {
				summonerName = result.summoner.getData().getName();
				if (result.stats != null) {
					for (LifetimeStatistics stats : result.stats) {
						if (stats.getChampionId().toString().equals("0")) {
							if (stats.getStatType().equals("TOTAL_DOUBLE_KILLS")) {						
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvDoubleKills.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_TRIPLE_KILLS")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvTripleKills.setText(formatter.format(amount).toString());		
								
							} else if (stats.getStatType().equals("TOTAL_QUADRA_KILLS")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvQuadraKills.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_PENTA_KILLS")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvPentaKills.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_CHAMPION_KILLS")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvKills.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_DEATHS_PER_SESSION")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvDeaths.setText(formatter.format(amount).toString());	
								
							} else if (stats.getStatType().equals("TOTAL_ASSISTS")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvAssists.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("KILLING_SPREE")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvKillingSprees.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("MOST_CHAMPION_KILLS_PER_SESSION")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvMostKills.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("MAX_NUM_DEATHS")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvMostDeaths.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_GOLD_EARNED")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvGold.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_MINION_KILLS")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvMinions.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_NEUTRAL_MINIONS_KILLED")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvNeutralMonsters.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_DAMAGE_DEALT")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvDamageDealt.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_MAGIC_DAMAGE_DEALT")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvMagicDamage.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_PHYSICAL_DAMAGE_DEALT")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvPhysicalDamage.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_HEAL")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvHealingDone.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_DAMAGE_TAKEN")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvDamageTaken.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("MAX_TIME_SPENT_LIVING")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvLifespan.setText(formatter.format(amount).toString() + " s");
								
							} else if (stats.getStatType().equals("MAX_TIME_PLAYED")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvTripleKills.setText(formatter.format(amount).toString() + " s");
								
							} else if (stats.getStatType().equals("TOTAL_SESSIONS_PLAYED")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvGamesPlayed.setText(formatter.format(amount).toString());
								gamesPlayed = stats.getValue().intValue();
								
							} else if (stats.getStatType().equals("MAX_LARGEST_CRITICAL_STRIKE")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvLargestCrit.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("MAX_LARGEST_KILLING_SPREE")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvKillingSpree.setText(formatter.format(amount).toString());
								
							} else if (stats.getStatType().equals("TOTAL_TIME_SPENT_DEAD")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvTimeDead.setText(formatter.format(amount).toString() + " s");
								
							} else if (stats.getStatType().equals("TOTAL_SESSIONS_WON")) {
								String number = stats.getValue().toString();
								double amount = Double.parseDouble(number);
								DecimalFormat formatter = new DecimalFormat("#,###");
								
								tvGamesWon.setText(formatter.format(amount).toString());
								gamesWon = stats.getValue().intValue();
								if (gamesPlayed != 0) {
									gamesLost = (gamesPlayed - gamesWon);
									String numberTwo = String.valueOf(gamesLost);
									double amountTwo = Double.parseDouble(numberTwo);
									DecimalFormat formatterTwo = new DecimalFormat("#,###");
									
									tvGamesLost.setText("" + formatterTwo.format(amountTwo).toString());
								}
								
							} 
						}
					}
				} else {
					Crouton.showText(ownerActivity, "Summoner \"" + name + "\" not found, or server is busy.", 
							de.keyboardsurfer.android.widget.crouton.Style.ALERT);
				}
				
				if (result.recentGames != null)
				{		
					for(GameStatistics stats : result.recentGames)
					{
						someArrayList.add(stats);
					}					
				}
				
				if (result.sLeagues != null)
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
							
							ivSoloFive.setVisibility(View.VISIBLE);
							ivTeamFive.setVisibility(View.VISIBLE);
							ivTeamThree.setVisibility(View.VISIBLE);
							tvDebugOne.setVisibility(View.VISIBLE);
							tvDebugTwo.setVisibility(View.VISIBLE);
							tvDebugThree.setVisibility(View.VISIBLE);
							tvThreeDivision.setVisibility(View.VISIBLE);
							tvSoloDivision.setVisibility(View.VISIBLE);
							tvFiveDivision.setVisibility(View.VISIBLE);
							tvThreeLP.setVisibility(View.VISIBLE);
							tvSoloLP.setVisibility(View.VISIBLE);
							tvFiveLP.setVisibility(View.VISIBLE);
							tvThreeWins.setVisibility(View.VISIBLE);
							tvSoloWins.setVisibility(View.VISIBLE);
							tvFiveWins.setVisibility(View.VISIBLE);
							tvFiveLosses.setVisibility(View.VISIBLE);
							tvThreeLosses.setVisibility(View.VISIBLE);
							tvSoloLosses.setVisibility(View.VISIBLE);
							winsThree.setVisibility(View.VISIBLE);
							winsSolo.setVisibility(View.VISIBLE);
							winsFive.setVisibility(View.VISIBLE);
							lossesFive.setVisibility(View.VISIBLE);
							lossesThree.setVisibility(View.VISIBLE);
							lossesSolo.setVisibility(View.VISIBLE);
							MenuItemCompat.collapseActionView(searchItem);
							
						} 
					} 	
				
					if (someArrayList.size() > 0) {
						lazyAdapter = new LazyAdapter(context,
								R.layout.custom_list_view, someArrayList);
						if (lv != null) {
							lv.setAdapter(lazyAdapter);
							//tvOne.setText("Summoner Name:");
							lv.setBackgroundColor(Color.BLACK);
							lazyAdapter.notifyDataSetChanged();
						} else {
							Log.w("ListView", "STUPID LISTVIEW WAS NULL AGAIN WTF");
						}
						
					} 
					
				}
				
//				InputMethodManager imm = (InputMethodManager)context.getSystemService(Activity.INPUT_METHOD_SERVICE);
//				imm.hideSoftInputFromWindow(etSummName.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				
				
				
			} catch (Exception e){
				
				
				
				Log.w("Oops", "An error occured: " + e.getMessage());
				e.printStackTrace();
				
			}
			
		}
	}

}
