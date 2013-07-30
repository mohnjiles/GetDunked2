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
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;


public class AnotherAsyncTask {

	ArrayList<GameStatistics> someArrayList;
	
	PopupWindow pWindow = MatchHistoryFragment.pwindo;

	TextView tvChampKills = MatchHistoryFragment.tvChampKills;
	TextView tvDeaths = MatchHistoryFragment.tvDeaths;
	TextView tvAssists = MatchHistoryFragment.tvAssists;
	TextView tvKillingSpree = MatchHistoryFragment.tvKillingSpree;
	TextView tvDamageToChamps = MatchHistoryFragment.tvDamageToChamps;
	TextView tvPhysicalToChamps = MatchHistoryFragment.tvPhysicalToChamps;
	TextView tvMagicToChamps = MatchHistoryFragment.tvMagicToChamps;
	TextView tvDamageDealt = MatchHistoryFragment.tvDamageDealt;
	TextView tvPhysicalDamage = MatchHistoryFragment.tvPhysicalDamage;
	TextView tvPhysicalTaken = MatchHistoryFragment.tvPhysicalTaken;
	TextView tvMagicTaken = MatchHistoryFragment.tvMagicTaken;
	TextView tvMagicDamage = MatchHistoryFragment.tvMagicDamage;
	TextView tvLargestCrit = MatchHistoryFragment.tvLargestCrit;
	TextView tvTurrets = MatchHistoryFragment.tvTurrets;
	TextView tvInhibitors = MatchHistoryFragment.tvInhibitors;
	TextView tvDamageTaken = MatchHistoryFragment.tvDamageTaken;
	TextView tvHealingDone = MatchHistoryFragment.tvHealingDone;
	TextView tvGold = MatchHistoryFragment.tvGold;
	TextView tvMultiKill = MatchHistoryFragment.tvMultiKill;
	TextView tvTimeDead = MatchHistoryFragment.tvTimeDead;
	TextView tvWardsPlaced = MatchHistoryFragment.tvWardsPlaced;
	TextView tvWardsKilled = MatchHistoryFragment.tvWardsKilled;
	TextView tvMinionsKilled = MatchHistoryFragment.tvMinionsKilled;
	TextView tvNeutralMinionsKilled = MatchHistoryFragment.tvNeutralMinionsKilled;
	TextView tvChampName = MatchHistoryFragment.tvChampName;
	
	ImageView ivChampIcon = MatchHistoryFragment.ivChampIcon;
	
	String name = ProfileMainActivity.name;
	
