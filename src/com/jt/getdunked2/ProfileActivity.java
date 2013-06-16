package com.jt.getdunked2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.actionbarsherlock.app.SherlockActivity;
import com.google.gson.JsonParseException;

import android.R.integer;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends SherlockActivity {
// paige jones object oriented programming *** remember plz ***
	LocationManager lm;

	ArrayList<GameStatistics> someArrayList = null;
	LazyAdapter lazyAdapter;

	ListView lv;
	TextView loadingText;
	static EditText etSummName;
	String url;
	Button btnSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		lv = (ListView) findViewById(R.id.listViewStats);
		etSummName = (EditText) findViewById(R.id.etSearch);
		url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";

		
		btnSearch = (Button) findViewById(R.id.btnSearch);

		

		btnSearch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new PostFetcher().execute(url);
				someArrayList = new ArrayList();
				lazyAdapter = new LazyAdapter(ProfileActivity.this,
						R.layout.custom_list_view, someArrayList);
				
				lv.setTextFilterEnabled(true);
				lv.setAdapter(lazyAdapter);
				
				

			}
		});
	}

	private static class PostFetchResult {
		InGameStats igs;
		Summoner summoner;
		List<GameStatistics> recentGames;
	}
	
	public static class SoData {
		public Data data;
	}
	

	private class PostFetcher extends AsyncTask<String, Void, PostFetchResult> {
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
			} catch (NullPointerException e) {
				Log.w("NPE recentGames", "Recent Games error: " + e.getMessage());
				
			}
			return result;
			
		}

		@Override
		protected void onPostExecute(PostFetchResult result) {
			// TextView declarations -- may not keep
			TextView tvSummName = (TextView) findViewById(R.id.tvSummonerName);
			TextView tvSummLevel = (TextView) findViewById(R.id.tvSummonerLevel);
			TextView tvDebug = (TextView) findViewById(R.id.tvDebug);

			if(result == null) {
				Toast.makeText(getApplicationContext(), "Null result, aborting", Toast.LENGTH_LONG);
			}
			
			// Set InGameStats data to TextView
			if (result.igs != null && result.igs.getData() != null) {
				tvSummName.setText(result.igs.getData().getGame().getGameMode());
			} else {
				Toast.makeText(ProfileActivity.this, "" + etSummName.getText().toString().replace(" ", "")
								+ " is not in a game", Toast.LENGTH_LONG).show();
			}
			
			// Set Summoner data to TextView
			if (result.summoner != null && result.summoner.getData() != null) {
				tvSummLevel.setText(result.summoner.getData().getName());
			} else {
				Toast.makeText(ProfileActivity.this, "An error occured", Toast.LENGTH_LONG).show();
			}
			
			try {
				if (result.recentGames.size() > 0)
				{
					
					Number gameHeal = null;
					Number gameId = result.recentGames.get(0).getGameId();
								

					for(Statistics statistic : result.recentGames.get(0).getStatistics()) {
						if(statistic.getStatType().equals("TOTAL_HEAL")) {
							gameHeal = statistic.getValue();
						}
					}
					
					tvDebug.setText(gameId.toString());
					
					
					
					for(GameStatistics stats : result.recentGames)
					{
						someArrayList.add(stats);
						
						
					}					
				}
			} catch (NullPointerException e){
				Log.w("Oops", "An error occured: " + e.getMessage());
			}
			
		}
	}
}
