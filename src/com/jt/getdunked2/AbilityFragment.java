package com.jt.getdunked2;

<<<<<<< HEAD
=======
import android.content.Context;
>>>>>>> d56ad557451e3c607625b5f9fbc5412b165fe61b
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
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
	  
<<<<<<< HEAD
  	  
  	  int position = ChampsActivity.myInt;
  	  
  	  /*********** Q onClickListener ***********/
  	  ivQ.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {	
			Intent detailsIntent = new Intent(getActivity().getBaseContext(), AbilityDetails.class);
			detailsIntent.putExtra("Ability", 1);
			startActivity(detailsIntent);
			
		}
	});
  	  /*********** END Q onClickListener ***********/
  	  
  	  /*********** W onClickListener ***********/
  	  ivW.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {	
			Intent detailsIntent = new Intent(getActivity().getBaseContext(), AbilityDetails.class);
			detailsIntent.putExtra("Ability", 2);
			startActivity(detailsIntent);
			
		}
	});
  	  /*********** END W onClickListener ***********/
  	  
  	  /*********** E onClickListener ***********/
  	  ivE.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {	
			Intent detailsIntent = new Intent(getActivity().getBaseContext(),AbilityDetails.class);
			detailsIntent.putExtra("Ability", 3);
			startActivity(detailsIntent);
			
		}
	});
  	  /*********** END E onClickListener ***********/
  	  
  	  /*********** R onClickListener ***********/
  	  ivR.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {	
			Intent detailsIntent = new Intent(getActivity().getBaseContext(), AbilityDetails.class);
			detailsIntent.putExtra("Ability", 4);
			startActivity(detailsIntent);
			
		}
	});
  	  /*********** END R onClickListener ***********/
  	 
  	  
=======
  	  
  	  int position = ChampsActivity.myInt;
