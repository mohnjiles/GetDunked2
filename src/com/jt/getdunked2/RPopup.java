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
		View V = inflater.inflate(R.layout.activity_e_popup, container, false);

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
			SetStuff("Massacre", R.drawable.massacre, "Cooldown", "Cost",
					"Magic Damage", "Attack Speed", "100 / 85 / 70 seconds",
					"No Cost", "200 / 300 / 400 (+ 100% AP)", "40 / 50 / 60%");
			break;
		case 1:
			SetStuff("Spirit Rush", R.drawable.spirit_rush, "Range",
					"Cooldown", "Cost", "Magic Damage",
					"Max Damage to Same Target", "450",
					"110 / 95 / 80 seconds", "100 mana",
					"60 / 90 / 120 / 150 / 180 (+ 35% AP)",
					"255 / 375 / 495 (+ 105% AP)");
			break;
		case 2:
			SetStuff("Shadow Dance", R.drawable.shadow_dance, "Range",
					"Cooldown", "Cost", "Magic Damage",
					"New Essence of Shadow", "800", "2 / 1.5 / 1 second(s)",
					"1 Essence of Shadow", "100 / 175 / 250 (+ 50% AP)",
					"Every 30 / 22.5 / 15 seconds");
			break;
		case 3:
			SetStuff("Unbreakable Will", R.drawable.unbreakable_will,
					"Cooldown", "Cost", "Bonus AD", "Damage Reduction",
					"120 / 100 / 80", "100 mana", "60 / 75 / 90",
					"50 / 60 / 70%");
			break;
		case 4:
			SetStuff("Curse of the Sad Mummy",
					R.drawable.curse_of_the_sad_mummy, "Range (Radius)",
					"Cooldown", "Cost", "Magic Damage", "550",
					"150 / 130 / 110", "100 / 150 / 200 Mana",
					"150 / 250 / 350 (+ 80% AP)");
			break;
		case 5:
			SetStuff("Glacial Storm", R.drawable.glacial_storm, "Range",
					"Cooldown", "Cost", "Magic Damage per Second",
					"Mana Drain per Second", "615", "6", "75 mana",
					"80 / 120 / 160 (+ 25% AP)", "40 / 50 / 60");
			break;
		case 6:
			SetStuff(
					"Summon Tibbers",
					R.drawable.summontibbers,
					"Range",
					"Cooldown",
					"Cost",
					"Summon Magic Damage",
					"Tibbers Stats",
					"600",
					"120 seconds",
					"125 / 175 / 225 Mana",
					"200 / 325 / 450 (+ 70% AP)",
					"Health: 1200 / 1600 / 2000\nAttack Damage: 80 / 105 / 130\n"
							+ "Armor: 30 / 50 / 70\nMagic Resistance: 25 / 45 / 65");
			break;
		case 7:
			SetStuff("Enchanted Crystal Arrow",
					R.drawable.enchanted_crystal_arrow, "Range", "Cooldown",
					"Cost", "Magic Damage", "Splash Damage", "Global",
					"100 / 90 / 80 seconds", "150 Mana",
					"250 / 425 / 600 (+ 100% AP)",
					"125 / 212.5 / 300 (+ 50% AP)");
			break;
		case 8:
			SetStuff("Static Field", R.drawable.static_field, "Cooldown",
					"Cost", "Passive Magic Damage", "Passive Range",
					"Active Magic Damage", "AoE Range", "30 seconds",
					"150 Mana", "100 / 200 / 300 (+ 20% AP)", "450",
					"250 / 375 / 500 (+ 100% AP)", "600");
			break;
		case 9:
			SetStuff("Pyroclasm", R.drawable.pyroclasm, "Range", "Cooldown",
					"Cost", "Magic Damage per Bounce",
					"Max Magic Damage to the Same Target", "Max Magic Damage",
					"750", "105 / 90 / 75 seconds", "100 / 150 / 200 Mana",
					"150 / 250 / 350 (+ 50% AP)",
					"450 / 750 / 1050 (+ 150% AP)",
					"750 / 1250 / 1750 (+ 250% AP)");
			break;
		case 10:
			SetStuff("Ace in the Hole", R.drawable.ace_in_the_hole, "Range",
					"Cooldown", "Cost", "Physical Damage",
					"2000 / 2500 / 3000", "90 / 75 / 60 seconds", "100 Mana",
					"250 / 475 / 700 (+ 200% bonus AD)");
			break;
		case 11:
			SetStuff("Petrifying Gaze", R.drawable.petrifying_gaze, "Range",
					"Cooldown", "Cost", "Magic Damage", "Cone Angle", "850",
					"130 / 120 / 110 seconds", "120 / 160 / 200 Mana",
					"200 / 325 / 450 (+ 60% AP)", "80º");
			break;
		case 12:
			SetStuff("Feast", R.drawable.feast, "Range", "Cooldown", "Cost",
					"True Damage", "Health per Stack",
					"Bonus Attack Range per Stack", "150", "60 seconds",
					"100 Mana", "300 / 475 / 650 (+ 70% AP)", "90 / 120 / 150",
					"3.8 / 6.1 / 8.3");
			break;
		case 13:
			SetStuff("Missile Barrage", R.drawable.missile_barrage, "Range",
					"Cooldown", "Cost", "Magic Damage", "Big One Magic Damage",
					"Missile Reload Time", "1225", "1.2 seconds",
					"30 / 35 / 40 Mana",
					"120 / 190 / 260 (+ 30% AP) (+ 20% AD)",
					"180 / 285 / 390 (+ 45% AP) (+ 30% AD)",
					"12 / 10 / 8 seconds");
			break;
		case 14:
			SetStuff("Noxian Guillotine", R.drawable.noxian_guillotine,
					"Range", "Cooldown", "Cost", "True Damage",
					"Max True Damage", "460", "120 / 100 / 80 seconds",
					"100 Mana", "160 / 250 / 340 (+ 75% bonus AD)",
					"320 / 500 / 680 (+ 150% bonus AD)");
			break;
		case 15:
			SetStuff("Lunar Rush", R.drawable.lunar_rush, "Range", "Cooldown",
					"Cost", "Magic Damage", "825", "25 / 20 / 15 seconds",
					"50 / 65 / 80 Mana", "100 / 160 / 220 (+ 60% AP)");
			break;
		case 16:
			SetStuff("Sadism", R.drawable.sadism, "Cooldown", "Cost", "Heal",
					"Movement Speed", "75 seconds", "20% of Current Health",
					"40 / 50 / 60% of maximum health", "15 / 25 / 35%");
			break;
		case 17:
			SetStuff("Whirling Death", R.drawable.whirling_death, "Range",
					"Cooldown", "Cost", "Physical Damage (One Hit)",
					"Maximum Physical Damage (Two Hits)",
					"Minimum Physical Damage (One Hit)",
					"Minimum Physical Damage (Two Hits)", "Global",
					"110 / 100 / 90 seconds", "120 Mana",
					"175 / 275 / 375 (+ 110% bonus AD)",
					"350 / 550 / 750 (+ 220% bonus AD)",
					"70 / 110 / 150 (+ 44% bonus AD)",
					"140 / 220 / 300 (+ 88% bonus AD)");
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
