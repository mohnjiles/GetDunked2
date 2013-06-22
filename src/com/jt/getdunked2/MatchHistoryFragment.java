package com.jt.getdunked2;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;

import android.R.anim;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;;

public class MatchHistoryFragment extends SherlockListFragment {
// paige jones object oriented programming *** remember plz ***
	LocationManager lm;

	ArrayList<GameStatistics> someArrayList;
	LazyAdapter lazyAdapter;

	ListView lv;
	TextView loadingText;
	static EditText etSummName;
	String url;
	Button btnSearch;
	TextView tvOne;
	MatchHistoryFragment our_context;
	
	public static int matchNumber;
	public static Number champId[];
	public static Number teamId[];

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	    	
	    
	    View V = inflater.inflate(R.layout.activity_profile, container, false);
		tvOne = (TextView) V.findViewById(R.id.tvTitle);
		etSummName = (EditText) getSherlockActivity().findViewById(R.id.etSummName);
		url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
		
		
		
			  

		return V;

		
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		btnSearch = (Button) getSherlockActivity().findViewById(R.id.button2);
		

		((Button)btnSearch).setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				PostFetcher pf = new PostFetcher(getSherlockActivity());
				pf.execute(url);
				
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
	
	
	public class PostFetcher extends AsyncTask<String, Void, PostFetchResult> {
		private ProgressDialog dialog;
		private Context context;
		public PostFetcher(Context cxt) {
			context = cxt;
			dialog = new ProgressDialog(context);
		}
		
		
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
			} catch (Exception e) {
				Log.w("doInBackground recentGames", "Recent Games error: " + e.getMessage());
				
			}
			return result;
			
		}
		
		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			dialog = ProgressDialog.show(context, "", "Loading " + etSummName.getText().toString() + "'s match history...", true);
			dialog.show();
		}

		@Override
		protected void onPostExecute(PostFetchResult result) {
			// TextView declarations -- may not keep

			if(result == null) {
				Toast.makeText(getSherlockActivity(), "Null result, aborting", Toast.LENGTH_LONG).show();
			}
			
			
			
			someArrayList = new ArrayList<GameStatistics>();
			dialog.dismiss();
			try {
				if (result.recentGames.size() > 0)
				{		
					for(GameStatistics stats : result.recentGames)
					{
						someArrayList.add(stats);
					}					
					
				}
				lv = getListView();
				lazyAdapter = new LazyAdapter(context,
						R.layout.custom_list_view, someArrayList);

				setListAdapter(lazyAdapter);
				tvOne.setText("Summoner Name:");
				lazyAdapter.notifyDataSetChanged();
				
			} catch (Exception e){
				
				AlertDialog aDialog = new AlertDialog.Builder(context).create();
				aDialog.setTitle("Error");
				aDialog.setMessage("Unable to get summoner match history. Please try again in a few seconds.");
				aDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {	
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						
					}
				});
				
				aDialog.show();
				
				
				Log.w("Oops", "An error occured: " + e.getMessage());
				
			}
			
		}
	}



}
