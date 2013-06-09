package com.jt.getdunked2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ResponseCache;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.DefaultedHttpContext;
import org.json.JSONObject;

import com.actionbarsherlock.app.SherlockActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.CursorJoiner.Result;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ProfileActivity extends SherlockActivity {
	
	LocationManager lm;
	
	ArrayList someArrayList = null;
	LazyAdapter lazyAdapter;
	Response response;
	
	ListView lv;
	TextView loadingText;
	static EditText evSummName;
	String url;
	Button btnSearch;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		// Show the Up button in the action bar.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		lv = (ListView) findViewById(R.id.listViewStats);
		evSummName = (EditText) findViewById(R.id.etSearch);
		url = "http://api.elophant.com/v2/NA/in_progress_game_info/" + evSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
		
		someArrayList = new ArrayList();
		lazyAdapter = new LazyAdapter(ProfileActivity.this, R.layout.custom_list_view, someArrayList);
		btnSearch = (Button) findViewById(R.id.btnSearch);
		
		lv.setTextFilterEnabled(true);
		lv.setAdapter(lazyAdapter);
		
		btnSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				new PostFetcher().execute(url);
				
			}
		});
		
		
		

		
		//String json = "{"data":{"lastModifiedDate":"\/Date(-62135568000000-0800)\/","game":{"gameStartTime":"\/Date(1370584778000-0700)\/","spectatorsAllowed":"NONE","passwordSet":false,"gameType":"NORMAL_GAME","gameTypeConfigId":1,"gameState":"IN_PROGRESS","observers":[],"statusOfParticipants":"1111111111","id":907503190,"teamOne":[{"timeAddedToQueue":1370584536145,"index":0,"accountId":39202757,"botDifficulty":"NONE","summonerInternalName":"beelzeb1","lastSelectedSkinIndex":0,"profileIconId":13,"teamOwner":false,"summonerId":24806628,"pickTurn":1,"summonerName":"Beelzeb1","pickMode":0,"originalPlatformId":"NA"},{"timeAddedToQueue":1370584519874,"index":0,"accountId":44735992,"botDifficulty":"NONE","summonerInternalName":"snakesisisisisi","lastSelectedSkinIndex":5,"profileIconId":502,"teamOwner":false,"summonerId":30457712,"pickTurn":1,"summonerName":"Snake SiSiSiSiSi","pickMode":0,"originalPlatformId":"NA1"},{"timeAddedToQueue":1370584519874,"index":0,"accountId":44746140,"botDifficulty":"NONE","summonerInternalName":"brucelv","lastSelectedSkinIndex":0,"profileIconId":502,"teamOwner":true,"summonerId":30377776,"pickTurn":1,"summonerName":"BruceLV","pickMode":0,"originalPlatformId":"NA1"},{"timeAddedToQueue":1370584522894,"index":0,"accountId":35254611,"botDifficulty":"NONE","summonerInternalName":"daralex","lastSelectedSkinIndex":0,"profileIconId":545,"teamOwner":false,"summonerId":21748409,"pickTurn":1,"summonerName":"Daralex","pickMode":0,"originalPlatformId":"NA"},{"timeAddedToQueue":1370584519874,"index":0,"accountId":45480424,"botDifficulty":"NONE","summonerInternalName":"beanyang","lastSelectedSkinIndex":0,"profileIconId":6,"teamOwner":false,"summonerId":31034110,"pickTurn":1,"summonerName":"BeanYang","pickMode":0,"originalPlatformId":"NA1"}],"teamTwo":[{"timeAddedToQueue":1370584522702,"index":0,"accountId":33564286,"botDifficulty":"NONE","summonerInternalName":"ghosthin","lastSelectedSkinIndex":4,"profileIconId":518,"teamOwner":true,"summonerId":20550448,"pickTurn":1,"summonerName":"Ghost Hin","pickMode":0,"originalPlatformId":"NA"},{"timeAddedToQueue":1370584516141,"index":0,"accountId":46994824,"botDifficulty":"NONE","summonerInternalName":"warrtu4n","lastSelectedSkinIndex":3,"profileIconId":12,"teamOwner":false,"summonerId":32153136,"pickTurn":1,"summonerName":"WarrTu4n","pickMode":0,"originalPlatformId":"NA1"},{"timeAddedToQueue":1370584522702,"index":0,"accountId":39664317,"botDifficulty":"NONE","summonerInternalName":"xeneria","lastSelectedSkinIndex":0,"profileIconId":28,"teamOwner":false,"summonerId":25126590,"pickTurn":1,"summonerName":"Xeneria","pickMode":0,"originalPlatformId":"NA"},{"timeAddedToQueue":1370584522702,"index":0,"accountId":32624077,"botDifficulty":"NONE","summonerInternalName":"trooprm32","lastSelectedSkinIndex":0,"profileIconId":539,"teamOwner":false,"summonerId":19875107,"pickTurn":1,"summonerName":"Trooprm32","pickMode":0,"originalPlatformId":"NA"},{"timeAddedToQueue":1370584522702,"index":0,"accountId":36849883,"botDifficulty":"NONE","summonerInternalName":"stevefrenchjr","lastSelectedSkinIndex":0,"profileIconId":538,"teamOwner":false,"summonerId":22907290,"pickTurn":1,"summonerName":"Steve French Jr","pickMode":0,"originalPlatformId":"NA"}],"bannedChampions":[],"name":"Match-907503190","spectatorDelay":0,"terminatedCondition":"NOT_TERMINATED","queueTypeName":"NORMAL","optimisticLock":22,"maxNumPlayers":10,"queuePosition":0,"gameMode":"CLASSIC","mapId":1,"pickTurn":3,"playerChampionSelections":[{"summonerInternalName":"ghosthin","spell1Id":14,"spell2Id":12,"selectedSkinIndex":0,"championId":17},{"summonerInternalName":"warrtu4n","spell1Id":11,"spell2Id":4,"selectedSkinIndex":0,"championId":64},{"summonerInternalName":"snakesisisisisi","spell1Id":4,"spell2Id":14,"selectedSkinIndex":0,"championId":11},{"summonerInternalName":"stevefrenchjr","spell1Id":3,"spell2Id":4,"selectedSkinIndex":0,"championId":80},{"summonerInternalName":"beelzeb1","spell1Id":4,"spell2Id":11,"selectedSkinIndex":0,"championId":154},{"summonerInternalName":"xeneria","spell1Id":4,"spell2Id":14,"selectedSkinIndex":6,"championId":39},{"summonerInternalName":"beanyang","spell1Id":3,"spell2Id":4,"selectedSkinIndex":0,"championId":412},{"summonerInternalName":"trooprm32","spell1Id":14,"spell2Id":4,"selectedSkinIndex":0,"championId":105},{"summonerInternalName":"brucelv","spell1Id":12,"spell2Id":6,"selectedSkinIndex":0,"championId":27},{"summonerInternalName":"daralex","spell1Id":4,"spell2Id":21,"selectedSkinIndex":0,"championId":119}]},"playerCredentials":{"gameId":907503190,"lastSelectedSkinIndex":0,"observer":true,"observerServerIp":"216.133.234.17","playerId":35254611,"observerServerPort":8088,"observerEncryptionKey":"qK3C03Pl+wI4qMPCqu1OETAqNsL3V9Rd"},"gameName":"match-907503190"},"success":true}";
		
		//InGameStats data = new Gson().fromJson(json, InGameStats.class);
	    
		
	}
	
	
	private class PostFetcher extends AsyncTask<String, Void, String> {
		private static final String TAG = "PostFetcher";
		public final String SERVER_URL = "http://api.elophant.com/v2/NA/in_progress_game_info/" + evSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
		public String jsonString = "";
		
		
		@Override
		protected String doInBackground(String... urls) {  
			try {
				  URL url = new URL(SERVER_URL);
					BufferedReader in = new BufferedReader(
						new InputStreamReader(url.openStream()));
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						jsonString = inputLine;
					}
					in.close();
					//Create gson
			        Gson gson = new Gson();
					response = gson.fromJson(jsonString, Response.class);
					//Log.w("json", gson.toJson(response).toString()); 
				} catch (IOException e) {
			  		e.getMessage();
						e.printStackTrace();
				} catch (Exception e) {
						e.getMessage();
						e.printStackTrace();
				}
			return jsonString;
			
		}
		
		@Override
		protected void onPostExecute(String jsonString)
		{
			
			TextView tvSummName = (TextView) findViewById(R.id.tvSummonerName);
			if (response != null && response.getData() != null)
			{
				tvSummName.setText(response.getData().getGame().getGameMode());
			}
			else {
				Toast.makeText(ProfileActivity.this, "" + evSummName.getText().toString() + " is not in a game", Toast.LENGTH_LONG).show();
			}
		}
	}
}


