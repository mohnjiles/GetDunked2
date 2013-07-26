package com.jt.getdunked2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import de.keyboardsurfer.android.widget.crouton.Crouton;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
		private Activity ownerActivity;
		private Context context;
		private ProgressDialog dialog;
		public PostFetcher(Context cxt, Activity activity) {
			context = cxt;
			this.ownerActivity = activity;
		}
	
		

		@Override
		protected PostFetchResult doInBackground(String... urls) {
			PostFetchResult result = new PostFetchResult();
			try {
				doc = Jsoup.connect("http://leagueoflegends.wikia.com/wiki/Free_champion_rotation").get();
				classes = doc.select("ol.free_champion_rotation");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return result;
			
		}
		

		@Override
		protected void onPostExecute(PostFetchResult result) {
			// TextView declarations -- may not keep
			
			for (Element clazz : classes) {
				images = clazz.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
				for (Element image : images) {
					if(image.attr("data-image-name").equals("AatroxSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.aatroxsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.aatroxsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.aatroxsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.aatroxsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.aatroxsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.aatroxsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.aatroxsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.aatroxsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.aatroxsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.aatroxsquare);
						}	
					} else if(image.attr("data-image-name").equals("AhriSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.ahrisquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.ahrisquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.ahrisquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.ahrisquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.ahrisquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.ahrisquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.ahrisquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.ahrisquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.ahrisquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.ahrisquare);
						}	
					} else if(image.attr("data-image-name").equals("AkaliSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.akalisquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.akalisquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.akalisquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.akalisquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.akalisquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.akalisquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.akalisquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.akalisquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.akalisquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.akalisquare);
						}	
					} else if(image.attr("data-image-name").equals("AlistarSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.alistarsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.alistarsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.alistarsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.alistarsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.alistarsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.alistarsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.alistarsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.alistarsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.alistarsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.alistarsquare);
						}	
					} else if(image.attr("data-image-name").equals("AmumuSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.amumusquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.amumusquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.amumusquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.amumusquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.amumusquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.amumusquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.amumusquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.amumusquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.amumusquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.amumusquare);
						}	
					} else if(image.attr("data-image-name").equals("AniviaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.aniviasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.aniviasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.aniviasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.aniviasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.aniviasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.aniviasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.aniviasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.aniviasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.aniviasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.aniviasquare);
						}	
					} else if(image.attr("data-image-name").equals("AnnieSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.anniesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.anniesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.anniesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.anniesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.anniesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.anniesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.anniesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.anniesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.anniesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.anniesquare);
						}	
					} else if(image.attr("data-image-name").equals("AsheSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.ashesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.ashesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.ashesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.ashesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.ashesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.ashesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.ashesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.ashesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.ashesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.ashesquare);
						}	
					} else if(image.attr("data-image-name").equals("BlitzcrankSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.cassiopeiasquare);
						}	
					} else if(image.attr("data-image-name").equals("BrandSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.brandsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.brandsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.brandsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.brandsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.brandsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.brandsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.brandsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.brandsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.brandsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.brandsquare);
						}	
					} else if(image.attr("data-image-name").equals("CaitlynSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.caitlynsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.caitlynsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.caitlynsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.caitlynsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.caitlynsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.caitlynsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.caitlynsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.caitlynsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.caitlynsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.caitlynsquare);
						}	
					} else if(image.attr("data-image-name").equals("CassiopeiaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.cassiopeiasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.cassiopeiasquare);
						}	
					} else if(image.attr("data-image-name").equals("ChoGathSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.chogathsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.chogathsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.chogathsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.chogathsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.chogathsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.chogathsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.chogathsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.chogathsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.chogathsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.chogathsquare);
						}	
					} else if(image.attr("data-image-name").equals("CorkiSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.corkisquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.corkisquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.corkisquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.corkisquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.corkisquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.corkisquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.corkisquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.corkisquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.corkisquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.corkisquare);
						}	
					} else if(image.attr("data-image-name").equals("DariusSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.dravensquare);
						}	
					} else if(image.attr("data-image-name").equals("DianaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.dianasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.dianasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.dianasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.dianasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.dianasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.dianasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.dianasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.dianasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.dianasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.dianasquare);
						}	
					} else if(image.attr("data-image-name").equals("DrMundoSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.drmundosquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.drmundosquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.drmundosquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.drmundosquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.drmundosquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.drmundosquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.drmundosquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.drmundosquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.drmundosquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.drmundosquare);
						}	
					} else if(image.attr("data-image-name").equals("DravenSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.dravensquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.dravensquare);
						}	
					} else if(image.attr("data-image-name").equals("EliseSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.elisesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.elisesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.elisesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.elisesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.elisesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.elisesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.elisesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.elisesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.elisesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.elisesquare);
						}	
					} else if(image.attr("data-image-name").equals("EvelynnSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.evelynnsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.evelynnsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.evelynnsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.evelynnsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.evelynnsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.evelynnsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.evelynnsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.evelynnsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.evelynnsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.evelynnsquare);
						}	
					} else if(image.attr("data-image-name").equals("EzrealSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.ezrealsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.ezrealsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.ezrealsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.ezrealsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.ezrealsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.ezrealsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.ezrealsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.ezrealsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.ezrealsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.ezrealsquare);
						}	
					} else if(image.attr("data-image-name").equals("FiddlesticksSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.fiddlestickssquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.fiddlestickssquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.fiddlestickssquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.fiddlestickssquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.fiddlestickssquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.fiddlestickssquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.fiddlestickssquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.fiddlestickssquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.fiddlestickssquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.fiddlestickssquare);
						}	
					} else if(image.attr("data-image-name").equals("FioraSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.fiorasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.fiorasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.fiorasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.fiorasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.fiorasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.fiorasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.fiorasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.fiorasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.fiorasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.fiorasquare);
						}	
					} else if(image.attr("data-image-name").equals("FizzSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.fizzsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.fizzsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.fizzsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.fizzsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.fizzsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.fizzsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.fizzsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.fizzsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.fizzsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.fizzsquare);
						}	
					} 
				}		
			}
		}
	}

}
