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
	
	ImageView ivFreeOne = MainActivity.ivFreeOne;
	ImageView ivFreeTwo = MainActivity.ivFreeTwo;
	ImageView ivFreeThree = MainActivity.ivFreeThree;
	ImageView ivFreeFour = MainActivity.ivFreeFour;
	ImageView ivFreeFive = MainActivity.ivFreeFive;
	ImageView ivFreeSix = MainActivity.ivFreeSix;
	ImageView ivFreeSeven = MainActivity.ivFreeSeven;
	ImageView ivFreeEight = MainActivity.ivFreeEight;
	ImageView ivFreeNine = MainActivity.ivFreeNine;
	ImageView ivFreeTen = MainActivity.ivFreeTen;
	
	TextView tvWeekText = MainActivity.tvWeekNum;
	TextView tvFreeOne = MainActivity.tvFreeOne;
	TextView tvFreeTwo = MainActivity.tvFreeTwo;
	TextView tvFreeThree = MainActivity.tvFreeThree;
	TextView tvFreeFour = MainActivity.tvFreeFour;
	TextView tvFreeFive = MainActivity.tvFreeFive;
	TextView tvFreeSix = MainActivity.tvFreeSix;
	TextView tvFreeSeven = MainActivity.tvFreeSeven;
	TextView tvFreeEight = MainActivity.tvFreeEight;
	TextView tvFreeNine = MainActivity.tvFreeNine;
	TextView tvFreeTen = MainActivity.tvFreeTen;
	
	
	public class PostFetcher extends AsyncTask<String, Void, Document> {
		
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
		protected void onPostExecute(Document document) {
			// set textview for week number
			if (weekText != null) {
				tvWeekText.setText(weekText.text());
			}
			
	
			for (Element clazz : classes) { // get images from free champ rotation list only
				images = clazz.select("img[src~=(?i)\\.(png|jpeg|gif)]");
				
				for (Element image : images) { // set images for free week scrollview
					if(image.attr("data-image-name").equals("AatroxSquare.png")) {
						setFreeWeek(R.drawable.aatroxsquare, "Aatrox");
						
					} else if(image.attr("data-image-name").equals("AhriSquare.png")) {
						setFreeWeek(R.drawable.ahrisquare, "Ahri");
						
					} else if(image.attr("data-image-name").equals("AkaliSquare.png")) {
						setFreeWeek(R.drawable.akalisquare, "Akali");
						
					} else if(image.attr("data-image-name").equals("AlistarSquare.png")) {
						setFreeWeek(R.drawable.alistarsquare, "Alistar");
						
					} else if(image.attr("data-image-name").equals("AmumuSquare.png")) {
						setFreeWeek(R.drawable.amumusquare, "Amumu");
						
					} else if(image.attr("data-image-name").equals("AniviaSquare.png")) {
						setFreeWeek(R.drawable.aniviasquare, "Anivia");
						
					} else if(image.attr("data-image-name").equals("AnnieSquare.png")) {
						setFreeWeek(R.drawable.anniesquare, "Annie");
						
					} else if(image.attr("data-image-name").equals("AsheSquare.png")) {
						setFreeWeek(R.drawable.ashesquare, "Ashe");
						
					} else if(image.attr("data-image-name").equals("BlitzcrankSquare.png")) {
						setFreeWeek(R.drawable.blitzcranksquare, "Blitzcrank");
						
					} else if(image.attr("data-image-name").equals("BrandSquare.png")) {
						setFreeWeek(R.drawable.brandsquare, "Brand");
						
					} else if(image.attr("data-image-name").equals("CaitlynSquare.png")) {
						setFreeWeek(R.drawable.caitlynsquare, "Caitlyn");
						
					} else if(image.attr("data-image-name").equals("CassiopeiaSquare.png")) {
						setFreeWeek(R.drawable.cassiopeiasquare, "Cassiopeia");
						
					} else if(image.attr("data-image-name").equals("ChoGathSquare.png")) {
						setFreeWeek(R.drawable.chogathsquare, "Cho'Gath");
						
					} else if(image.attr("data-image-name").equals("CorkiSquare.png")) {
						setFreeWeek(R.drawable.corkisquare, "Corki");
						
					} else if(image.attr("data-image-name").equals("DariusSquare.png")) {
						setFreeWeek(R.drawable.dariussquare, "Darius");
						
					} else if(image.attr("data-image-name").equals("DianaSquare.png")) {
						setFreeWeek(R.drawable.dianasquare, "Diana");
						
					} else if(image.attr("data-image-name").equals("DrMundoSquare.png")) {
						setFreeWeek(R.drawable.drmundosquare, "Dr. Mundo");
						
					} else if(image.attr("data-image-name").equals("DravenSquare.png")) {
						setFreeWeek(R.drawable.dravensquare, "Draven");
						
					} else if(image.attr("data-image-name").equals("EliseSquare.png")) {
						setFreeWeek(R.drawable.elisesquare, "Elise");
						
					} else if(image.attr("data-image-name").equals("EvelynnSquare.png")) {
						setFreeWeek(R.drawable.evelynnsquare, "Evelynn");
						
					} else if(image.attr("data-image-name").equals("EzrealSquare.png")) {
						setFreeWeek(R.drawable.ezrealsquare, "Ezreal");
						
					} else if(image.attr("data-image-name").equals("FiddlesticksSquare.png")) {
						setFreeWeek(R.drawable.fiddlestickssquare, "Fiddlesticks");
						
					} else if(image.attr("data-image-name").equals("FioraSquare.png")) {
						setFreeWeek(R.drawable.fiorasquare, "Fiora");
						
					} else if(image.attr("data-image-name").equals("FizzSquare.png")) {
						setFreeWeek(R.drawable.fizzsquare, "Fizz");
						
					} else if(image.attr("data-image-name").equals("GalioSquare.png")) {
						setFreeWeek(R.drawable.galiosquare, "Galio");
						
					} else if(image.attr("data-image-name").equals("GangplankSquare.png")) {
						setFreeWeek(R.drawable.gangplanksquare, "Gangplank");
						
					} else if(image.attr("data-image-name").equals("GarenSquare.png")) {
						setFreeWeek(R.drawable.garensquare, "Garen");
						
					} else if(image.attr("data-image-name").equals("GragasSquare.png")) {
						setFreeWeek(R.drawable.gragassquare, "Gragas");
						
					} else if(image.attr("data-image-name").equals("GravesSquare.png")) {
						setFreeWeek(R.drawable.gravessquare, "Graves");
						
					} else if(image.attr("data-image-name").equals("HecarimSquare.png")) {
						setFreeWeek(R.drawable.hecarimsquare, "Hecarim");
						
					} else if(image.attr("data-image-name").equals("HeimerdingerSquare.png")) {
						setFreeWeek(R.drawable.heimerdingersquare, "Heimerdinger");
						
					} else if(image.attr("data-image-name").equals("IreliaSquare.png")) {
						setFreeWeek(R.drawable.ireliasquare, "Irelia");
						
					} else if(image.attr("data-image-name").equals("JannaSquare.png")) {
						setFreeWeek(R.drawable.jannasquare, "Janna");
						
					} else if(image.attr("data-image-name").equals("JarvanIVSquare.png")) {
						setFreeWeek(R.drawable.jarvanivsquare, "Jarvan IV");
						
					} else if(image.attr("data-image-name").equals("JaxSquare.png")) {
						setFreeWeek(R.drawable.jaxsquare, "Jax");
						
					} else if(image.attr("data-image-name").equals("JayceSquare.png")) {
						setFreeWeek(R.drawable.jaycesquare, "Jayce");
						
					} else if(image.attr("data-image-name").equals("KarmaSquare.png")) {
						setFreeWeek(R.drawable.karmasquare, "Karma");
						
					} else if(image.attr("data-image-name").equals("KarthusSquare.png")) {
						setFreeWeek(R.drawable.karthussquare, "Karthus");
						
					} else if(image.attr("data-image-name").equals("KassadinSquare.png")) {
						setFreeWeek(R.drawable.kassadinsquare, "Kassadin");
						
					} else if(image.attr("data-image-name").equals("KatarinaSquare.png")) {
						setFreeWeek(R.drawable.katarinasquare, "Katarina");
						
					} else if(image.attr("data-image-name").equals("KayleSquare.png")) {
						setFreeWeek(R.drawable.kaylesquare, "Kayle");
						
					} else if(image.attr("data-image-name").equals("KennenSquare.png")) {
						setFreeWeek(R.drawable.kennensquare, "Kennen");
						
					} else if(image.attr("data-image-name").equals("KhaZixSquare.png")) {
						setFreeWeek(R.drawable.khazixsquare, "Kha'Zix");
						
					} else if(image.attr("data-image-name").equals("KogMawSquare.png")) {
						setFreeWeek(R.drawable.kogmawsquare, "Kog'Maw");
						
					} else if(image.attr("data-image-name").equals("LeBlancSquare.png")) {
						setFreeWeek(R.drawable.leblancsquare, "LeBlanc");
						
					} else if(image.attr("data-image-name").equals("LeeSinSquare.png")) {
						setFreeWeek(R.drawable.leesinsquare, "Lee Sin");
						
					} else if(image.attr("data-image-name").equals("LeonaSquare.png")) {
						setFreeWeek(R.drawable.leonasquare, "Leona");
						
					} else if(image.attr("data-image-name").equals("LissandraSquare.png")) {
						setFreeWeek(R.drawable.lissandrasquare, "Lissandra");
						
					} else if(image.attr("data-image-name").equals("LuluSquare.png")) {
						setFreeWeek(R.drawable.lulusquare, "Lulu");
						
					} else if(image.attr("data-image-name").equals("LuxSquare.png")) {
						setFreeWeek(R.drawable.luxsquare, "Lux");
						
					} else if(image.attr("data-image-name").equals("MalphiteSquare.png")) {
						setFreeWeek(R.drawable.malphitesquare, "Malphite");
						
					} else if(image.attr("data-image-name").equals("MalzaharSquare.png")) {
						setFreeWeek(R.drawable.malzaharsquare, "Malzahar");
						
					} else if(image.attr("data-image-name").equals("MaokaiSquare.png")) {
						setFreeWeek(R.drawable.maokaisquare, "Maokai");
						
					} else if(image.attr("data-image-name").equals("MasterYiSquare.png")) {
						setFreeWeek(R.drawable.masteryisquare, "Master Yi");
						
					} else if(image.attr("data-image-name").equals("MissFortuneSquare.png")) {
						setFreeWeek(R.drawable.missfortunesquare, "Miss Fortune");
						
					} else if(image.attr("data-image-name").equals("MordekaiserSquare.png")) {
						setFreeWeek(R.drawable.mordekaisersquare, "Mordekaiser");
						
					} else if(image.attr("data-image-name").equals("MorganaSquare.png")) {
						setFreeWeek(R.drawable.morganasquare, "Morgana");
						
					} else if(image.attr("data-image-name").equals("NamiSquare.png")) {
						setFreeWeek(R.drawable.namisquare, "Nami");
						
					} else if(image.attr("data-image-name").equals("NasusSquare.png")) {
						setFreeWeek(R.drawable.nasussquare, "Nasus");
						
					} else if(image.attr("data-image-name").equals("NautilusSquare.png")) {
						setFreeWeek(R.drawable.nautilussquare, "Nautilus");
						
					} else if(image.attr("data-image-name").equals("NidaleeSquare.png")) {
						setFreeWeek(R.drawable.nidaleesquare, "Nidalee");
						
					} else if(image.attr("data-image-name").equals("NocturneSquare.png")) {
						setFreeWeek(R.drawable.nocturnesquare, "Nocturne");
						
					} else if(image.attr("data-image-name").equals("NunuSquare.png")) {
						setFreeWeek(R.drawable.nunusquare, "Nunu");
						
					} else if(image.attr("data-image-name").equals("OlafSquare.png")) {
						setFreeWeek(R.drawable.olafsquare, "Olaf");
						
					} else if(image.attr("data-image-name").equals("OriannaSquare.png")) {
						setFreeWeek(R.drawable.oriannasquare, "Orianna");
						
					} else if(image.attr("data-image-name").equals("PantheonSquare.png")) {
						setFreeWeek(R.drawable.pantheonsquare, "Pantheon");
						
					} else if(image.attr("data-image-name").equals("PoppySquare.png")) {
						setFreeWeek(R.drawable.poppysquare, "Poppy");
						
					} else if(image.attr("data-image-name").equals("QuinnSquare.png")) {
						setFreeWeek(R.drawable.quinnsquare, "Quinn");
						
					} else if(image.attr("data-image-name").equals("RammusSquare.png")) {
						setFreeWeek(R.drawable.rammussquare, "Rammus");
						
					} else if(image.attr("data-image-name").equals("RenektonSquare.png")) {
						setFreeWeek(R.drawable.renektonsquare, "Renekton");
						
					} else if(image.attr("data-image-name").equals("RengarSquare.png")) {
						setFreeWeek(R.drawable.rengarsquare, "Rengar");
						
					} else if(image.attr("data-image-name").equals("RivenSquare.png")) {
						setFreeWeek(R.drawable.rivensquare, "Riven");
						
					} else if(image.attr("data-image-name").equals("RumbleSquare.png")) {
						setFreeWeek(R.drawable.rumblesquare, "Rumble");
						
					} else if(image.attr("data-image-name").equals("RyzeSquare.png")) {
						setFreeWeek(R.drawable.ryzesquare, "Ryze");
						
					} else if(image.attr("data-image-name").equals("SejuaniSquare.png")) {
						setFreeWeek(R.drawable.sejuanisquare, "Sejuani");
						
					} else if(image.attr("data-image-name").equals("ShacoSquare.png")) {
						setFreeWeek(R.drawable.shacosquare, "Shaco");
						
					} else if(image.attr("data-image-name").equals("ShenSquare.png")) {
						setFreeWeek(R.drawable.shensquare, "Shen");
						
					} else if(image.attr("data-image-name").equals("ShyvanaSquare.png")) {
						setFreeWeek(R.drawable.shyvanasquare, "Shyvana");
						
					} else if(image.attr("data-image-name").equals("SingedSquare.png")) {
						setFreeWeek(R.drawable.singedsquare, "Singed");
						
					} else if(image.attr("data-image-name").equals("SionSquare.png")) {
						setFreeWeek(R.drawable.sionsquare, "Sion");
						
					} else if(image.attr("data-image-name").equals("SivirSquare.png")) {
						setFreeWeek(R.drawable.sivirsquare, "Sivir");
						
					} else if(image.attr("data-image-name").equals("SkarnerSquare.png")) {
						setFreeWeek(R.drawable.skarnersquare, "Skarner");
						
					} else if(image.attr("data-image-name").equals("SonaSquare.png")) {
						setFreeWeek(R.drawable.sonasquare, "Sona");
						
					} else if(image.attr("data-image-name").equals("SorakaSquare.png")) {
						setFreeWeek(R.drawable.sorakasquare, "Soraka");
						
					} else if(image.attr("data-image-name").equals("SwainSquare.png")) {
						setFreeWeek(R.drawable.swainsquare, "Swain");
						
					} else if(image.attr("data-image-name").equals("SyndraSquare.png")) {
						setFreeWeek(R.drawable.syndrasquare, "Syndra");
						
					} else if(image.attr("data-image-name").equals("TalonSquare.png")) {
						setFreeWeek(R.drawable.talonsquare, "Talon");
						
					} else if(image.attr("data-image-name").equals("TaricSquare.png")) {
						setFreeWeek(R.drawable.taricsquare, "Taric");
						
					} else if(image.attr("data-image-name").equals("TeemoSquare.png")) {
						setFreeWeek(R.drawable.teemosquare, "Teemo");
						
					} else if(image.attr("data-image-name").equals("ThreshSquare.png")) {
						setFreeWeek(R.drawable.threshsquare, "Thresh");
						
					} else if(image.attr("data-image-name").equals("TristanaSquare.png")) {
						setFreeWeek(R.drawable.tristanasquare, "Tristana");
						
					} else if(image.attr("data-image-name").equals("TrundleSquare.png")) {
						setFreeWeek(R.drawable.trundlesquare, "Trundle");
						
					} else if(image.attr("data-image-name").equals("TryndamereSquare.png")) {
						setFreeWeek(R.drawable.tryndameresquare, "Tryndamere");
						
					} else if(image.attr("data-image-name").equals("TwistedFateSquare.png")) {
						setFreeWeek(R.drawable.twistedfatesquare, "Twisted Fate");
						
					} else if(image.attr("data-image-name").equals("TwitchSquare.png")) {
						setFreeWeek(R.drawable.twitchsquare, "Twitch");
						
					} else if(image.attr("data-image-name").equals("UdyrSquare.png")) {
						setFreeWeek(R.drawable.udyrsquare, "Udyr");
						
					} else if(image.attr("data-image-name").equals("UrgotSquare.png")) {
						setFreeWeek(R.drawable.urgotsquare, "Urgot");
						
					} else if(image.attr("data-image-name").equals("VarusSquare.png")) {
						setFreeWeek(R.drawable.varussquare, "Varus");
						
					} else if(image.attr("data-image-name").equals("VayneSquare.png")) {
						setFreeWeek(R.drawable.vaynesquare, "Vayne");
						
					} else if(image.attr("data-image-name").equals("VeigarSquare.png")) {
						setFreeWeek(R.drawable.veigarsquare, "Veigar");
						
					} else if(image.attr("data-image-name").equals("ViSquare.png")) {
						setFreeWeek(R.drawable.visquare, "Vi");
						
					} else if(image.attr("data-image-name").equals("ViktorSquare.png")) {
						setFreeWeek(R.drawable.viktorsquare, "Viktor");
						
					} else if(image.attr("data-image-name").equals("VladimirSquare.png")) {
						setFreeWeek(R.drawable.vladimirsquare, "Vladimir");
						
					} else if(image.attr("data-image-name").equals("VolibearSquare.png")) {
						setFreeWeek(R.drawable.volibearsquare, "Volibear");
						
					} else if(image.attr("data-image-name").equals("WarwickSquare.png")) {
						setFreeWeek(R.drawable.warwicksquare, "Warwick");
						
					} else if(image.attr("data-image-name").equals("WukongSquare.png")) {
						setFreeWeek(R.drawable.wukongsquare, "Wukong");
						
					} else if(image.attr("data-image-name").equals("XerathSquare.png")) {
						setFreeWeek(R.drawable.xerathsquare, "Xerath");
						
					} else if(image.attr("data-image-name").equals("XinZhaoSquare.png")) {
						setFreeWeek(R.drawable.xinzhaosquare, "Xin Zhao");
						
					} else if(image.attr("data-image-name").equals("YorickSquare.png")) {
						setFreeWeek(R.drawable.yoricksquare, "Yorick");
						
					} else if(image.attr("data-image-name").equals("ZacSquare.png")) {
						setFreeWeek(R.drawable.zacsquare, "Zac");
						
					} else if(image.attr("data-image-name").equals("ZedSquare.png")) {
						setFreeWeek(R.drawable.zedsquare, "Zed");
						
					} else if(image.attr("data-image-name").equals("ZiggsSquare.png")) {
						setFreeWeek(R.drawable.ziggssquare, "Ziggs");
						
					} else if(image.attr("data-image-name").equals("ZileanSquare.png")) {
						setFreeWeek(R.drawable.zileansquare, "Zilean");
						
					} else if(image.attr("data-image-name").equals("ZyraSquare.png")) {
						setFreeWeek(R.drawable.zyrasquare, "Zyra");	
					} 
					
				}		
			}
		}
	}


	public void setFreeWeek(int champId, String champName) {
		if (ivFreeOne.getDrawable() == null) {
			ivFreeOne.setImageResource(champId);
			tvFreeOne.setText(champName);
			
		} else if (ivFreeTwo.getDrawable() == null) {
			ivFreeTwo.setImageResource(champId);
			tvFreeTwo.setText(champName);
			
		} else if (ivFreeThree.getDrawable() == null) {
			ivFreeThree.setImageResource(champId);
			tvFreeThree.setText(champName);
			
		} else if (ivFreeFour.getDrawable() == null) {
			ivFreeFour.setImageResource(champId);
			tvFreeFour.setText(champName);
			
		} else if (ivFreeFive.getDrawable() == null) {
			ivFreeFive.setImageResource(champId);
			tvFreeFive.setText(champName);
			
		} else if (ivFreeSix.getDrawable() == null) {
			ivFreeSix.setImageResource(champId);
			tvFreeSix.setText(champName);
			
		} else if (ivFreeSeven.getDrawable() == null) {
			ivFreeSeven.setImageResource(champId);
			tvFreeSeven.setText(champName);
			
		} else if (ivFreeEight.getDrawable() == null) {
			ivFreeEight.setImageResource(champId);
			tvFreeEight.setText(champName);
			
		} else if (ivFreeNine.getDrawable() == null) {
			ivFreeNine.setImageResource(champId);
			tvFreeNine.setText(champName);
			
		} else if (ivFreeTen.getDrawable() == null) {
			ivFreeTen.setImageResource(champId);
			tvFreeTen.setText(champName);
		}	
	}

}
