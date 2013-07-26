package com.jt.getdunked2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class QPopup extends Fragment {
	
	TextView tvSpellName;
	ImageView ivPassiveIcon;
	TextView tvHeader1;
	TextView tvHeader2;
	TextView tvHeader3;
	TextView tvHeader4;
	TextView tvHeader5;
	TextView tvHeader6;
	TextView tvValue1;
	TextView tvValue2;
	TextView tvValue3;
	TextView tvValue4;
	TextView tvValue5;
	TextView tvValue6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View V = inflater.inflate(R.layout.activity_q_popup, container, false);
    	
    	int position = ChampsActivity.myInt;
    	
    	
		
		tvSpellName = (TextView)V.findViewById(R.id.tvSpellName);
		ivPassiveIcon = (ImageView)V.findViewById(R.id.ivFreeThree);
		tvHeader1 = (TextView)V.findViewById(R.id.tvHeader1);
		tvHeader2 = (TextView)V.findViewById(R.id.tvHeader2);
		tvHeader3 = (TextView)V.findViewById(R.id.tvHeader3);
		tvHeader4 = (TextView)V.findViewById(R.id.tvHeader4);
		tvHeader5 = (TextView)V.findViewById(R.id.tvHeader5);
		tvHeader6 = (TextView)V.findViewById(R.id.tvHeader6);
		tvValue1 = (TextView)V.findViewById(R.id.tvValue1);
		tvValue2 = (TextView)V.findViewById(R.id.tvValue2);
		tvValue3 = (TextView)V.findViewById(R.id.tvValue3);
		tvValue4 = (TextView)V.findViewById(R.id.tvValue4);
		tvValue5 = (TextView)V.findViewById(R.id.tvValue5);
		tvValue6 = (TextView)V.findViewById(R.id.tvValue6);
		
		
		switch (position) {
			case 0:
				SetStuff("Orb of Deception", R.drawable.orb_of_deception, "Range", "Cooldown", "Cost", "Magic / True Damage", "Max Damage to Same Target", 
						"880", "7 seconds", "70 / 75 / 80 / 85 / 90 Mana", "40 / 65 / 90 / 115 / 140 (+ 33% AP)", "80 / 130 / 180 / 230 / 280 (+ 66% AP)");
				break;
			case 1:
				SetStuff("Mark of the Assassin", R.drawable.mark_of_the_assassin, "Range", "Cooldown", "Cost", "Initial Magic Damage", 
						"Detonation Magic Damage", "Energy Restored", "600", "6 / 5.5 / 5 / 4.5 / 4 seconds", "60 Energy", 
						"35 / 55 / 75 / 95 / 115 (+ 40% AP)", "45 / 70 / 95 / 120 / 145 (+ 50% AP)", "20 / 25 / 30 / 35 / 40 Energy");
				break;
			case 2:
				SetStuff("Pulverize", R.drawable.pulverize, "Range", "Cooldown", "Cost", "Magic Damage", "182.5", "17 / 16 / 15 / 14 / 13 seconds", 
						"70 / 80 / 90 / 100 / 110 Mana", "60 / 105 / 150 / 195 / 240 (+50% AP)");
				break;
			case 3:
				SetStuff("Bandage Toss", R.drawable.bandage_toss, "Range", "Cooldown", "Cost", "Magic Damage", "1100", "16 / 14 / 12 / 10 / 8 seconds", 
						"80 / 90 / 100 / 110 / 120 Mana", "80 / 130 / 180 / 230 / 280 (+ 70% AP)");
				break;
			case 4:
				SetStuff("Flash Frost", R.drawable.flash_frost, "Range", "Projectile Speed", "Cooldown", "Cost", "Magic Damage", "Max Damage", "1100", 
						"850", "12 / 11 / 10 / 9 / 8 seconds", "80 / 100 / 120 / 140 / 160 Mana", "60 / 90 / 120 / 150 / 180 (+ 50% AP)", 
						"120 / 180 / 240 / 300 / 360 (+ 100% AP)");
				break;
			case 5:
				SetStuff("Disintegrate", R.drawable.disintegrate, "Range", "Cooldown", "Cost", "Magic Damage", "625", "4 seconds", 
						"60 / 65 / 70 / 75 / 80 Mana", "85 / 125 / 165 / 205 / 245 (+ 70% AP)");
				break;
			case 6:
				SetStuff("Frost Shot", R.drawable.frost_shot, "Cost", "Slow", "8 Mana per Attack", "15 / 20 / 25 / 30 / 35%");
				break;
			case 7:
				SetStuff("Rocket Grab", R.drawable.rocket_grab, "Range", "Cooldown", "Cost", "Magic Damage", "Projectile Speed", 
						"925", "20 / 19 / 18 / 17 / 16 seconds", "120 Mana", "80 / 135 / 190 / 245 / 300 (+ 100% AP)", "1800");
				break;
			case 8:
				SetStuff("Sear", R.drawable.sear, "Range", "Cooldown", "Cost", "Magic Damage", "900", "8 / 7.5 / 7 / 6.5 / 6 seconds", "50 Mana", 
						"80 / 120 / 160 / 200 / 240 (+ 65% AP)");
				break;
			case 9:
				SetStuff("Piltover Peacemaker", R.drawable.piltover_peacemaker, "Range", "Cooldown", "Cost", "Physical Damage", "Minimum Damage", 
						"1300", "10 / 9 / 8 / 7 / 6 seconds", "50 / 60 / 70 / 80 / 90 mana", "20 / 60 / 100 / 140 / 180 (+ 130% AD)", 
						"10 / 30 / 50 / 70 / 90 (+ 65% AD)");
				break;
			case 10:
				SetStuff("Noxious Blast", R.drawable.noxious_blast, "Range", "Cooldown", "Cost", "Magic Damage per Second", "Total Magic Damage", 
						"Movement Speed", "850", "3 seconds", "35 / 45 / 55 / 65 / 75 Mana", "25 / 38 / 52 / 65 / 78 (+ 27% AP)", 
						"75 / 115 / 155 / 195 / 235 (+ 80% AP)", "15% / 17.5% / 20% / 22.5% / 25%");
				break;
			case 11:
				SetStuff("Rupture", R.drawable.rupture, "Range", "Cooldown", "Cost", "Magic Damage", "950", "9 seconds", "90 Mana", 
						"80 / 135 / 190 / 245 / 305 (+ 100% AP)");
				break;
			case 12:
				SetStuff("Phosphorus Bomb", R.drawable.phosphorus_bomb, "Range", "Cooldown", "Cost", "Magic Damage", "600", "8 seconds", 
						"80 / 90 / 100 / 110 / 120 Mana", "80 / 130 / 180 / 230 / 280 (+ 50% AP)");
				break;
		}  	
        return V;       
    }

	public void SetStuff(String abilityName, int abilityIcon, String header1, String header2, String header3, String header4, 
			String header5, String header6, String value1, String value2, String value3, String value4, String value5, String value6) {
		
		tvSpellName.setText(abilityName);
		ivPassiveIcon.setImageResource(abilityIcon);
		tvHeader1.setText(header1);
		tvHeader2.setText(header2);
		tvHeader3.setText(header3);
		tvHeader4.setText(header4);
		tvHeader5.setText(header5);
		tvHeader6.setText(header6);
		tvValue1.setText(value1);
		tvValue2.setText(value2);
		tvValue3.setText(value3);
		tvValue4.setText(value4);
		tvValue5.setText(value5);
		tvValue6.setText(value6);
		
		
	}

	public void SetStuff(String abilityName, int abilityIcon, String header1, String header2, String header3, String header4, 
			String header5, String value1, String value2, String value3, String value4, String value5) {
		
		tvSpellName.setText(abilityName);
		ivPassiveIcon.setImageResource(abilityIcon);
		tvHeader1.setText(header1);
		tvHeader2.setText(header2);
		tvHeader3.setText(header3);
		tvHeader4.setText(header4);
		tvHeader5.setText(header5);
		tvValue1.setText(value1);
		tvValue2.setText(value2);
		tvValue3.setText(value3);
		tvValue4.setText(value4);
		tvValue5.setText(value5);
		
		tvHeader6.setVisibility(View.GONE);
		tvValue6.setVisibility(View.GONE);
		
	}
	public void SetStuff(String abilityName, int abilityIcon, String header1, String header2, String header3, String header4, 
			String value1, String value2, String value3, String value4) {
		
		tvSpellName.setText(abilityName);
		ivPassiveIcon.setImageResource(abilityIcon);
		tvHeader1.setText(header1);
		tvHeader2.setText(header2);
		tvHeader3.setText(header3);
		tvHeader4.setText(header4);
		tvValue1.setText(value1);
		tvValue2.setText(value2);
		tvValue3.setText(value3);
		tvValue4.setText(value4);
		
		tvHeader5.setVisibility(View.GONE);
		tvValue5.setVisibility(View.GONE);
		tvHeader6.setVisibility(View.GONE);
		tvValue6.setVisibility(View.GONE);
		
	}
	public void SetStuff(String abilityName, int abilityIcon, String header1, String header2, String header3, String value1, 
			String value2, String value3) {
		
		tvSpellName.setText(abilityName);
		ivPassiveIcon.setImageResource(abilityIcon);
		tvHeader1.setText(header1);
		tvHeader2.setText(header2);
		tvHeader3.setText(header3);
		tvValue1.setText(value1);
		tvValue2.setText(value2);
		tvValue3.setText(value3);
		
		tvHeader4.setVisibility(View.GONE);
		tvValue4.setVisibility(View.GONE);
		tvHeader5.setVisibility(View.GONE);
		tvValue5.setVisibility(View.GONE);
		tvHeader6.setVisibility(View.GONE);
		tvValue6.setVisibility(View.GONE);
	}

	public void SetStuff(String abilityName, int abilityIcon, String header1, String header2, String value1, 
			String value2) {
		
		tvSpellName.setText(abilityName);
		ivPassiveIcon.setImageResource(abilityIcon);
		tvHeader1.setText(header1);
		tvHeader2.setText(header2);
		tvValue1.setText(value1);
		tvValue2.setText(value2);
		
		tvHeader3.setVisibility(View.GONE);
		tvValue3.setVisibility(View.GONE);
		tvHeader4.setVisibility(View.GONE);
		tvValue4.setVisibility(View.GONE);
		tvHeader5.setVisibility(View.GONE);
		tvValue5.setVisibility(View.GONE);
		tvHeader6.setVisibility(View.GONE);
		tvValue6.setVisibility(View.GONE);
	}
}




