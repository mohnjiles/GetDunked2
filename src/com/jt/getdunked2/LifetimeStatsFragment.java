package com.jt.getdunked2;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class LifetimeStatsFragment extends Fragment {

	public static TextView tvDoubleKills;
	public static TextView tvTripleKills;
	public static TextView tvQuadraKills;
	public static TextView tvPentaKills;
	public static TextView tvKills;
	public static TextView tvDeaths;
	public static TextView tvAssists;
	public static TextView tvKillingSprees;
	public static TextView tvMostKills;
	public static TextView tvMostDeaths;
	public static TextView tvGold;
	public static TextView tvMinions;
	public static TextView tvNeutralMonsters;
	public static TextView tvDamageDealt;
	public static TextView tvMagicDamage;
	public static TextView tvPhysicalDamage;
	public static TextView tvHealingDone;
	public static TextView tvDamageTaken;
	public static TextView tvLargestCrit;
	public static TextView tvKillingSpree;
	public static TextView tvTimeDead;
	public static TextView tvLifespan;
	public static TextView tvLongestGame;
	public static TextView tvGamesPlayed;
	public static TextView tvGamesWon;
	public static TextView tvGamesLost;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View v = inflater.inflate(R.layout.fragment_lifetime_stats, container, false);
    	
    	
    	
    	return v;
	}
    
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		tvDoubleKills = (TextView) getView().findViewById(R.id.tvDoubleKills);
    	tvTripleKills = (TextView) getView().findViewById(R.id.tvTripleKills);
    	tvQuadraKills = (TextView) getView().findViewById(R.id.tvQuadraKills);
    	tvPentaKills = (TextView) getView().findViewById(R.id.tvPentaKills);
    	tvKills = (TextView) getView().findViewById(R.id.tvLifetimeKills);
    	tvDeaths = (TextView) getView().findViewById(R.id.tvLifetimeDeaths);
    	tvAssists = (TextView) getView().findViewById(R.id.tvLifetimeAssists);
    	tvKillingSprees = (TextView) getView().findViewById(R.id.tvKillingSprees);
    	tvMostKills = (TextView) getView().findViewById(R.id.tvMostKills);
    	tvMostDeaths = (TextView) getView().findViewById(R.id.tvMostDeaths);
    	tvGold = (TextView) getView().findViewById(R.id.tvGold);
    	tvMinions = (TextView) getView().findViewById(R.id.tvMinions);
    	tvNeutralMonsters = (TextView) getView().findViewById(R.id.tvNeutralMonsters);
    	tvDamageDealt = (TextView) getView().findViewById(R.id.tvLifetimeDamageDealt);
    	tvMagicDamage = (TextView) getView().findViewById(R.id.tvMagicDamageDealt);
    	tvPhysicalDamage = (TextView) getView().findViewById(R.id.tvPhysicalDamageDealt);
    	tvHealingDone = (TextView) getView().findViewById(R.id.tvHealingDone);
    	tvDamageTaken = (TextView) getView().findViewById(R.id.tvDamageTaken);
    	tvLargestCrit = (TextView) getView().findViewById(R.id.tvLargestCrit);
    	tvKillingSpree = (TextView) getView().findViewById(R.id.tvLargestKillingSpree);
    	tvTimeDead = (TextView) getView().findViewById(R.id.tvTimeDead);
    	tvLifespan = (TextView) getView().findViewById(R.id.tvLongestAlive);
    	tvLongestGame = (TextView) getView().findViewById(R.id.tvLongestGame);
    	tvGamesPlayed = (TextView) getView().findViewById(R.id.tvGamesPlayed);
    	tvGamesWon = (TextView) getView().findViewById(R.id.tvGamesWon);
    	tvGamesLost = (TextView) getView().findViewById(R.id.tvGamesLost);
		
		
		
	}
}