>>>>>>> d56ad557451e3c607625b5f9fbc5412b165fe61b
  	  
  	  ivPassive.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {	
			Intent passiveIntent = new Intent(getActivity().getBaseContext(), PassivePopup.class);
			startActivity(passiveIntent);
			
		}
	});
  	  
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
	  		case 9:
	  			ivPassive.setImageResource(R.drawable.headshot);
	  			ivQ.setImageResource(R.drawable.piltover_peacemaker);
	  			ivW.setImageResource(R.drawable.yordle_snap_trap);
	  			ivE.setImageResource(R.drawable.ninety_caliber_net);
	  			ivR.setImageResource(R.drawable.ace_in_the_hole);
	  			
	  			tvPassiveTitle.setText("Headshot");
	  			tvPassiveText.setText(R.string.Headshot);
	  			
	  			tvQTitle.setText("Piltover Peacemaker");
	  			tvQText.setText(R.string.PiltoverPeacemaker);
	  			
	  			tvWTitle.setText("Yordle Snap Trap");
	  			tvWText.setText(R.string.YordleSnapTrap);
	  			
	  			tvETitle.setText("90 Caliber Net");
	  			tvEText.setText(R.string.NinetyCaliberNet);
	  			
	  			tvRTitle.setText("Ace in the Hole");
	  			tvRText.setText(R.string.AceInTheHole);
	  			return V;
	  		case 10:
	  			ivPassive.setImageResource(R.drawable.deadly_cadence);
	  			ivQ.setImageResource(R.drawable.noxious_blast);
	  			ivW.setImageResource(R.drawable.miasma);
	  			ivE.setImageResource(R.drawable.twin_fang);
	  			ivR.setImageResource(R.drawable.petrifying_gaze);
	  			
	  			tvPassiveTitle.setText("Deadly Cadence");
	  			tvPassiveText.setText(R.string.DeadlyCadence);
	  			
	  			tvQTitle.setText("Noxious Blast");
	  			tvQText.setText(R.string.NoxiousBlast);
	  			
	  			tvWTitle.setText("Miasma");
	  			tvWText.setText(R.string.Miasma);
	  			
	  			tvETitle.setText("Twin Fang");
	  			tvEText.setText(R.string.TwinFang);
	  			
	  			tvRTitle.setText("Petrifying Gaze");
	  			tvRText.setText(R.string.PetrifyingGaze);
	  			return V;
	  		case 11:
	  			ivPassive.setImageResource(R.drawable.carnivore);
	  			ivQ.setImageResource(R.drawable.rupture);
	  			ivW.setImageResource(R.drawable.feral_scream);
	  			ivE.setImageResource(R.drawable.vorpal_spikes);
	  			ivR.setImageResource(R.drawable.feast);
	  			
	  			tvPassiveTitle.setText("Carnivore");
	  			tvPassiveText.setText(R.string.Carnivore);
	  			
	  			tvQTitle.setText("Rupture");
	  			tvQText.setText(R.string.Rupture);
	  			
	  			tvWTitle.setText("Feral Scream");
	  			tvWText.setText(R.string.FeralScream);
	  			
	  			tvETitle.setText("Vorpal Spikes");
	  			tvEText.setText(R.string.VorpalSpikes);
	  			
	  			tvRTitle.setText("Feast");
	  			tvRText.setText(R.string.Feast);
	  			return V;
	  		case 12:
	  			ivPassive.setImageResource(R.drawable.hextech_shrapnel_shells);
	  			ivQ.setImageResource(R.drawable.phosphorus_bomb);
	  			ivW.setImageResource(R.drawable.valkyrie);
	  			ivE.setImageResource(R.drawable.gatling_gun);
	  			ivR.setImageResource(R.drawable.missile_barrage);
	  			
	  			tvPassiveTitle.setText("Hextech Shrapnel Shells");
	  			tvPassiveText.setText(R.string.HextechShrapnelShells);
	  			
	  			tvQTitle.setText("Phosphorus Bomb");
	  			tvQText.setText(R.string.PhosphorusBomb);
	  			
	  			tvWTitle.setText("Valkyrie");
	  			tvWText.setText(R.string.Valkyrie);
	  			
	  			tvETitle.setText("Gatling Gun");
	  			tvEText.setText(R.string.GatlingGun);
	  			
	  			tvRTitle.setText("Missile Barrage");
	  			tvRText.setText(R.string.MissileBarrage);
	  			return V;
	  		case 13:
	  			ivPassive.setImageResource(R.drawable.hemorrhage);
	  			ivQ.setImageResource(R.drawable.decimate);
	  			ivW.setImageResource(R.drawable.crippling_strike);
	  			ivE.setImageResource(R.drawable.apprehend);
	  			ivR.setImageResource(R.drawable.noxian_guillotine);
	  			
	  			tvPassiveTitle.setText("Hemorrhage");
	  			tvPassiveText.setText(R.string.Hemorrhage);
	  			
	  			tvQTitle.setText("Decimate");
	  			tvQText.setText(R.string.Decimate);
	  			
	  			tvWTitle.setText("Crippling Strike");
	  			tvWText.setText(R.string.CripplingStrike);
	  			
	  			tvETitle.setText("Apprehend");
	  			tvEText.setText(R.string.Apprehend);
	  			
	  			tvRTitle.setText("Noxian Guillotine");
	  			tvRText.setText(R.string.NoxianGuillotine);
	  			return V;
	  		case 14:
	  			ivPassive.setImageResource(R.drawable.moonsilver_blade);
	  			ivQ.setImageResource(R.drawable.crescent_strike);
	  			ivW.setImageResource(R.drawable.pale_cascade);
	  			ivE.setImageResource(R.drawable.moonfall);
	  			ivR.setImageResource(R.drawable.lunar_rush);
	  			
	  			tvPassiveTitle.setText("Moonsilver Blade");
	  			tvPassiveText.setText(R.string.MoonsilverBlade);
	  			
	  			tvQTitle.setText("Crescent Strike");
	  			tvQText.setText(R.string.CrescentStrike);
	  			
	  			tvWTitle.setText("Pale Cascade");
	  			tvWText.setText(R.string.PaleCascade);
	  			
	  			tvETitle.setText("Moonfall");
	  			tvEText.setText(R.string.Moonfall);
	  			
	  			tvRTitle.setText("Lunar Rush");
	  			tvRText.setText(R.string.LunarRush);
	  			return V;
	  		case 15:
	  			ivPassive.setImageResource(R.drawable.adrenaline_rush);
	  			ivQ.setImageResource(R.drawable.infected_cleaver);
	  			ivW.setImageResource(R.drawable.burning_agony);
	  			ivE.setImageResource(R.drawable.masochism);
	  			ivR.setImageResource(R.drawable.sadism);
	  			
	  			tvPassiveTitle.setText("Adrenaline Rush");
	  			tvPassiveText.setText(R.string.AdrenalineRush);
	  			
	  			tvQTitle.setText("Infected Cleaver");
	  			tvQText.setText(R.string.InfectedCleaver);
	  			
	  			tvWTitle.setText("Burning Agony");
	  			tvWText.setText(R.string.BurningAgony);
	  			
	  			tvETitle.setText("Masochism");
	  			tvEText.setText(R.string.Masochism);
	  			
	  			tvRTitle.setText("Sadism");
	  			tvRText.setText(R.string.Sadism);
	  			return V;
	  		case 16:
	  			ivPassive.setImageResource(R.drawable.wicked_blades);
	  			ivQ.setImageResource(R.drawable.spinning_axe);
	  			ivW.setImageResource(R.drawable.blood_rush);
	  			ivE.setImageResource(R.drawable.stand_aside);
	  			ivR.setImageResource(R.drawable.whirling_death);
	  			
	  			tvPassiveTitle.setText("Wicked Blades");
	  			tvPassiveText.setText(R.string.WickedBlades);
	  			
	  			tvQTitle.setText("Spinning Axe");
	  			tvQText.setText(R.string.SpinningAxe);
	  			
	  			tvWTitle.setText("Blood Rush");
	  			tvWText.setText(R.string.BloodRush);
	  			
	  			tvETitle.setText("Stand Aside");
	  			tvEText.setText(R.string.StandAside);
	  			
	  			tvRTitle.setText("Whirling Death");
	  			tvRText.setText(R.string.WhirlingDeath);
	  			return V;
	  		case 17:
	  			ivPassive.setImageResource(R.drawable.spider_swarm);
	  			ivQ.setImageResource(R.drawable.neurotoxin);
	  			ivW.setImageResource(R.drawable.volatile_spiderling);
	  			ivE.setImageResource(R.drawable.cocoon);
	  			ivR.setImageResource(R.drawable.spider_form);
	  			
	  			tvPassiveTitle.setText("Spider Swarm");
	  			tvPassiveText.setText(R.string.SpiderSwarm);
	  			
	  			tvQTitle.setText("Neurotoxin / Venomous Bite");
	  			tvQText.setText(R.string.EliseQ);
	  			
	  			tvWTitle.setText("Volatile Spiderling / Skittering Frenzy");
	  			tvWText.setText(R.string.EliseW);
	  			
	  			tvETitle.setText("Cocoon / Rappel");
	  			tvEText.setText(R.string.EliseE);
	  			
	  			tvRTitle.setText("Spider Form / Human Form");
	  			tvRText.setText(R.string.EliseR);
	  			return V;
	  		case 18:
	  			ivPassive.setImageResource(R.drawable.shadow_walk);
	  			ivQ.setImageResource(R.drawable.hate_spike);
	  			ivW.setImageResource(R.drawable.dark_frenzy);
	  			ivE.setImageResource(R.drawable.ravage);
	  			ivR.setImageResource(R.drawable.agonys_embrace);
	  			
	  			tvPassiveTitle.setText("Shadow Walk");
	  			tvPassiveText.setText(R.string.ShadowWalk);
	  			
	  			tvQTitle.setText("Hate Spike");
	  			tvQText.setText(R.string.HateSpike);
	  			
	  			tvWTitle.setText("Dark Frenzy");
	  			tvWText.setText(R.string.DarkFrenzy);
	  			
	  			tvETitle.setText("Ravage");
	  			tvEText.setText(R.string.Ravage);
	  			
	  			tvRTitle.setText("Agony's Embrace");
	  			tvRText.setText(R.string.AgonysEmbrace);
	  			return V;
	  		case 19:
	  			ivPassive.setImageResource(R.drawable.rising_spell_force);
	  			ivQ.setImageResource(R.drawable.mystic_shot);
	  			ivW.setImageResource(R.drawable.essence_flux);
	  			ivE.setImageResource(R.drawable.arcane_shift);
	  			ivR.setImageResource(R.drawable.trueshot_barrage);
	  			
	  			tvPassiveTitle.setText("Rising Spell Force");
	  			tvPassiveText.setText(R.string.RisingSpellForce);
	  			
	  			tvQTitle.setText("Mystic Shot");
	  			tvQText.setText(R.string.MysticShot);
	  			
	  			tvWTitle.setText("Essence Flux");
	  			tvWText.setText(R.string.EssenceFlux);
	  			
	  			tvETitle.setText("Arcane Shift");
	  			tvEText.setText(R.string.ArcaneShift);
	  			
	  			tvRTitle.setText("Trueshot Barrage");
	  			tvRText.setText(R.string.TrueshotBarrage);
	  			return V;
	  		case 20:
	  			ivPassive.setImageResource(R.drawable.dread);
	  			ivQ.setImageResource(R.drawable.terrify);
	  			ivW.setImageResource(R.drawable.drain);
	  			ivE.setImageResource(R.drawable.dark_wind);
	  			ivR.setImageResource(R.drawable.crowstorm);
	  			
	  			tvPassiveTitle.setText("Dread");
	  			tvPassiveText.setText(R.string.Dread);
	  			
	  			tvQTitle.setText("Terrify");
	  			tvQText.setText(R.string.Terrify);
	  			
	  			tvWTitle.setText("Drain");
	  			tvWText.setText(R.string.Drain);
	  			
	  			tvETitle.setText("Dark Wind");
	  			tvEText.setText(R.string.DarkWind);
	  			
	  			tvRTitle.setText("Crowstorm");
	  			tvRText.setText(R.string.Crowstorm);
	  			return V;
	  		case 21:
	  			ivPassive.setImageResource(R.drawable.duelist);
	  			ivQ.setImageResource(R.drawable.lunge);
	  			ivW.setImageResource(R.drawable.riposte);
	  			ivE.setImageResource(R.drawable.burst_of_speed);
	  			ivR.setImageResource(R.drawable.blade_waltz);
	  			
	  			tvPassiveTitle.setText("Duelist");
	  			tvPassiveText.setText(R.string.Duelist);
	  			
	  			tvQTitle.setText("Lunge");
	  			tvQText.setText(R.string.Lunge);
	  			
	  			tvWTitle.setText("Riposte");
	  			tvWText.setText(R.string.Riposte);
	  			
	  			tvETitle.setText("Burst of Speed");
	  			tvEText.setText(R.string.BurstofSpeed);
	  			
	  			tvRTitle.setText("Blade Waltz");
	  			tvRText.setText(R.string.BladeWaltz);
	  			return V;
	  		case 22:
	  			ivPassive.setImageResource(R.drawable.nimble_fighter);
	  			ivQ.setImageResource(R.drawable.urchin_strike);
	  			ivW.setImageResource(R.drawable.seastone_trident);
	  			ivE.setImageResource(R.drawable.playful);
	  			ivR.setImageResource(R.drawable.chum_the_waters);
	  			
	  			tvPassiveTitle.setText("Nimble Fighter");
	  			tvPassiveText.setText(R.string.NimbleFighter);
	  			
	  			tvQTitle.setText("Urchin Strike");
	  			tvQText.setText(R.string.UrchinStrike);
	  			
	  			tvWTitle.setText("Seastone Trident");
	  			tvWText.setText(R.string.SeastoneTrident);
	  			
	  			tvETitle.setText("Playful / Trickster");
	  			tvEText.setText(R.string.PlayfulTrickster);
	  			
	  			tvRTitle.setText("Chum the Waters");
	  			tvRText.setText(R.string.ChumtheWaters);
	  			return V;
	  		case 23:
	  			ivPassive.setImageResource(R.drawable.runic_skin);
	  			ivQ.setImageResource(R.drawable.resolute_smite);
	  			ivW.setImageResource(R.drawable.bulwark);
	  			ivE.setImageResource(R.drawable.righteous_gust);
	  			ivR.setImageResource(R.drawable.idol_of_durand);
	  			
	  			tvPassiveTitle.setText("Runic Skin");
	  			tvPassiveText.setText(R.string.RunicSkin);
	  			
	  			tvQTitle.setText("Resolute Smite");
	  			tvQText.setText(R.string.ResoluteSmite);
	  			
	  			tvWTitle.setText("Bulwark");
	  			tvWText.setText(R.string.Bulwark);
	  			
	  			tvETitle.setText("Righteous Gust");
	  			tvEText.setText(R.string.RighteousGust);
	  			
	  			tvRTitle.setText("Idol of Durand");
	  			tvRText.setText(R.string.IdolofDurand);
	  			return V;
	  		case 24:
	  			ivPassive.setImageResource(R.drawable.grog_soaked_blade);
	  			ivQ.setImageResource(R.drawable.parrrley);
	  			ivW.setImageResource(R.drawable.remove_scurvy);
	  			ivE.setImageResource(R.drawable.raise_morale);
	  			ivR.setImageResource(R.drawable.cannon_barrage);
	  			
	  			tvPassiveTitle.setText("Grog Soaked Blade");
	  			tvPassiveText.setText(R.string.GrogSoakedBlade);
	  			
	  			tvQTitle.setText("Parrrley");
	  			tvQText.setText(R.string.Parrrley);
	  			
	  			tvWTitle.setText("Remove Scurvy");
	  			tvWText.setText(R.string.RemoveScurvy);
	  			
	  			tvETitle.setText("Raise Morale");
	  			tvEText.setText(R.string.RaiseMorale);
	  			
	  			tvRTitle.setText("Cannon Barrage");
	  			tvRText.setText(R.string.CannonBarrage);
	  			return V;
	  		case 25:
	  			ivPassive.setImageResource(R.drawable.perseverance);
	  			ivQ.setImageResource(R.drawable.decisive_strike);
	  			ivW.setImageResource(R.drawable.courage);
	  			ivE.setImageResource(R.drawable.judgment);
	  			ivR.setImageResource(R.drawable.demacian_justice);
	  			
	  			tvPassiveTitle.setText("Perseverance");
	  			tvPassiveText.setText(R.string.Perseverance);
	  			
	  			tvQTitle.setText("Decisive Strike");
	  			tvQText.setText(R.string.DecisiveStrike);
	  			
	  			tvWTitle.setText("Courage");
	  			tvWText.setText(R.string.Courage);
	  			
	  			tvETitle.setText("Judgment");
	  			tvEText.setText(R.string.Judgment);
	  			
	  			tvRTitle.setText("Demacian Justice");
	  			tvRText.setText(R.string.DemacianJustice);
	  			return V;
	  		default:
	  			return V;
  	  }
  	  
    	
	  		
		  
       
    }

    
}