	Number champKills = null;
	Number deaths = null;
	Number assists = null;
	Number killingSpree = null;
	Number damageToChamps = null;
	Number physicalToChamps = null;
	Number magicToChamps = null;
	Number damageDealt = null;
	Number physicalDamage = null;
	Number magicDamage = null;
	Number largestCrit = null;
	Number damageTaken = null;
	Number physicalTaken = null;
	Number magicTaken = null;
	Number turrets = null;
	Number inhibitors = null;
	Number healingDone = null;
	Number gold = null;
	Number multiKill = null;
	Number timeDead = null;
	Number wardsPlaced = null;
	Number wardsKilled = null;
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
					switch (result.recentGames.get(position).getChampionId().intValue()) {
					case 1:
						ivChampIcon.setImageResource(R.drawable.anniesquare);
						tvChampName.setText("Annie");
						break;
					case 2:
						ivChampIcon.setImageResource(R.drawable.olafsquare);
						tvChampName.setText("Olaf");
						break;
					case 3:
						ivChampIcon.setImageResource(R.drawable.galiosquare);
						tvChampName.setText("Galio");
						break;
					case 4:
						ivChampIcon.setImageResource(R.drawable.twistedfatesquare);
						tvChampName.setText("Twisted Fate");
						break;
					case 5:
						ivChampIcon.setImageResource(R.drawable.xinzhaosquare);
						tvChampName.setText("Xin Zhao");
						break;
					case 6:
						ivChampIcon.setImageResource(R.drawable.urgotsquare);
						tvChampName.setText("Urgot");
						break;
					case 7:
						ivChampIcon.setImageResource(R.drawable.leblancsquare);
						tvChampName.setText("LeBlanc");
						break;
					case 8:
						ivChampIcon.setImageResource(R.drawable.vladimirsquare);
						tvChampName.setText("Vladimir");
						break;
					case 9:
						ivChampIcon.setImageResource(R.drawable.fiddlestickssquare);
						tvChampName.setText("Fiddlesticks");
						break;
					case 10:
						ivChampIcon.setImageResource(R.drawable.kaylesquare);
						tvChampName.setText("Kayle");
						break;
					case 11:
						ivChampIcon.setImageResource(R.drawable.masteryisquare);
						tvChampName.setText("Master Yi");
						break;
					case 12:
						ivChampIcon.setImageResource(R.drawable.alistarsquare);
						tvChampName.setText("Alistar");
						break;
					case 13:
						ivChampIcon.setImageResource(R.drawable.ryzesquare);
						tvChampName.setText("Ryze");
						break;
					case 14:
						ivChampIcon.setImageResource(R.drawable.sionsquare);
						tvChampName.setText("Sion");
						break;
					case 15:
						ivChampIcon.setImageResource(R.drawable.sivirsquare);
						tvChampName.setText("Sivir");
						break;
					case 16:
						ivChampIcon.setImageResource(R.drawable.sorakasquare);
						tvChampName.setText("Soraka");
						break;
					case 17:
						ivChampIcon.setImageResource(R.drawable.teemosquare);
						tvChampName.setText("Teemo");
						break;
					case 18:
						ivChampIcon.setImageResource(R.drawable.tristanasquare);
						tvChampName.setText("Tristana");
						break;
					case 19:
						ivChampIcon.setImageResource(R.drawable.warwicksquare);
						tvChampName.setText("Warwick");
						break;
					case 20:
						ivChampIcon.setImageResource(R.drawable.nunusquare);
						tvChampName.setText("Nunu");
						break;
					case 21:
						ivChampIcon.setImageResource(R.drawable.missfortunesquare);
						tvChampName.setText("Miss Fortune");
						break;
					case 22:
						ivChampIcon.setImageResource(R.drawable.ashesquare);
						tvChampName.setText("Ashe");
						break;
					case 23:
						ivChampIcon.setImageResource(R.drawable.tryndameresquare);
						tvChampName.setText("Tryndamere");
						break;
					case 24:
						ivChampIcon.setImageResource(R.drawable.jaxsquare);
						tvChampName.setText("Jax");
						break;
					case 25:
						ivChampIcon.setImageResource(R.drawable.morganasquare);
						tvChampName.setText("Morgana");
						break;
					case 26:
						ivChampIcon.setImageResource(R.drawable.zileansquare);
						tvChampName.setText("Zilean");
						break;
					case 27:
						ivChampIcon.setImageResource(R.drawable.singedsquare);
						tvChampName.setText("Singed");
						break;
					case 28:
						ivChampIcon.setImageResource(R.drawable.evelynnsquare);
						tvChampName.setText("Evelynn");
						break;
					case 29:
						ivChampIcon.setImageResource(R.drawable.twitchsquare);
						tvChampName.setText("Twitch");
						break;
					case 30:
						ivChampIcon.setImageResource(R.drawable.karthussquare);
						tvChampName.setText("Karthus");
						break;
					case 31:
						ivChampIcon.setImageResource(R.drawable.chogathsquare);
						tvChampName.setText("Cho'Gath");
						break;
					case 32:
						ivChampIcon.setImageResource(R.drawable.amumusquare);
						tvChampName.setText("Amumu");
						break;
					case 33:
						ivChampIcon.setImageResource(R.drawable.rammussquare);
						tvChampName.setText("Rammus");
						break;
					case 34:
						ivChampIcon.setImageResource(R.drawable.aniviasquare);
						tvChampName.setText("Anivia");
						break;
					case 35:
						ivChampIcon.setImageResource(R.drawable.shacosquare);
						tvChampName.setText("Shaco");
						break;
					case 36:
						ivChampIcon.setImageResource(R.drawable.drmundosquare);
						tvChampName.setText("Dr. Mundo");
						break;
					case 37:
						ivChampIcon.setImageResource(R.drawable.sonasquare);
						tvChampName.setText("Sona");
						break;
					case 38:
						ivChampIcon.setImageResource(R.drawable.kassadinsquare);
						tvChampName.setText("Kassadin");
						break;
					case 39:
						ivChampIcon.setImageResource(R.drawable.ireliasquare);
						tvChampName.setText("Irelia");
						break;
					case 40:
						ivChampIcon.setImageResource(R.drawable.jannasquare);
						tvChampName.setText("Janna");
						break;
					case 41:
						ivChampIcon.setImageResource(R.drawable.gangplanksquare);
						tvChampName.setText("Gangplank");
						break;
					case 42:
						ivChampIcon.setImageResource(R.drawable.corkisquare);
						tvChampName.setText("Corki");
						break;
					case 43:
						ivChampIcon.setImageResource(R.drawable.karmasquare);
						tvChampName.setText("Karma");
						break;
					case 44:
						ivChampIcon.setImageResource(R.drawable.taricsquare);
						tvChampName.setText("Taric");
						break;
					case 45:
						ivChampIcon.setImageResource(R.drawable.veigarsquare);
						tvChampName.setText("Veigar");
						break;
					case 48:
						ivChampIcon.setImageResource(R.drawable.trundlesquare);
						tvChampName.setText("Trundle");
						break;
					case 50:
						ivChampIcon.setImageResource(R.drawable.swainsquare);
						tvChampName.setText("Swain");
						break;
					case 51:
						ivChampIcon.setImageResource(R.drawable.caitlynsquare);
						tvChampName.setText("Caitlyn");
						break;
					case 53:
						ivChampIcon.setImageResource(R.drawable.blitzcranksquare);
						tvChampName.setText("Blitzcrank");
						break;
					case 54:
						ivChampIcon.setImageResource(R.drawable.malphitesquare);
						tvChampName.setText("Malphite");
						break;
					case 55:
						ivChampIcon.setImageResource(R.drawable.katarinasquare);
						tvChampName.setText("Katarina");
						break;
					case 56:
						ivChampIcon.setImageResource(R.drawable.nocturnesquare);
						tvChampName.setText("Nocturne");
						break;
					case 57:
						ivChampIcon.setImageResource(R.drawable.maokaisquare);
						tvChampName.setText("Maokai");
						break;
					case 58:
						ivChampIcon.setImageResource(R.drawable.renektonsquare);
						tvChampName.setText("Renekton");
						break;
					case 59:
						ivChampIcon.setImageResource(R.drawable.jarvanivsquare);
						tvChampName.setText("Jarvan IV");
						break;
					case 60:
						ivChampIcon.setImageResource(R.drawable.elisesquare);
						tvChampName.setText("Elise");
						break;
					case 61:
						ivChampIcon.setImageResource(R.drawable.oriannasquare);
						tvChampName.setText("Orianna");
						break;
					case 62:
						ivChampIcon.setImageResource(R.drawable.wukongsquare);
						tvChampName.setText("Wukong");
						break;
					case 63:
						ivChampIcon.setImageResource(R.drawable.brandsquare);
						tvChampName.setText("Brand");
						break;
					case 64:
						ivChampIcon.setImageResource(R.drawable.leesinsquare);
						tvChampName.setText("Lee Sin");
						break;
					case 67:
						ivChampIcon.setImageResource(R.drawable.vaynesquare);
						tvChampName.setText("Vayne");
						break;
					case 68:
						ivChampIcon.setImageResource(R.drawable.rumblesquare);
						tvChampName.setText("Rumble");
						break;
					case 69:
						ivChampIcon.setImageResource(R.drawable.cassiopeiasquare);
						tvChampName.setText("Cassiopeia");
						break;
					case 72:
						ivChampIcon.setImageResource(R.drawable.skarnersquare);
						tvChampName.setText("Skarner");
						break;
					case 74:
						ivChampIcon.setImageResource(R.drawable.heimerdingersquare);
						tvChampName.setText("Heimerdinger");
						break;
					case 75:
						ivChampIcon.setImageResource(R.drawable.nasussquare);
						tvChampName.setText("Nasus");
						break;
					case 76:
						ivChampIcon.setImageResource(R.drawable.nidaleesquare);
						tvChampName.setText("Nidalee");
						break;
					case 77:
						ivChampIcon.setImageResource(R.drawable.udyrsquare);
						tvChampName.setText("Udyr");
						break;
					case 78:
						ivChampIcon.setImageResource(R.drawable.poppysquare);
						tvChampName.setText("Poppy");
						break;
					case 79:
						ivChampIcon.setImageResource(R.drawable.gragassquare);
						tvChampName.setText("Gragas");
						break;
					case 80:
						ivChampIcon.setImageResource(R.drawable.pantheonsquare);
						tvChampName.setText("Pantheon");
						break;
					case 81:
						ivChampIcon.setImageResource(R.drawable.ezrealsquare);
						tvChampName.setText("Ezreal");
						break;
					case 82:
						ivChampIcon.setImageResource(R.drawable.mordekaisersquare);
						tvChampName.setText("Mordekaiser");
						break;
					case 83:
						ivChampIcon.setImageResource(R.drawable.yoricksquare);
						tvChampName.setText("Yorick");
						break;
					case 84:
						ivChampIcon.setImageResource(R.drawable.akalisquare);
						tvChampName.setText("Akali");
						break;
					case 85:
						ivChampIcon.setImageResource(R.drawable.kennensquare);
						tvChampName.setText("Kennen");
						break;
					case 86:
						ivChampIcon.setImageResource(R.drawable.garensquare);
						tvChampName.setText("Garen");
						break;
					case 89:
						ivChampIcon.setImageResource(R.drawable.leonasquare);
						tvChampName.setText("Leona");
						break;
					case 90:
						ivChampIcon.setImageResource(R.drawable.malzaharsquare);
						tvChampName.setText("Malzahar");
						break;
					case 91:
						ivChampIcon.setImageResource(R.drawable.talonsquare);
						tvChampName.setText("Talon");
						break;
					case 92:
						ivChampIcon.setImageResource(R.drawable.rivensquare);
						tvChampName.setText("Riven");
						break;
					case 96:
						ivChampIcon.setImageResource(R.drawable.kogmawsquare);
						tvChampName.setText("Kog'Maw");
						break;
					case 98:
						ivChampIcon.setImageResource(R.drawable.shensquare);
						tvChampName.setText("Shen");
						break;
					case 99:
						ivChampIcon.setImageResource(R.drawable.luxsquare);
						tvChampName.setText("Lux");
						break;
					case 101:
						ivChampIcon.setImageResource(R.drawable.xerathsquare);
						tvChampName.setText("Xerath");
						break;
					case 102:
						ivChampIcon.setImageResource(R.drawable.shyvanasquare);
						tvChampName.setText("Shyvana");
						break;
					case 103:
						ivChampIcon.setImageResource(R.drawable.ahrisquare);
						tvChampName.setText("Ahri");
						break;
					case 104:
						ivChampIcon.setImageResource(R.drawable.gravessquare);
						tvChampName.setText("Graves");
						break;
					case 105:
						ivChampIcon.setImageResource(R.drawable.fizzsquare);
						tvChampName.setText("Fizz");
						break;
					case 106:
						ivChampIcon.setImageResource(R.drawable.volibearsquare);
						tvChampName.setText("Volibear");
						break;
					case 107:
						ivChampIcon.setImageResource(R.drawable.rengarsquare);
						tvChampName.setText("Rengar");
						break;
					case 110:
						ivChampIcon.setImageResource(R.drawable.varussquare);
						tvChampName.setText("Varus");
						break;
					case 111:
						ivChampIcon.setImageResource(R.drawable.nautilussquare);
						tvChampName.setText("Nautilus");
						break;
					case 112:
						ivChampIcon.setImageResource(R.drawable.viktorsquare);
						tvChampName.setText("Viktor");
						break;
					case 113:
						ivChampIcon.setImageResource(R.drawable.sejuanisquare);
						tvChampName.setText("Sejuani");
						break;
					case 114:
						ivChampIcon.setImageResource(R.drawable.fiorasquare);
						tvChampName.setText("Fiora");
						break;
					case 115:
						ivChampIcon.setImageResource(R.drawable.ziggssquare);
						tvChampName.setText("Ziggs");
						break;
					case 117:
						ivChampIcon.setImageResource(R.drawable.lulusquare);
						tvChampName.setText("Lulu");
						break;
					case 119:
						ivChampIcon.setImageResource(R.drawable.dravensquare);
						tvChampName.setText("Draven");
						break;
					case 120:
						ivChampIcon.setImageResource(R.drawable.hecarimsquare);
						tvChampName.setText("Hecarim");
						break;
					case 121:
						ivChampIcon.setImageResource(R.drawable.khazixsquare);
						tvChampName.setText("Kha'Zix");
						break;
					case 122:
						ivChampIcon.setImageResource(R.drawable.dariussquare);
						tvChampName.setText("Darius");
						break;
					case 126:
						ivChampIcon.setImageResource(R.drawable.jaycesquare);
						tvChampName.setText("Jayce");
						break;
					case 127:
						ivChampIcon.setImageResource(R.drawable.lissandrasquare);
						tvChampName.setText("Lissandra");
						break;
					case 131:
						ivChampIcon.setImageResource(R.drawable.dianasquare);
						tvChampName.setText("Diana");
						break;
					case 133:
						ivChampIcon.setImageResource(R.drawable.quinnsquare);
						tvChampName.setText("Quinn");
						break;
					case 134:
						ivChampIcon.setImageResource(R.drawable.syndrasquare2);
						tvChampName.setText("Syndra");
						break;
					case 143:
						ivChampIcon.setImageResource(R.drawable.zyrasquare);
						tvChampName.setText("Zyra");
						break;
					case 154:
						ivChampIcon.setImageResource(R.drawable.zacsquare);
						tvChampName.setText("Zac");
						break;
					case 238:
						ivChampIcon.setImageResource(R.drawable.zedsquare);
						tvChampName.setText("Zed");
						break;
					case 254:
						ivChampIcon.setImageResource(R.drawable.visquare);
						tvChampName.setText("Vi");
						break;
					case 266:
						ivChampIcon.setImageResource(R.drawable.aatroxsquare);
						tvChampName.setText("Aatrox");
						break;
					case 267:
						ivChampIcon.setImageResource(R.drawable.namisquare);
						tvChampName.setText("Nami");
						break;
					case 412:
						ivChampIcon.setImageResource(R.drawable.threshsquare);
						tvChampName.setText("Thresh");
						break;
					}
					for (Statistics stats : result.recentGames.get(position).getStatistics()) {
						
						if (stats.getStatType().equals("TOTAL_DAMAGE_DEALT")) {
							damageDealt = stats.getValue();
						} else if (stats.getStatType().equals("TOTAL_DAMAGE_TAKEN")) {
							damageTaken = stats.getValue();
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
						} else if (stats.getStatType().equals("PHYSICAL_DAMAGE_DEALT_TO_CHAMPIONS")) {
							physicalToChamps = stats.getValue();
						} else if (stats.getStatType().equals("PHYSICAL_DAMAGE_TAKEN")) {
							physicalTaken = stats.getValue();
						} else if (stats.getStatType().equals("MAGIC_DAMAGE_DEALT_TO_CHAMPIONS")) {
							magicToChamps = stats.getValue();
						} else if (stats.getStatType().equals("TOTAL_DAMAGE_DEALT_TO_CHAMPIONS")) {
							damageToChamps = stats.getValue();
						} else if (stats.getStatType().equals("TURRETS_KILLED")) {
							turrets = stats.getValue();
						} else if (stats.getStatType().equals("LARGEST_CRITICAL_STRIKE")) {
							largestCrit = stats.getValue();
						} else if (stats.getStatType().equals("NUM_DEATHS")) {
							deaths = stats.getValue();
						} else if (stats.getStatType().equals("BARRACKS_KILLED")) {
							inhibitors = stats.getValue();
						} else if (stats.getStatType().equals("CHAMPIONS_KILLED")) {
							champKills = stats.getValue();
						} else if (stats.getStatType().equals("TOTAL_TIME_SPENT_DEAD")) {
							timeDead = stats.getValue();
						} else if (stats.getStatType().equals("ASSISTS")) {
							assists = stats.getValue();
						} else if (stats.getStatType().equals("LARGEST_KILLING_SPREE")) {
							killingSpree = stats.getValue();
						} else if (stats.getStatType().equals("MAGIC_DAMAGE_TAKEN")) {
							magicTaken = stats.getValue();
						} else if (stats.getStatType().equals("WARD_KILLED")) {
							wardsKilled = stats.getValue();
						} else if (stats.getStatType().equals("MAGIC_DAMAGE_DEALT_PLAYER")) {
							magicDamage = stats.getValue();
						} else if (stats.getStatType().equals("PHYSICAL_DAMAGE_DEALT_PLAYER")) {
							physicalDamage = stats.getValue();
						}
						
						
						// Set Minions Killed
						if (minionsKilled != null) {
							tvMinionsKilled.setText(minionsKilled.toString());
						}
						
						// Neutral Minions Killed
						if (neutralMinionsKilled != null) {
							tvNeutralMinionsKilled.setText(neutralMinionsKilled.toString());
						}
						
						// Set Damage Dealt
						if (damageDealt != null) {
							String number = damageDealt.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvDamageDealt.setText(formatter.format(amount).toString());
						}

						// Set Damage Taken
						if (damageTaken != null) {
							String number = damageTaken.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvDamageTaken.setText(formatter.format(amount).toString());
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
							String number = timeDead.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvTimeDead.setText(formatter.format(amount).toString() + " s");
						
						}
						
						// Set Wards Placed
						if (wardsPlaced != null) {
							tvWardsPlaced.setText(wardsPlaced.toString());
						}
					
						// Set Champions Killed
						if (champKills != null) {
							String number = champKills.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvChampKills.setText(formatter.format(amount).toString());
						}
						
						// Set Deaths
						if (deaths != null) {
							String number = deaths.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvDeaths.setText(formatter.format(amount).toString());
						}
						
						// Set Assists
						if (assists != null) {
							String number = assists.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvAssists.setText(formatter.format(amount).toString());
						}
						
						// Set Largest Killing Spree
						
						if (killingSpree != null) {
							String number = killingSpree.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvKillingSpree.setText(formatter.format(amount).toString());
						}
						
						// Set Damage to Champs
						if (damageToChamps != null) {
							String number = damageToChamps.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvDamageToChamps.setText(formatter.format(amount).toString());
						}
						
						// Set physical damage to champs
						if (physicalToChamps != null) {
							String number = physicalToChamps.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvPhysicalToChamps.setText(formatter.format(amount).toString());
						}
						
						// Set magic damage to champs
						if (magicToChamps != null) {
							String number = magicToChamps.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvMagicToChamps.setText(formatter.format(amount).toString());
						}
						
						// Set total physical damage dealt
						if (physicalDamage != null) {
							String number = physicalDamage.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvPhysicalDamage.setText(formatter.format(amount).toString());
						}
						
						// Set total magic damage dealt
						if (magicDamage != null) {
							String number = magicDamage.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvMagicDamage.setText(formatter.format(amount).toString());
						}
						
						// Set largest crit
						if (largestCrit != null) {
							String number = largestCrit.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvLargestCrit.setText(formatter.format(amount).toString());
						}
						
						// Set physical damage taken
						if (physicalTaken != null) {
							String number = physicalTaken.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvPhysicalTaken.setText(formatter.format(amount).toString());
						}
						
						// Set magic damage taken
						if (magicTaken != null) {
							String number = magicTaken.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvMagicTaken.setText(formatter.format(amount).toString());
						}
						
						// Set turrets destroyed
						if (turrets != null) {
							String number = turrets.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvTurrets.setText(formatter.format(amount).toString());
						}
						
						// Set inhibs destroyed
						if (inhibitors != null) {
							String number = inhibitors.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvInhibitors.setText(formatter.format(amount).toString());
						}
						
						// Set wards killed
						if (wardsKilled != null) {
							String number = wardsKilled.toString();
							double amount = Double.parseDouble(number);
							DecimalFormat formatter = new DecimalFormat("#,###");
							
							tvWardsKilled.setText(formatter.format(amount).toString());
						}
						
						
					}
				}
			} catch (Exception e) {
				Crouton.showText(ownerActivity, "Error loading " + name + "'s match info." +
						" Please try again in a few seconds.", 
						de.keyboardsurfer.android.widget.crouton.Style.ALERT);
				Log.w("onPostExecute", "" + e.getMessage() + e.getStackTrace()[2].getLineNumber());
				pWindow.dismiss();
				
				e.printStackTrace();
			}
		
		}
	}
}
