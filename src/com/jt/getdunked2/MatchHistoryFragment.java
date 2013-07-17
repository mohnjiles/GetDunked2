package com.jt.getdunked2;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;
import com.jt.getdunked2.AsyncTasks.PostFetcher;

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
import android.view.inputmethod.InputMethodManager;
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

	public static ListView lv;
	TextView loadingText;
	static EditText etSummName;
	String url;
	Button btnSearch;
	public static TextView tvOne;
	MatchHistoryFragment our_context;
	
	public static int matchNumber;
	public static Number champId[];
	public static Number teamId[];

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
		// Inflate the layout for this fragment    
	    View V = inflater.inflate(R.layout.match_history_fragment, container, false);
	    
		etSummName = (EditText) getSherlockActivity().findViewById(R.id.etSummName);
		url = "http://api.elophant.com/v2/NA/in_progress_game_info/"
				+ etSummName.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
		
		
		return V;	
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		btnSearch = (Button) getSherlockActivity().findViewById(R.id.button2);
		lv = getListView();
		
		((Button)btnSearch).setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				AsyncTasks tasks = new AsyncTasks();
				PostFetcher pf = tasks.new PostFetcher(getSherlockActivity());
				pf.execute(url);
			}
		});	
		
	}
}
