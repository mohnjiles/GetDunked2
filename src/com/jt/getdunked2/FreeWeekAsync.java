package com.jt.getdunked2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import de.keyboardsurfer.android.widget.crouton.Crouton;
import android.R.integer;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Loader.ForceLoadContentObserver;
import android.os.AsyncTask;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FreeWeekAsync {

	Document doc;
	Elements images;
	Elements classes;
	Elements weekText;
	
	ImageView ivFreeOne = FreeWeekActivity.ivFreeOne;
	ImageView ivFreeTwo = FreeWeekActivity.ivFreeTwo;
	ImageView ivFreeThree = FreeWeekActivity.ivFreeThree;
	ImageView ivFreeFour = FreeWeekActivity.ivFreeFour;
	ImageView ivFreeFive = FreeWeekActivity.ivFreeFive;
	ImageView ivFreeSix = FreeWeekActivity.ivFreeSix;
	ImageView ivFreeSeven = FreeWeekActivity.ivFreeSeven;
	ImageView ivFreeEight = FreeWeekActivity.ivFreeEight;
	ImageView ivFreeNine = FreeWeekActivity.ivFreeNine;
	ImageView ivFreeTen = FreeWeekActivity.ivFreeTen;
	
	TextView tvWeekText = FreeWeekActivity.tvWeekNum;
	TextView tvFreeOne = FreeWeekActivity.tvFreeOne;
	TextView tvFreeTwo = FreeWeekActivity.tvFreeTwo;
	TextView tvFreeThree = FreeWeekActivity.tvFreeThree;
	TextView tvFreeFour = FreeWeekActivity.tvFreeFour;
	TextView tvFreeFive = FreeWeekActivity.tvFreeFive;
	TextView tvFreeSix = FreeWeekActivity.tvFreeSix;
	TextView tvFreeSeven = FreeWeekActivity.tvFreeSeven;
	TextView tvFreeEight = FreeWeekActivity.tvFreeEight;
	TextView tvFreeNine = FreeWeekActivity.tvFreeNine;
	TextView tvFreeTen = FreeWeekActivity.tvFreeTen;
	
	public static int[] champNumber = new int[10];
	
	
	public class PostFetcher extends AsyncTask<String, Void, Document> {
		private Context context;
		private ProgressDialog dialog;
		
		public PostFetcher(Context cxt) {
			this.context = cxt;
			dialog = new ProgressDialog(context);
		}
		
		@Override
		protected Document doInBackground(String... urls) {

			try {
				//connect to LoL wiki
				doc = Jsoup.connect("http://leagueoflegends.wikia.com/wiki/Free_champion_rotation").get();
				
				classes = doc.select("ol.free_champion_rotation"); /* get list of free champs */
				weekText = doc.select("div#rotationweek"); /* get free week number */
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return doc;
			
		}
		
		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			
			// setup & show the loading indicator
			dialog = ProgressDialog.show(context, "", "Loading Free Champion Rotation...", true);
			dialog.show();
			
		}
		
		
		@Override
		protected void onPostExecute(Document document) {
			// set textview for week number 
			dialog.cancel();
			if (weekText != null) {
				tvWeekText.setText(weekText.text());
			} else {
				tvWeekText.setText("Failed to Load");
			}
			
			if (classes != null) {
				for (Element clazz : classes) { // get images from free champ rotation list only
					images = clazz.select("img[src~=(?i)\\.(png|jpeg|gif)]");
					
					for (Element image : images) { // set images for free week scrollview
						if(image.attr("data-image-name").equals("AatroxSquare.png")) {
							setFreeWeek(R.drawable.aatroxsquare, "Aatrox", 0);
							
						} else if(image.attr("data-image-name").equals("AhriSquare.png")) {
							setFreeWeek(R.drawable.ahrisquare, "Ahri", 1);
							
						} else if(image.attr("data-image-name").equals("AkaliSquare.png")) {
							setFreeWeek(R.drawable.akalisquare, "Akali", 2);
							
						} else if(image.attr("data-image-name").equals("AlistarSquare.png")) {
							setFreeWeek(R.drawable.alistarsquare, "Alistar", 3);
							
						} else if(image.attr("data-image-name").equals("AmumuSquare.png")) {
							setFreeWeek(R.drawable.amumusquare, "Amumu", 4);
							
						} else if(image.attr("data-image-name").equals("AniviaSquare.png")) {
							setFreeWeek(R.drawable.aniviasquare, "Anivia", 5);
							
						} else if(image.attr("data-image-name").equals("AnnieSquare.png")) {
							setFreeWeek(R.drawable.anniesquare, "Annie", 6);
							
						} else if(image.attr("data-image-name").equals("AsheSquare.png")) {
							setFreeWeek(R.drawable.ashesquare, "Ashe", 7);
							
						} else if(image.attr("data-image-name").equals("BlitzcrankSquare.png")) {
							setFreeWeek(R.drawable.blitzcranksquare, "Blitzcrank", 8);
							
						} else if(image.attr("data-image-name").equals("BrandSquare.png")) {
							setFreeWeek(R.drawable.brandsquare, "Brand", 9);
							
						} else if(image.attr("data-image-name").equals("CaitlynSquare.png")) {
							setFreeWeek(R.drawable.caitlynsquare, "Caitlyn", 10);
							
						} else if(image.attr("data-image-name").equals("CassiopeiaSquare.png")) {
							setFreeWeek(R.drawable.cassiopeiasquare, "Cassiopeia", 11);
							
						} else if(image.attr("data-image-name").equals("ChoGathSquare.png")) {
							setFreeWeek(R.drawable.chogathsquare, "Cho'Gath", 12);
							
						} else if(image.attr("data-image-name").equals("CorkiSquare.png")) {
							setFreeWeek(R.drawable.corkisquare, "Corki", 13);
							
						} else if(image.attr("data-image-name").equals("DariusSquare.png")) {
							setFreeWeek(R.drawable.dariussquare, "Darius", 14);
							
						} else if(image.attr("data-image-name").equals("DianaSquare.png")) {
							setFreeWeek(R.drawable.dianasquare, "Diana", 15);
							
						} else if(image.attr("data-image-name").equals("DrMundoSquare.png")) {
							setFreeWeek(R.drawable.drmundosquare, "Dr. Mundo", 16);
							
						} else if(image.attr("data-image-name").equals("DravenSquare.png")) {
							setFreeWeek(R.drawable.dravensquare, "Draven", 17);
							
						} else if(image.attr("data-image-name").equals("EliseSquare.png")) {
							setFreeWeek(R.drawable.elisesquare, "Elise", 18);
							
						} else if(image.attr("data-image-name").equals("EvelynnSquare.png")) {
							setFreeWeek(R.drawable.evelynnsquare, "Evelynn", 19);
							
						} else if(image.attr("data-image-name").equals("EzrealSquare.png")) {
							setFreeWeek(R.drawable.ezrealsquare, "Ezreal", 20);
							
						} else if(image.attr("data-image-name").equals("FiddlesticksSquare.png")) {
							setFreeWeek(R.drawable.fiddlestickssquare, "Fiddlesticks", 21);
							
						} else if(image.attr("data-image-name").equals("FioraSquare.png")) {
							setFreeWeek(R.drawable.fiorasquare, "Fiora", 22);
							
						} else if(image.attr("data-image-name").equals("FizzSquare.png")) {
							setFreeWeek(R.drawable.fizzsquare, "Fizz", 23);
							
						} else if(image.attr("data-image-name").equals("GalioSquare.png")) {
							setFreeWeek(R.drawable.galiosquare, "Galio", 24);
							
						} else if(image.attr("data-image-name").equals("GangplankSquare.png")) {
							setFreeWeek(R.drawable.gangplanksquare, "Gangplank", 25);
							
						} else if(image.attr("data-image-name").equals("GarenSquare.png")) {
							setFreeWeek(R.drawable.garensquare, "Garen", 26);
							
						} else if(image.attr("data-image-name").equals("GragasSquare.png")) {
							setFreeWeek(R.drawable.gragassquare, "Gragas", 27);
							
						} else if(image.attr("data-image-name").equals("GravesSquare.png")) {
							setFreeWeek(R.drawable.gravessquare, "Graves", 28);
							
						} else if(image.attr("data-image-name").equals("HecarimSquare.png")) {
							setFreeWeek(R.drawable.hecarimsquare, "Hecarim", 29);
							
						} else if(image.attr("data-image-name").equals("HeimerdingerSquare.png")) {
							setFreeWeek(R.drawable.heimerdingersquare, "Heimerdinger", 30);
							
						} else if(image.attr("data-image-name").equals("IreliaSquare.png")) {
							setFreeWeek(R.drawable.ireliasquare, "Irelia", 31);
							
						} else if(image.attr("data-image-name").equals("JannaSquare.png")) {
							setFreeWeek(R.drawable.jannasquare, "Janna", 32);
							
						} else if(image.attr("data-image-name").equals("JarvanIVSquare.png")) {
							setFreeWeek(R.drawable.jarvanivsquare, "Jarvan IV", 33);
							
						} else if(image.attr("data-image-name").equals("JaxSquare.png")) {
							setFreeWeek(R.drawable.jaxsquare, "Jax", 34);
							
						} else if(image.attr("data-image-name").equals("JayceSquare.png")) {
							setFreeWeek(R.drawable.jaycesquare, "Jayce", 35);
							
						} else if(image.attr("data-image-name").equals("KarmaSquare.png")) {
							setFreeWeek(R.drawable.karmasquare, "Karma", 36);
							
						} else if(image.attr("data-image-name").equals("KarthusSquare.png")) {
							setFreeWeek(R.drawable.karthussquare, "Karthus", 37);
							
						} else if(image.attr("data-image-name").equals("KassadinSquare.png")) {
							setFreeWeek(R.drawable.kassadinsquare, "Kassadin", 38);
							
						} else if(image.attr("data-image-name").equals("KatarinaSquare.png")) {
							setFreeWeek(R.drawable.katarinasquare, "Katarina", 39);
							
						} else if(image.attr("data-image-name").equals("KayleSquare.png")) {
							setFreeWeek(R.drawable.kaylesquare, "Kayle", 40);
							
						} else if(image.attr("data-image-name").equals("KennenSquare.png")) {
							setFreeWeek(R.drawable.kennensquare, "Kennen", 41);
							
						} else if(image.attr("data-image-name").equals("KhaZixSquare.png")) {
							setFreeWeek(R.drawable.khazixsquare, "Kha'Zix", 42);
							
						} else if(image.attr("data-image-name").equals("KogMawSquare.png")) {
							setFreeWeek(R.drawable.kogmawsquare, "Kog'Maw", 43);
							
						} else if(image.attr("data-image-name").equals("LeBlancSquare.png")) {
							setFreeWeek(R.drawable.leblancsquare, "LeBlanc", 44);
							
						} else if(image.attr("data-image-name").equals("LeeSinSquare.png")) {
							setFreeWeek(R.drawable.leesinsquare, "Lee Sin", 45);
							
						} else if(image.attr("data-image-name").equals("LeonaSquare.png")) {
							setFreeWeek(R.drawable.leonasquare, "Leona", 46);
							
						} else if(image.attr("data-image-name").equals("LissandraSquare.png")) {
							setFreeWeek(R.drawable.lissandrasquare, "Lissandra", 47);
							
						} else if(image.attr("data-image-name").equals("LucianSquare.png")) {
							setFreeWeek(R.drawable.luciansquare, "Lucian", 48);
							
						} else if(image.attr("data-image-name").equals("LuluSquare.png")) {
							setFreeWeek(R.drawable.lulusquare, "Lulu", 49);
							
						} else if(image.attr("data-image-name").equals("LuxSquare.png")) {
							setFreeWeek(R.drawable.luxsquare, "Lux", 50);
							
						} else if(image.attr("data-image-name").equals("MalphiteSquare.png")) {
							setFreeWeek(R.drawable.malphitesquare, "Malphite", 51);
							
						} else if(image.attr("data-image-name").equals("MalzaharSquare.png")) {
							setFreeWeek(R.drawable.malzaharsquare, "Malzahar", 52);
							
						} else if(image.attr("data-image-name").equals("MaokaiSquare.png")) {
							setFreeWeek(R.drawable.maokaisquare, "Maokai", 53);
							
						} else if(image.attr("data-image-name").equals("MasterYiSquare.png")) {
							setFreeWeek(R.drawable.masteryisquare, "Master Yi", 54);
							
						} else if(image.attr("data-image-name").equals("MissFortuneSquare.png")) {
							setFreeWeek(R.drawable.missfortunesquare, "Miss Fortune", 55);
							
						} else if(image.attr("data-image-name").equals("MordekaiserSquare.png")) {
							setFreeWeek(R.drawable.mordekaisersquare, "Mordekaiser", 56);
							
						} else if(image.attr("data-image-name").equals("MorganaSquare.png")) {
							setFreeWeek(R.drawable.morganasquare, "Morgana", 57);
							
						} else if(image.attr("data-image-name").equals("NamiSquare.png")) {
							setFreeWeek(R.drawable.namisquare, "Nami", 58);
							
						} else if(image.attr("data-image-name").equals("NasusSquare.png")) {
							setFreeWeek(R.drawable.nasussquare, "Nasus", 59);
							
						} else if(image.attr("data-image-name").equals("NautilusSquare.png")) {
							setFreeWeek(R.drawable.nautilussquare, "Nautilus", 60);
							
						} else if(image.attr("data-image-name").equals("NidaleeSquare.png")) {
							setFreeWeek(R.drawable.nidaleesquare, "Nidalee", 61);
							
						} else if(image.attr("data-image-name").equals("NocturneSquare.png")) {
							setFreeWeek(R.drawable.nocturnesquare, "Nocturne", 62);
							
						} else if(image.attr("data-image-name").equals("NunuSquare.png")) {
							setFreeWeek(R.drawable.nunusquare, "Nunu", 63);
							
						} else if(image.attr("data-image-name").equals("OlafSquare.png")) {
							setFreeWeek(R.drawable.olafsquare, "Olaf", 64);
							
						} else if(image.attr("data-image-name").equals("OriannaSquare.png")) {
							setFreeWeek(R.drawable.oriannasquare, "Orianna", 65);
							
						} else if(image.attr("data-image-name").equals("PantheonSquare.png")) {
							setFreeWeek(R.drawable.pantheonsquare, "Pantheon", 66);
							
						} else if(image.attr("data-image-name").equals("PoppySquare.png")) {
							setFreeWeek(R.drawable.poppysquare, "Poppy", 67);
							
						} else if(image.attr("data-image-name").equals("QuinnSquare.png")) {
							setFreeWeek(R.drawable.quinnsquare, "Quinn", 68);
							
						} else if(image.attr("data-image-name").equals("RammusSquare.png")) {
							setFreeWeek(R.drawable.rammussquare, "Rammus", 69);
							
						} else if(image.attr("data-image-name").equals("RenektonSquare.png")) {
							setFreeWeek(R.drawable.renektonsquare, "Renekton", 70);
							
						} else if(image.attr("data-image-name").equals("RengarSquare.png")) {
							setFreeWeek(R.drawable.rengarsquare, "Rengar", 71);
							
						} else if(image.attr("data-image-name").equals("RivenSquare.png")) {
							setFreeWeek(R.drawable.rivensquare, "Riven", 72);
							
						} else if(image.attr("data-image-name").equals("RumbleSquare.png")) {
							setFreeWeek(R.drawable.rumblesquare, "Rumble", 73);
							
						} else if(image.attr("data-image-name").equals("RyzeSquare.png")) {
							setFreeWeek(R.drawable.ryzesquare, "Ryze", 74);
							
						} else if(image.attr("data-image-name").equals("SejuaniSquare.png")) {
							setFreeWeek(R.drawable.sejuanisquare, "Sejuani", 75);
							
						} else if(image.attr("data-image-name").equals("ShacoSquare.png")) {
							setFreeWeek(R.drawable.shacosquare, "Shaco", 76);
							
						} else if(image.attr("data-image-name").equals("ShenSquare.png")) {
							setFreeWeek(R.drawable.shensquare, "Shen", 77);
							
						} else if(image.attr("data-image-name").equals("ShyvanaSquare.png")) {
							setFreeWeek(R.drawable.shyvanasquare, "Shyvana", 78);
							
						} else if(image.attr("data-image-name").equals("SingedSquare.png")) {
							setFreeWeek(R.drawable.singedsquare, "Singed", 79);
							
						} else if(image.attr("data-image-name").equals("SionSquare.png")) {
							setFreeWeek(R.drawable.sionsquare, "Sion", 80);
							
						} else if(image.attr("data-image-name").equals("SivirSquare.png")) {
							setFreeWeek(R.drawable.sivirsquare, "Sivir", 81);
							
						} else if(image.attr("data-image-name").equals("SkarnerSquare.png")) {
							setFreeWeek(R.drawable.skarnersquare, "Skarner", 82);
							
						} else if(image.attr("data-image-name").equals("SonaSquare.png")) {
							setFreeWeek(R.drawable.sonasquare, "Sona", 83);
							
						} else if(image.attr("data-image-name").equals("SorakaSquare.png")) {
							setFreeWeek(R.drawable.sorakasquare, "Soraka", 84);
							
						} else if(image.attr("data-image-name").equals("SwainSquare.png")) {
							setFreeWeek(R.drawable.swainsquare, "Swain", 85);
							
						} else if(image.attr("data-image-name").equals("SyndraSquare.png")) {
							setFreeWeek(R.drawable.syndrasquare, "Syndra", 86);
							
						} else if(image.attr("data-image-name").equals("TalonSquare.png")) {
							setFreeWeek(R.drawable.talonsquare, "Talon", 87);
							
						} else if(image.attr("data-image-name").equals("TaricSquare.png")) {
							setFreeWeek(R.drawable.taricsquare, "Taric", 88);
							
						} else if(image.attr("data-image-name").equals("TeemoSquare.png")) {
							setFreeWeek(R.drawable.teemosquare, "Teemo", 89);
							
						} else if(image.attr("data-image-name").equals("ThreshSquare.png")) {
							setFreeWeek(R.drawable.threshsquare, "Thresh", 90);
							
						} else if(image.attr("data-image-name").equals("TristanaSquare.png")) {
							setFreeWeek(R.drawable.tristanasquare, "Tristana", 91);
							
						} else if(image.attr("data-image-name").equals("TrundleSquare.png")) {
							setFreeWeek(R.drawable.trundlesquare, "Trundle", 92);
							
						} else if(image.attr("data-image-name").equals("TryndamereSquare.png")) {
							setFreeWeek(R.drawable.tryndameresquare, "Tryndamere", 93);
							
						} else if(image.attr("data-image-name").equals("TwistedFateSquare.png")) {
							setFreeWeek(R.drawable.twistedfatesquare, "Twisted Fate", 94);
							
						} else if(image.attr("data-image-name").equals("TwitchSquare.png")) {
							setFreeWeek(R.drawable.twitchsquare, "Twitch", 95);
							
						} else if(image.attr("data-image-name").equals("UdyrSquare.png")) {
							setFreeWeek(R.drawable.udyrsquare, "Udyr", 96);
							
						} else if(image.attr("data-image-name").equals("UrgotSquare.png")) {
							setFreeWeek(R.drawable.urgotsquare, "Urgot", 97);
							
						} else if(image.attr("data-image-name").equals("VarusSquare.png")) {
							setFreeWeek(R.drawable.varussquare, "Varus", 98);
							
						} else if(image.attr("data-image-name").equals("VayneSquare.png")) {
							setFreeWeek(R.drawable.vaynesquare, "Vayne", 99);
							
						} else if(image.attr("data-image-name").equals("VeigarSquare.png")) {
							setFreeWeek(R.drawable.veigarsquare, "Veigar", 100);
							
						} else if(image.attr("data-image-name").equals("ViSquare.png")) {
							setFreeWeek(R.drawable.visquare, "Vi", 101);
							
						} else if(image.attr("data-image-name").equals("ViktorSquare.png")) {
							setFreeWeek(R.drawable.viktorsquare, "Viktor", 102);
							
						} else if(image.attr("data-image-name").equals("VladimirSquare.png")) {
							setFreeWeek(R.drawable.vladimirsquare, "Vladimir", 103);
							
						} else if(image.attr("data-image-name").equals("VolibearSquare.png")) {
							setFreeWeek(R.drawable.volibearsquare, "Volibear", 104);
							
						} else if(image.attr("data-image-name").equals("WarwickSquare.png")) {
							setFreeWeek(R.drawable.warwicksquare, "Warwick", 105);
							
						} else if(image.attr("data-image-name").equals("WukongSquare.png")) {
							setFreeWeek(R.drawable.wukongsquare, "Wukong", 106);
							
						} else if(image.attr("data-image-name").equals("XerathSquare.png")) {
							setFreeWeek(R.drawable.xerathsquare, "Xerath", 107);
							
						} else if(image.attr("data-image-name").equals("XinZhaoSquare.png")) {
							setFreeWeek(R.drawable.xinzhaosquare, "Xin Zhao", 108);
							
						} else if(image.attr("data-image-name").equals("YorickSquare.png")) {
							setFreeWeek(R.drawable.yoricksquare, "Yorick", 109);
							
						} else if(image.attr("data-image-name").equals("ZacSquare.png")) {
							setFreeWeek(R.drawable.zacsquare, "Zac", 110);
							
						} else if(image.attr("data-image-name").equals("ZedSquare.png")) {
							setFreeWeek(R.drawable.zedsquare, "Zed", 111);
							
						} else if(image.attr("data-image-name").equals("ZiggsSquare.png")) {
							setFreeWeek(R.drawable.ziggssquare, "Ziggs", 112);
							
						} else if(image.attr("data-image-name").equals("ZileanSquare.png")) {
							setFreeWeek(R.drawable.zileansquare, "Zilean", 113);
							
						} else if(image.attr("data-image-name").equals("ZyraSquare.png")) {
							setFreeWeek(R.drawable.zyrasquare, "Zyra", 114);	
						} 
					}
				}		
			}
		}
	}


	public void setFreeWeek(int champId, String champName, int champNum) {
		if (ivFreeOne.getDrawable() == null) {
			ivFreeOne.setImageResource(champId);
			tvFreeOne.setText(champName);
			champNumber[0] = champNum;
			
		} else if (ivFreeTwo.getDrawable() == null) {
			ivFreeTwo.setImageResource(champId);
			tvFreeTwo.setText(champName);
			champNumber[1] = champNum;
			
		} else if (ivFreeThree.getDrawable() == null) {
			ivFreeThree.setImageResource(champId);
			tvFreeThree.setText(champName);
			champNumber[2] = champNum;
			
		} else if (ivFreeFour.getDrawable() == null) {
			ivFreeFour.setImageResource(champId);
			tvFreeFour.setText(champName);
			champNumber[3] = champNum;
			
		} else if (ivFreeFive.getDrawable() == null) {
			ivFreeFive.setImageResource(champId);
			tvFreeFive.setText(champName);
			champNumber[4] = champNum;
			
		} else if (ivFreeSix.getDrawable() == null) {
			ivFreeSix.setImageResource(champId);
			tvFreeSix.setText(champName);
			champNumber[5] = champNum;
			
		} else if (ivFreeSeven.getDrawable() == null) {
			ivFreeSeven.setImageResource(champId);
			tvFreeSeven.setText(champName);
			champNumber[6] = champNum;
			
		} else if (ivFreeEight.getDrawable() == null) {
			ivFreeEight.setImageResource(champId);
			tvFreeEight.setText(champName);
			champNumber[7] = champNum;
			
		} else if (ivFreeNine.getDrawable() == null) {
			ivFreeNine.setImageResource(champId);
			tvFreeNine.setText(champName);
			champNumber[8] = champNum;
			
		} else if (ivFreeTen.getDrawable() == null) {
			ivFreeTen.setImageResource(champId);
			tvFreeTen.setText(champName);
			champNumber[9] = champNum;
		}	
	}

}
