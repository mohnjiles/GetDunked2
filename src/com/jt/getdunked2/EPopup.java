package com.jt.getdunked2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class EPopup extends Fragment {
	
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
    	View V = inflater.inflate(R.layout.activity_e_popup, container, false);
    	
    	int position = ChampsActivity.myInt;
    	
    	
		
		tvSpellName = (TextView)V.findViewById(R.id.tvSpellName);
		ivPassiveIcon = (ImageView)V.findViewById(R.id.imageView1);
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
				SetStuff("Charm", R.drawable.charm, "Range", "Cooldown", "Cost", "Magic Damage", "Duration", "975", "12 seconds", 
						"50 / 65 / 80 / 95 / 110 mana", "60 / 90 / 120 / 150 / 180 (+ 35% AP)", "1 / 1.25 / 1.5 / 1.75 / 2 second(s)");
				break;
			case 1:
				SetStuff("Crescent Slash", R.drawable.crescent_slash, "Range", "Cooldown", "Cost", "Physical Damage", "325", 
						"7 / 6 / 5 / 4 / 3 seconds", "60 / 55 / 50 / 45 / 40 energy", "30 / 55 / 80 / 105 / 130 (+ 30% AP) (+ 60% AD)");
				break;
			case 2:
				SetStuff("Triumphant Roar", R.drawable.triumphant_roar, "Range", "Cooldown", "Cost", "Self Heal", "Friendly Unit Heal", 
						"287.5", "12 seconds", "40 / 50 / 60 / 70 / 80 mana", "60 / 90 / 120 / 150 / 180 (+20% AP)", 
						"30 / 45 / 60 / 75 / 90 (+10% AP)");
				break;
			case 3:
				SetStuff("Tantrum", R.drawable.tantrum, "Range", "Cooldown", "Cost", "Physical Damage Reduction", "Magic Damage", "200", 
						"10 / 9 / 8 / 7 / 6 seconds", "35 Mana", "2 / 4 / 6 / 8 / 10", "75 / 100 / 125 / 150 / 175 (+ 50% AP)");
				break;
			case 4:
				SetStuff("Frostbite", R.drawable.frostbite, "Range", "Cooldown", "Cost", "Magic Damage", "Chilled Damage", "650", "5 seconds", 
						"50 / 60 / 70 / 80 / 90 Mana", "55 / 85 / 115 / 145 / 175 (+ 50% AP)", "110 / 170 / 230 / 290 / 350 (+ 100% AP)");
				break;
			case 5:
				SetStuff("Molten Shield", R.drawable.molten_shield, "Cooldown", "Cost", "Armor / Magic Resist", "Magic Damage", "10 seconds", 
						"20 Mana", "20 / 30 / 40 / 50 / 60", "20 / 30 / 40 / 50 / 60 (+ 20% AP)");
				break;
			case 6:
				SetStuff("Hawkshot", R.drawable.hawkshot, "Range", "Cooldown", "Cost", "Bonus Gold", "2500 / 3250 / 4000 / 4750 / 5500", 
						"60 seconds", "No cost", "1 / 2 / 3 / 4 / 5");
				break;
			case 7:
				SetStuff("Power Fist", R.drawable.power_fist, "Cooldown", "Cost", "9 / 8 / 7 / 6 / 5 seconds", "25 Mana");
				break;
			case 8:
				SetStuff("Conflagration", R.drawable.conflagration, "Range", "Cooldown", "Cost", "Magic Damage", "625", " 12 / 11 / 10 / 9 / 8 seconds", 
						"60 / 65 / 70 / 75 / 80 Mana", "70 / 105 / 140 / 175 / 210 (+ 55% AP)");
				break;
			case 9:
				SetStuff("90 Caliber Net", R.drawable.ninety_caliber_net, "Range", "Cooldown", "Cost", "Magic Damage", "Slow Duration", "1000", 
						"18 / 16 / 14 / 12 / 10 seconds", "75 Mana", "80 / 130 / 180 / 230 / 280 (+ 80% AP)", "1 / 1.25 / 1.5 / 1.75 / 2 second(s)");
				break;
			case 10:
				SetStuff("Twin Fang", R.drawable.twin_fang, "Range", "Cooldown", "Cost", "Magic Damage", "700", "5 seconds", "50 / 60 / 70 / 80 / 90 Mana", 
						"50 / 85 / 120 / 155 / 190 (+ 55% AP)");
				break;
			case 11:
				SetStuff("Vorpal Spikes", R.drawable.vorpal_spikes, "Range", "Magic Damage", "500", "20 / 35 / 50 / 65 / 80 (+ 30% AP)");
				break;
			case 12:
				SetStuff("Gatling Gun", R.drawable.gatling_gun, "Range", "Cooldown", "Cost", "Physical Damage", "Maximum Damage", 
						"Armor Reduction per Stack (Max 8)", "600", "16 seconds", "60 / 65 / 70 / 75 / 80 Mana", "0 / 16 / 22 / 28 / 34 (+ 20% bonus AD)", 
						"80 / 128 / 176 / 224 / 272 (+ 160% bonus AD)", "1 / 2 / 3 / 4 / 5");
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




