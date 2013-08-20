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
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class AsyncTasks {

	// Define / grab all the views/etc we'll be using
	EditText searchView = ProfileMainActivity.editTxt;
	public static LazyAdapter lazyAdapter;
	ArrayList<GameStatistics> someArrayList;
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
	
	ActionBar actionBar = ProfileMainActivity.actionBar;
	
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
	
	public static int numOfRecentGames;
	String summonerName;
	
	// Holder class
	public static class PostFetchResult {
		public static Summoner summoner;
		public static List<GameStatistics> recentGames;
		List<SummonerLeagues> sLeagues;
		List<LifetimeStatistics> stats;
		public static List<Statistics> statistics;
	}
	
	public static class SoData {
		public Data data;
	}
	
	// Gettin down to business. Asynctask to grab all the data from elophant
	public class PostFetcher extends AsyncTask<String, Void, PostFetchResult> {
		private Activity ownerActivity;
		private Context context;
		private ProgressDialog dialog;
		private Context cxtTwo;
		SharedPreferences sharedPrefs;
		
		// gotta love context
		public PostFetcher(Context cxt, Activity activity, Context contextTwo) {
			context = cxt;
			dialog = new ProgressDialog(context);
			this.ownerActivity = activity;
			cxtTwo = contextTwo;
		};
		
		
		

		@Override
		protected PostFetchResult doInBackground(String... urls) {
			// get holder class
			PostFetchResult result = new PostFetchResult(); 
			
			// get user preferences
			sharedPrefs = PreferenceManager.getDefaultSharedPreferences(cxtTwo); 
			
			// URL for summoner info
			final String SERVER_URL_SUMMONER = "http://api.elophant.com/v2/" + sharedPrefs.getString("user_region", "NA") 
					+ "/summoner/" + name.replace(" ", "") + "?key=eS4XmrLVhc7EhPson8dV"; 	
			// get summoner info (thanks GSON!)
			PostFetchResult.summoner = JsonUtil.fromJsonUrl(SERVER_URL_SUMMONER, Summoner.class);
			
			try {
				
				// if we got a result from the Summoner request, proceed to getting the other data
				if (PostFetchResult.summoner.getSuccess() == true) {
					
					// set acctId & summonerId, they'll be useful later on
					String acctId = PostFetchResult.summoner.getData().getAcctId().toString();
					String summonerId = PostFetchResult.summoner.getData().getSummonerId().toString();
					
					// get recent matches info 
					PostFetchResult.recentGames = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/" + sharedPrefs.getString("user_region", "NA") 
							+ "/recent_games/" + acctId.toString() + "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getGameStatistics();
					
					// try to get summoner leagues, not all players (lvl < 30) will have this
					try {	
						result.sLeagues = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/" + sharedPrefs.getString("user_region", "NA") 
								+ "/leagues/" + summonerId.toString() + "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getSummonerLeagues(); 
					} catch (NullPointerException e) {
						Log.w("Summoner Leagues", "Summoner Leagues was null");
					}
					
					// try to get lifetime stats, not all players will have this
					try {					
						result.stats = JsonUtil.fromJsonUrl("http://api.elophant.com/v2/" + sharedPrefs.getString("user_region", "NA") 
								+ "/ranked_stats/" + acctId.toString() + "?key=eS4XmrLVhc7EhPson8dV", SoData.class).data.getLifetimeStatistics();
					} catch (NullPointerException e) {
						Log.w("Ranked Stats", "Ranked Stats was null");
					}
					
				}
				
			} catch (NullPointerException e) {
				Log.w("doInBackground recentGames", "Recent Games error: " + e.getMessage());
				e.printStackTrace();
			}
			
			
			return result;
			
		}
		
		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			
			// setup & show the loading indicator
			dialog = ProgressDialog.show(context, "", "Loading " + name + "'s match history...", true);
			dialog.show();
			
		}

		@Override
		protected void onPostExecute(PostFetchResult result) {
			// get the ListView for recent games
			ListView lv = MatchHistoryFragment.lv;
			
			// close the loading indicator
			dialog.cancel();
			
			// define some variables to be used later
			int gamesPlayed = 0;
			int gamesWon = 0;
			int gamesLost = 0;
			
			// try to set all applicable data
			try {
				if (PostFetchResult.summoner != null) {
					
					// set action bar title to summoner name
					summonerName = PostFetchResult.summoner.getData().getName();
					actionBar.setTitle(summonerName);
					
					// set action bar icon to summoner icon
					switch (PostFetchResult.summoner.getData().getProfileIconId().intValue()) {
					case 0:
						actionBar.setIcon(R.drawable.profileicon01);
						break;
					case 1:
						actionBar.setIcon(R.drawable.profileicon02);
						break;
					case 2:
						actionBar.setIcon(R.drawable.profileicon03);
						break;
					case 3:
						actionBar.setIcon(R.drawable.profileicon04);
						break;
					case 4:
						actionBar.setIcon(R.drawable.profileicon05);
						break;
					case 5:
						actionBar.setIcon(R.drawable.profileicon06);
						break;
					case 6:
						actionBar.setIcon(R.drawable.profileicon07);
						break;
					case 7:
						actionBar.setIcon(R.drawable.profileicon08);
						break;
					case 8:
						actionBar.setIcon(R.drawable.profileicon09);
						break;
					case 9:
						actionBar.setIcon(R.drawable.profileicon10);
						break;
					case 10:
						actionBar.setIcon(R.drawable.profileicon11);
						break;
					case 11:
						actionBar.setIcon(R.drawable.profileicon12);
						break;
					case 12:
						actionBar.setIcon(R.drawable.profileicon13);
						break;
					case 13:
						actionBar.setIcon(R.drawable.profileicon14);
						break;
					case 14:
						actionBar.setIcon(R.drawable.profileicon15);
						break;
					case 15:
						actionBar.setIcon(R.drawable.profileicon16);
						break;
					case 16:
						actionBar.setIcon(R.drawable.profileicon17);
						break;
					case 17:
						actionBar.setIcon(R.drawable.profileicon18);
						break;
					case 18:
						actionBar.setIcon(R.drawable.profileicon19);
						break;
					case 19:
						actionBar.setIcon(R.drawable.profileicon20);
						break;
					case 20:
						actionBar.setIcon(R.drawable.profileicon21);
						break;
					case 21:
						actionBar.setIcon(R.drawable.profileicon22);
						break;
					case 22:
						actionBar.setIcon(R.drawable.profileicon23);
						break;
					case 23:
						actionBar.setIcon(R.drawable.profileicon24);
						break;
					case 24:
						actionBar.setIcon(R.drawable.profileicon25);
						break;
					case 25:
						actionBar.setIcon(R.drawable.profileicon26);
						break;
					case 26:
						actionBar.setIcon(R.drawable.profileicon27);
						break;
					case 27:
						actionBar.setIcon(R.drawable.profileicon28);
						break;
					case 28:
						actionBar.setIcon(R.drawable.profileicon29);
						break;
					case 29:
						actionBar.setIcon(R.drawable.profile_icon_29);
						break;
					case 30:
						actionBar.setIcon(R.drawable.profile_icon_30);
						break;
					case 31:
						actionBar.setIcon(R.drawable.profile_icon_31);
						break;
					case 502:
						actionBar.setIcon(R.drawable.profileicon30);
						break;
					case 503:
						actionBar.setIcon(R.drawable.profileicon32);
						break;
					case 504:
						actionBar.setIcon(R.drawable.profileicon34);
						break;
					case 505:
						actionBar.setIcon(R.drawable.profileicon36);
						break;
					case 506:
						actionBar.setIcon(R.drawable.profileicon35);
						break;
					case 507:
						actionBar.setIcon(R.drawable.profileicon33);
						break;
					case 508:
						actionBar.setIcon(R.drawable.profileicon31);
						break;
					case 509:
						actionBar.setIcon(R.drawable.profileicon42);
						break;
					case 510:
						actionBar.setIcon(R.drawable.profileicon43);
						break;
					case 511:
						actionBar.setIcon(R.drawable.profileicon44);
						break;
					case 512:
						actionBar.setIcon(R.drawable.profileicon37);
						break;
					case 513:
						actionBar.setIcon(R.drawable.profileicon41);
						break;
					case 514:
						actionBar.setIcon(R.drawable.profileicon46);
						break;
					case 515:
						actionBar.setIcon(R.drawable.profileicon47);
						break;
					case 516:
						actionBar.setIcon(R.drawable.profileicon48);
						break;
					case 517:
						actionBar.setIcon(R.drawable.profileicon38);
						break;
					case 518:
						actionBar.setIcon(R.drawable.profileicon45);
						break;
					case 519:
						actionBar.setIcon(R.drawable.profileicon50);
						break;
					case 520:
						actionBar.setIcon(R.drawable.profileicon51);
						break;
					case 521:
						actionBar.setIcon(R.drawable.profileicon52);
						break;
					case 522:
						actionBar.setIcon(R.drawable.profileicon39);
						break;
					case 523:
						actionBar.setIcon(R.drawable.profileicon49);
						break;
					case 524:
						actionBar.setIcon(R.drawable.profileicon54);
						break;
					case 525:
						actionBar.setIcon(R.drawable.profileicon55);
						break;
					case 526:
						actionBar.setIcon(R.drawable.profileicon56);
						break;
					case 527:
						actionBar.setIcon(R.drawable.profileicon40);
						break;
					case 528:
						actionBar.setIcon(R.drawable.profileicon53);
						break;
					case 529:
						actionBar.setIcon(R.drawable.profileicon58);
						break;
					case 530:
						actionBar.setIcon(R.drawable.profileicon59);
						break;
					case 531:
						actionBar.setIcon(R.drawable.profileicon60);
						break;
					case 532:
						actionBar.setIcon(R.drawable.profileicon57);
						break;
					case 533:
						actionBar.setIcon(R.drawable.master_beta_tester);
						break;
					case 534:
						actionBar.setIcon(R.drawable.grand_master_beta_tester);
						break;
					case 535:
						actionBar.setIcon(R.drawable.profileicon66);
						break;
					case 536:
						actionBar.setIcon(R.drawable.profileicon61);
						break;
					case 537:
						actionBar.setIcon(R.drawable.profileicon64);
						break;
					case 538:
						actionBar.setIcon(R.drawable.profile_icon_lunar_2013_urf);
						break;
					case 539:
						actionBar.setIcon(R.drawable.profileicon62);
						break;
					case 540:
						actionBar.setIcon(R.drawable.profileicon63);
						break;
					case 541:
						actionBar.setIcon(R.drawable.profile_icon_lunar_2013_envelope);
						break;
					case 542:
						actionBar.setIcon(R.drawable.profile_icon_lunar_2013_keeper);
						break;
					case 543:
						actionBar.setIcon(R.drawable.profile_icon_lunar_2013_urf);
						break;
					case 544:
						actionBar.setIcon(R.drawable.profile_icon_lunar_2013_lantern);
						break;
					case 545:
						actionBar.setIcon(R.drawable.profile_icon_lunar_2013_snake);
						break;
					case 546:
						actionBar.setIcon(R.drawable.profileicon_avarosan);
						break;
					case 547:
						actionBar.setIcon(R.drawable.profileicon_winters_claw);
						break;
					case 548:
						actionBar.setIcon(R.drawable.frostguard);
						break;
					case 549:
						actionBar.setIcon(R.drawable.profileicon67);
						break;
					case 550:
						actionBar.setIcon(R.drawable.profileicon69);
						break;
					case 551:
						actionBar.setIcon(R.drawable.profileicon68);
						break;
					case 552:
						actionBar.setIcon(R.drawable.profileicon70);
						break;
					case 553:
						actionBar.setIcon(R.drawable.latin_america_beta_tester);
						break;
					case 554:
						actionBar.setIcon(R.drawable.profileicon72);
						break;
					case 555:
						actionBar.setIcon(R.drawable.profileicon73);
						break;
					case 556:
						actionBar.setIcon(R.drawable.profileicon74);
						break;
					case 557:
						actionBar.setIcon(R.drawable.profileicon75);
						break;
					case 558:
						actionBar.setIcon(R.drawable.profileicon76);
						break;
					case 559:
						actionBar.setIcon(R.drawable.profileicon77);
						break;
					case 560:
						actionBar.setIcon(R.drawable.profileicon78);
						break;
					case 561:
						actionBar.setIcon(R.drawable.profileicon71);
						break;
					case 562:
						actionBar.setIcon(R.drawable.profileicon80);
						break;
					case 563:
						actionBar.setIcon(R.drawable.profileicon81);
						break;
					case 564:
						actionBar.setIcon(R.drawable.profileicon82);
						break;
					case 565:
						actionBar.setIcon(R.drawable.profileicon83);
						break;
					case 566:
						actionBar.setIcon(R.drawable.profileicon84);
						break;
					case 567:
						actionBar.setIcon(R.drawable.profileicon85);
						break;
					case 568:
						actionBar.setIcon(R.drawable.profileicon568);
						break;
					case 569:
						actionBar.setIcon(R.drawable.profileicon79);
						break;
					default:
						actionBar.setIcon(R.drawable.ability);
						break;
					}
				}
				
				if (result.stats != null) {					
					// get lifetime stats
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
				} 
				
				if (PostFetchResult.recentGames != null)
				{	
					// set up arraylist with data from elophant for LazyAdapter
					numOfRecentGames = PostFetchResult.recentGames.size();
					someArrayList = new ArrayList<GameStatistics>();
					for(GameStatistics stats : PostFetchResult.recentGames)
					{
						someArrayList.add(stats);
					}					
				}
				
				if (result.sLeagues != null)
				{	
					// set profile page, including ranked tiers & w/l
					for(SummonerLeagues summonerLeagues : result.sLeagues)
					{
						if(summonerLeagues.getQueue().equals("RANKED_TEAM_5x5")) {
							teamFiveLeague = summonerLeagues.getName().toString();
							teamFiveRank = summonerLeagues.getRequestorsRank().toString();
							teamFiveTier = summonerLeagues.getTier().toString();
							
							// set Ranked Team 5v5 data
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
							} else {
								ivTeamFive.setImageResource(R.drawable.unknown);
								tvFiveDivision.setText("No Rating");
								tvFiveLP.setText("");
								tvFiveLosses.setText("0");
								tvFiveWins.setText("0");
							}
						} 
						// set Ranked Team 3v3 data
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
							} else {
								ivTeamThree.setImageResource(R.drawable.unknown);
								tvThreeDivision.setText("No Rating");
								tvThreeLP.setText("");
								tvThreeLosses.setText("0");
								tvThreeWins.setText("0");
							}
						} 
						// set Solo Queue data
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
							} else {
								
							}
							
						} 
						// show all the views we hid now that we have data
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
						// aaaaand close the search box if we're successful
						MenuItemCompat.collapseActionView(searchItem);
						
						// If player is only ranked in one queue, set the other queues to default values
						if (result.sLeagues.size() == 1) {
							if (summonerLeagues.getQueue().equals("RANKED_SOLO_5x5")) {
								ivTeamFive.setImageResource(R.drawable.unknown);
								tvFiveDivision.setText("No Rating");
								tvFiveLP.setText("");
								tvFiveLosses.setText("0");
								tvFiveWins.setText("0");
								ivTeamThree.setImageResource(R.drawable.unknown);
								tvThreeDivision.setText("No Rating");
								tvThreeLP.setText("");
								tvThreeLosses.setText("0");
								tvThreeWins.setText("0");
							} else if (summonerLeagues.getQueue().equals("RANKED_TEAM_5x5")) {
								ivSoloFive.setImageResource(R.drawable.unknown);
								tvSoloDivision.setText("No Rating");
								tvSoloLP.setText("");
								tvSoloLosses.setText("0");
								tvSoloWins.setText("0");
								ivTeamThree.setImageResource(R.drawable.unknown);
								tvThreeDivision.setText("No Rating");
								tvThreeLP.setText("");
								tvThreeLosses.setText("0");
								tvThreeWins.setText("0");
							} else if (summonerLeagues.getQueue().equals("RANKED_TEAM_3x3")) {
								ivTeamFive.setImageResource(R.drawable.unknown);
								tvFiveDivision.setText("No Rating");
								tvFiveLP.setText("");
								tvFiveLosses.setText("0");
								tvFiveWins.setText("0");
								ivSoloFive.setImageResource(R.drawable.unknown);
								tvSoloDivision.setText("No Rating");
								tvSoloLP.setText("");
								tvSoloLosses.setText("0");
								tvSoloWins.setText("0");
							}
						}
						// if the player is ranked in 2 queues, but not all 3, show default values for the correct queue
						else if (result.sLeagues.size() == 2) {
							// if no solo queue rating
							if ((result.sLeagues.get(0).getQueue().equals("RANKED_TEAM_5x5") 
									&& result.sLeagues.get(1).getQueue().equals("RANKED_TEAM_3x3")) 
									|| (result.sLeagues.get(1).getQueue().equals("RANKED_TEAM_5x5") 
											&& result.sLeagues.get(0).getQueue().equals("RANKED_TEAM_3x3")) ) {
								ivSoloFive.setImageResource(R.drawable.unknown);
								tvSoloDivision.setText("No Rating");
								tvSoloLP.setText("");
								tvSoloLosses.setText("0");
								tvSoloWins.setText("0");
							} 
							// if no ranked team 5v5 rating
							else if ((result.sLeagues.get(0).getQueue().equals("RANKED_SOLO_5x5") 
									&& result.sLeagues.get(1).getQueue().equals("RANKED_TEAM_3x3")) 
									|| (result.sLeagues.get(1).getQueue().equals("RANKED_SOLO_5x5") 
											&& result.sLeagues.get(0).getQueue().equals("RANKED_TEAM_3x3")) ) {
								ivTeamFive.setImageResource(R.drawable.unknown);
								tvFiveDivision.setText("No Rating");
								tvFiveLP.setText("");
								tvFiveLosses.setText("0");
								tvFiveWins.setText("0");
							} 
							// if no ranked team 3v3 rating
							else if ((result.sLeagues.get(0).getQueue().equals("RANKED_SOLO_5x5") 
									&& result.sLeagues.get(1).getQueue().equals("RANKED_TEAM_5x5")) 
									|| (result.sLeagues.get(1).getQueue().equals("RANKED_SOLO_5x5") 
											&& result.sLeagues.get(0).getQueue().equals("RANKED_TEAM_5x5")) ) {
								ivTeamThree.setImageResource(R.drawable.unknown);
								tvThreeDivision.setText("No Rating");
								tvThreeLP.setText("");
								tvThreeLosses.setText("0");
								tvThreeWins.setText("0");
							}
						} else if (result.sLeagues.size() >= 3) {
							
						} 
					} 	
					
					// set up the ListView with its adapter & data
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
					
				} else {
					// if we didn't get anything back, set this stuff invisible again.
					Crouton.showText(ownerActivity, "Summoner \"" + name + "\" not found, or server is busy.",
							de.keyboardsurfer.android.widget.crouton.Style.ALERT);
					ivSoloFive.setVisibility(View.INVISIBLE);
					ivTeamFive.setVisibility(View.INVISIBLE);
					ivTeamThree.setVisibility(View.INVISIBLE);
					tvDebugOne.setVisibility(View.INVISIBLE);
					tvDebugTwo.setVisibility(View.INVISIBLE);
					tvDebugThree.setVisibility(View.INVISIBLE);
					tvThreeDivision.setVisibility(View.INVISIBLE);
					tvSoloDivision.setVisibility(View.INVISIBLE);
					tvFiveDivision.setVisibility(View.INVISIBLE);
					tvThreeLP.setVisibility(View.INVISIBLE);
					tvSoloLP.setVisibility(View.INVISIBLE);
					tvFiveLP.setVisibility(View.INVISIBLE);
					tvThreeWins.setVisibility(View.INVISIBLE);
					tvSoloWins.setVisibility(View.INVISIBLE);
					tvFiveWins.setVisibility(View.INVISIBLE);
					tvFiveLosses.setVisibility(View.INVISIBLE);
					tvThreeLosses.setVisibility(View.INVISIBLE);
					tvSoloLosses.setVisibility(View.INVISIBLE);
					winsThree.setVisibility(View.INVISIBLE);
					winsSolo.setVisibility(View.INVISIBLE);
					winsFive.setVisibility(View.INVISIBLE);
					lossesFive.setVisibility(View.INVISIBLE);
					lossesThree.setVisibility(View.INVISIBLE);
					lossesSolo.setVisibility(View.INVISIBLE);
				}			
			} catch (NullPointerException e){
				if (PostFetchResult.summoner.getSuccess() == false) {
					if (PostFetchResult.summoner.getError().equals("The global rate limit has been exceeded.")) {
						Crouton.showText(ownerActivity, "Summoner \"" + name + "\" not found, or server is busy.", 
								de.keyboardsurfer.android.widget.crouton.Style.ALERT);
					} else if (PostFetchResult.summoner.getError().equals("No active connection found for the given region.")) {
						Crouton.showText(ownerActivity, "Server not responding: No connection to region \"" + 
						sharedPrefs.getString("user_region", "NA") + "\", please try again later.", 
						de.keyboardsurfer.android.widget.crouton.Style.ALERT);
					}	
				} else {
					Crouton.showText(ownerActivity, "Summoner \"" + name + "\" not found, or server is busy.", 
							de.keyboardsurfer.android.widget.crouton.Style.ALERT);
				}
				
				
				Log.w("Oops", "An error occured: " + e.getMessage());
				e.printStackTrace();
				
			}
			
		}
	}

}
