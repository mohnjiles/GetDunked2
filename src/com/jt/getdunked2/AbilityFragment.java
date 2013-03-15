package com.jt.getdunked2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AbilityFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	
    	
    	View V = inflater.inflate(R.layout.ability_fragment, container, false);
    	
  	  // imageview variables
  	  ImageView ivPassive = (ImageView)V.findViewById(R.id.imageView1);
  	  ImageView ivQ = (ImageView) V.findViewById(R.id.imageView2);
  	  ImageView ivW = (ImageView) V.findViewById(R.id.imageView3);
  	  ImageView ivE = (ImageView) V.findViewById(R.id.imageView4);
  	  ImageView ivR = (ImageView) V.findViewById(R.id.imageView5);
  	  
  	  // textviews
  	  TextView tvPassiveTitle = (TextView)V.findViewById(R.id.tvPassiveName);
  	  TextView tvQTitle = (TextView)V.findViewById(R.id.tvQName);
  	  TextView tvWTitle = (TextView)V.findViewById(R.id.tvWName);
  	  TextView tvETitle = (TextView)V.findViewById(R.id.tvEName);
  	  TextView tvRTitle = (TextView)V.findViewById(R.id.tvRName);

  	  TextView tvPassiveText = (TextView)V.findViewById(R.id.tvPassiveText);
  	  TextView tvQText = (TextView)V.findViewById(R.id.tvQText);
  	  TextView tvWText = (TextView)V.findViewById(R.id.tvWText);
  	  TextView tvEText = (TextView)V.findViewById(R.id.tvEText);
  	  TextView tvRText = (TextView)V.findViewById(R.id.tvRText);

  	  


  	  
  	  
  	  int position = ChampsActivity.myInt;
  	  switch (position) {
	  		case 1:

	  			ivPassive.setImageResource(R.drawable.twin_disciplines);
	  			ivQ.setImageResource(R.drawable.mark_of_the_assassin);
	  			ivW.setImageResource(R.drawable.twilight_shroud);
	  			ivE.setImageResource(R.drawable.crescent_slash);
	  			ivR.setImageResource(R.drawable.shadow_dance);
	  			
	  			tvPassiveTitle.setText("Twin Disciplines");
	  			tvPassiveText.setText(R.string.TwinDisciplines);
	  			
	  			tvQTitle.setText("Mark of the Assassin");
	  			tvQText.setText(R.string.MarkOfTheAssassin);
	  			
	  			tvWTitle.setText("Twilight Shroud");
	  			tvWText.setText(R.string.TwilightShroud);
	  			
	  			tvETitle.setText("Crescent Slash");
	  			tvEText.setText(R.string.CrescentSlash);
	  			
	  			tvRTitle.setText("Shadow Dance");
	  			tvRText.setText(R.string.ShadowDance);
	  			
	  			return V;
	  		case 2:
	  			ivPassive.setImageResource(R.drawable.trample);
	  			ivQ.setImageResource(R.drawable.pulverize);
	  			ivW.setImageResource(R.drawable.headbutt);
	  			ivE.setImageResource(R.drawable.triumphant_roar);
	  			ivR.setImageResource(R.drawable.unbreakable_will);
	  			
	  			tvPassiveTitle.setText("Trample");
	  			tvPassiveText.setText(R.string.Trample);
	  			
	  			tvQTitle.setText("Pulverize");
	  			tvQText.setText(R.string.Pulverize);
	  			
	  			tvWTitle.setText("Headbutt");
	  			tvWText.setText(R.string.Headbutt);
	  			
	  			tvETitle.setText("Triumphant Roar");
	  			tvEText.setText(R.string.TriumphantRoar);
	  			
	  			tvRTitle.setText("Unbreakable Will");
	  			tvRText.setText(R.string.UnbreakableWill);
	  			return V;
	  			
	  		case 3:
	  			ivPassive.setImageResource(R.drawable.cursed_touch);
	  			ivQ.setImageResource(R.drawable.bandage_toss);
	  			ivW.setImageResource(R.drawable.despair);
	  			ivE.setImageResource(R.drawable.tantrum);
	  			ivR.setImageResource(R.drawable.curse_of_the_sad_mummy);
	  			
	  			tvPassiveTitle.setText("Cursed Touch");
	  			tvPassiveText.setText(R.string.CursedTouch);
	  			
	  			tvQTitle.setText("Bandage Toss");
	  			tvQText.setText(R.string.BandageToss);
	  			
	  			tvWTitle.setText("Despair");
	  			tvWText.setText(R.string.Despair);
	  			
	  			tvETitle.setText("Tantrum");
	  			tvEText.setText(R.string.Tantrum);
	  			
	  			tvRTitle.setText("Curse of the Sad Mummy");
	  			tvRText.setText(R.string.CurseOfTheSadMummy);
	  		case 4:
	  			ivPassive.setImageResource(R.drawable.rebirth);
	  			ivQ.setImageResource(R.drawable.flash_frost);
	  			ivW.setImageResource(R.drawable.crystallize);
	  			ivE.setImageResource(R.drawable.frostbite);
	  			ivR.setImageResource(R.drawable.glacial_storm);
	  			
	  			tvPassiveTitle.setText("Rebirth");
	  			tvPassiveText.setText(R.string.Rebirth);
	  			
	  			tvQTitle.setText("Flash Frost");
	  			tvQText.setText(R.string.FlashFrost);
	  			
	  			tvWTitle.setText("Crystallize");
	  			tvWText.setText(R.string.Crystallize);
	  			
	  			tvETitle.setText("Frostbite");
	  			tvEText.setText(R.string.Frostbite);
	  			
	  			tvRTitle.setText("Glacial Storm");
	  			tvRText.setText(R.string.GlacialStorm);
	  			return V;
	  		case 5:
	  			ivPassive.setImageResource(R.drawable.pyromania);
	  			ivQ.setImageResource(R.drawable.disintegrate);
	  			ivW.setImageResource(R.drawable.incinerate);
	  			ivE.setImageResource(R.drawable.molten_shield);
	  			ivR.setImageResource(R.drawable.summontibbers);
	  			
	  			tvPassiveTitle.setText("Pyromania");
	  			tvPassiveText.setText(R.string.Pyromania);
	  			
	  			tvQTitle.setText("Disintegrate");
	  			tvQText.setText(R.string.Disintegrate);
	  			
	  			tvWTitle.setText("Incinerate");
	  			tvWText.setText(R.string.Incinerate);
	  			
	  			tvETitle.setText("Molten Shield");
	  			tvEText.setText(R.string.MoltenShield);
	  			
	  			tvRTitle.setText("Summon Tibbers");
	  			tvRText.setText(R.string.SummonTibbers);
	  			return V;
	  		case 6:
	  			ivPassive.setImageResource(R.drawable.focus);
	  			ivQ.setImageResource(R.drawable.frost_shot);
	  			ivW.setImageResource(R.drawable.volley);
	  			ivE.setImageResource(R.drawable.hawkshot);
	  			ivR.setImageResource(R.drawable.enchanted_crystal_arrow);
	  			
	  			tvPassiveTitle.setText("Focus");
	  			tvPassiveText.setText(R.string.Focus);
	  			
	  			tvQTitle.setText("Frost Shot");
	  			tvQText.setText(R.string.FrostShot);
	  			
	  			tvWTitle.setText("Volley");
	  			tvWText.setText(R.string.Volley);
	  			
	  			tvETitle.setText("Hawkshot");
	  			tvEText.setText(R.string.Hawkshot);
	  			
	  			tvRTitle.setText("Enchanted Crystal Arrow");
	  			tvRText.setText(R.string.EnchantedCrystalArrow);
	  			return V;
	  		case 7:
	  			ivPassive.setImageResource(R.drawable.mana_barrier);
	  			ivQ.setImageResource(R.drawable.rocket_grab);
	  			ivW.setImageResource(R.drawable.overdrive);
	  			ivE.setImageResource(R.drawable.power_fist);
	  			ivR.setImageResource(R.drawable.static_field);
	  			
	  			tvPassiveTitle.setText("Mana Barrier");
	  			tvPassiveText.setText(R.string.ManaBarrier);
	  			
	  			tvQTitle.setText("Rocket Grab");
	  			tvQText.setText(R.string.RocketGrab);
	  			
	  			tvWTitle.setText("Overdrive");
	  			tvWText.setText(R.string.Overdrive);
	  			
	  			tvETitle.setText("Power Fist");
	  			tvEText.setText(R.string.PowerFist);
	  			
	  			tvRTitle.setText("Static Field");
	  			tvRText.setText(R.string.StaticField);
	  			return V;
	  		case 8:
	  			ivPassive.setImageResource(R.drawable.blaze);
	  			ivQ.setImageResource(R.drawable.sear);
	  			ivW.setImageResource(R.drawable.pillar_of_flame);
	  			ivE.setImageResource(R.drawable.conflagration);
	  			ivR.setImageResource(R.drawable.pyroclasm);
	  			
	  			tvPassiveTitle.setText("Blaze");
	  			tvPassiveText.setText(R.string.Blaze);
	  			
	  			tvQTitle.setText("Sear");
	  			tvQText.setText(R.string.Sear);
	  			
	  			tvWTitle.setText("Pillar of Flame");
	  			tvWText.setText(R.string.PillarOfFlame);
	  			
	  			tvETitle.setText("Conflagration");
	  			tvEText.setText(R.string.Conflagration);
	  			
	  			tvRTitle.setText("Pyroclasm");
	  			tvRText.setText(R.string.Pyroclasm);
	  			return V;
	  		default:
	  			return V;
  	  }
  	  
    	
	  		
		  
       
    }

    
}


