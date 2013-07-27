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
	
	
	public class PostFetcher extends AsyncTask<String, Void, Document> {
		
		@Override
		protected Document doInBackground(String... urls) {

			try {
				//connect to LoL wiki
				doc = Jsoup.connect("http://leagueoflegends.wikia.com/wiki/Free_champion_rotation").get();
				
				classes = doc.select("ol.free_champion_rotation"); /* get list of free champs */
				weekText = doc.select("div#rotationweek"); /* get champ images */
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return doc;
			
		}
		

		@Override
		protected void onPostExecute(Document document) {
			// set textview for week number
			tvWeekText.setText(weekText.text());
	
			for (Element clazz : classes) { // get images from free champ rotation list only
				images = clazz.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
				
				for (Element image : images) { // set images for free week scrollview
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
					} else if(image.attr("data-image-name").equals("GalioSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.galiosquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.galiosquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.galiosquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.galiosquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.galiosquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.galiosquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.galiosquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.galiosquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.galiosquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.galiosquare);
						}	
					} else if(image.attr("data-image-name").equals("GangplankSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.gangplanksquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.gangplanksquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.gangplanksquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.gangplanksquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.gangplanksquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.gangplanksquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.gangplanksquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.gangplanksquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.gangplanksquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.gangplanksquare);
						}	
					} else if(image.attr("data-image-name").equals("GarenSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.garensquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.garensquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.garensquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.garensquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.garensquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.garensquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.garensquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.garensquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.garensquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.garensquare);
						}	
					} else if(image.attr("data-image-name").equals("GragasSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.gragassquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.gragassquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.gragassquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.gragassquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.gragassquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.gragassquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.gragassquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.gragassquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.gragassquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.gragassquare);
						}	
					} else if(image.attr("data-image-name").equals("GravesSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.gravessquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.gravessquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.gravessquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.gravessquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.gravessquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.gravessquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.gravessquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.gravessquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.gravessquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.gravessquare);
						}	
					} else if(image.attr("data-image-name").equals("HecarimSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.hecarimsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.hecarimsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.hecarimsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.hecarimsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.hecarimsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.hecarimsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.hecarimsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.hecarimsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.hecarimsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.hecarimsquare);
						}	
					} else if(image.attr("data-image-name").equals("HeimerdingerSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.heimerdingersquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.heimerdingersquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.heimerdingersquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.heimerdingersquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.heimerdingersquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.heimerdingersquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.heimerdingersquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.heimerdingersquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.heimerdingersquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.heimerdingersquare);
						}	
					} else if(image.attr("data-image-name").equals("IreliaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.ireliasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.ireliasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.ireliasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.ireliasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.ireliasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.ireliasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.ireliasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.ireliasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.ireliasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.ireliasquare);
						}	
					} else if(image.attr("data-image-name").equals("JannaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.jannasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.jannasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.jannasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.jannasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.jannasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.jannasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.jannasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.jannasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.jannasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.jannasquare);
						}	
					} else if(image.attr("data-image-name").equals("JarvanIVSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.jarvanivsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.jarvanivsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.jarvanivsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.jarvanivsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.jarvanivsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.jarvanivsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.jarvanivsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.jarvanivsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.jarvanivsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.jarvanivsquare);
						}	
					} else if(image.attr("data-image-name").equals("JaxSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.jaxsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.jaxsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.jaxsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.jaxsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.jaxsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.jaxsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.jaxsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.jaxsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.jaxsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.jaxsquare);
						}	
					} else if(image.attr("data-image-name").equals("JayceSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.jaycesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.jaycesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.jaycesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.jaycesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.jaycesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.jaycesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.jaycesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.jaycesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.jaycesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.jaycesquare);
						}	
					} else if(image.attr("data-image-name").equals("KarmaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.karmasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.karmasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.karmasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.karmasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.karmasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.karmasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.karmasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.karmasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.karmasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.karmasquare);
						}	
					} else if(image.attr("data-image-name").equals("KarthusSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.karthussquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.karthussquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.karthussquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.karthussquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.karthussquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.karthussquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.karthussquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.karthussquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.karthussquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.karthussquare);
						}	
					} else if(image.attr("data-image-name").equals("KassadinSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.kassadinsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.kassadinsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.kassadinsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.kassadinsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.kassadinsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.kassadinsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.kassadinsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.kassadinsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.kassadinsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.kassadinsquare);
						}	
					} else if(image.attr("data-image-name").equals("KatarinaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.katarinasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.katarinasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.katarinasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.katarinasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.katarinasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.katarinasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.katarinasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.katarinasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.katarinasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.katarinasquare);
						}	
					} else if(image.attr("data-image-name").equals("KayleSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.kaylesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.kaylesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.kaylesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.kaylesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.kaylesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.kaylesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.kaylesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.kaylesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.kaylesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.kaylesquare);
						}	
					} else if(image.attr("data-image-name").equals("KennenSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.kennensquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.kennensquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.kennensquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.kennensquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.kennensquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.kennensquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.kennensquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.kennensquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.kennensquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.kennensquare);
						}	
					} else if(image.attr("data-image-name").equals("KhaZixSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.khazixsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.khazixsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.khazixsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.khazixsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.khazixsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.khazixsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.khazixsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.khazixsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.khazixsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.khazixsquare);
						}	
					} else if(image.attr("data-image-name").equals("KogMawSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.kogmawsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.kogmawsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.kogmawsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.kogmawsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.kogmawsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.kogmawsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.kogmawsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.kogmawsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.kogmawsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.kogmawsquare);
						}	
					} else if(image.attr("data-image-name").equals("LeBlancSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.leblancsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.leblancsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.leblancsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.leblancsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.leblancsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.leblancsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.leblancsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.leblancsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.leblancsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.leblancsquare);
						}	
					} else if(image.attr("data-image-name").equals("LeeSinSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.leesinsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.leesinsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.leesinsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.leesinsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.leesinsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.leesinsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.leesinsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.leesinsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.leesinsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.leesinsquare);
						}	
					} else if(image.attr("data-image-name").equals("LeonaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.leonasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.leonasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.leonasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.leonasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.leonasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.leonasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.leonasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.leonasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.leonasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.leonasquare);
						}	
					} else if(image.attr("data-image-name").equals("LissandraSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.lissandrasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.lissandrasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.lissandrasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.lissandrasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.lissandrasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.lissandrasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.lissandrasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.lissandrasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.lissandrasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.lissandrasquare);
						}	
					} else if(image.attr("data-image-name").equals("LuluSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.lulusquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.lulusquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.lulusquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.lulusquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.lulusquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.lulusquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.lulusquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.lulusquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.lulusquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.lulusquare);
						}	
					} else if(image.attr("data-image-name").equals("LuxSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.luxsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.luxsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.luxsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.luxsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.luxsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.luxsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.luxsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.luxsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.luxsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.luxsquare);
						}	
					} else if(image.attr("data-image-name").equals("MalphiteSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.malphitesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.malphitesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.malphitesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.malphitesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.malphitesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.malphitesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.malphitesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.malphitesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.malphitesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.malphitesquare);
						}	
					} else if(image.attr("data-image-name").equals("MalzaharSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.malzaharsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.malzaharsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.malzaharsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.malzaharsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.malzaharsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.malzaharsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.malzaharsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.malzaharsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.malzaharsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.malzaharsquare);
						}	
					} else if(image.attr("data-image-name").equals("MaokaiSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.maokaisquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.maokaisquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.maokaisquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.maokaisquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.maokaisquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.maokaisquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.maokaisquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.maokaisquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.maokaisquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.maokaisquare);
						}	
					} else if(image.attr("data-image-name").equals("MasterYiSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.masteryisquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.masteryisquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.masteryisquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.masteryisquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.masteryisquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.masteryisquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.masteryisquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.masteryisquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.masteryisquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.masteryisquare);
						}	
					} else if(image.attr("data-image-name").equals("MissFortuneSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.missfortunesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.missfortunesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.missfortunesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.missfortunesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.missfortunesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.missfortunesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.missfortunesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.missfortunesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.missfortunesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.missfortunesquare);
						}	
					} else if(image.attr("data-image-name").equals("MordekaiserSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.mordekaisersquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.mordekaisersquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.mordekaisersquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.mordekaisersquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.mordekaisersquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.mordekaisersquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.mordekaisersquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.mordekaisersquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.mordekaisersquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.mordekaisersquare);
						}	
					} else if(image.attr("data-image-name").equals("MorganaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.morganasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.morganasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.morganasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.morganasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.morganasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.morganasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.morganasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.morganasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.morganasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.morganasquare);
						}	
					} else if(image.attr("data-image-name").equals("NamiSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.namisquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.namisquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.namisquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.namisquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.namisquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.namisquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.namisquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.namisquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.namisquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.namisquare);
						}	
					} else if(image.attr("data-image-name").equals("NasusSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.nasussquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.nasussquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.nasussquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.nasussquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.nasussquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.nasussquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.nasussquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.nasussquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.nasussquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.nasussquare);
						}	
					} else if(image.attr("data-image-name").equals("NautilusSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.nautilussquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.nautilussquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.nautilussquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.nautilussquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.nautilussquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.nautilussquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.nautilussquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.nautilussquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.nautilussquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.nautilussquare);
						}	
					} else if(image.attr("data-image-name").equals("NidaleeSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.nidaleesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.nidaleesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.nidaleesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.nidaleesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.nidaleesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.nidaleesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.nidaleesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.nidaleesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.nidaleesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.nidaleesquare);
						}	
					} else if(image.attr("data-image-name").equals("NocturneSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.nocturnesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.nocturnesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.nocturnesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.nocturnesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.nocturnesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.nocturnesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.nocturnesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.nocturnesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.nocturnesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.nocturnesquare);
						}	
					} else if(image.attr("data-image-name").equals("NunuSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.nunusquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.nunusquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.nunusquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.nunusquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.nunusquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.nunusquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.nunusquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.nunusquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.nunusquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.nunusquare);
						}	
					} else if(image.attr("data-image-name").equals("OlafSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.olafsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.olafsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.olafsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.olafsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.olafsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.olafsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.olafsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.olafsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.olafsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.olafsquare);
						}	
					} else if(image.attr("data-image-name").equals("OriannaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.oriannasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.oriannasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.oriannasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.oriannasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.oriannasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.oriannasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.oriannasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.oriannasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.oriannasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.oriannasquare);
						}	
					} else if(image.attr("data-image-name").equals("PantheonSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.pantheonsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.pantheonsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.pantheonsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.pantheonsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.pantheonsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.pantheonsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.pantheonsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.pantheonsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.pantheonsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.pantheonsquare);
						}	
					} else if(image.attr("data-image-name").equals("PoppySquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.poppysquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.poppysquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.poppysquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.poppysquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.poppysquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.poppysquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.poppysquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.poppysquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.poppysquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.poppysquare);
						}	
					} else if(image.attr("data-image-name").equals("QuinnSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.quinnsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.quinnsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.quinnsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.quinnsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.quinnsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.quinnsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.quinnsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.quinnsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.quinnsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.quinnsquare);
						}	
					} else if(image.attr("data-image-name").equals("RammusSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.rammussquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.rammussquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.rammussquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.rammussquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.rammussquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.rammussquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.rammussquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.rammussquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.rammussquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.rammussquare);
						}	
					} else if(image.attr("data-image-name").equals("RenektonSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.renektonsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.renektonsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.renektonsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.renektonsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.renektonsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.renektonsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.renektonsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.renektonsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.renektonsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.renektonsquare);
						}	
					} else if(image.attr("data-image-name").equals("RengarSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.rengarsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.rengarsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.rengarsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.rengarsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.rengarsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.rengarsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.rengarsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.rengarsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.rengarsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.rengarsquare);
						}	
					} else if(image.attr("data-image-name").equals("RivenSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.rivensquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.rivensquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.rivensquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.rivensquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.rivensquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.rivensquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.rivensquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.rivensquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.rivensquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.rivensquare);
						}	
					} else if(image.attr("data-image-name").equals("RumbleSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.rumblesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.rumblesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.rumblesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.rumblesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.rumblesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.rumblesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.rumblesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.rumblesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.rumblesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.rumblesquare);
						}	
					} else if(image.attr("data-image-name").equals("RyzeSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.ryzesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.ryzesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.ryzesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.ryzesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.ryzesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.ryzesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.ryzesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.ryzesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.ryzesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.ryzesquare);
						}	
					} else if(image.attr("data-image-name").equals("SejuaniSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.sejuanisquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.sejuanisquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.sejuanisquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.sejuanisquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.sejuanisquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.sejuanisquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.sejuanisquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.sejuanisquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.sejuanisquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.sejuanisquare);
						}	
					} else if(image.attr("data-image-name").equals("ShacoSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.shacosquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.shacosquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.shacosquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.shacosquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.shacosquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.shacosquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.shacosquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.shacosquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.shacosquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.shacosquare);
						}	
					} else if(image.attr("data-image-name").equals("ShenSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.shensquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.shensquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.shensquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.shensquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.shensquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.shensquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.shensquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.shensquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.shensquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.shensquare);
						}	
					} else if(image.attr("data-image-name").equals("ShyvanaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.shyvanasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.shyvanasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.shyvanasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.shyvanasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.shyvanasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.shyvanasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.shyvanasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.shyvanasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.shyvanasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.shyvanasquare);
						}	
					} else if(image.attr("data-image-name").equals("SingedSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.singedsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.singedsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.singedsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.singedsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.singedsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.singedsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.singedsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.singedsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.singedsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.singedsquare);
						}	
					} else if(image.attr("data-image-name").equals("SionSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.sionsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.sionsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.sionsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.sionsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.sionsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.sionsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.sionsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.sionsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.sionsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.sionsquare);
						}	
					} else if(image.attr("data-image-name").equals("SivirSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.sivirsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.sivirsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.sivirsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.sivirsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.sivirsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.sivirsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.sivirsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.sivirsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.sivirsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.sivirsquare);
						}	
					} else if(image.attr("data-image-name").equals("SkarnerSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.skarnersquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.skarnersquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.skarnersquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.skarnersquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.skarnersquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.skarnersquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.skarnersquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.skarnersquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.skarnersquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.skarnersquare);
						}	
					} else if(image.attr("data-image-name").equals("SonaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.sonasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.sonasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.sonasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.sonasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.sonasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.sonasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.sonasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.sonasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.sonasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.sonasquare);
						}	
					} else if(image.attr("data-image-name").equals("SorakaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.sorakasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.sorakasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.sorakasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.sorakasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.sorakasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.sorakasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.sorakasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.sorakasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.sorakasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.sorakasquare);
						}	
					} else if(image.attr("data-image-name").equals("SwainSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.swainsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.swainsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.swainsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.swainsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.swainsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.swainsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.swainsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.swainsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.swainsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.swainsquare);
						}	
					} else if(image.attr("data-image-name").equals("SyndraSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.syndrasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.syndrasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.syndrasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.syndrasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.syndrasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.syndrasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.syndrasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.syndrasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.syndrasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.syndrasquare);
						}	
					} else if(image.attr("data-image-name").equals("TalonSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.talonsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.talonsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.talonsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.talonsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.talonsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.talonsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.talonsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.talonsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.talonsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.talonsquare);
						}	
					} else if(image.attr("data-image-name").equals("TaricSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.taricsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.taricsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.taricsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.taricsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.taricsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.taricsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.taricsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.taricsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.taricsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.taricsquare);
						}	
					} else if(image.attr("data-image-name").equals("TeemoSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.teemosquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.teemosquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.teemosquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.teemosquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.teemosquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.teemosquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.teemosquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.teemosquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.teemosquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.teemosquare);
						}	
					} else if(image.attr("data-image-name").equals("ThreshSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.threshsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.threshsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.threshsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.threshsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.threshsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.threshsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.threshsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.threshsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.threshsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.threshsquare);
						}	
					} else if(image.attr("data-image-name").equals("TristanaSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.tristanasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.tristanasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.tristanasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.tristanasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.tristanasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.tristanasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.tristanasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.tristanasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.tristanasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.tristanasquare);
						}	
					} else if(image.attr("data-image-name").equals("TrundleSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.trundlesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.trundlesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.trundlesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.trundlesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.trundlesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.trundlesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.trundlesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.trundlesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.trundlesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.trundlesquare);
						}	
					} else if(image.attr("data-image-name").equals("TryndamereSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.tryndameresquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.tryndameresquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.tryndameresquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.tryndameresquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.tryndameresquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.tryndameresquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.tryndameresquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.tryndameresquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.tryndameresquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.tryndameresquare);
						}	
					} else if(image.attr("data-image-name").equals("TwistedFateSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.twistedfatesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.twistedfatesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.twistedfatesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.twistedfatesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.twistedfatesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.twistedfatesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.twistedfatesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.twistedfatesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.twistedfatesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.twistedfatesquare);
						}	
					} else if(image.attr("data-image-name").equals("TwitchSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.twitchsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.twitchsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.twitchsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.twitchsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.twitchsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.twitchsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.twitchsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.twitchsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.twitchsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.twitchsquare);
						}	
					} else if(image.attr("data-image-name").equals("UdyrSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.udyrsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.udyrsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.udyrsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.udyrsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.udyrsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.udyrsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.udyrsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.udyrsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.udyrsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.udyrsquare);
						}	
					} else if(image.attr("data-image-name").equals("UrgotSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.urgotsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.urgotsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.urgotsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.urgotsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.urgotsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.urgotsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.urgotsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.urgotsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.urgotsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.urgotsquare);
						}	
					} else if(image.attr("data-image-name").equals("VarusSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.varussquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.varussquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.varussquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.varussquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.varussquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.varussquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.varussquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.varussquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.varussquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.varussquare);
						}	
					} else if(image.attr("data-image-name").equals("VayneSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.vaynesquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.vaynesquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.vaynesquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.vaynesquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.vaynesquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.vaynesquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.vaynesquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.vaynesquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.vaynesquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.vaynesquare);
						}	
					} else if(image.attr("data-image-name").equals("VeigarSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.veigarsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.veigarsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.veigarsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.veigarsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.veigarsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.veigarsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.veigarsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.veigarsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.veigarsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.veigarsquare);
						}	
					} else if(image.attr("data-image-name").equals("ViSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.visquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.visquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.visquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.visquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.visquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.visquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.visquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.visquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.visquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.visquare);
						}	
					} else if(image.attr("data-image-name").equals("ViktorSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.viktorsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.viktorsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.viktorsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.viktorsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.viktorsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.viktorsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.viktorsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.viktorsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.viktorsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.viktorsquare);
						}	
					} else if(image.attr("data-image-name").equals("VladimirSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.vladimirsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.vladimirsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.vladimirsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.vladimirsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.vladimirsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.vladimirsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.vladimirsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.vladimirsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.vladimirsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.vladimirsquare);
						}	
					} else if(image.attr("data-image-name").equals("VolibearSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.volibearsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.volibearsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.volibearsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.volibearsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.volibearsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.volibearsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.volibearsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.volibearsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.volibearsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.volibearsquare);
						}	
					} else if(image.attr("data-image-name").equals("WarwickSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.warwicksquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.warwicksquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.warwicksquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.warwicksquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.warwicksquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.warwicksquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.warwicksquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.warwicksquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.warwicksquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.warwicksquare);
						}	
					} else if(image.attr("data-image-name").equals("WukongSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.wukongsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.wukongsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.wukongsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.wukongsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.wukongsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.wukongsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.wukongsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.wukongsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.wukongsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.wukongsquare);
						}	
					} else if(image.attr("data-image-name").equals("XerathSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.xerathsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.xerathsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.xerathsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.xerathsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.xerathsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.xerathsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.xerathsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.xerathsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.xerathsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.xerathsquare);
						}	
					} else if(image.attr("data-image-name").equals("XinZhaoSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.xinzhaosquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.xinzhaosquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.xinzhaosquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.xinzhaosquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.xinzhaosquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.xinzhaosquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.xinzhaosquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.xinzhaosquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.xinzhaosquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.xinzhaosquare);
						}	
					} else if(image.attr("data-image-name").equals("YorickSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.yoricksquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.yoricksquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.yoricksquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.yoricksquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.yoricksquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.yoricksquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.yoricksquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.yoricksquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.yoricksquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.yoricksquare);
						}	
					} else if(image.attr("data-image-name").equals("ZacSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.zacsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.zacsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.zacsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.zacsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.zacsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.zacsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.zacsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.zacsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.zacsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.zacsquare);
						}	
					} else if(image.attr("data-image-name").equals("ZedSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.zedsquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.zedsquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.zedsquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.zedsquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.zedsquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.zedsquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.zedsquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.zedsquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.zedsquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.zedsquare);
						}	
					} else if(image.attr("data-image-name").equals("ZiggsSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.ziggssquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.ziggssquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.ziggssquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.ziggssquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.ziggssquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.ziggssquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.ziggssquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.ziggssquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.ziggssquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.ziggssquare);
						}	
					} else if(image.attr("data-image-name").equals("ZileanSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.zileansquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.zileansquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.zileansquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.zileansquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.zileansquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.zileansquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.zileansquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.zileansquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.zileansquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.zileansquare);
						}	
					} else if(image.attr("data-image-name").equals("ZyraSquare.png")) {
						if (ivFreeOne.getDrawable() == null) {
							ivFreeOne.setImageResource(R.drawable.zyrasquare);
						} else if (ivFreeTwo.getDrawable() == null) {
							ivFreeTwo.setImageResource(R.drawable.zyrasquare);
						} else if (ivFreeThree.getDrawable() == null) {
							ivFreeThree.setImageResource(R.drawable.zyrasquare);
						} else if (ivFreeFour.getDrawable() == null) {
							ivFreeFour.setImageResource(R.drawable.zyrasquare);
						} else if (ivFreeFive.getDrawable() == null) {
							ivFreeFive.setImageResource(R.drawable.zyrasquare);
						} else if (ivFreeSix.getDrawable() == null) {
							ivFreeSix.setImageResource(R.drawable.zyrasquare);
						} else if (ivFreeSeven.getDrawable() == null) {
							ivFreeSeven.setImageResource(R.drawable.zyrasquare);
						} else if (ivFreeEight.getDrawable() == null) {
							ivFreeEight.setImageResource(R.drawable.zyrasquare);
						} else if (ivFreeNine.getDrawable() == null) {
							ivFreeNine.setImageResource(R.drawable.zyrasquare);
						} else if (ivFreeTen.getDrawable() == null) {
							ivFreeTen.setImageResource(R.drawable.zyrasquare);
						}	
					} 
					
				}		
			}
		}
	}

}
