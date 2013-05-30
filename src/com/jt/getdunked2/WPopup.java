package com.jt.getdunked2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class WPopup extends Fragment {
	
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
    	View V = inflater.inflate(R.layout.activity_w_popup, container, false);
    	
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
				SetStuff("Fox-Fire", R.drawable.foxfire, "Range", "Cooldown", "Cost", "Magic Damage per Fox-Fire", 
						"Magic Damage to Three Targets", "Magic Damage to the Same Target", "800", "9 / 8 / 7 / 6 / 5 seconds", 
						"60 Mana", "40 / 65 / 90 / 115 / 140 (+ 40% AP)", "120 / 195 / 270 / 345 / 420 (+ 120% AP)", 
						"80 / 130 / 180 / 230 / 280 (+ 80% AP)");
				break;
			case 1:
				SetStuff("Twilight Shroud", R.drawable.twilight_shroud, "Range", "Cooldown", "Cost", "Armor / Magic Resistance", 
						"Slow", "700", "20 seconds", "80 / 75 / 70 / 65 / 60 energy", "10 / 20 / 30 / 40 / 50", "14 / 18 / 22 / 26 / 30%");
				break;
			case 2:
				SetStuff("Headbutt", R.drawable.headbutt, "Range", "Cooldown", "Cost", "Magic Damage", "Knockback Distance", "650", "14 / 13 / 12 / 11 / 10 seconds", 
						"70 / 80 / 90 / 100 / 110 Mana", "55 / 110 / 165 / 220 / 275 (+70% AP)", "650");
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




