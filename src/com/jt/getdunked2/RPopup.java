package com.jt.getdunked2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RPopup extends Fragment {
	
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
				SetStuff("Spirit Rush", R.drawable.spirit_rush, "Range", "Cooldown", "Cost", "Magic Damage", "Max Damage to Same Target", 
						"450", "110 / 95 / 80 seconds", "100 mana", "60 / 90 / 120 / 150 / 180 (+ 35% AP)", "255 / 375 / 495 (+ 105% AP)");
				break;
			case 1:
				SetStuff("Shadow Dance", R.drawable.shadow_dance, "Range", "Cooldown", "Cost", "Magic Damage", "New Essence of Shadow", "800", 
						"2 / 1.5 / 1 second(s)", "1 Essence of Shadow", "100 / 175 / 250 (+ 50% AP)", "Every 30 / 22.5 / 15 seconds");
				break;
			case 2:
				SetStuff("Unbreakable Will", R.drawable.unbreakable_will, "Cooldown", "Cost", "Bonus AD", "Damage Reduction", "120 / 100 / 80", "100 mana", 
						"60 / 75 / 90", "50 / 60 / 70%");
				break;
			case 3:
				SetStuff("Curse of the Sad Mummy", R.drawable.curse_of_the_sad_mummy, "Range (Radius)", "Cooldown", "Cost", "Magic Damage", 
						"550", "150 / 130 / 110", "100 / 150 / 200 Mana", "150 / 250 / 350 (+ 80% AP)");
				break;
			case 4:
				SetStuff("Glacial Storm", R.drawable.glacial_storm, "Range", "Cooldown", "Cost", "Magic Damage per Second", "Mana Drain per Second", 
						"615", "6", "75 mana", "80 / 120 / 160 (+ 25% AP)", "40 / 50 / 60");
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
}




