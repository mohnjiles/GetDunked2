package com.jt.getdunked2;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
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
    	
    	tvDoubleKills = (TextView) v.findViewById(R.id.tvDoubleKills);
    	tvTripleKills = (TextView) v.findViewById(R.id.tvTripleKills);
    	tvQuadraKills = (TextView) v.findViewById(R.id.tvQuadraKills);
    	tvPentaKills = (TextView) v.findViewById(R.id.tvPentaKills);
    	tvKills = (TextView) v.findViewById(R.id.tvLifetimeKills);
    	tvDeaths = (TextView) v.findViewById(R.id.tvLifetimeDeaths);
    	tvAssists = (TextView) v.findViewById(R.id.tvLifetimeAssists);
    	tvKillingSprees = (TextView) v.findViewById(R.id.tvKillingSprees);
    	tvMostKills = (TextView) v.findViewById(R.id.tvMostKills);
    	tvMostDeaths = (TextView) v.findViewById(R.id.tvMostDeaths);
    	tvGold = (TextView) v.findViewById(R.id.tvGold);
    	tvMinions = (TextView) v.findViewById(R.id.tvMinions);
    	tvNeutralMonsters = (TextView) v.findViewById(R.id.tvNeutralMonsters);
    	tvDamageDealt = (TextView) v.findViewById(R.id.tvLifetimeDamageDealt);
    	tvMagicDamage = (TextView) v.findViewById(R.id.tvMagicDamageDealt);
    	tvPhysicalDamage = (TextView) v.findViewById(R.id.tvPhysicalDamageDealt);
    	tvHealingDone = (TextView) v.findViewById(R.id.tvHealingDone);
    	tvDamageTaken = (TextView) v.findViewById(R.id.tvDamageTaken);
    	tvLargestCrit = (TextView) v.findViewById(R.id.tvLargestCrit);
    	tvKillingSpree = (TextView) v.findViewById(R.id.tvLargestKillingSpree);
    	tvTimeDead = (TextView) v.findViewById(R.id.tvTimeDead);
    	tvLifespan = (TextView) v.findViewById(R.id.tvLongestAlive);
    	tvLongestGame = (TextView) v.findViewById(R.id.tvLongestGame);
    	tvGamesPlayed = (TextView) v.findViewById(R.id.tvGamesPlayed);
    	tvGamesWon = (TextView) v.findViewById(R.id.tvGamesWon);
    	tvGamesLost = (TextView) v.findViewById(R.id.tvGamesLost);
    	
    	return v;
	}
}
