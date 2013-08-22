package com.jt.getdunked2;

import com.jt.getdunked2.R.drawable;

import android.R.raw;
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
	TextView tvHeader7;
	TextView tvValue1;
	TextView tvValue2;
	TextView tvValue3;
	TextView tvValue4;
	TextView tvValue5;
	TextView tvValue6;
	TextView tvValue7;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View V = inflater.inflate(R.layout.activity_w_popup, container, false);

		int position = ChampsActivity.myInt;

		tvSpellName = (TextView) V.findViewById(R.id.tvSpellName);
		ivPassiveIcon = (ImageView) V.findViewById(R.id.ivFreeThree);
		tvHeader1 = (TextView) V.findViewById(R.id.tvHeader1);
		tvHeader2 = (TextView) V.findViewById(R.id.tvHeader2);
		tvHeader3 = (TextView) V.findViewById(R.id.tvHeader3);
		tvHeader4 = (TextView) V.findViewById(R.id.tvHeader4);
		tvHeader5 = (TextView) V.findViewById(R.id.tvHeader5);
		tvHeader6 = (TextView) V.findViewById(R.id.tvHeader6);
		tvHeader7 = (TextView) V.findViewById(R.id.tvHeader7);
		tvValue1 = (TextView) V.findViewById(R.id.tvValue1);
		tvValue2 = (TextView) V.findViewById(R.id.tvValue2);
		tvValue3 = (TextView) V.findViewById(R.id.tvValue3);
		tvValue4 = (TextView) V.findViewById(R.id.tvValue4);
		tvValue5 = (TextView) V.findViewById(R.id.tvValue5);
		tvValue6 = (TextView) V.findViewById(R.id.tvValue6);
		tvValue7 = (TextView) V.findViewById(R.id.tvValue7);

		switch (position) {
		case 0:
			SetStuff("Blood Thirst / Blood Price", R.drawable.blood_thirst,
					"Cooldown", "Heal", "Enhanced Heal",
					"Bonus Physical Damage", "Health Cost on Third Attack",
					"0.5 seconds", "20 / 25 / 30 / 35 / 40 (+25% bonus AD)",
					"60 / 75 / 90 / 105 / 120 (+75% bonus AD)",
					"60 / 95 / 130 / 165 / 200 (+100% bonus AD)",
					"15 / 23.75 / 32.5 / 41.25 / 50 (+25% bonus AD)");
			break;
		case 1:
			SetStuff("Fox-Fire", R.drawable.foxfire, "Range", "Cooldown",
					"Cost", "Magic Damage per Fox-Fire",
					"Magic Damage to Three Targets",
					"Magic Damage to the Same Target", "800",
					"9 / 8 / 7 / 6 / 5 seconds", "60 Mana",
					"40 / 65 / 90 / 115 / 140 (+ 40% AP)",
					"120 / 195 / 270 / 345 / 420 (+ 120% AP)",
					"80 / 130 / 180 / 230 / 280 (+ 80% AP)");
			break;
		case 2:
			SetStuff("Twilight Shroud", R.drawable.twilight_shroud, "Range",
					"Cooldown", "Cost", "Armor / Magic Resistance", "Slow",
					"700", "20 seconds", "80 / 75 / 70 / 65 / 60 energy",
					"10 / 20 / 30 / 40 / 50", "14 / 18 / 22 / 26 / 30%");
			break;
		case 3:
			SetStuff("Headbutt", R.drawable.headbutt, "Range", "Cooldown",
					"Cost", "Magic Damage", "Knockback Distance", "650",
					"14 / 13 / 12 / 11 / 10 seconds",
					"70 / 80 / 90 / 100 / 110 Mana",
					"55 / 110 / 165 / 220 / 275 (+70% AP)", "650");
			break;
		case 4:
			SetStuff("Despair", R.drawable.despair, "Range", "Cooldown",
					"Cost", "Base Magic Damage per Second",
					"Additional Damage per Second", "400", "1 second",
					"8 mana per second", "8 / 12 / 16 / 20 / 24",
					"1.5 / 1.8 / 2.1 / 2.4 / 2.7% (+ 1% per 100 AP) of enemies' maximum health");
			break;
		case 5:
			SetStuff("Crystallize", R.drawable.crystallize, "Range",
					"Cooldown", "Cost", "Wall Length", "1000", "25 seconds",
					"70 / 90 / 110 / 130 / 150 Mana",
					"400 / 500 / 600 / 700 / 800");
			break;
		case 6:
			SetStuff("Incinerate", R.drawable.incinerate, "Range", "Cooldown",
					"Cost", "Magic Damage", "Cone Angle", "625", "8 seconds",
					"70 / 80 / 90 / 100 / 110 Mana",
					"80 / 130 / 180 / 230 / 280 (+ 75% AP)", "50º");
			break;
		case 7:
			SetStuff("Volley", R.drawable.volley, "Range", "Cooldown", "Cost",
					"Physical Damage per Arrow", "1200",
					"16 / 13 / 10 / 7 / 4 seconds", "60 Mana",
					"40 / 50 / 60 / 70 / 80 (+ 100% AD)");
			break;
		case 8:
			SetStuff("Overdrive", R.drawable.overdrive, "Cooldown", "Cost",
					"Movement Speed", "Attack Speed", "15 seconds", "75 Mana",
					"16 / 20 / 24 / 28 / 32%", "30 / 38 / 46 / 54 / 62%");
			break;
		case 9:
			SetStuff("Pillar of Flame", R.drawable.pillar_of_flame, "Range",
					"Cooldown", "Cost", "Magic Damage", "Ablaze Magic Damage",
					"900", "10 seconds", "70 / 80 / 90 / 100 / 110 Mana",
					"75 / 120 / 165 / 210 / 255 (+ 60% AP)",
					"94 / 150 / 206 / 263 / 319 (+ 75% AP)");
			break;
		case 10:
			SetStuff("Yordle Snap Trap", R.drawable.yordle_snap_trap, "Range",
					"Cooldown", "Cost", "Magic Damage", "800",
					"20 / 17 / 14 / 11 / 8", "50 Mana",
					"80 / 130 / 180 / 230 / 280 (+ 60% AP)");
			break;
		case 11:
			SetStuff("Miasma", R.drawable.miasma, "Range", "Cooldown", "Cost",
					"Magic Damage per Second", "Total Max Magic Damage",
					"Slow", "850", "9 seconds",
					"70 / 80 / 90 / 100 / 110 Mana",
					"25 / 35 / 45 / 55 / 65 (+ 15% AP)",
					"225 / 315 / 405 / 495 / 585 (+ 135% AP)",
					"15 / 20 / 25 / 30 / 35%");
			break;
		case 12:
			SetStuff("Feral Scream", R.drawable.feral_scream, "Range",
					"Cooldown", "Cost", "Magic Damage", "Silence Duration",
					"Cone Angle", "700", "13 seconds",
					"70 / 80 / 90 / 100 / 110 Mana",
					"75 / 125 / 175 / 225 / 275 (+ 70% AP)",
					"1.5 / 1.75 / 2 / 2.25 / 2.5 seconds", "60º");
			break;
		case 13:
			SetStuff("Valkyrie", R.drawable.valkyrie, "Range", "Cooldown",
					"Cost", "Magic Damage", "Maximum Damage", "800",
					"26 / 23 / 20 / 17 / 14 seconds", "100 Mana",
					"30 / 45 / 60 / 75 / 90 (+ 20% AP)",
					"150 / 225 / 300 / 375 / 450 (+ 100% AP)");
			break;
		case 14:
			SetStuff("Crippling Strike", R.drawable.crippling_strike, "Range",
					"Cooldown", "Cost", "Total Physical Damage", "Slow", "145",
					"8 seconds", "30 / 35 / 40 / 45 / 50 Mana",
					"120 / 140 / 160 / 180 / 200% AD",
					"20 / 25 / 30 / 35 / 40%");
			break;
		case 15:
			SetStuff("Pale Cascade", R.drawable.pale_cascade, "Range",
					"Cooldown", "Cost", "Magic Damage Per Orb",
					"Max Magic Damage", "Shield Strength",
					"Max Shield Strength", "200", "10 seconds",
					"60 / 70 / 80 / 90 / 100 Mana",
					"22 / 34 / 46 / 58 / 70 (+ 20% AP)",
					"66 / 102 / 138 / 174 / 210 (+ 60% AP)",
					"40 / 55 / 70 / 85 / 100 (+ 30% AP)",
					"80 / 110 / 140 / 170 / 200 (+ 60% AP)");
			break;
		case 16:
			SetStuff("Burning Agony", R.drawable.burning_agony, "Range",
					"Cooldown", "Cost", "Magic Damage Per Second",
					"Crowd Control Reduction", "162.5", "4 seconds",
					"10 / 15 / 20 / 25 / 30 Health per second",
					"35 / 50 / 65 / 80 / 95 (+ 20% AP)",
					"10 / 15 / 20 / 25 / 30%");
			break;
		case 17:
			SetStuff("Blood Rush", R.drawable.blood_rush, "Cooldown", "Cost",
					"Movement Speed", "Attack Speed", "12 seconds", "40 Mana",
					"40 / 45 / 50 / 55 / 60%", "20 / 25 / 30 / 35 / 40%");
			break;
		}
		return V;
	}

	public void SetStuff(String abilityName, int abilityIcon, String header1,
			String header2, String header3, String header4, String header5,
			String header6, String header7, String value1, String value2,
			String value3, String value4, String value5, String value6,
			String value7) {

		tvSpellName.setText(abilityName);
		ivPassiveIcon.setImageResource(abilityIcon);
		tvHeader1.setText(header1);
		tvHeader2.setText(header2);
		tvHeader3.setText(header3);
		tvHeader4.setText(header4);
		tvHeader5.setText(header5);
		tvHeader6.setText(header6);
		tvHeader7.setText(header7);
		tvValue1.setText(value1);
		tvValue2.setText(value2);
		tvValue3.setText(value3);
		tvValue4.setText(value4);
		tvValue5.setText(value5);
		tvValue6.setText(value6);
		tvValue7.setText(value7);
	}

	public void SetStuff(String abilityName, int abilityIcon, String header1,
			String header2, String header3, String header4, String header5,
			String header6, String value1, String value2, String value3,
			String value4, String value5, String value6) {

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
		tvHeader7.setVisibility(View.GONE);
		tvValue7.setVisibility(View.GONE);

	}

	public void SetStuff(String abilityName, int abilityIcon, String header1,
			String header2, String header3, String header4, String header5,
			String value1, String value2, String value3, String value4,
			String value5) {

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
		tvHeader7.setVisibility(View.GONE);
		tvValue7.setVisibility(View.GONE);

	}

	public void SetStuff(String abilityName, int abilityIcon, String header1,
			String header2, String header3, String header4, String value1,
			String value2, String value3, String value4) {

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
		tvHeader7.setVisibility(View.GONE);
		tvValue7.setVisibility(View.GONE);

	}

	public void SetStuff(String abilityName, int abilityIcon, String header1,
			String header2, String header3, String value1, String value2,
			String value3) {

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
		tvHeader7.setVisibility(View.GONE);
		tvValue7.setVisibility(View.GONE);
	}

	public void SetStuff(String abilityName, int abilityIcon, String header1,
			String header2, String value1, String value2) {

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
		tvHeader7.setVisibility(View.GONE);
		tvValue7.setVisibility(View.GONE);

	}
}