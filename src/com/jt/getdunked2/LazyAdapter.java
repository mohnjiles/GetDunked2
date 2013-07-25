package com.jt.getdunked2;

import java.security.PublicKey;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.PrivateCredentialPermission;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LazyAdapter extends ArrayAdapter {


	Number killsValue = null;
	Number deathsValue = null;
	Number assistsValue = null;
	Number itemOneId = null;
	Number itemTwoId = null;
	Number itemThreeId = null;
	Number itemFourId = null;
	Number itemFiveId = null;
	Number itemSixId = null;
	public static Number damageDealt = null;
	Number damageRec = null;
	Number healingDone = null;
	Number gold = null;
	Number multiKill = null;
	Number timeDead = null;
	Number wardsPlaced = null;
	Number minionsKilled = null;
	Number neutralMinionsKilled = null;
	Number summSpellOne = null;
	Number summSpellTwo = null;
	int itemNumber = 0;
	
	int resource;
	String response;
	Context context;
	private LayoutInflater mInflater;
	Map<String, Integer> champs = new HashMap<String, Integer>();

	public LazyAdapter(Context context, int resource, List objects) {
		super(context, resource, objects);
		this.resource = resource;
		mInflater = LayoutInflater.from(context);
	}

	static class ViewHolder {
		TextView gameType;
		TextView winOrLose;
		TextView killsTxt;
		TextView deathsTxt;
		TextView assistsTxt;
		TextView kills;
		TextView deaths;
		TextView assists;
		TextView dDealt;
		TextView dRec;
		TextView hDone;
		TextView goldValue;
		TextView lrgMultiKill;
		TextView timeSpentDead;
		TextView wards;
		TextView minions;
		TextView titleOne;
		TextView titleTwo;
		TextView tvDebug;
		ImageView champIcon;
		ImageView itemOne;
		ImageView itemTwo;
		ImageView itemThree;
		ImageView itemFour;
		ImageView itemFive;
		ImageView itemSix;
		ImageView summonerOne;
		ImageView summonerTwo;
		RelativeLayout background;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		GameStatistics gs = (GameStatistics) getItem(9 - position);
		ViewHolder holder;
		// Get the current location object

		// Inflate the view
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.custom_list_view, parent,
					false);
			holder = new ViewHolder();
			
			holder.gameType = (TextView) convertView
					.findViewById(R.id.gameType);
			holder.winOrLose = (TextView) convertView
					.findViewById(R.id.tvResult);
			holder.dDealt = (TextView) convertView
					.findViewById(R.id.tvDDealtNum);
			holder.dRec = (TextView) convertView
					.findViewById(R.id.tvDRecNum);
			holder.hDone = (TextView) convertView
					.findViewById(R.id.tvHDoneNum);
			holder.goldValue = (TextView) convertView
					.findViewById(R.id.tvGold);
			holder.lrgMultiKill = (TextView) convertView
					.findViewById(R.id.tvMultiKillValue);
			holder.timeSpentDead = (TextView) convertView
					.findViewById(R.id.tvTimeDeadValue);
			holder.wards = (TextView) convertView
					.findViewById(R.id.tvWardsPlacedValue);
			holder.minions = (TextView) convertView
					.findViewById(R.id.tvMinionsValue);
			holder.champIcon = (ImageView) convertView
					.findViewById(R.id.list_image);
			holder.background = (RelativeLayout) convertView
					.findViewById(R.id.relativeList);
			holder.itemOne = (ImageView) convertView
					.findViewById(R.id.ivItemOne);
			holder.itemTwo = (ImageView) convertView
					.findViewById(R.id.ivItemTwo);
			holder.itemThree = (ImageView) convertView
					.findViewById(R.id.ivItemThree);
			holder.itemFour = (ImageView) convertView
					.findViewById(R.id.ivItemFour);
			holder.itemFive = (ImageView) convertView
					.findViewById(R.id.ivItemFive);
			holder.itemSix = (ImageView) convertView
					.findViewById(R.id.ivItemSix);
			holder.summonerOne = (ImageView) convertView
					.findViewById(R.id.ivSummonerOne);
			holder.summonerTwo = (ImageView) convertView
					.findViewById(R.id.ivSummonerTwo);
					
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// define some shit
		Number win = null;
		
		// Get Statistics
		for (Statistics statistic : gs.getStatistics()) {
			if (statistic.getStatType().equals("WIN")) {
				win = statistic.getValue();
			} else if (statistic.getStatType().equals("CHAMPIONS_KILLED")) {
				killsValue = statistic.getValue();
			} else if (statistic.getStatType().equals("NUM_DEATHS")) {
				deathsValue = statistic.getValue();
			} else if (statistic.getStatType().equals("ASSISTS")) {
				assistsValue = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM0")) {
				itemOneId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM1")) {
				itemTwoId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM2")) {
				itemThreeId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM3")) {
				itemFourId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM4")) {
				itemFiveId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM5")) {
				itemSixId = statistic.getValue();
			} else if (statistic.getStatType().equals("TOTAL_DAMAGE_DEALT")) {
				damageDealt = statistic.getValue();
			} else if (statistic.getStatType().equals("TOTAL_DAMAGE_TAKEN")) {
				damageRec = statistic.getValue();
			} else if (statistic.getStatType().equals("TOTAL_HEAL")) {
				healingDone = statistic.getValue();
			} else if (statistic.getStatType().equals("GOLD_EARNED")) {
				gold = statistic.getValue();
			} else if (statistic.getStatType().equals("LARGEST_MULTI_KILL")) {
				multiKill = statistic.getValue();
			} else if (statistic.getStatType().equals("TOTAL_TIME_SPENT_DEAD")) {
				timeDead = statistic.getValue();
			} else if (statistic.getStatType().equals("WARD_PLACED")) {
				wardsPlaced = statistic.getValue();
			} else if (statistic.getStatType().equals("MINIONS_KILLED")) {
				minionsKilled = statistic.getValue();
			} else if (statistic.getStatType().equals("NEUTRAL_MINIONS_KILLED")) {
				neutralMinionsKilled = statistic.getValue();
			}

		}
		// Set Game Mode

		if (gs.getGameType() != null) {
			if (gs.getGameType().equals("MATCHED_GAME") && gs.getGameMode().equals("CLASSIC") && gs.getQueueType().equals("NORMAL")) {
				holder.gameType.setText("Normal 5v5");
			}
			else if (gs.getQueueType().equals("RANKED_TEAM_5x5")) {
				holder.gameType.setText("Ranked Team 5v5");
			}
			else if (gs.getQueueType().equals("RANKED_SOLO_5x5")) {
				holder.gameType.setText("Ranked Solo 5v5");
			}
			else if (gs.getGameMode().equals("CLASSIC") && gs.getQueueType().equals("BOT")) {
				holder.gameType.setText("Co-op vs. AI 5v5");
			}
			else if (gs.getQueueType().equals("RANKED_TEAM_3x3")) {
				holder.gameType.setText("Ranked Team 3v3");
			}
			else if (gs.getQueueType().equals("NORMAL_3x3")) {
				holder.gameType.setText("Normal 3v3");
			}
			else if (gs.getQueueType().equals("BOT_3x3")) {
				holder.gameType.setText("Co-op vs. AI 3v3");
			}
			else if (gs.getGameMode().equals("ODIN") && gs.getQueueType().equals("ODIN_UNRANKED")) {
				holder.gameType.setText("Dominion");
			}
			else if (gs.getGameMode().equals("ODIN") && gs.getQueueType().equals("BOT")) {
				holder.gameType.setText("Co-op vs. AI Dominion");
			}
			else if (gs.getGameType().equals("MATCHED_GAME") && gs.getGameMode().equals("ARAM")) {
				holder.gameType.setText("ARAM");
			}
			else if (gs.getGameType().equals("CUSTOM_GAME")) {
				holder.gameType.setText("Custom Game");
			}
			
			
		}

		// Set Item Icons
		if (gs.getSpell1() != null) {
			switch (gs.getSpell1().intValue()) {
			case 1:
				holder.summonerOne.setImageResource(R.drawable.cleanse);
				break;
			case 2:
				holder.summonerOne.setImageResource(R.drawable.clairvoyance);
				break;
			case 3:
				holder.summonerOne.setImageResource(R.drawable.exhaust);
				break;
			case 4:
				holder.summonerOne.setImageResource(R.drawable.flash);
				break;
			case 6:
				holder.summonerOne.setImageResource(R.drawable.ghost);
				break;
			case 7:
				holder.summonerOne.setImageResource(R.drawable.heal);
				break;
			case 10:
				holder.summonerOne.setImageResource(R.drawable.revive);
				break;
			case 11:
				holder.summonerOne.setImageResource(R.drawable.smite);
				break;
			case 12:
				holder.summonerOne.setImageResource(R.drawable.teleport);
				break;
			case 13:
				holder.summonerOne.setImageResource(R.drawable.clarity);
				break;
			case 14:
				holder.summonerOne.setImageResource(R.drawable.ignite);
				break;
			case 17:
				holder.summonerOne.setImageResource(R.drawable.garrison);
				break;
			case 21:
				holder.summonerOne.setImageResource(R.drawable.barrier);
				break;
			default:
				holder.summonerOne.setImageResource(R.drawable.ability);
				break;
			}
		}
		
		if (gs.getSpell2() != null) {
			switch (gs.getSpell2().intValue()) {
			case 1:
				holder.summonerTwo.setImageResource(R.drawable.cleanse);
				break;
			case 2:
				holder.summonerTwo.setImageResource(R.drawable.clairvoyance);
				break;
			case 3:
				holder.summonerTwo.setImageResource(R.drawable.exhaust);
				break;
			case 4:
				holder.summonerTwo.setImageResource(R.drawable.flash);
				break;
			case 6:
				holder.summonerTwo.setImageResource(R.drawable.ghost);
				break;
			case 7:
				holder.summonerTwo.setImageResource(R.drawable.heal);
				break;
			case 10:
				holder.summonerTwo.setImageResource(R.drawable.revive);
				break;
			case 11:
				holder.summonerTwo.setImageResource(R.drawable.smite);
				break;
			case 12:
				holder.summonerTwo.setImageResource(R.drawable.teleport);
				break;
			case 13:
				holder.summonerTwo.setImageResource(R.drawable.clarity);
				break;
			case 14:
				holder.summonerTwo.setImageResource(R.drawable.ignite);
				break;
			case 17:
				holder.summonerTwo.setImageResource(R.drawable.garrison);
				break;
			case 21:
				holder.summonerTwo.setImageResource(R.drawable.barrier);
				break;
			default:
				holder.summonerTwo.setImageResource(R.drawable.ability);
				break;
			}
		}
		// Item 1
		if (itemOneId != null) {
			switch (itemOneId.intValue()) {
			case 1001:
				holder.itemOne.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1004:
				holder.itemOne.setImageResource(R.drawable.faerie_charm_item);
				break;
			case 1006:
				holder.itemOne.setImageResource(R.drawable.rejuvenation_bead_item);
				break;
			case 1011:
				holder.itemOne.setImageResource(R.drawable.giants_belt_item);
				break;
			case 1018:
				holder.itemOne.setImageResource(R.drawable.cloak_of_agility_item);
				break;
			case 1026:
				holder.itemOne.setImageResource(R.drawable.blasting_wand_item);
				break;
			case 1027:
				holder.itemOne.setImageResource(R.drawable.sapphire_crystal_item);
				break;
			case 1028:
				holder.itemOne.setImageResource(R.drawable.ruby_crystal_item);
				break;
			case 1029:
				holder.itemOne.setImageResource(R.drawable.cloth_armor_item);
				break;
			case 1031:
				holder.itemOne.setImageResource(R.drawable.chain_vest_item);
				break;
			case 1033:
				holder.itemOne.setImageResource(R.drawable.nullmagic_mantle_item);
				break;
			case 1036:
				holder.itemOne.setImageResource(R.drawable.long_sword_item);
				break;
			case 1037:
				holder.itemOne.setImageResource(R.drawable.pickaxe_item);
				break;
			case 1038:
				holder.itemOne.setImageResource(R.drawable.b_f_sword_item);
				break;
			case 1039:
				holder.itemOne.setImageResource(R.drawable.hunters_machete_item);
				break;
			case 1042:
				holder.itemOne.setImageResource(R.drawable.dagger_item);
				break;
			case 1043:
				holder.itemOne.setImageResource(R.drawable.recurve_bow_item);
				break;
			case 1051:
				holder.itemOne.setImageResource(R.drawable.brawlers_gloves_item);
				break;
			case 1052:
				holder.itemOne.setImageResource(R.drawable.amplifying_tome_item);
				break;
			case 1053:
				holder.itemOne.setImageResource(R.drawable.vampiric_scepter_item);
				break;
			case 1054:
				holder.itemOne.setImageResource(R.drawable.dorans_shield_item);
				break;
			case 1055:
				holder.itemOne.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 1056:
				holder.itemOne.setImageResource(R.drawable.dorans_ring_item);
				break;
			case 1057:
				holder.itemOne.setImageResource(R.drawable.negatron_cloak_item);
				break;
			case 1058:
				holder.itemOne.setImageResource(R.drawable.needlessly_large_rod_item);
				break;
			case 1062:
				holder.itemOne.setImageResource(R.drawable.prospectors_blade_item);
				break;
			case 1063:
				holder.itemOne.setImageResource(R.drawable.prospectors_ring_item);
				break;
			case 1080:
				holder.itemOne.setImageResource(R.drawable.spirit_stone_item);
				break;
			case 2003:
				holder.itemOne.setImageResource(R.drawable.health_potion_item);
				break;
			case 2004:
				holder.itemOne.setImageResource(R.drawable.mana_potion_item);
				break;
			case 2009:
				holder.itemOne.setImageResource(R.drawable.total_biscuit_of_rejuvenation_item);
				break;
			case 2037:
				holder.itemOne.setImageResource(R.drawable.elixir_of_fortitude_item);
				break;
			case 2039:
				holder.itemOne.setImageResource(R.drawable.elixir_of_brilliance_item);
				break;
			case 2040:
				holder.itemOne.setImageResource(R.drawable.ichor_of_rage_item);
				break;
			case 2041:
				holder.itemOne.setImageResource(R.drawable.crystalline_flask_item);
				break;
			case 2042:
				holder.itemOne.setImageResource(R.drawable.oracles_elixir_item);
				break;
			case 2043:
				holder.itemOne.setImageResource(R.drawable.vision_ward_item);
				break;
			case 2044:
				holder.itemOne.setImageResource(R.drawable.sight_ward_item);
				break;
			case 2045:
				holder.itemOne.setImageResource(R.drawable.ruby_sightstone_item);
				break;
			case 2047:
				holder.itemOne.setImageResource(R.drawable.oracles_extract_item);
				break;
			case 2048:
				holder.itemOne.setImageResource(R.drawable.ichor_of_illumination_item);
				break;
			case 2049:
				holder.itemOne.setImageResource(R.drawable.sightstone_item);
				break;
			case 3001:
				holder.itemOne.setImageResource(R.drawable.abyssal_scepter_item);
				break;
			case 3003:
				holder.itemOne.setImageResource(R.drawable.archangels_staff_item);
				break;
			case 3004:
				holder.itemOne.setImageResource(R.drawable.manamune_item);
				break;
			case 3005:
				holder.itemOne.setImageResource(R.drawable.atmas_impaler_item);
				break;
			case 3006:
				holder.itemOne.setImageResource(R.drawable.berserkers_greaves_item);
				break;
			case 3009:
				holder.itemOne.setImageResource(R.drawable.boots_of_swiftness_item);
				break;
			case 3010:
				holder.itemOne.setImageResource(R.drawable.catalyst_the_protector_item);
				break;
			case 3020:
				holder.itemOne.setImageResource(R.drawable.sorcerers_shoes_item);
				break;
			case 3022:
				holder.itemOne.setImageResource(R.drawable.frozen_mallet_item);
				break;
			case 3023:
				holder.itemOne.setImageResource(R.drawable.twin_shadows_item);
				break;
			case 3024:
				holder.itemOne.setImageResource(R.drawable.glacial_shroud_item);
				break;
			case 3025:
				holder.itemOne.setImageResource(R.drawable.iceborn_gauntlet_item);
				break;
			case 3026:
				holder.itemOne.setImageResource(R.drawable.guardian_angel_item);
				break;
			case 3027:
				holder.itemOne.setImageResource(R.drawable.rod_of_ages_item);
				break;
			case 3028:
				holder.itemOne.setImageResource(R.drawable.chalice_of_harmony_item);
				break;
			case 3031:
				holder.itemOne.setImageResource(R.drawable.infinity_edge_item);
				break;
			case 3035:
				holder.itemOne.setImageResource(R.drawable.last_whisper_item);
				break;
			case 3037:
				holder.itemOne.setImageResource(R.drawable.mana_manipulator_item);
				break;
			case 3041:
				holder.itemOne.setImageResource(R.drawable.mejais_soulstealer_item);
				break;
			case 3044:
				holder.itemOne.setImageResource(R.drawable.phage_item);
				break;
			case 3046:
				holder.itemOne.setImageResource(R.drawable.phantom_dancer_item);
				break;
			case 3047:
				holder.itemOne.setImageResource(R.drawable.ninja_tabi_item);
				break;
			case 3050:
				holder.itemOne.setImageResource(R.drawable.zekes_herald_item);
				break;
			case 3056:
				holder.itemOne.setImageResource(R.drawable.ohmwrecker_item);
				break;
			case 3057:
				holder.itemOne.setImageResource(R.drawable.sheen_item);
				break;
			case 3060:
				holder.itemOne.setImageResource(R.drawable.banner_of_command_item);
				break;
			case 3065:
				holder.itemOne.setImageResource(R.drawable.spirit_visage_item);
				break;
			case 3067:
				holder.itemOne.setImageResource(R.drawable.kindlegem_item);
				break;
			case 3068:
				holder.itemOne.setImageResource(R.drawable.sunfire_cape_item);
				break;
			case 3069:
				holder.itemOne.setImageResource(R.drawable.shurelyas_reverie_item);
				break;
			case 3070:
				holder.itemOne
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3071:
				holder.itemOne.setImageResource(R.drawable.the_black_cleaver_item);
				break;
			case 3072:
				holder.itemOne
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			case 3074:
				holder.itemOne.setImageResource(R.drawable.ravenous_hydra_item);
				break;
			case 3075:
				holder.itemOne.setImageResource(R.drawable.thornmail_item);
				break;
			case 3077:
				holder.itemOne.setImageResource(R.drawable.tiamat_item);
				break;
			case 3078:
				holder.itemOne.setImageResource(R.drawable.trinity_force_item);
				break;
			case 3082:
				holder.itemOne.setImageResource(R.drawable.wardens_mail_item);
				break;
			case 3083:
				holder.itemOne.setImageResource(R.drawable.warmogs_armor_item);
				break;
			case 3084:
				holder.itemOne.setImageResource(R.drawable.overlords_bloodmail_item);
				break;
			case 3085:
				holder.itemOne.setImageResource(R.drawable.runaans_hurricane_item);
				break;
			case 3086:
				holder.itemOne.setImageResource(R.drawable.zeal_item);
				break;
			case 3087:
				holder.itemOne.setImageResource(R.drawable.statikk_shiv_item);
				break;
			case 3089:
				holder.itemOne.setImageResource(R.drawable.rabadons_deathcap_item);
				break;
			case 3090:
				holder.itemOne.setImageResource(R.drawable.wooglets_witchcap_item);
				break;
			case 3091:
				holder.itemOne.setImageResource(R.drawable.wits_end_item);
				break;
			case 3092:
				holder.itemOne.setImageResource(R.drawable.shard_of_true_ice_item);
				break;
			case 3093:
				holder.itemOne.setImageResource(R.drawable.avarice_blade_item);
				break;
			case 3096:
				holder.itemOne.setImageResource(R.drawable.philosophers_stone_item);
				break;
			case 3097:
				holder.itemOne.setImageResource(R.drawable.emblem_of_valor_item);
				break;
			case 3098:
				holder.itemOne.setImageResource(R.drawable.kages_lucky_pick_item);
				break;
			case 3100:
				holder.itemOne.setImageResource(R.drawable.lich_bane_item);
				break;
			case 3101:
				holder.itemOne.setImageResource(R.drawable.stinger_item);
				break;
			case 3102:
				holder.itemOne.setImageResource(R.drawable.banshees_veil_item);
				break;
			case 3104:
				holder.itemOne.setImageResource(R.drawable.lord_van_damms_pillager_item);
				break;
			case 3105:
				holder.itemOne.setImageResource(R.drawable.aegis_of_the_legion_item);
				break;
			case 3106:
				holder.itemOne.setImageResource(R.drawable.madreds_razors_item);
				break;
			case 3107:
				holder.itemOne.setImageResource(R.drawable.runic_bulwark_item);
				break;
			case 3108:
				holder.itemOne.setImageResource(R.drawable.fiendish_codex_item);
				break;
			case 3110:
				holder.itemOne.setImageResource(R.drawable.frozen_heart_item);
				break;
			case 3111:
				holder.itemOne.setImageResource(R.drawable.mercurys_treads_item);
				break;
			case 3114:
				holder.itemOne.setImageResource(R.drawable.malady_item);
				break;
			case 3115:
				holder.itemOne.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3116:
				holder.itemOne.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3117:
				holder.itemOne.setImageResource(R.drawable.boots_of_mobility_item);
				break;
			case 3122:
				holder.itemOne.setImageResource(R.drawable.wicked_hatchet_item);
				break;
			case 3123:
				holder.itemOne.setImageResource(R.drawable.executioners_calling_item);
				break;
			case 3124:
				holder.itemOne.setImageResource(R.drawable.guinsoos_rageblade_item);
				break;
			case 3128:
				holder.itemOne.setImageResource(R.drawable.deathfire_grasp_item);
				break;
			case 3131:
				holder.itemOne.setImageResource(R.drawable.sword_of_the_divine_item);
				break;
			case 3134:
				holder.itemOne.setImageResource(R.drawable.the_brutalizer_item);
				break;
			case 3135:
				holder.itemOne.setImageResource(R.drawable.void_staff_item);
				break;
			case 3136:
				holder.itemOne.setImageResource(R.drawable.haunting_guise_item);
				break;
			case 3139:
				holder.itemOne.setImageResource(R.drawable.mercurial_scimitar_item);
				break;
			case 3140:
				holder.itemOne.setImageResource(R.drawable.quicksilver_sash_item);
				break;
			case 3141:
				holder.itemOne.setImageResource(R.drawable.sword_of_the_occult_item);
				break;
			case 3142:
				holder.itemOne.setImageResource(R.drawable.youmuus_ghostblade_item);
				break;
			case 3143:
				holder.itemOne.setImageResource(R.drawable.randuins_omen_item);
				break;
			case 3144:
				holder.itemOne.setImageResource(R.drawable.bilgewater_cutlass_item);
				break;
			case 3145:
				holder.itemOne.setImageResource(R.drawable.hextech_revolver_item);
				break;
			case 3146:
				holder.itemOne.setImageResource(R.drawable.hextech_gunblade_item);
				break;
			case 3151:
				holder.itemOne.setImageResource(R.drawable.liandrys_torment_item);
				break;
			case 3152:
				holder.itemOne.setImageResource(R.drawable.will_of_the_ancients_item);
				break;
			case 3153:
				holder.itemOne.setImageResource(R.drawable.blade_of_the_ruined_king_item);
				break;
			case 3154:
				holder.itemOne.setImageResource(R.drawable.wriggles_lantern_item);
				break;
			case 3155:
				holder.itemOne.setImageResource(R.drawable.hexdrinker_item);
				break;
			case 3156:
				holder.itemOne.setImageResource(R.drawable.maw_of_malmortius_item);
				break;
			case 3157:
				holder.itemOne.setImageResource(R.drawable.zhonyas_hourglass_item);
				break;
			case 3158:
				holder.itemOne.setImageResource(R.drawable.ionian_boots_of_lucidity_item);
				break;
			case 3159:
				holder.itemOne.setImageResource(R.drawable.grezs_spectral_lantern_item);
				break;
			case 3165:
				holder.itemOne.setImageResource(R.drawable.morellonomicon_item);
				break;
			case 3166:
				holder.itemOne.setImageResource(R.drawable.bonetooth_necklace_item);
				break;
			case 3172:
				holder.itemOne.setImageResource(R.drawable.zephyr_item);
				break;
			case 3173:
				holder.itemOne.setImageResource(R.drawable.eleisas_miracle_item);
				break;
			case 3174:
				holder.itemOne.setImageResource(R.drawable.athenes_unholy_grail_item);
				break;
			case 3180:
				holder.itemOne.setImageResource(R.drawable.odyns_veil_item);
				break;
			case 3181:
				holder.itemOne.setImageResource(R.drawable.sanguine_blade_item);
				break;
			case 3184:
				holder.itemOne.setImageResource(R.drawable.entropy_item);
				break;
			case 3185:
				holder.itemOne.setImageResource(R.drawable.the_lightbringer_item);
				break;
			case 3186:
				holder.itemOne.setImageResource(R.drawable.kitaes_bloodrazor_item);
				break;
			case 3187:
				holder.itemOne.setImageResource(R.drawable.hextech_sweeper_item);
				break;
			case 3188:
				holder.itemOne.setImageResource(R.drawable.blackfire_torch_item);
				break;
			case 3190:
				holder.itemOne.setImageResource(R.drawable.locket_of_the_iron_solari_item);
				break;
			case 3196:
				holder.itemOne.setImageResource(R.drawable.augment_power_item);
				break;
			case 3197:
				holder.itemOne.setImageResource(R.drawable.augment_gravity_item);
				break;
			case 3198:
				holder.itemOne.setImageResource(R.drawable.augment_death_item);
				break;
			case 3206:
				holder.itemOne.setImageResource(R.drawable.spirit_of_the_spectral_wraith_item);
				break;
			case 3207:
				holder.itemOne.setImageResource(R.drawable.spirit_of_the_ancient_golem_item);
				break;
			case 3209:
				holder.itemOne.setImageResource(R.drawable.spirit_of_the_elder_lizard_item);
				break;
			case 3222:
				holder.itemOne.setImageResource(R.drawable.mikaels_crucible_item);
				break;
			case 3250:
				holder.itemOne.setImageResource(R.drawable.berserkers_greaves_homeguard_item);
				break;
			case 3251:
				holder.itemOne.setImageResource(R.drawable.berserkers_greaves_captain_item);
				break;
			case 3252:
				holder.itemOne.setImageResource(R.drawable.berserkers_greaves_furor_item);
				break;
			case 3253:
				holder.itemOne.setImageResource(R.drawable.berserkers_greaves_distortion_item);
				break;
			case 3254:
				holder.itemOne.setImageResource(R.drawable.berserkers_greaves_alacrity_item);
				break;
			case 3255:
				holder.itemOne.setImageResource(R.drawable.sorcerers_shoes_homeguard_item);
				break;
			case 3256:
				holder.itemOne.setImageResource(R.drawable.sorcerers_shoes_captain_item);
				break;
			case 3257:
				holder.itemOne.setImageResource(R.drawable.sorcerers_shoes_furor_item);
				break;
			case 3258:
				holder.itemOne.setImageResource(R.drawable.sorcerers_shoes_distortion_item);
				break;
			case 3259:
				holder.itemOne.setImageResource(R.drawable.sorcerers_shoes_alacrity_item);
				break;
			case 3260:
				holder.itemOne.setImageResource(R.drawable.ninja_tabi_homeguard_item);
				break;
			case 3261:
				holder.itemOne.setImageResource(R.drawable.ninja_tabi_captain_item);
				break;
			case 3262:
				holder.itemOne.setImageResource(R.drawable.ninja_tabi_furor_item);
				break;
			case 3263:
				holder.itemOne.setImageResource(R.drawable.ninja_tabi_distortion_item);
				break;
			case 3264:
				holder.itemOne.setImageResource(R.drawable.ninja_tabi_alacrity_item);
				break;
			case 3265:
				holder.itemOne.setImageResource(R.drawable.mercurys_treads_homeguard_item);
				break;
			case 3266:
				holder.itemOne.setImageResource(R.drawable.mercurys_treads_captain_item);
				break;
			case 3267:
				holder.itemOne.setImageResource(R.drawable.mercurys_treads_furor_item);
				break;
			case 3268:
				holder.itemOne.setImageResource(R.drawable.mercurys_treads_distortion_item);
				break;
			case 3269:
				holder.itemOne.setImageResource(R.drawable.mercurys_treads_alacrity_item);
				break;
			case 3270:
				holder.itemOne.setImageResource(R.drawable.boots_of_mobility_homeguard_item);
				break;
			case 3271:
				holder.itemOne.setImageResource(R.drawable.boots_of_mobility_captain_item);
				break;
			case 3272:
				holder.itemOne.setImageResource(R.drawable.boots_of_mobility_furor_item);
				break;
			case 3273:
				holder.itemOne.setImageResource(R.drawable.boots_of_mobility_distortion_item);
				break;
			case 3274:
				holder.itemOne.setImageResource(R.drawable.boots_of_mobility_alacrity_item);
				break;
			case 3275:
				holder.itemOne.setImageResource(R.drawable.ionian_boots_of_lucidity_homeguard_item);
				break;
			case 3276:
				holder.itemOne.setImageResource(R.drawable.ionian_boots_of_lucidity_captain_item);
				break;
			case 3277:
				holder.itemOne.setImageResource(R.drawable.ionian_boots_of_lucidity_furor_item);
				break;
			case 3278:
				holder.itemOne.setImageResource(R.drawable.ionian_boots_of_lucidity_distortion_item);
				break;
			case 3279:
				holder.itemOne.setImageResource(R.drawable.ionian_boots_of_lucidity_alacrity_item);
				break;
			case 3280:
				holder.itemOne.setImageResource(R.drawable.boots_of_swiftness_homeguard_item);
				break;
			case 3281:
				holder.itemOne.setImageResource(R.drawable.boots_of_swiftness_captain_item);
				break;
			case 3282:
				holder.itemOne.setImageResource(R.drawable.boots_of_swiftness_furor_item);
				break;
			case 3283:
				holder.itemOne.setImageResource(R.drawable.boots_of_swiftness_distortion_item);
				break;
			case 3284:
				holder.itemOne.setImageResource(R.drawable.boots_of_swiftness_alacrity_item);
				break;
			default:
				holder.itemOne.setImageResource(R.drawable.ability);
				holder.itemOne.setVisibility(View.INVISIBLE);
				break;
			} 
			
		} else {
			holder.itemOne.setImageResource(R.drawable.ability);
			holder.itemOne.setVisibility(View.INVISIBLE);
		}
		
		// Item 2
		if (itemTwoId != null) {
			switch (itemTwoId.intValue()) {
			case 1001:
				holder.itemTwo.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1004:
				holder.itemTwo.setImageResource(R.drawable.faerie_charm_item);
				break;
			case 1006:
				holder.itemTwo.setImageResource(R.drawable.rejuvenation_bead_item);
				break;
			case 1011:
				holder.itemTwo.setImageResource(R.drawable.giants_belt_item);
				break;
			case 1018:
				holder.itemTwo.setImageResource(R.drawable.cloak_of_agility_item);
				break;
			case 1026:
				holder.itemTwo.setImageResource(R.drawable.blasting_wand_item);
				break;
			case 1027:
				holder.itemTwo.setImageResource(R.drawable.sapphire_crystal_item);
				break;
			case 1028:
				holder.itemTwo.setImageResource(R.drawable.ruby_crystal_item);
				break;
			case 1029:
				holder.itemTwo.setImageResource(R.drawable.cloth_armor_item);
				break;
			case 1031:
				holder.itemTwo.setImageResource(R.drawable.chain_vest_item);
				break;
			case 1033:
				holder.itemTwo.setImageResource(R.drawable.nullmagic_mantle_item);
				break;
			case 1036:
				holder.itemTwo.setImageResource(R.drawable.long_sword_item);
				break;
			case 1037:
				holder.itemTwo.setImageResource(R.drawable.pickaxe_item);
				break;
			case 1038:
				holder.itemTwo.setImageResource(R.drawable.b_f_sword_item);
				break;
			case 1039:
				holder.itemTwo.setImageResource(R.drawable.hunters_machete_item);
				break;
			case 1042:
				holder.itemTwo.setImageResource(R.drawable.dagger_item);
				break;
			case 1043:
				holder.itemTwo.setImageResource(R.drawable.recurve_bow_item);
				break;
			case 1051:
				holder.itemTwo.setImageResource(R.drawable.brawlers_gloves_item);
				break;
			case 1052:
				holder.itemTwo.setImageResource(R.drawable.amplifying_tome_item);
				break;
			case 1053:
				holder.itemTwo.setImageResource(R.drawable.vampiric_scepter_item);
				break;
			case 1054:
				holder.itemTwo.setImageResource(R.drawable.dorans_shield_item);
				break;
			case 1055:
				holder.itemTwo.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 1056:
				holder.itemTwo.setImageResource(R.drawable.dorans_ring_item);
				break;
			case 1057:
				holder.itemTwo.setImageResource(R.drawable.negatron_cloak_item);
				break;
			case 1058:
				holder.itemTwo.setImageResource(R.drawable.needlessly_large_rod_item);
				break;
			case 1062:
				holder.itemTwo.setImageResource(R.drawable.prospectors_blade_item);
				break;
			case 1063:
				holder.itemTwo.setImageResource(R.drawable.prospectors_ring_item);
				break;
			case 1080:
				holder.itemTwo.setImageResource(R.drawable.spirit_stone_item);
				break;
			case 2003:
				holder.itemTwo.setImageResource(R.drawable.health_potion_item);
				break;
			case 2004:
				holder.itemTwo.setImageResource(R.drawable.mana_potion_item);
				break;
			case 2009:
				holder.itemTwo.setImageResource(R.drawable.total_biscuit_of_rejuvenation_item);
				break;
			case 2037:
				holder.itemTwo.setImageResource(R.drawable.elixir_of_fortitude_item);
				break;
			case 2039:
				holder.itemTwo.setImageResource(R.drawable.elixir_of_brilliance_item);
				break;
			case 2040:
				holder.itemTwo.setImageResource(R.drawable.ichor_of_rage_item);
				break;
			case 2041:
				holder.itemTwo.setImageResource(R.drawable.crystalline_flask_item);
				break;
			case 2042:
				holder.itemTwo.setImageResource(R.drawable.oracles_elixir_item);
				break;
			case 2043:
				holder.itemTwo.setImageResource(R.drawable.vision_ward_item);
				break;
			case 2044:
				holder.itemTwo.setImageResource(R.drawable.sight_ward_item);
				break;
			case 2045:
				holder.itemTwo.setImageResource(R.drawable.ruby_sightstone_item);
				break;
			case 2047:
				holder.itemTwo.setImageResource(R.drawable.oracles_extract_item);
				break;
			case 2048:
				holder.itemTwo.setImageResource(R.drawable.ichor_of_illumination_item);
				break;
			case 2049:
				holder.itemTwo.setImageResource(R.drawable.sightstone_item);
				break;
			case 3001:
				holder.itemTwo.setImageResource(R.drawable.abyssal_scepter_item);
				break;
			case 3003:
				holder.itemTwo.setImageResource(R.drawable.archangels_staff_item);
				break;
			case 3004:
				holder.itemTwo.setImageResource(R.drawable.manamune_item);
				break;
			case 3005:
				holder.itemTwo.setImageResource(R.drawable.atmas_impaler_item);
				break;
			case 3006:
				holder.itemTwo.setImageResource(R.drawable.berserkers_greaves_item);
				break;
			case 3009:
				holder.itemTwo.setImageResource(R.drawable.boots_of_swiftness_item);
				break;
			case 3010:
				holder.itemTwo.setImageResource(R.drawable.catalyst_the_protector_item);
				break;
			case 3020:
				holder.itemTwo.setImageResource(R.drawable.sorcerers_shoes_item);
				break;
			case 3022:
				holder.itemTwo.setImageResource(R.drawable.frozen_mallet_item);
				break;
			case 3023:
				holder.itemTwo.setImageResource(R.drawable.twin_shadows_item);
				break;
			case 3024:
				holder.itemTwo.setImageResource(R.drawable.glacial_shroud_item);
				break;
			case 3025:
				holder.itemTwo.setImageResource(R.drawable.iceborn_gauntlet_item);
				break;
			case 3026:
				holder.itemTwo.setImageResource(R.drawable.guardian_angel_item);
				break;
			case 3027:
				holder.itemTwo.setImageResource(R.drawable.rod_of_ages_item);
				break;
			case 3028:
				holder.itemTwo.setImageResource(R.drawable.chalice_of_harmony_item);
				break;
			case 3031:
				holder.itemTwo.setImageResource(R.drawable.infinity_edge_item);
				break;
			case 3035:
				holder.itemTwo.setImageResource(R.drawable.last_whisper_item);
				break;
			case 3037:
				holder.itemTwo.setImageResource(R.drawable.mana_manipulator_item);
				break;
			case 3041:
				holder.itemTwo.setImageResource(R.drawable.mejais_soulstealer_item);
				break;
			case 3044:
				holder.itemTwo.setImageResource(R.drawable.phage_item);
				break;
			case 3046:
				holder.itemTwo.setImageResource(R.drawable.phantom_dancer_item);
				break;
			case 3047:
				holder.itemTwo.setImageResource(R.drawable.ninja_tabi_item);
				break;
			case 3050:
				holder.itemTwo.setImageResource(R.drawable.zekes_herald_item);
				break;
			case 3056:
				holder.itemTwo.setImageResource(R.drawable.ohmwrecker_item);
				break;
			case 3057:
				holder.itemTwo.setImageResource(R.drawable.sheen_item);
				break;
			case 3060:
				holder.itemTwo.setImageResource(R.drawable.banner_of_command_item);
				break;
			case 3065:
				holder.itemTwo.setImageResource(R.drawable.spirit_visage_item);
				break;
			case 3067:
				holder.itemTwo.setImageResource(R.drawable.kindlegem_item);
				break;
			case 3068:
				holder.itemTwo.setImageResource(R.drawable.sunfire_cape_item);
				break;
			case 3069:
				holder.itemTwo.setImageResource(R.drawable.shurelyas_reverie_item);
				break;
			case 3070:
				holder.itemTwo
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3071:
				holder.itemTwo.setImageResource(R.drawable.the_black_cleaver_item);
				break;
			case 3072:
				holder.itemTwo
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			case 3074:
				holder.itemTwo.setImageResource(R.drawable.ravenous_hydra_item);
				break;
			case 3075:
				holder.itemTwo.setImageResource(R.drawable.thornmail_item);
				break;
			case 3077:
				holder.itemTwo.setImageResource(R.drawable.tiamat_item);
				break;
			case 3078:
				holder.itemTwo.setImageResource(R.drawable.trinity_force_item);
				break;
			case 3082:
				holder.itemTwo.setImageResource(R.drawable.wardens_mail_item);
				break;
			case 3083:
				holder.itemTwo.setImageResource(R.drawable.warmogs_armor_item);
				break;
			case 3084:
				holder.itemTwo.setImageResource(R.drawable.overlords_bloodmail_item);
				break;
			case 3085:
				holder.itemTwo.setImageResource(R.drawable.runaans_hurricane_item);
				break;
			case 3086:
				holder.itemTwo.setImageResource(R.drawable.zeal_item);
				break;
			case 3087:
				holder.itemTwo.setImageResource(R.drawable.statikk_shiv_item);
				break;
			case 3089:
				holder.itemTwo.setImageResource(R.drawable.rabadons_deathcap_item);
				break;
			case 3090:
				holder.itemTwo.setImageResource(R.drawable.wooglets_witchcap_item);
				break;
			case 3091:
				holder.itemTwo.setImageResource(R.drawable.wits_end_item);
				break;
			case 3092:
				holder.itemTwo.setImageResource(R.drawable.shard_of_true_ice_item);
				break;
			case 3093:
				holder.itemTwo.setImageResource(R.drawable.avarice_blade_item);
				break;
			case 3096:
				holder.itemTwo.setImageResource(R.drawable.philosophers_stone_item);
				break;
			case 3097:
				holder.itemTwo.setImageResource(R.drawable.emblem_of_valor_item);
				break;
			case 3098:
				holder.itemTwo.setImageResource(R.drawable.kages_lucky_pick_item);
				break;
			case 3100:
				holder.itemTwo.setImageResource(R.drawable.lich_bane_item);
				break;
			case 3101:
				holder.itemTwo.setImageResource(R.drawable.stinger_item);
				break;
			case 3102:
				holder.itemTwo.setImageResource(R.drawable.banshees_veil_item);
				break;
			case 3104:
				holder.itemTwo.setImageResource(R.drawable.lord_van_damms_pillager_item);
				break;
			case 3105:
				holder.itemTwo.setImageResource(R.drawable.aegis_of_the_legion_item);
				break;
			case 3106:
				holder.itemTwo.setImageResource(R.drawable.madreds_razors_item);
				break;
			case 3107:
				holder.itemTwo.setImageResource(R.drawable.runic_bulwark_item);
				break;
			case 3108:
				holder.itemTwo.setImageResource(R.drawable.fiendish_codex_item);
				break;
			case 3110:
				holder.itemTwo.setImageResource(R.drawable.frozen_heart_item);
				break;
			case 3111:
				holder.itemTwo.setImageResource(R.drawable.mercurys_treads_item);
				break;
			case 3114:
				holder.itemTwo.setImageResource(R.drawable.malady_item);
				break;
			case 3115:
				holder.itemTwo.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3116:
				holder.itemTwo.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3117:
				holder.itemTwo.setImageResource(R.drawable.boots_of_mobility_item);
				break;
			case 3122:
				holder.itemTwo.setImageResource(R.drawable.wicked_hatchet_item);
				break;
			case 3123:
				holder.itemTwo.setImageResource(R.drawable.executioners_calling_item);
				break;
			case 3124:
				holder.itemTwo.setImageResource(R.drawable.guinsoos_rageblade_item);
				break;
			case 3128:
				holder.itemTwo.setImageResource(R.drawable.deathfire_grasp_item);
				break;
			case 3131:
				holder.itemTwo.setImageResource(R.drawable.sword_of_the_divine_item);
				break;
			case 3134:
				holder.itemTwo.setImageResource(R.drawable.the_brutalizer_item);
				break;
			case 3135:
				holder.itemTwo.setImageResource(R.drawable.void_staff_item);
				break;
			case 3136:
				holder.itemTwo.setImageResource(R.drawable.haunting_guise_item);
				break;
			case 3139:
				holder.itemTwo.setImageResource(R.drawable.mercurial_scimitar_item);
				break;
			case 3140:
				holder.itemTwo.setImageResource(R.drawable.quicksilver_sash_item);
				break;
			case 3141:
				holder.itemTwo.setImageResource(R.drawable.sword_of_the_occult_item);
				break;
			case 3142:
				holder.itemTwo.setImageResource(R.drawable.youmuus_ghostblade_item);
				break;
			case 3143:
				holder.itemTwo.setImageResource(R.drawable.randuins_omen_item);
				break;
			case 3144:
				holder.itemTwo.setImageResource(R.drawable.bilgewater_cutlass_item);
				break;
			case 3145:
				holder.itemTwo.setImageResource(R.drawable.hextech_revolver_item);
				break;
			case 3146:
				holder.itemTwo.setImageResource(R.drawable.hextech_gunblade_item);
				break;
			case 3151:
				holder.itemTwo.setImageResource(R.drawable.liandrys_torment_item);
				break;
			case 3152:
				holder.itemTwo.setImageResource(R.drawable.will_of_the_ancients_item);
				break;
			case 3153:
				holder.itemTwo.setImageResource(R.drawable.blade_of_the_ruined_king_item);
				break;
			case 3154:
				holder.itemTwo.setImageResource(R.drawable.wriggles_lantern_item);
				break;
			case 3155:
				holder.itemTwo.setImageResource(R.drawable.hexdrinker_item);
				break;
			case 3156:
				holder.itemTwo.setImageResource(R.drawable.maw_of_malmortius_item);
				break;
			case 3157:
				holder.itemTwo.setImageResource(R.drawable.zhonyas_hourglass_item);
				break;
			case 3158:
				holder.itemTwo.setImageResource(R.drawable.ionian_boots_of_lucidity_item);
				break;
			case 3159:
				holder.itemTwo.setImageResource(R.drawable.grezs_spectral_lantern_item);
				break;
			case 3165:
				holder.itemTwo.setImageResource(R.drawable.morellonomicon_item);
				break;
			case 3166:
				holder.itemTwo.setImageResource(R.drawable.bonetooth_necklace_item);
				break;
			case 3172:
				holder.itemTwo.setImageResource(R.drawable.zephyr_item);
				break;
			case 3173:
				holder.itemTwo.setImageResource(R.drawable.eleisas_miracle_item);
				break;
			case 3174:
				holder.itemTwo.setImageResource(R.drawable.athenes_unholy_grail_item);
				break;
			case 3180:
				holder.itemTwo.setImageResource(R.drawable.odyns_veil_item);
				break;
			case 3181:
				holder.itemTwo.setImageResource(R.drawable.sanguine_blade_item);
				break;
			case 3184:
				holder.itemTwo.setImageResource(R.drawable.entropy_item);
				break;
			case 3185:
				holder.itemTwo.setImageResource(R.drawable.the_lightbringer_item);
				break;
			case 3186:
				holder.itemTwo.setImageResource(R.drawable.kitaes_bloodrazor_item);
				break;
			case 3187:
				holder.itemTwo.setImageResource(R.drawable.hextech_sweeper_item);
				break;
			case 3188:
				holder.itemTwo.setImageResource(R.drawable.blackfire_torch_item);
				break;
			case 3190:
				holder.itemTwo.setImageResource(R.drawable.locket_of_the_iron_solari_item);
				break;
			case 3196:
				holder.itemTwo.setImageResource(R.drawable.augment_power_item);
				break;
			case 3197:
				holder.itemTwo.setImageResource(R.drawable.augment_gravity_item);
				break;
			case 3198:
				holder.itemTwo.setImageResource(R.drawable.augment_death_item);
				break;
			case 3206:
				holder.itemTwo.setImageResource(R.drawable.spirit_of_the_spectral_wraith_item);
				break;
			case 3207:
				holder.itemTwo.setImageResource(R.drawable.spirit_of_the_ancient_golem_item);
				break;
			case 3209:
				holder.itemTwo.setImageResource(R.drawable.spirit_of_the_elder_lizard_item);
				break;
			case 3222:
				holder.itemTwo.setImageResource(R.drawable.mikaels_crucible_item);
				break;
			case 3250:
				holder.itemTwo.setImageResource(R.drawable.berserkers_greaves_homeguard_item);
				break;
			case 3251:
				holder.itemTwo.setImageResource(R.drawable.berserkers_greaves_captain_item);
				break;
			case 3252:
				holder.itemTwo.setImageResource(R.drawable.berserkers_greaves_furor_item);
				break;
			case 3253:
				holder.itemTwo.setImageResource(R.drawable.berserkers_greaves_distortion_item);
				break;
			case 3254:
				holder.itemTwo.setImageResource(R.drawable.berserkers_greaves_alacrity_item);
				break;
			case 3255:
				holder.itemTwo.setImageResource(R.drawable.sorcerers_shoes_homeguard_item);
				break;
			case 3256:
				holder.itemTwo.setImageResource(R.drawable.sorcerers_shoes_captain_item);
				break;
			case 3257:
				holder.itemTwo.setImageResource(R.drawable.sorcerers_shoes_furor_item);
				break;
			case 3258:
				holder.itemTwo.setImageResource(R.drawable.sorcerers_shoes_distortion_item);
				break;
			case 3259:
				holder.itemTwo.setImageResource(R.drawable.sorcerers_shoes_alacrity_item);
				break;
			case 3260:
				holder.itemTwo.setImageResource(R.drawable.ninja_tabi_homeguard_item);
				break;
			case 3261:
				holder.itemTwo.setImageResource(R.drawable.ninja_tabi_captain_item);
				break;
			case 3262:
				holder.itemTwo.setImageResource(R.drawable.ninja_tabi_furor_item);
				break;
			case 3263:
				holder.itemTwo.setImageResource(R.drawable.ninja_tabi_distortion_item);
				break;
			case 3264:
				holder.itemTwo.setImageResource(R.drawable.ninja_tabi_alacrity_item);
				break;
			case 3265:
				holder.itemTwo.setImageResource(R.drawable.mercurys_treads_homeguard_item);
				break;
			case 3266:
				holder.itemTwo.setImageResource(R.drawable.mercurys_treads_captain_item);
				break;
			case 3267:
				holder.itemTwo.setImageResource(R.drawable.mercurys_treads_furor_item);
				break;
			case 3268:
				holder.itemTwo.setImageResource(R.drawable.mercurys_treads_distortion_item);
				break;
			case 3269:
				holder.itemTwo.setImageResource(R.drawable.mercurys_treads_alacrity_item);
				break;
			case 3270:
				holder.itemTwo.setImageResource(R.drawable.boots_of_mobility_homeguard_item);
				break;
			case 3271:
				holder.itemTwo.setImageResource(R.drawable.boots_of_mobility_captain_item);
				break;
			case 3272:
				holder.itemTwo.setImageResource(R.drawable.boots_of_mobility_furor_item);
				break;
			case 3273:
				holder.itemTwo.setImageResource(R.drawable.boots_of_mobility_distortion_item);
				break;
			case 3274:
				holder.itemTwo.setImageResource(R.drawable.boots_of_mobility_alacrity_item);
				break;
			case 3275:
				holder.itemTwo.setImageResource(R.drawable.ionian_boots_of_lucidity_homeguard_item);
				break;
			case 3276:
				holder.itemTwo.setImageResource(R.drawable.ionian_boots_of_lucidity_captain_item);
				break;
			case 3277:
				holder.itemTwo.setImageResource(R.drawable.ionian_boots_of_lucidity_furor_item);
				break;
			case 3278:
				holder.itemTwo.setImageResource(R.drawable.ionian_boots_of_lucidity_distortion_item);
				break;
			case 3279:
				holder.itemTwo.setImageResource(R.drawable.ionian_boots_of_lucidity_alacrity_item);
				break;
			case 3280:
				holder.itemTwo.setImageResource(R.drawable.boots_of_swiftness_homeguard_item);
				break;
			case 3281:
				holder.itemTwo.setImageResource(R.drawable.boots_of_swiftness_captain_item);
				break;
			case 3282:
				holder.itemTwo.setImageResource(R.drawable.boots_of_swiftness_furor_item);
				break;
			case 3283:
				holder.itemTwo.setImageResource(R.drawable.boots_of_swiftness_distortion_item);
				break;
			case 3284:
				holder.itemTwo.setImageResource(R.drawable.boots_of_swiftness_alacrity_item);
				break;
			default:
				holder.itemTwo.setImageResource(R.drawable.ability);
				holder.itemTwo.setVisibility(View.INVISIBLE);
				break;
			}
		} else {
			holder.itemTwo.setImageResource(R.drawable.ability);
			holder.itemTwo.setVisibility(View.INVISIBLE);
		}
		if (itemThreeId != null) {
			switch (itemThreeId.intValue()) {

			case 1001:
				holder.itemThree.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1004:
				holder.itemThree.setImageResource(R.drawable.faerie_charm_item);
				break;
			case 1006:
				holder.itemThree.setImageResource(R.drawable.rejuvenation_bead_item);
				break;
			case 1011:
				holder.itemThree.setImageResource(R.drawable.giants_belt_item);
				break;
			case 1018:
				holder.itemThree.setImageResource(R.drawable.cloak_of_agility_item);
				break;
			case 1026:
				holder.itemThree.setImageResource(R.drawable.blasting_wand_item);
				break;
			case 1027:
				holder.itemThree.setImageResource(R.drawable.sapphire_crystal_item);
				break;
			case 1028:
				holder.itemThree.setImageResource(R.drawable.ruby_crystal_item);
				break;
			case 1029:
				holder.itemThree.setImageResource(R.drawable.cloth_armor_item);
				break;
			case 1031:
				holder.itemThree.setImageResource(R.drawable.chain_vest_item);
				break;
			case 1033:
				holder.itemThree.setImageResource(R.drawable.nullmagic_mantle_item);
				break;
			case 1036:
				holder.itemThree.setImageResource(R.drawable.long_sword_item);
				break;
			case 1037:
				holder.itemThree.setImageResource(R.drawable.pickaxe_item);
				break;
			case 1038:
				holder.itemThree.setImageResource(R.drawable.b_f_sword_item);
				break;
			case 1039:
				holder.itemThree.setImageResource(R.drawable.hunters_machete_item);
				break;
			case 1042:
				holder.itemThree.setImageResource(R.drawable.dagger_item);
				break;
			case 1043:
				holder.itemThree.setImageResource(R.drawable.recurve_bow_item);
				break;
			case 1051:
				holder.itemThree.setImageResource(R.drawable.brawlers_gloves_item);
				break;
			case 1052:
				holder.itemThree.setImageResource(R.drawable.amplifying_tome_item);
				break;
			case 1053:
				holder.itemThree.setImageResource(R.drawable.vampiric_scepter_item);
				break;
			case 1054:
				holder.itemThree.setImageResource(R.drawable.dorans_shield_item);
				break;
			case 1055:
				holder.itemThree.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 1056:
				holder.itemThree.setImageResource(R.drawable.dorans_ring_item);
				break;
			case 1057:
				holder.itemThree.setImageResource(R.drawable.negatron_cloak_item);
				break;
			case 1058:
				holder.itemThree.setImageResource(R.drawable.needlessly_large_rod_item);
				break;
			case 1062:
				holder.itemThree.setImageResource(R.drawable.prospectors_blade_item);
				break;
			case 1063:
				holder.itemThree.setImageResource(R.drawable.prospectors_ring_item);
				break;
			case 1080:
				holder.itemThree.setImageResource(R.drawable.spirit_stone_item);
				break;
			case 2003:
				holder.itemThree.setImageResource(R.drawable.health_potion_item);
				break;
			case 2004:
				holder.itemThree.setImageResource(R.drawable.mana_potion_item);
				break;
			case 2009:
				holder.itemThree.setImageResource(R.drawable.total_biscuit_of_rejuvenation_item);
				break;
			case 2037:
				holder.itemThree.setImageResource(R.drawable.elixir_of_fortitude_item);
				break;
			case 2039:
				holder.itemThree.setImageResource(R.drawable.elixir_of_brilliance_item);
				break;
			case 2040:
				holder.itemThree.setImageResource(R.drawable.ichor_of_rage_item);
				break;
			case 2041:
				holder.itemThree.setImageResource(R.drawable.crystalline_flask_item);
				break;
			case 2042:
				holder.itemThree.setImageResource(R.drawable.oracles_elixir_item);
				break;
			case 2043:
				holder.itemThree.setImageResource(R.drawable.vision_ward_item);
				break;
			case 2044:
				holder.itemThree.setImageResource(R.drawable.sight_ward_item);
				break;
			case 2045:
				holder.itemThree.setImageResource(R.drawable.ruby_sightstone_item);
				break;
			case 2047:
				holder.itemThree.setImageResource(R.drawable.oracles_extract_item);
				break;
			case 2048:
				holder.itemThree.setImageResource(R.drawable.ichor_of_illumination_item);
				break;
			case 2049:
				holder.itemThree.setImageResource(R.drawable.sightstone_item);
				break;
			case 3001:
				holder.itemThree.setImageResource(R.drawable.abyssal_scepter_item);
				break;
			case 3003:
				holder.itemThree.setImageResource(R.drawable.archangels_staff_item);
				break;
			case 3004:
				holder.itemThree.setImageResource(R.drawable.manamune_item);
				break;
			case 3005:
				holder.itemThree.setImageResource(R.drawable.atmas_impaler_item);
				break;
			case 3006:
				holder.itemThree.setImageResource(R.drawable.berserkers_greaves_item);
				break;
			case 3009:
				holder.itemThree.setImageResource(R.drawable.boots_of_swiftness_item);
				break;
			case 3010:
				holder.itemThree.setImageResource(R.drawable.catalyst_the_protector_item);
				break;
			case 3020:
				holder.itemThree.setImageResource(R.drawable.sorcerers_shoes_item);
				break;
			case 3022:
				holder.itemThree.setImageResource(R.drawable.frozen_mallet_item);
				break;
			case 3023:
				holder.itemThree.setImageResource(R.drawable.twin_shadows_item);
				break;
			case 3024:
				holder.itemThree.setImageResource(R.drawable.glacial_shroud_item);
				break;
			case 3025:
				holder.itemThree.setImageResource(R.drawable.iceborn_gauntlet_item);
				break;
			case 3026:
				holder.itemThree.setImageResource(R.drawable.guardian_angel_item);
				break;
			case 3027:
				holder.itemThree.setImageResource(R.drawable.rod_of_ages_item);
				break;
			case 3028:
				holder.itemThree.setImageResource(R.drawable.chalice_of_harmony_item);
				break;
			case 3031:
				holder.itemThree.setImageResource(R.drawable.infinity_edge_item);
				break;
			case 3035:
				holder.itemThree.setImageResource(R.drawable.last_whisper_item);
				break;
			case 3037:
				holder.itemThree.setImageResource(R.drawable.mana_manipulator_item);
				break;
			case 3041:
				holder.itemThree.setImageResource(R.drawable.mejais_soulstealer_item);
				break;
			case 3044:
				holder.itemThree.setImageResource(R.drawable.phage_item);
				break;
			case 3046:
				holder.itemThree.setImageResource(R.drawable.phantom_dancer_item);
				break;
			case 3047:
				holder.itemThree.setImageResource(R.drawable.ninja_tabi_item);
				break;
			case 3050:
				holder.itemThree.setImageResource(R.drawable.zekes_herald_item);
				break;
			case 3056:
				holder.itemThree.setImageResource(R.drawable.ohmwrecker_item);
				break;
			case 3057:
				holder.itemThree.setImageResource(R.drawable.sheen_item);
				break;
			case 3060:
				holder.itemThree.setImageResource(R.drawable.banner_of_command_item);
				break;
			case 3065:
				holder.itemThree.setImageResource(R.drawable.spirit_visage_item);
				break;
			case 3067:
				holder.itemThree.setImageResource(R.drawable.kindlegem_item);
				break;
			case 3068:
				holder.itemThree.setImageResource(R.drawable.sunfire_cape_item);
				break;
			case 3069:
				holder.itemThree.setImageResource(R.drawable.shurelyas_reverie_item);
				break;
			case 3070:
				holder.itemThree
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3071:
				holder.itemThree.setImageResource(R.drawable.the_black_cleaver_item);
				break;
			case 3072:
				holder.itemThree
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			case 3074:
				holder.itemThree.setImageResource(R.drawable.ravenous_hydra_item);
				break;
			case 3075:
				holder.itemThree.setImageResource(R.drawable.thornmail_item);
				break;
			case 3077:
				holder.itemThree.setImageResource(R.drawable.tiamat_item);
				break;
			case 3078:
				holder.itemThree.setImageResource(R.drawable.trinity_force_item);
				break;
			case 3082:
				holder.itemThree.setImageResource(R.drawable.wardens_mail_item);
				break;
			case 3083:
				holder.itemThree.setImageResource(R.drawable.warmogs_armor_item);
				break;
			case 3084:
				holder.itemThree.setImageResource(R.drawable.overlords_bloodmail_item);
				break;
			case 3085:
				holder.itemThree.setImageResource(R.drawable.runaans_hurricane_item);
				break;
			case 3086:
				holder.itemThree.setImageResource(R.drawable.zeal_item);
				break;
			case 3087:
				holder.itemThree.setImageResource(R.drawable.statikk_shiv_item);
				break;
			case 3089:
				holder.itemThree.setImageResource(R.drawable.rabadons_deathcap_item);
				break;
			case 3090:
				holder.itemThree.setImageResource(R.drawable.wooglets_witchcap_item);
				break;
			case 3091:
				holder.itemThree.setImageResource(R.drawable.wits_end_item);
				break;
			case 3092:
				holder.itemThree.setImageResource(R.drawable.shard_of_true_ice_item);
				break;
			case 3093:
				holder.itemThree.setImageResource(R.drawable.avarice_blade_item);
				break;
			case 3096:
				holder.itemThree.setImageResource(R.drawable.philosophers_stone_item);
				break;
			case 3097:
				holder.itemThree.setImageResource(R.drawable.emblem_of_valor_item);
				break;
			case 3098:
				holder.itemThree.setImageResource(R.drawable.kages_lucky_pick_item);
				break;
			case 3100:
				holder.itemThree.setImageResource(R.drawable.lich_bane_item);
				break;
			case 3101:
				holder.itemThree.setImageResource(R.drawable.stinger_item);
				break;
			case 3102:
				holder.itemThree.setImageResource(R.drawable.banshees_veil_item);
				break;
			case 3104:
				holder.itemThree.setImageResource(R.drawable.lord_van_damms_pillager_item);
				break;
			case 3105:
				holder.itemThree.setImageResource(R.drawable.aegis_of_the_legion_item);
				break;
			case 3106:
				holder.itemThree.setImageResource(R.drawable.madreds_razors_item);
				break;
			case 3107:
				holder.itemThree.setImageResource(R.drawable.runic_bulwark_item);
				break;
			case 3108:
				holder.itemThree.setImageResource(R.drawable.fiendish_codex_item);
				break;
			case 3110:
				holder.itemThree.setImageResource(R.drawable.frozen_heart_item);
				break;
			case 3111:
				holder.itemThree.setImageResource(R.drawable.mercurys_treads_item);
				break;
			case 3114:
				holder.itemThree.setImageResource(R.drawable.malady_item);
				break;
			case 3115:
				holder.itemThree.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3116:
				holder.itemThree.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3117:
				holder.itemThree.setImageResource(R.drawable.boots_of_mobility_item);
				break;
			case 3122:
				holder.itemThree.setImageResource(R.drawable.wicked_hatchet_item);
				break;
			case 3123:
				holder.itemThree.setImageResource(R.drawable.executioners_calling_item);
				break;
			case 3124:
				holder.itemThree.setImageResource(R.drawable.guinsoos_rageblade_item);
				break;
			case 3128:
				holder.itemThree.setImageResource(R.drawable.deathfire_grasp_item);
				break;
			case 3131:
				holder.itemThree.setImageResource(R.drawable.sword_of_the_divine_item);
				break;
			case 3134:
				holder.itemThree.setImageResource(R.drawable.the_brutalizer_item);
				break;
			case 3135:
				holder.itemThree.setImageResource(R.drawable.void_staff_item);
				break;
			case 3136:
				holder.itemThree.setImageResource(R.drawable.haunting_guise_item);
				break;
			case 3139:
				holder.itemThree.setImageResource(R.drawable.mercurial_scimitar_item);
				break;
			case 3140:
				holder.itemThree.setImageResource(R.drawable.quicksilver_sash_item);
				break;
			case 3141:
				holder.itemThree.setImageResource(R.drawable.sword_of_the_occult_item);
				break;
			case 3142:
				holder.itemThree.setImageResource(R.drawable.youmuus_ghostblade_item);
				break;
			case 3143:
				holder.itemThree.setImageResource(R.drawable.randuins_omen_item);
				break;
			case 3144:
				holder.itemThree.setImageResource(R.drawable.bilgewater_cutlass_item);
				break;
			case 3145:
				holder.itemThree.setImageResource(R.drawable.hextech_revolver_item);
				break;
			case 3146:
				holder.itemThree.setImageResource(R.drawable.hextech_gunblade_item);
				break;
			case 3151:
				holder.itemThree.setImageResource(R.drawable.liandrys_torment_item);
				break;
			case 3152:
				holder.itemThree.setImageResource(R.drawable.will_of_the_ancients_item);
				break;
			case 3153:
				holder.itemThree.setImageResource(R.drawable.blade_of_the_ruined_king_item);
				break;
			case 3154:
				holder.itemThree.setImageResource(R.drawable.wriggles_lantern_item);
				break;
			case 3155:
				holder.itemThree.setImageResource(R.drawable.hexdrinker_item);
				break;
			case 3156:
				holder.itemThree.setImageResource(R.drawable.maw_of_malmortius_item);
				break;
			case 3157:
				holder.itemThree.setImageResource(R.drawable.zhonyas_hourglass_item);
				break;
			case 3158:
				holder.itemThree.setImageResource(R.drawable.ionian_boots_of_lucidity_item);
				break;
			case 3159:
				holder.itemThree.setImageResource(R.drawable.grezs_spectral_lantern_item);
				break;
			case 3165:
				holder.itemThree.setImageResource(R.drawable.morellonomicon_item);
				break;
			case 3166:
				holder.itemThree.setImageResource(R.drawable.bonetooth_necklace_item);
				break;
			case 3172:
				holder.itemThree.setImageResource(R.drawable.zephyr_item);
				break;
			case 3173:
				holder.itemThree.setImageResource(R.drawable.eleisas_miracle_item);
				break;
			case 3174:
				holder.itemThree.setImageResource(R.drawable.athenes_unholy_grail_item);
				break;
			case 3180:
				holder.itemThree.setImageResource(R.drawable.odyns_veil_item);
				break;
			case 3181:
				holder.itemThree.setImageResource(R.drawable.sanguine_blade_item);
				break;
			case 3184:
				holder.itemThree.setImageResource(R.drawable.entropy_item);
				break;
			case 3185:
				holder.itemThree.setImageResource(R.drawable.the_lightbringer_item);
				break;
			case 3186:
				holder.itemThree.setImageResource(R.drawable.kitaes_bloodrazor_item);
				break;
			case 3187:
				holder.itemThree.setImageResource(R.drawable.hextech_sweeper_item);
				break;
			case 3188:
				holder.itemThree.setImageResource(R.drawable.blackfire_torch_item);
				break;
			case 3190:
				holder.itemThree.setImageResource(R.drawable.locket_of_the_iron_solari_item);
				break;
			case 3196:
				holder.itemThree.setImageResource(R.drawable.augment_power_item);
				break;
			case 3197:
				holder.itemThree.setImageResource(R.drawable.augment_gravity_item);
				break;
			case 3198:
				holder.itemThree.setImageResource(R.drawable.augment_death_item);
				break;
			case 3206:
				holder.itemThree.setImageResource(R.drawable.spirit_of_the_spectral_wraith_item);
				break;
			case 3207:
				holder.itemThree.setImageResource(R.drawable.spirit_of_the_ancient_golem_item);
				break;
			case 3209:
				holder.itemThree.setImageResource(R.drawable.spirit_of_the_elder_lizard_item);
				break;
			case 3222:
				holder.itemThree.setImageResource(R.drawable.mikaels_crucible_item);
				break;
			case 3250:
				holder.itemThree.setImageResource(R.drawable.berserkers_greaves_homeguard_item);
				break;
			case 3251:
				holder.itemThree.setImageResource(R.drawable.berserkers_greaves_captain_item);
				break;
			case 3252:
				holder.itemThree.setImageResource(R.drawable.berserkers_greaves_furor_item);
				break;
			case 3253:
				holder.itemThree.setImageResource(R.drawable.berserkers_greaves_distortion_item);
				break;
			case 3254:
				holder.itemThree.setImageResource(R.drawable.berserkers_greaves_alacrity_item);
				break;
			case 3255:
				holder.itemThree.setImageResource(R.drawable.sorcerers_shoes_homeguard_item);
				break;
			case 3256:
				holder.itemThree.setImageResource(R.drawable.sorcerers_shoes_captain_item);
				break;
			case 3257:
				holder.itemThree.setImageResource(R.drawable.sorcerers_shoes_furor_item);
				break;
			case 3258:
				holder.itemThree.setImageResource(R.drawable.sorcerers_shoes_distortion_item);
				break;
			case 3259:
				holder.itemThree.setImageResource(R.drawable.sorcerers_shoes_alacrity_item);
				break;
			case 3260:
				holder.itemThree.setImageResource(R.drawable.ninja_tabi_homeguard_item);
				break;
			case 3261:
				holder.itemThree.setImageResource(R.drawable.ninja_tabi_captain_item);
				break;
			case 3262:
				holder.itemThree.setImageResource(R.drawable.ninja_tabi_furor_item);
				break;
			case 3263:
				holder.itemThree.setImageResource(R.drawable.ninja_tabi_distortion_item);
				break;
			case 3264:
				holder.itemThree.setImageResource(R.drawable.ninja_tabi_alacrity_item);
				break;
			case 3265:
				holder.itemThree.setImageResource(R.drawable.mercurys_treads_homeguard_item);
				break;
			case 3266:
				holder.itemThree.setImageResource(R.drawable.mercurys_treads_captain_item);
				break;
			case 3267:
				holder.itemThree.setImageResource(R.drawable.mercurys_treads_furor_item);
				break;
			case 3268:
				holder.itemThree.setImageResource(R.drawable.mercurys_treads_distortion_item);
				break;
			case 3269:
				holder.itemThree.setImageResource(R.drawable.mercurys_treads_alacrity_item);
				break;
			case 3270:
				holder.itemThree.setImageResource(R.drawable.boots_of_mobility_homeguard_item);
				break;
			case 3271:
				holder.itemThree.setImageResource(R.drawable.boots_of_mobility_captain_item);
				break;
			case 3272:
				holder.itemThree.setImageResource(R.drawable.boots_of_mobility_furor_item);
				break;
			case 3273:
				holder.itemThree.setImageResource(R.drawable.boots_of_mobility_distortion_item);
				break;
			case 3274:
				holder.itemThree.setImageResource(R.drawable.boots_of_mobility_alacrity_item);
				break;
			case 3275:
				holder.itemThree.setImageResource(R.drawable.ionian_boots_of_lucidity_homeguard_item);
				break;
			case 3276:
				holder.itemThree.setImageResource(R.drawable.ionian_boots_of_lucidity_captain_item);
				break;
			case 3277:
				holder.itemThree.setImageResource(R.drawable.ionian_boots_of_lucidity_furor_item);
				break;
			case 3278:
				holder.itemThree.setImageResource(R.drawable.ionian_boots_of_lucidity_distortion_item);
				break;
			case 3279:
				holder.itemThree.setImageResource(R.drawable.ionian_boots_of_lucidity_alacrity_item);
				break;
			case 3280:
				holder.itemThree.setImageResource(R.drawable.boots_of_swiftness_homeguard_item);
				break;
			case 3281:
				holder.itemThree.setImageResource(R.drawable.boots_of_swiftness_captain_item);
				break;
			case 3282:
				holder.itemThree.setImageResource(R.drawable.boots_of_swiftness_furor_item);
				break;
			case 3283:
				holder.itemThree.setImageResource(R.drawable.boots_of_swiftness_distortion_item);
				break;
			case 3284:
				holder.itemThree.setImageResource(R.drawable.boots_of_swiftness_alacrity_item);
				break;
			default:
				holder.itemThree.setImageResource(R.drawable.ability);
				holder.itemThree.setVisibility(View.INVISIBLE);
				break;
			}
		} else {
			holder.itemThree.setImageResource(R.drawable.ability);
			holder.itemThree.setVisibility(View.INVISIBLE);
		}
		
		if (itemFourId != null) {
			switch (itemFourId.intValue()) {

			case 1001:
				holder.itemFour.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1004:
				holder.itemFour.setImageResource(R.drawable.faerie_charm_item);
				break;
			case 1006:
				holder.itemFour.setImageResource(R.drawable.rejuvenation_bead_item);
				break;
			case 1011:
				holder.itemFour.setImageResource(R.drawable.giants_belt_item);
				break;
			case 1018:
				holder.itemFour.setImageResource(R.drawable.cloak_of_agility_item);
				break;
			case 1026:
				holder.itemFour.setImageResource(R.drawable.blasting_wand_item);
				break;
			case 1027:
				holder.itemFour.setImageResource(R.drawable.sapphire_crystal_item);
				break;
			case 1028:
				holder.itemFour.setImageResource(R.drawable.ruby_crystal_item);
				break;
			case 1029:
				holder.itemFour.setImageResource(R.drawable.cloth_armor_item);
				break;
			case 1031:
				holder.itemFour.setImageResource(R.drawable.chain_vest_item);
				break;
			case 1033:
				holder.itemFour.setImageResource(R.drawable.nullmagic_mantle_item);
				break;
			case 1036:
				holder.itemFour.setImageResource(R.drawable.long_sword_item);
				break;
			case 1037:
				holder.itemFour.setImageResource(R.drawable.pickaxe_item);
				break;
			case 1038:
				holder.itemFour.setImageResource(R.drawable.b_f_sword_item);
				break;
			case 1039:
				holder.itemFour.setImageResource(R.drawable.hunters_machete_item);
				break;
			case 1042:
				holder.itemFour.setImageResource(R.drawable.dagger_item);
				break;
			case 1043:
				holder.itemFour.setImageResource(R.drawable.recurve_bow_item);
				break;
			case 1051:
				holder.itemFour.setImageResource(R.drawable.brawlers_gloves_item);
				break;
			case 1052:
				holder.itemFour.setImageResource(R.drawable.amplifying_tome_item);
				break;
			case 1053:
				holder.itemFour.setImageResource(R.drawable.vampiric_scepter_item);
				break;
			case 1054:
				holder.itemFour.setImageResource(R.drawable.dorans_shield_item);
				break;
			case 1055:
				holder.itemFour.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 1056:
				holder.itemFour.setImageResource(R.drawable.dorans_ring_item);
				break;
			case 1057:
				holder.itemFour.setImageResource(R.drawable.negatron_cloak_item);
				break;
			case 1058:
				holder.itemFour.setImageResource(R.drawable.needlessly_large_rod_item);
				break;
			case 1062:
				holder.itemFour.setImageResource(R.drawable.prospectors_blade_item);
				break;
			case 1063:
				holder.itemFour.setImageResource(R.drawable.prospectors_ring_item);
				break;
			case 1080:
				holder.itemFour.setImageResource(R.drawable.spirit_stone_item);
				break;
			case 2003:
				holder.itemFour.setImageResource(R.drawable.health_potion_item);
				break;
			case 2004:
				holder.itemFour.setImageResource(R.drawable.mana_potion_item);
				break;
			case 2009:
				holder.itemFour.setImageResource(R.drawable.total_biscuit_of_rejuvenation_item);
				break;
			case 2037:
				holder.itemFour.setImageResource(R.drawable.elixir_of_fortitude_item);
				break;
			case 2039:
				holder.itemFour.setImageResource(R.drawable.elixir_of_brilliance_item);
				break;
			case 2040:
				holder.itemFour.setImageResource(R.drawable.ichor_of_rage_item);
				break;
			case 2041:
				holder.itemFour.setImageResource(R.drawable.crystalline_flask_item);
				break;
			case 2042:
				holder.itemFour.setImageResource(R.drawable.oracles_elixir_item);
				break;
			case 2043:
				holder.itemFour.setImageResource(R.drawable.vision_ward_item);
				break;
			case 2044:
				holder.itemFour.setImageResource(R.drawable.sight_ward_item);
				break;
			case 2045:
				holder.itemFour.setImageResource(R.drawable.ruby_sightstone_item);
				break;
			case 2047:
				holder.itemFour.setImageResource(R.drawable.oracles_extract_item);
				break;
			case 2048:
				holder.itemFour.setImageResource(R.drawable.ichor_of_illumination_item);
				break;
			case 2049:
				holder.itemFour.setImageResource(R.drawable.sightstone_item);
				break;
			case 3001:
				holder.itemFour.setImageResource(R.drawable.abyssal_scepter_item);
				break;
			case 3003:
				holder.itemFour.setImageResource(R.drawable.archangels_staff_item);
				break;
			case 3004:
				holder.itemFour.setImageResource(R.drawable.manamune_item);
				break;
			case 3005:
				holder.itemFour.setImageResource(R.drawable.atmas_impaler_item);
				break;
			case 3006:
				holder.itemFour.setImageResource(R.drawable.berserkers_greaves_item);
				break;
			case 3009:
				holder.itemFour.setImageResource(R.drawable.boots_of_swiftness_item);
				break;
			case 3010:
				holder.itemFour.setImageResource(R.drawable.catalyst_the_protector_item);
				break;
			case 3020:
				holder.itemFour.setImageResource(R.drawable.sorcerers_shoes_item);
				break;
			case 3022:
				holder.itemFour.setImageResource(R.drawable.frozen_mallet_item);
				break;
			case 3023:
				holder.itemFour.setImageResource(R.drawable.twin_shadows_item);
				break;
			case 3024:
				holder.itemFour.setImageResource(R.drawable.glacial_shroud_item);
				break;
			case 3025:
				holder.itemFour.setImageResource(R.drawable.iceborn_gauntlet_item);
				break;
			case 3026:
				holder.itemFour.setImageResource(R.drawable.guardian_angel_item);
				break;
			case 3027:
				holder.itemFour.setImageResource(R.drawable.rod_of_ages_item);
				break;
			case 3028:
				holder.itemFour.setImageResource(R.drawable.chalice_of_harmony_item);
				break;
			case 3031:
				holder.itemFour.setImageResource(R.drawable.infinity_edge_item);
				break;
			case 3035:
				holder.itemFour.setImageResource(R.drawable.last_whisper_item);
				break;
			case 3037:
				holder.itemFour.setImageResource(R.drawable.mana_manipulator_item);
				break;
			case 3041:
				holder.itemFour.setImageResource(R.drawable.mejais_soulstealer_item);
				break;
			case 3044:
				holder.itemFour.setImageResource(R.drawable.phage_item);
				break;
			case 3046:
				holder.itemFour.setImageResource(R.drawable.phantom_dancer_item);
				break;
			case 3047:
				holder.itemFour.setImageResource(R.drawable.ninja_tabi_item);
				break;
			case 3050:
				holder.itemFour.setImageResource(R.drawable.zekes_herald_item);
				break;
			case 3056:
				holder.itemFour.setImageResource(R.drawable.ohmwrecker_item);
				break;
			case 3057:
				holder.itemFour.setImageResource(R.drawable.sheen_item);
				break;
			case 3060:
				holder.itemFour.setImageResource(R.drawable.banner_of_command_item);
				break;
			case 3065:
				holder.itemFour.setImageResource(R.drawable.spirit_visage_item);
				break;
			case 3067:
				holder.itemFour.setImageResource(R.drawable.kindlegem_item);
				break;
			case 3068:
				holder.itemFour.setImageResource(R.drawable.sunfire_cape_item);
				break;
			case 3069:
				holder.itemFour.setImageResource(R.drawable.shurelyas_reverie_item);
				break;
			case 3070:
				holder.itemFour
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3071:
				holder.itemFour.setImageResource(R.drawable.the_black_cleaver_item);
				break;
			case 3072:
				holder.itemFour
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			case 3074:
				holder.itemFour.setImageResource(R.drawable.ravenous_hydra_item);
				break;
			case 3075:
				holder.itemFour.setImageResource(R.drawable.thornmail_item);
				break;
			case 3077:
				holder.itemFour.setImageResource(R.drawable.tiamat_item);
				break;
			case 3078:
				holder.itemFour.setImageResource(R.drawable.trinity_force_item);
				break;
			case 3082:
				holder.itemFour.setImageResource(R.drawable.wardens_mail_item);
				break;
			case 3083:
				holder.itemFour.setImageResource(R.drawable.warmogs_armor_item);
				break;
			case 3084:
				holder.itemFour.setImageResource(R.drawable.overlords_bloodmail_item);
				break;
			case 3085:
				holder.itemFour.setImageResource(R.drawable.runaans_hurricane_item);
				break;
			case 3086:
				holder.itemFour.setImageResource(R.drawable.zeal_item);
				break;
			case 3087:
				holder.itemFour.setImageResource(R.drawable.statikk_shiv_item);
				break;
			case 3089:
				holder.itemFour.setImageResource(R.drawable.rabadons_deathcap_item);
				break;
			case 3090:
				holder.itemFour.setImageResource(R.drawable.wooglets_witchcap_item);
				break;
			case 3091:
				holder.itemFour.setImageResource(R.drawable.wits_end_item);
				break;
			case 3092:
				holder.itemFour.setImageResource(R.drawable.shard_of_true_ice_item);
				break;
			case 3093:
				holder.itemFour.setImageResource(R.drawable.avarice_blade_item);
				break;
			case 3096:
				holder.itemFour.setImageResource(R.drawable.philosophers_stone_item);
				break;
			case 3097:
				holder.itemFour.setImageResource(R.drawable.emblem_of_valor_item);
				break;
			case 3098:
				holder.itemFour.setImageResource(R.drawable.kages_lucky_pick_item);
				break;
			case 3100:
				holder.itemFour.setImageResource(R.drawable.lich_bane_item);
				break;
			case 3101:
				holder.itemFour.setImageResource(R.drawable.stinger_item);
				break;
			case 3102:
				holder.itemFour.setImageResource(R.drawable.banshees_veil_item);
				break;
			case 3104:
				holder.itemFour.setImageResource(R.drawable.lord_van_damms_pillager_item);
				break;
			case 3105:
				holder.itemFour.setImageResource(R.drawable.aegis_of_the_legion_item);
				break;
			case 3106:
				holder.itemFour.setImageResource(R.drawable.madreds_razors_item);
				break;
			case 3107:
				holder.itemFour.setImageResource(R.drawable.runic_bulwark_item);
				break;
			case 3108:
				holder.itemFour.setImageResource(R.drawable.fiendish_codex_item);
				break;
			case 3110:
				holder.itemFour.setImageResource(R.drawable.frozen_heart_item);
				break;
			case 3111:
				holder.itemFour.setImageResource(R.drawable.mercurys_treads_item);
				break;
			case 3114:
				holder.itemFour.setImageResource(R.drawable.malady_item);
				break;
			case 3115:
				holder.itemFour.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3116:
				holder.itemFour.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3117:
				holder.itemFour.setImageResource(R.drawable.boots_of_mobility_item);
				break;
			case 3122:
				holder.itemFour.setImageResource(R.drawable.wicked_hatchet_item);
				break;
			case 3123:
				holder.itemFour.setImageResource(R.drawable.executioners_calling_item);
				break;
			case 3124:
				holder.itemFour.setImageResource(R.drawable.guinsoos_rageblade_item);
				break;
			case 3128:
				holder.itemFour.setImageResource(R.drawable.deathfire_grasp_item);
				break;
			case 3131:
				holder.itemFour.setImageResource(R.drawable.sword_of_the_divine_item);
				break;
			case 3134:
				holder.itemFour.setImageResource(R.drawable.the_brutalizer_item);
				break;
			case 3135:
				holder.itemFour.setImageResource(R.drawable.void_staff_item);
				break;
			case 3136:
				holder.itemFour.setImageResource(R.drawable.haunting_guise_item);
				break;
			case 3139:
				holder.itemFour.setImageResource(R.drawable.mercurial_scimitar_item);
				break;
			case 3140:
				holder.itemFour.setImageResource(R.drawable.quicksilver_sash_item);
				break;
			case 3141:
				holder.itemFour.setImageResource(R.drawable.sword_of_the_occult_item);
				break;
			case 3142:
				holder.itemFour.setImageResource(R.drawable.youmuus_ghostblade_item);
				break;
			case 3143:
				holder.itemFour.setImageResource(R.drawable.randuins_omen_item);
				break;
			case 3144:
				holder.itemFour.setImageResource(R.drawable.bilgewater_cutlass_item);
				break;
			case 3145:
				holder.itemFour.setImageResource(R.drawable.hextech_revolver_item);
				break;
			case 3146:
				holder.itemFour.setImageResource(R.drawable.hextech_gunblade_item);
				break;
			case 3151:
				holder.itemFour.setImageResource(R.drawable.liandrys_torment_item);
				break;
			case 3152:
				holder.itemFour.setImageResource(R.drawable.will_of_the_ancients_item);
				break;
			case 3153:
				holder.itemFour.setImageResource(R.drawable.blade_of_the_ruined_king_item);
				break;
			case 3154:
				holder.itemFour.setImageResource(R.drawable.wriggles_lantern_item);
				break;
			case 3155:
				holder.itemFour.setImageResource(R.drawable.hexdrinker_item);
				break;
			case 3156:
				holder.itemFour.setImageResource(R.drawable.maw_of_malmortius_item);
				break;
			case 3157:
				holder.itemFour.setImageResource(R.drawable.zhonyas_hourglass_item);
				break;
			case 3158:
				holder.itemFour.setImageResource(R.drawable.ionian_boots_of_lucidity_item);
				break;
			case 3159:
				holder.itemFour.setImageResource(R.drawable.grezs_spectral_lantern_item);
				break;
			case 3165:
				holder.itemFour.setImageResource(R.drawable.morellonomicon_item);
				break;
			case 3166:
				holder.itemFour.setImageResource(R.drawable.bonetooth_necklace_item);
				break;
			case 3172:
				holder.itemFour.setImageResource(R.drawable.zephyr_item);
				break;
			case 3173:
				holder.itemFour.setImageResource(R.drawable.eleisas_miracle_item);
				break;
			case 3174:
				holder.itemFour.setImageResource(R.drawable.athenes_unholy_grail_item);
				break;
			case 3180:
				holder.itemFour.setImageResource(R.drawable.odyns_veil_item);
				break;
			case 3181:
				holder.itemFour.setImageResource(R.drawable.sanguine_blade_item);
				break;
			case 3184:
				holder.itemFour.setImageResource(R.drawable.entropy_item);
				break;
			case 3185:
				holder.itemFour.setImageResource(R.drawable.the_lightbringer_item);
				break;
			case 3186:
				holder.itemFour.setImageResource(R.drawable.kitaes_bloodrazor_item);
				break;
			case 3187:
				holder.itemFour.setImageResource(R.drawable.hextech_sweeper_item);
				break;
			case 3188:
				holder.itemFour.setImageResource(R.drawable.blackfire_torch_item);
				break;
			case 3190:
				holder.itemFour.setImageResource(R.drawable.locket_of_the_iron_solari_item);
				break;
			case 3196:
				holder.itemFour.setImageResource(R.drawable.augment_power_item);
				break;
			case 3197:
				holder.itemFour.setImageResource(R.drawable.augment_gravity_item);
				break;
			case 3198:
				holder.itemFour.setImageResource(R.drawable.augment_death_item);
				break;
			case 3206:
				holder.itemFour.setImageResource(R.drawable.spirit_of_the_spectral_wraith_item);
				break;
			case 3207:
				holder.itemFour.setImageResource(R.drawable.spirit_of_the_ancient_golem_item);
				break;
			case 3209:
				holder.itemFour.setImageResource(R.drawable.spirit_of_the_elder_lizard_item);
				break;
			case 3222:
				holder.itemFour.setImageResource(R.drawable.mikaels_crucible_item);
				break;
			case 3250:
				holder.itemFour.setImageResource(R.drawable.berserkers_greaves_homeguard_item);
				break;
			case 3251:
				holder.itemFour.setImageResource(R.drawable.berserkers_greaves_captain_item);
				break;
			case 3252:
				holder.itemFour.setImageResource(R.drawable.berserkers_greaves_furor_item);
				break;
			case 3253:
				holder.itemFour.setImageResource(R.drawable.berserkers_greaves_distortion_item);
				break;
			case 3254:
				holder.itemFour.setImageResource(R.drawable.berserkers_greaves_alacrity_item);
				break;
			case 3255:
				holder.itemFour.setImageResource(R.drawable.sorcerers_shoes_homeguard_item);
				break;
			case 3256:
				holder.itemFour.setImageResource(R.drawable.sorcerers_shoes_captain_item);
				break;
			case 3257:
				holder.itemFour.setImageResource(R.drawable.sorcerers_shoes_furor_item);
				break;
			case 3258:
				holder.itemFour.setImageResource(R.drawable.sorcerers_shoes_distortion_item);
				break;
			case 3259:
				holder.itemFour.setImageResource(R.drawable.sorcerers_shoes_alacrity_item);
				break;
			case 3260:
				holder.itemFour.setImageResource(R.drawable.ninja_tabi_homeguard_item);
				break;
			case 3261:
				holder.itemFour.setImageResource(R.drawable.ninja_tabi_captain_item);
				break;
			case 3262:
				holder.itemFour.setImageResource(R.drawable.ninja_tabi_furor_item);
				break;
			case 3263:
				holder.itemFour.setImageResource(R.drawable.ninja_tabi_distortion_item);
				break;
			case 3264:
				holder.itemFour.setImageResource(R.drawable.ninja_tabi_alacrity_item);
				break;
			case 3265:
				holder.itemFour.setImageResource(R.drawable.mercurys_treads_homeguard_item);
				break;
			case 3266:
				holder.itemFour.setImageResource(R.drawable.mercurys_treads_captain_item);
				break;
			case 3267:
				holder.itemFour.setImageResource(R.drawable.mercurys_treads_furor_item);
				break;
			case 3268:
				holder.itemFour.setImageResource(R.drawable.mercurys_treads_distortion_item);
				break;
			case 3269:
				holder.itemFour.setImageResource(R.drawable.mercurys_treads_alacrity_item);
				break;
			case 3270:
				holder.itemFour.setImageResource(R.drawable.boots_of_mobility_homeguard_item);
				break;
			case 3271:
				holder.itemFour.setImageResource(R.drawable.boots_of_mobility_captain_item);
				break;
			case 3272:
				holder.itemFour.setImageResource(R.drawable.boots_of_mobility_furor_item);
				break;
			case 3273:
				holder.itemFour.setImageResource(R.drawable.boots_of_mobility_distortion_item);
				break;
			case 3274:
				holder.itemFour.setImageResource(R.drawable.boots_of_mobility_alacrity_item);
				break;
			case 3275:
				holder.itemFour.setImageResource(R.drawable.ionian_boots_of_lucidity_homeguard_item);
				break;
			case 3276:
				holder.itemFour.setImageResource(R.drawable.ionian_boots_of_lucidity_captain_item);
				break;
			case 3277:
				holder.itemFour.setImageResource(R.drawable.ionian_boots_of_lucidity_furor_item);
				break;
			case 3278:
				holder.itemFour.setImageResource(R.drawable.ionian_boots_of_lucidity_distortion_item);
				break;
			case 3279:
				holder.itemFour.setImageResource(R.drawable.ionian_boots_of_lucidity_alacrity_item);
				break;
			case 3280:
				holder.itemFour.setImageResource(R.drawable.boots_of_swiftness_homeguard_item);
				break;
			case 3281:
				holder.itemFour.setImageResource(R.drawable.boots_of_swiftness_captain_item);
				break;
			case 3282:
				holder.itemFour.setImageResource(R.drawable.boots_of_swiftness_furor_item);
				break;
			case 3283:
				holder.itemFour.setImageResource(R.drawable.boots_of_swiftness_distortion_item);
				break;
			case 3284:
				holder.itemFour.setImageResource(R.drawable.boots_of_swiftness_alacrity_item);
				break;
			default:
				holder.itemFour.setImageResource(R.drawable.ability);
				holder.itemFour.setVisibility(View.INVISIBLE);
				break;
				
			}
		} else {
			holder.itemFour.setImageResource(R.drawable.ability);
			holder.itemFour.setVisibility(View.INVISIBLE);
		}
		
		if (itemFiveId != null) {
			switch (itemFiveId.intValue()) {

			case 1001:
				holder.itemFive.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1004:
				holder.itemFive.setImageResource(R.drawable.faerie_charm_item);
				break;
			case 1006:
				holder.itemFive.setImageResource(R.drawable.rejuvenation_bead_item);
				break;
			case 1011:
				holder.itemFive.setImageResource(R.drawable.giants_belt_item);
				break;
			case 1018:
				holder.itemFive.setImageResource(R.drawable.cloak_of_agility_item);
				break;
			case 1026:
				holder.itemFive.setImageResource(R.drawable.blasting_wand_item);
				break;
			case 1027:
				holder.itemFive.setImageResource(R.drawable.sapphire_crystal_item);
				break;
			case 1028:
				holder.itemFive.setImageResource(R.drawable.ruby_crystal_item);
				break;
			case 1029:
				holder.itemFive.setImageResource(R.drawable.cloth_armor_item);
				break;
			case 1031:
				holder.itemFive.setImageResource(R.drawable.chain_vest_item);
				break;
			case 1033:
				holder.itemFive.setImageResource(R.drawable.nullmagic_mantle_item);
				break;
			case 1036:
				holder.itemFive.setImageResource(R.drawable.long_sword_item);
				break;
			case 1037:
				holder.itemFive.setImageResource(R.drawable.pickaxe_item);
				break;
			case 1038:
				holder.itemFive.setImageResource(R.drawable.b_f_sword_item);
				break;
			case 1039:
				holder.itemFive.setImageResource(R.drawable.hunters_machete_item);
				break;
			case 1042:
				holder.itemFive.setImageResource(R.drawable.dagger_item);
				break;
			case 1043:
				holder.itemFive.setImageResource(R.drawable.recurve_bow_item);
				break;
			case 1051:
				holder.itemFive.setImageResource(R.drawable.brawlers_gloves_item);
				break;
			case 1052:
				holder.itemFive.setImageResource(R.drawable.amplifying_tome_item);
				break;
			case 1053:
				holder.itemFive.setImageResource(R.drawable.vampiric_scepter_item);
				break;
			case 1054:
				holder.itemFive.setImageResource(R.drawable.dorans_shield_item);
				break;
			case 1055:
				holder.itemFive.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 1056:
				holder.itemFive.setImageResource(R.drawable.dorans_ring_item);
				break;
			case 1057:
				holder.itemFive.setImageResource(R.drawable.negatron_cloak_item);
				break;
			case 1058:
				holder.itemFive.setImageResource(R.drawable.needlessly_large_rod_item);
				break;
			case 1062:
				holder.itemFive.setImageResource(R.drawable.prospectors_blade_item);
				break;
			case 1063:
				holder.itemFive.setImageResource(R.drawable.prospectors_ring_item);
				break;
			case 1080:
				holder.itemFive.setImageResource(R.drawable.spirit_stone_item);
				break;
			case 2003:
				holder.itemFive.setImageResource(R.drawable.health_potion_item);
				break;
			case 2004:
				holder.itemFive.setImageResource(R.drawable.mana_potion_item);
				break;
			case 2009:
				holder.itemFive.setImageResource(R.drawable.total_biscuit_of_rejuvenation_item);
				break;
			case 2037:
				holder.itemFive.setImageResource(R.drawable.elixir_of_fortitude_item);
				break;
			case 2039:
				holder.itemFive.setImageResource(R.drawable.elixir_of_brilliance_item);
				break;
			case 2040:
				holder.itemFive.setImageResource(R.drawable.ichor_of_rage_item);
				break;
			case 2041:
				holder.itemFive.setImageResource(R.drawable.crystalline_flask_item);
				break;
			case 2042:
				holder.itemFive.setImageResource(R.drawable.oracles_elixir_item);
				break;
			case 2043:
				holder.itemFive.setImageResource(R.drawable.vision_ward_item);
				break;
			case 2044:
				holder.itemFive.setImageResource(R.drawable.sight_ward_item);
				break;
			case 2045:
				holder.itemFive.setImageResource(R.drawable.ruby_sightstone_item);
				break;
			case 2047:
				holder.itemFive.setImageResource(R.drawable.oracles_extract_item);
				break;
			case 2048:
				holder.itemFive.setImageResource(R.drawable.ichor_of_illumination_item);
				break;
			case 2049:
				holder.itemFive.setImageResource(R.drawable.sightstone_item);
				break;
			case 3001:
				holder.itemFive.setImageResource(R.drawable.abyssal_scepter_item);
				break;
			case 3003:
				holder.itemFive.setImageResource(R.drawable.archangels_staff_item);
				break;
			case 3004:
				holder.itemFive.setImageResource(R.drawable.manamune_item);
				break;
			case 3005:
				holder.itemFive.setImageResource(R.drawable.atmas_impaler_item);
				break;
			case 3006:
				holder.itemFive.setImageResource(R.drawable.berserkers_greaves_item);
				break;
			case 3009:
				holder.itemFive.setImageResource(R.drawable.boots_of_swiftness_item);
				break;
			case 3010:
				holder.itemFive.setImageResource(R.drawable.catalyst_the_protector_item);
				break;
			case 3020:
				holder.itemFive.setImageResource(R.drawable.sorcerers_shoes_item);
				break;
			case 3022:
				holder.itemFive.setImageResource(R.drawable.frozen_mallet_item);
				break;
			case 3023:
				holder.itemFive.setImageResource(R.drawable.twin_shadows_item);
				break;
			case 3024:
				holder.itemFive.setImageResource(R.drawable.glacial_shroud_item);
				break;
			case 3025:
				holder.itemFive.setImageResource(R.drawable.iceborn_gauntlet_item);
				break;
			case 3026:
				holder.itemFive.setImageResource(R.drawable.guardian_angel_item);
				break;
			case 3027:
				holder.itemFive.setImageResource(R.drawable.rod_of_ages_item);
				break;
			case 3028:
				holder.itemFive.setImageResource(R.drawable.chalice_of_harmony_item);
				break;
			case 3031:
				holder.itemFive.setImageResource(R.drawable.infinity_edge_item);
				break;
			case 3035:
				holder.itemFive.setImageResource(R.drawable.last_whisper_item);
				break;
			case 3037:
				holder.itemFive.setImageResource(R.drawable.mana_manipulator_item);
				break;
			case 3041:
				holder.itemFive.setImageResource(R.drawable.mejais_soulstealer_item);
				break;
			case 3044:
				holder.itemFive.setImageResource(R.drawable.phage_item);
				break;
			case 3046:
				holder.itemFive.setImageResource(R.drawable.phantom_dancer_item);
				break;
			case 3047:
				holder.itemFive.setImageResource(R.drawable.ninja_tabi_item);
				break;
			case 3050:
				holder.itemFive.setImageResource(R.drawable.zekes_herald_item);
				break;
			case 3056:
				holder.itemFive.setImageResource(R.drawable.ohmwrecker_item);
				break;
			case 3057:
				holder.itemFive.setImageResource(R.drawable.sheen_item);
				break;
			case 3060:
				holder.itemFive.setImageResource(R.drawable.banner_of_command_item);
				break;
			case 3065:
				holder.itemFive.setImageResource(R.drawable.spirit_visage_item);
				break;
			case 3067:
				holder.itemFive.setImageResource(R.drawable.kindlegem_item);
				break;
			case 3068:
				holder.itemFive.setImageResource(R.drawable.sunfire_cape_item);
				break;
			case 3069:
				holder.itemFive.setImageResource(R.drawable.shurelyas_reverie_item);
				break;
			case 3070:
				holder.itemFive
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3071:
				holder.itemFive.setImageResource(R.drawable.the_black_cleaver_item);
				break;
			case 3072:
				holder.itemFive
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			case 3074:
				holder.itemFive.setImageResource(R.drawable.ravenous_hydra_item);
				break;
			case 3075:
				holder.itemFive.setImageResource(R.drawable.thornmail_item);
				break;
			case 3077:
				holder.itemFive.setImageResource(R.drawable.tiamat_item);
				break;
			case 3078:
				holder.itemFive.setImageResource(R.drawable.trinity_force_item);
				break;
			case 3082:
				holder.itemFive.setImageResource(R.drawable.wardens_mail_item);
				break;
			case 3083:
				holder.itemFive.setImageResource(R.drawable.warmogs_armor_item);
				break;
			case 3084:
				holder.itemFive.setImageResource(R.drawable.overlords_bloodmail_item);
				break;
			case 3085:
				holder.itemFive.setImageResource(R.drawable.runaans_hurricane_item);
				break;
			case 3086:
				holder.itemFive.setImageResource(R.drawable.zeal_item);
				break;
			case 3087:
				holder.itemFive.setImageResource(R.drawable.statikk_shiv_item);
				break;
			case 3089:
				holder.itemFive.setImageResource(R.drawable.rabadons_deathcap_item);
				break;
			case 3090:
				holder.itemFive.setImageResource(R.drawable.wooglets_witchcap_item);
				break;
			case 3091:
				holder.itemFive.setImageResource(R.drawable.wits_end_item);
				break;
			case 3092:
				holder.itemFive.setImageResource(R.drawable.shard_of_true_ice_item);
				break;
			case 3093:
				holder.itemFive.setImageResource(R.drawable.avarice_blade_item);
				break;
			case 3096:
				holder.itemFive.setImageResource(R.drawable.philosophers_stone_item);
				break;
			case 3097:
				holder.itemFive.setImageResource(R.drawable.emblem_of_valor_item);
				break;
			case 3098:
				holder.itemFive.setImageResource(R.drawable.kages_lucky_pick_item);
				break;
			case 3100:
				holder.itemFive.setImageResource(R.drawable.lich_bane_item);
				break;
			case 3101:
				holder.itemFive.setImageResource(R.drawable.stinger_item);
				break;
			case 3102:
				holder.itemFive.setImageResource(R.drawable.banshees_veil_item);
				break;
			case 3104:
				holder.itemFive.setImageResource(R.drawable.lord_van_damms_pillager_item);
				break;
			case 3105:
				holder.itemFive.setImageResource(R.drawable.aegis_of_the_legion_item);
				break;
			case 3106:
				holder.itemFive.setImageResource(R.drawable.madreds_razors_item);
				break;
			case 3107:
				holder.itemFive.setImageResource(R.drawable.runic_bulwark_item);
				break;
			case 3108:
				holder.itemFive.setImageResource(R.drawable.fiendish_codex_item);
				break;
			case 3110:
				holder.itemFive.setImageResource(R.drawable.frozen_heart_item);
				break;
			case 3111:
				holder.itemFive.setImageResource(R.drawable.mercurys_treads_item);
				break;
			case 3114:
				holder.itemFive.setImageResource(R.drawable.malady_item);
				break;
			case 3115:
				holder.itemFive.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3116:
				holder.itemFive.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3117:
				holder.itemFive.setImageResource(R.drawable.boots_of_mobility_item);
				break;
			case 3122:
				holder.itemFive.setImageResource(R.drawable.wicked_hatchet_item);
				break;
			case 3123:
				holder.itemFive.setImageResource(R.drawable.executioners_calling_item);
				break;
			case 3124:
				holder.itemFive.setImageResource(R.drawable.guinsoos_rageblade_item);
				break;
			case 3128:
				holder.itemFive.setImageResource(R.drawable.deathfire_grasp_item);
				break;
			case 3131:
				holder.itemFive.setImageResource(R.drawable.sword_of_the_divine_item);
				break;
			case 3134:
				holder.itemFive.setImageResource(R.drawable.the_brutalizer_item);
				break;
			case 3135:
				holder.itemFive.setImageResource(R.drawable.void_staff_item);
				break;
			case 3136:
				holder.itemFive.setImageResource(R.drawable.haunting_guise_item);
				break;
			case 3139:
				holder.itemFive.setImageResource(R.drawable.mercurial_scimitar_item);
				break;
			case 3140:
				holder.itemFive.setImageResource(R.drawable.quicksilver_sash_item);
				break;
			case 3141:
				holder.itemFive.setImageResource(R.drawable.sword_of_the_occult_item);
				break;
			case 3142:
				holder.itemFive.setImageResource(R.drawable.youmuus_ghostblade_item);
				break;
			case 3143:
				holder.itemFive.setImageResource(R.drawable.randuins_omen_item);
				break;
			case 3144:
				holder.itemFive.setImageResource(R.drawable.bilgewater_cutlass_item);
				break;
			case 3145:
				holder.itemFive.setImageResource(R.drawable.hextech_revolver_item);
				break;
			case 3146:
				holder.itemFive.setImageResource(R.drawable.hextech_gunblade_item);
				break;
			case 3151:
				holder.itemFive.setImageResource(R.drawable.liandrys_torment_item);
				break;
			case 3152:
				holder.itemFive.setImageResource(R.drawable.will_of_the_ancients_item);
				break;
			case 3153:
				holder.itemFive.setImageResource(R.drawable.blade_of_the_ruined_king_item);
				break;
			case 3154:
				holder.itemFive.setImageResource(R.drawable.wriggles_lantern_item);
				break;
			case 3155:
				holder.itemFive.setImageResource(R.drawable.hexdrinker_item);
				break;
			case 3156:
				holder.itemFive.setImageResource(R.drawable.maw_of_malmortius_item);
				break;
			case 3157:
				holder.itemFive.setImageResource(R.drawable.zhonyas_hourglass_item);
				break;
			case 3158:
				holder.itemFive.setImageResource(R.drawable.ionian_boots_of_lucidity_item);
				break;
			case 3159:
				holder.itemFive.setImageResource(R.drawable.grezs_spectral_lantern_item);
				break;
			case 3165:
				holder.itemFive.setImageResource(R.drawable.morellonomicon_item);
				break;
			case 3166:
				holder.itemFive.setImageResource(R.drawable.bonetooth_necklace_item);
				break;
			case 3172:
				holder.itemFive.setImageResource(R.drawable.zephyr_item);
				break;
			case 3173:
				holder.itemFive.setImageResource(R.drawable.eleisas_miracle_item);
				break;
			case 3174:
				holder.itemFive.setImageResource(R.drawable.athenes_unholy_grail_item);
				break;
			case 3180:
				holder.itemFive.setImageResource(R.drawable.odyns_veil_item);
				break;
			case 3181:
				holder.itemFive.setImageResource(R.drawable.sanguine_blade_item);
				break;
			case 3184:
				holder.itemFive.setImageResource(R.drawable.entropy_item);
				break;
			case 3185:
				holder.itemFive.setImageResource(R.drawable.the_lightbringer_item);
				break;
			case 3186:
				holder.itemFive.setImageResource(R.drawable.kitaes_bloodrazor_item);
				break;
			case 3187:
				holder.itemFive.setImageResource(R.drawable.hextech_sweeper_item);
				break;
			case 3188:
				holder.itemFive.setImageResource(R.drawable.blackfire_torch_item);
				break;
			case 3190:
				holder.itemFive.setImageResource(R.drawable.locket_of_the_iron_solari_item);
				break;
			case 3196:
				holder.itemFive.setImageResource(R.drawable.augment_power_item);
				break;
			case 3197:
				holder.itemFive.setImageResource(R.drawable.augment_gravity_item);
				break;
			case 3198:
				holder.itemFive.setImageResource(R.drawable.augment_death_item);
				break;
			case 3206:
				holder.itemFive.setImageResource(R.drawable.spirit_of_the_spectral_wraith_item);
				break;
			case 3207:
				holder.itemFive.setImageResource(R.drawable.spirit_of_the_ancient_golem_item);
				break;
			case 3209:
				holder.itemFive.setImageResource(R.drawable.spirit_of_the_elder_lizard_item);
				break;
			case 3222:
				holder.itemFive.setImageResource(R.drawable.mikaels_crucible_item);
				break;
			case 3250:
				holder.itemFive.setImageResource(R.drawable.berserkers_greaves_homeguard_item);
				break;
			case 3251:
				holder.itemFive.setImageResource(R.drawable.berserkers_greaves_captain_item);
				break;
			case 3252:
				holder.itemFive.setImageResource(R.drawable.berserkers_greaves_furor_item);
				break;
			case 3253:
				holder.itemFive.setImageResource(R.drawable.berserkers_greaves_distortion_item);
				break;
			case 3254:
				holder.itemFive.setImageResource(R.drawable.berserkers_greaves_alacrity_item);
				break;
			case 3255:
				holder.itemFive.setImageResource(R.drawable.sorcerers_shoes_homeguard_item);
				break;
			case 3256:
				holder.itemFive.setImageResource(R.drawable.sorcerers_shoes_captain_item);
				break;
			case 3257:
				holder.itemFive.setImageResource(R.drawable.sorcerers_shoes_furor_item);
				break;
			case 3258:
				holder.itemFive.setImageResource(R.drawable.sorcerers_shoes_distortion_item);
				break;
			case 3259:
				holder.itemFive.setImageResource(R.drawable.sorcerers_shoes_alacrity_item);
				break;
			case 3260:
				holder.itemFive.setImageResource(R.drawable.ninja_tabi_homeguard_item);
				break;
			case 3261:
				holder.itemFive.setImageResource(R.drawable.ninja_tabi_captain_item);
				break;
			case 3262:
				holder.itemFive.setImageResource(R.drawable.ninja_tabi_furor_item);
				break;
			case 3263:
				holder.itemFive.setImageResource(R.drawable.ninja_tabi_distortion_item);
				break;
			case 3264:
				holder.itemFive.setImageResource(R.drawable.ninja_tabi_alacrity_item);
				break;
			case 3265:
				holder.itemFive.setImageResource(R.drawable.mercurys_treads_homeguard_item);
				break;
			case 3266:
				holder.itemFive.setImageResource(R.drawable.mercurys_treads_captain_item);
				break;
			case 3267:
				holder.itemFive.setImageResource(R.drawable.mercurys_treads_furor_item);
				break;
			case 3268:
				holder.itemFive.setImageResource(R.drawable.mercurys_treads_distortion_item);
				break;
			case 3269:
				holder.itemFive.setImageResource(R.drawable.mercurys_treads_alacrity_item);
				break;
			case 3270:
				holder.itemFive.setImageResource(R.drawable.boots_of_mobility_homeguard_item);
				break;
			case 3271:
				holder.itemFive.setImageResource(R.drawable.boots_of_mobility_captain_item);
				break;
			case 3272:
				holder.itemFive.setImageResource(R.drawable.boots_of_mobility_furor_item);
				break;
			case 3273:
				holder.itemFive.setImageResource(R.drawable.boots_of_mobility_distortion_item);
				break;
			case 3274:
				holder.itemFive.setImageResource(R.drawable.boots_of_mobility_alacrity_item);
				break;
			case 3275:
				holder.itemFive.setImageResource(R.drawable.ionian_boots_of_lucidity_homeguard_item);
				break;
			case 3276:
				holder.itemFive.setImageResource(R.drawable.ionian_boots_of_lucidity_captain_item);
				break;
			case 3277:
				holder.itemFive.setImageResource(R.drawable.ionian_boots_of_lucidity_furor_item);
				break;
			case 3278:
				holder.itemFive.setImageResource(R.drawable.ionian_boots_of_lucidity_distortion_item);
				break;
			case 3279:
				holder.itemFive.setImageResource(R.drawable.ionian_boots_of_lucidity_alacrity_item);
				break;
			case 3280:
				holder.itemFive.setImageResource(R.drawable.boots_of_swiftness_homeguard_item);
				break;
			case 3281:
				holder.itemFive.setImageResource(R.drawable.boots_of_swiftness_captain_item);
				break;
			case 3282:
				holder.itemFive.setImageResource(R.drawable.boots_of_swiftness_furor_item);
				break;
			case 3283:
				holder.itemFive.setImageResource(R.drawable.boots_of_swiftness_distortion_item);
				break;
			case 3284:
				holder.itemFive.setImageResource(R.drawable.boots_of_swiftness_alacrity_item);
				break;
			default:
				holder.itemFive.setImageResource(R.drawable.ability);
				holder.itemFive.setVisibility(View.INVISIBLE);
				break;
				
			}
		} else {
			holder.itemFive.setImageResource(R.drawable.ability);
			holder.itemFive.setVisibility(View.INVISIBLE);
		}
		
		if (itemSixId != null) {
			switch (itemSixId.intValue()) {

			case 1001:
				holder.itemSix.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1004:
				holder.itemSix.setImageResource(R.drawable.faerie_charm_item);
				break;
			case 1006:
				holder.itemSix.setImageResource(R.drawable.rejuvenation_bead_item);
				break;
			case 1011:
				holder.itemSix.setImageResource(R.drawable.giants_belt_item);
				break;
			case 1018:
				holder.itemSix.setImageResource(R.drawable.cloak_of_agility_item);
				break;
			case 1026:
				holder.itemSix.setImageResource(R.drawable.blasting_wand_item);
				break;
			case 1027:
				holder.itemSix.setImageResource(R.drawable.sapphire_crystal_item);
				break;
			case 1028:
				holder.itemSix.setImageResource(R.drawable.ruby_crystal_item);
				break;
			case 1029:
				holder.itemSix.setImageResource(R.drawable.cloth_armor_item);
				break;
			case 1031:
				holder.itemSix.setImageResource(R.drawable.chain_vest_item);
				break;
			case 1033:
				holder.itemSix.setImageResource(R.drawable.nullmagic_mantle_item);
				break;
			case 1036:
				holder.itemSix.setImageResource(R.drawable.long_sword_item);
				break;
			case 1037:
				holder.itemSix.setImageResource(R.drawable.pickaxe_item);
				break;
			case 1038:
				holder.itemSix.setImageResource(R.drawable.b_f_sword_item);
				break;
			case 1039:
				holder.itemSix.setImageResource(R.drawable.hunters_machete_item);
				break;
			case 1042:
				holder.itemSix.setImageResource(R.drawable.dagger_item);
				break;
			case 1043:
				holder.itemSix.setImageResource(R.drawable.recurve_bow_item);
				break;
			case 1051:
				holder.itemSix.setImageResource(R.drawable.brawlers_gloves_item);
				break;
			case 1052:
				holder.itemSix.setImageResource(R.drawable.amplifying_tome_item);
				break;
			case 1053:
				holder.itemSix.setImageResource(R.drawable.vampiric_scepter_item);
				break;
			case 1054:
				holder.itemSix.setImageResource(R.drawable.dorans_shield_item);
				break;
			case 1055:
				holder.itemSix.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 1056:
				holder.itemSix.setImageResource(R.drawable.dorans_ring_item);
				break;
			case 1057:
				holder.itemSix.setImageResource(R.drawable.negatron_cloak_item);
				break;
			case 1058:
				holder.itemSix.setImageResource(R.drawable.needlessly_large_rod_item);
				break;
			case 1062:
				holder.itemSix.setImageResource(R.drawable.prospectors_blade_item);
				break;
			case 1063:
				holder.itemSix.setImageResource(R.drawable.prospectors_ring_item);
				break;
			case 1080:
				holder.itemSix.setImageResource(R.drawable.spirit_stone_item);
				break;
			case 2003:
				holder.itemSix.setImageResource(R.drawable.health_potion_item);
				break;
			case 2004:
				holder.itemSix.setImageResource(R.drawable.mana_potion_item);
				break;
			case 2009:
				holder.itemSix.setImageResource(R.drawable.total_biscuit_of_rejuvenation_item);
				break;
			case 2037:
				holder.itemSix.setImageResource(R.drawable.elixir_of_fortitude_item);
				break;
			case 2039:
				holder.itemSix.setImageResource(R.drawable.elixir_of_brilliance_item);
				break;
			case 2040:
				holder.itemSix.setImageResource(R.drawable.ichor_of_rage_item);
				break;
			case 2041:
				holder.itemSix.setImageResource(R.drawable.crystalline_flask_item);
				break;
			case 2042:
				holder.itemSix.setImageResource(R.drawable.oracles_elixir_item);
				break;
			case 2043:
				holder.itemSix.setImageResource(R.drawable.vision_ward_item);
				break;
			case 2044:
				holder.itemSix.setImageResource(R.drawable.sight_ward_item);
				break;
			case 2045:
				holder.itemSix.setImageResource(R.drawable.ruby_sightstone_item);
				break;
			case 2047:
				holder.itemSix.setImageResource(R.drawable.oracles_extract_item);
				break;
			case 2048:
				holder.itemSix.setImageResource(R.drawable.ichor_of_illumination_item);
				break;
			case 2049:
				holder.itemSix.setImageResource(R.drawable.sightstone_item);
				break;
			case 3001:
				holder.itemSix.setImageResource(R.drawable.abyssal_scepter_item);
				break;
			case 3003:
				holder.itemSix.setImageResource(R.drawable.archangels_staff_item);
				break;
			case 3004:
				holder.itemSix.setImageResource(R.drawable.manamune_item);
				break;
			case 3005:
				holder.itemSix.setImageResource(R.drawable.atmas_impaler_item);
				break;
			case 3006:
				holder.itemSix.setImageResource(R.drawable.berserkers_greaves_item);
				break;
			case 3009:
				holder.itemSix.setImageResource(R.drawable.boots_of_swiftness_item);
				break;
			case 3010:
				holder.itemSix.setImageResource(R.drawable.catalyst_the_protector_item);
				break;
			case 3020:
				holder.itemSix.setImageResource(R.drawable.sorcerers_shoes_item);
				break;
			case 3022:
				holder.itemSix.setImageResource(R.drawable.frozen_mallet_item);
				break;
			case 3023:
				holder.itemSix.setImageResource(R.drawable.twin_shadows_item);
				break;
			case 3024:
				holder.itemSix.setImageResource(R.drawable.glacial_shroud_item);
				break;
			case 3025:
				holder.itemSix.setImageResource(R.drawable.iceborn_gauntlet_item);
				break;
			case 3026:
				holder.itemSix.setImageResource(R.drawable.guardian_angel_item);
				break;
			case 3027:
				holder.itemSix.setImageResource(R.drawable.rod_of_ages_item);
				break;
			case 3028:
				holder.itemSix.setImageResource(R.drawable.chalice_of_harmony_item);
				break;
			case 3031:
				holder.itemSix.setImageResource(R.drawable.infinity_edge_item);
				break;
			case 3035:
				holder.itemSix.setImageResource(R.drawable.last_whisper_item);
				break;
			case 3037:
				holder.itemSix.setImageResource(R.drawable.mana_manipulator_item);
				break;
			case 3041:
				holder.itemSix.setImageResource(R.drawable.mejais_soulstealer_item);
				break;
			case 3044:
				holder.itemSix.setImageResource(R.drawable.phage_item);
				break;
			case 3046:
				holder.itemSix.setImageResource(R.drawable.phantom_dancer_item);
				break;
			case 3047:
				holder.itemSix.setImageResource(R.drawable.ninja_tabi_item);
				break;
			case 3050:
				holder.itemSix.setImageResource(R.drawable.zekes_herald_item);
				break;
			case 3056:
				holder.itemSix.setImageResource(R.drawable.ohmwrecker_item);
				break;
			case 3057:
				holder.itemSix.setImageResource(R.drawable.sheen_item);
				break;
			case 3060:
				holder.itemSix.setImageResource(R.drawable.banner_of_command_item);
				break;
			case 3065:
				holder.itemSix.setImageResource(R.drawable.spirit_visage_item);
				break;
			case 3067:
				holder.itemSix.setImageResource(R.drawable.kindlegem_item);
				break;
			case 3068:
				holder.itemSix.setImageResource(R.drawable.sunfire_cape_item);
				break;
			case 3069:
				holder.itemSix.setImageResource(R.drawable.shurelyas_reverie_item);
				break;
			case 3070:
				holder.itemSix
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3071:
				holder.itemSix.setImageResource(R.drawable.the_black_cleaver_item);
				break;
			case 3072:
				holder.itemSix
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			case 3074:
				holder.itemSix.setImageResource(R.drawable.ravenous_hydra_item);
				break;
			case 3075:
				holder.itemSix.setImageResource(R.drawable.thornmail_item);
				break;
			case 3077:
				holder.itemSix.setImageResource(R.drawable.tiamat_item);
				break;
			case 3078:
				holder.itemSix.setImageResource(R.drawable.trinity_force_item);
				break;
			case 3082:
				holder.itemSix.setImageResource(R.drawable.wardens_mail_item);
				break;
			case 3083:
				holder.itemSix.setImageResource(R.drawable.warmogs_armor_item);
				break;
			case 3084:
				holder.itemSix.setImageResource(R.drawable.overlords_bloodmail_item);
				break;
			case 3085:
				holder.itemSix.setImageResource(R.drawable.runaans_hurricane_item);
				break;
			case 3086:
				holder.itemSix.setImageResource(R.drawable.zeal_item);
				break;
			case 3087:
				holder.itemSix.setImageResource(R.drawable.statikk_shiv_item);
				break;
			case 3089:
				holder.itemSix.setImageResource(R.drawable.rabadons_deathcap_item);
				break;
			case 3090:
				holder.itemSix.setImageResource(R.drawable.wooglets_witchcap_item);
				break;
			case 3091:
				holder.itemSix.setImageResource(R.drawable.wits_end_item);
				break;
			case 3092:
				holder.itemSix.setImageResource(R.drawable.shard_of_true_ice_item);
				break;
			case 3093:
				holder.itemSix.setImageResource(R.drawable.avarice_blade_item);
				break;
			case 3096:
				holder.itemSix.setImageResource(R.drawable.philosophers_stone_item);
				break;
			case 3097:
				holder.itemSix.setImageResource(R.drawable.emblem_of_valor_item);
				break;
			case 3098:
				holder.itemSix.setImageResource(R.drawable.kages_lucky_pick_item);
				break;
			case 3100:
				holder.itemSix.setImageResource(R.drawable.lich_bane_item);
				break;
			case 3101:
				holder.itemSix.setImageResource(R.drawable.stinger_item);
				break;
			case 3102:
				holder.itemSix.setImageResource(R.drawable.banshees_veil_item);
				break;
			case 3104:
				holder.itemSix.setImageResource(R.drawable.lord_van_damms_pillager_item);
				break;
			case 3105:
				holder.itemSix.setImageResource(R.drawable.aegis_of_the_legion_item);
				break;
			case 3106:
				holder.itemSix.setImageResource(R.drawable.madreds_razors_item);
				break;
			case 3107:
				holder.itemSix.setImageResource(R.drawable.runic_bulwark_item);
				break;
			case 3108:
				holder.itemSix.setImageResource(R.drawable.fiendish_codex_item);
				break;
			case 3110:
				holder.itemSix.setImageResource(R.drawable.frozen_heart_item);
				break;
			case 3111:
				holder.itemSix.setImageResource(R.drawable.mercurys_treads_item);
				break;
			case 3114:
				holder.itemSix.setImageResource(R.drawable.malady_item);
				break;
			case 3115:
				holder.itemSix.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3116:
				holder.itemSix.setImageResource(R.drawable.nashors_tooth_item);
				break;
			case 3117:
				holder.itemSix.setImageResource(R.drawable.boots_of_mobility_item);
				break;
			case 3122:
				holder.itemSix.setImageResource(R.drawable.wicked_hatchet_item);
				break;
			case 3123:
				holder.itemSix.setImageResource(R.drawable.executioners_calling_item);
				break;
			case 3124:
				holder.itemSix.setImageResource(R.drawable.guinsoos_rageblade_item);
				break;
			case 3128:
				holder.itemSix.setImageResource(R.drawable.deathfire_grasp_item);
				break;
			case 3131:
				holder.itemSix.setImageResource(R.drawable.sword_of_the_divine_item);
				break;
			case 3134:
				holder.itemSix.setImageResource(R.drawable.the_brutalizer_item);
				break;
			case 3135:
				holder.itemSix.setImageResource(R.drawable.void_staff_item);
				break;
			case 3136:
				holder.itemSix.setImageResource(R.drawable.haunting_guise_item);
				break;
			case 3139:
				holder.itemSix.setImageResource(R.drawable.mercurial_scimitar_item);
				break;
			case 3140:
				holder.itemSix.setImageResource(R.drawable.quicksilver_sash_item);
				break;
			case 3141:
				holder.itemSix.setImageResource(R.drawable.sword_of_the_occult_item);
				break;
			case 3142:
				holder.itemSix.setImageResource(R.drawable.youmuus_ghostblade_item);
				break;
			case 3143:
				holder.itemSix.setImageResource(R.drawable.randuins_omen_item);
				break;
			case 3144:
				holder.itemSix.setImageResource(R.drawable.bilgewater_cutlass_item);
				break;
			case 3145:
				holder.itemSix.setImageResource(R.drawable.hextech_revolver_item);
				break;
			case 3146:
				holder.itemSix.setImageResource(R.drawable.hextech_gunblade_item);
				break;
			case 3151:
				holder.itemSix.setImageResource(R.drawable.liandrys_torment_item);
				break;
			case 3152:
				holder.itemSix.setImageResource(R.drawable.will_of_the_ancients_item);
				break;
			case 3153:
				holder.itemSix.setImageResource(R.drawable.blade_of_the_ruined_king_item);
				break;
			case 3154:
				holder.itemSix.setImageResource(R.drawable.wriggles_lantern_item);
				break;
			case 3155:
				holder.itemSix.setImageResource(R.drawable.hexdrinker_item);
				break;
			case 3156:
				holder.itemSix.setImageResource(R.drawable.maw_of_malmortius_item);
				break;
			case 3157:
				holder.itemSix.setImageResource(R.drawable.zhonyas_hourglass_item);
				break;
			case 3158:
				holder.itemSix.setImageResource(R.drawable.ionian_boots_of_lucidity_item);
				break;
			case 3159:
				holder.itemSix.setImageResource(R.drawable.grezs_spectral_lantern_item);
				break;
			case 3165:
				holder.itemSix.setImageResource(R.drawable.morellonomicon_item);
				break;
			case 3166:
				holder.itemSix.setImageResource(R.drawable.bonetooth_necklace_item);
				break;
			case 3172:
				holder.itemSix.setImageResource(R.drawable.zephyr_item);
				break;
			case 3173:
				holder.itemSix.setImageResource(R.drawable.eleisas_miracle_item);
				break;
			case 3174:
				holder.itemSix.setImageResource(R.drawable.athenes_unholy_grail_item);
				break;
			case 3180:
				holder.itemSix.setImageResource(R.drawable.odyns_veil_item);
				break;
			case 3181:
				holder.itemSix.setImageResource(R.drawable.sanguine_blade_item);
				break;
			case 3184:
				holder.itemSix.setImageResource(R.drawable.entropy_item);
				break;
			case 3185:
				holder.itemSix.setImageResource(R.drawable.the_lightbringer_item);
				break;
			case 3186:
				holder.itemSix.setImageResource(R.drawable.kitaes_bloodrazor_item);
				break;
			case 3187:
				holder.itemSix.setImageResource(R.drawable.hextech_sweeper_item);
				break;
			case 3188:
				holder.itemSix.setImageResource(R.drawable.blackfire_torch_item);
				break;
			case 3190:
				holder.itemSix.setImageResource(R.drawable.locket_of_the_iron_solari_item);
				break;
			case 3196:
				holder.itemSix.setImageResource(R.drawable.augment_power_item);
				break;
			case 3197:
				holder.itemSix.setImageResource(R.drawable.augment_gravity_item);
				break;
			case 3198:
				holder.itemSix.setImageResource(R.drawable.augment_death_item);
				break;
			case 3206:
				holder.itemSix.setImageResource(R.drawable.spirit_of_the_spectral_wraith_item);
				break;
			case 3207:
				holder.itemSix.setImageResource(R.drawable.spirit_of_the_ancient_golem_item);
				break;
			case 3209:
				holder.itemSix.setImageResource(R.drawable.spirit_of_the_elder_lizard_item);
				break;
			case 3222:
				holder.itemSix.setImageResource(R.drawable.mikaels_crucible_item);
				break;
			case 3250:
				holder.itemSix.setImageResource(R.drawable.berserkers_greaves_homeguard_item);
				break;
			case 3251:
				holder.itemSix.setImageResource(R.drawable.berserkers_greaves_captain_item);
				break;
			case 3252:
				holder.itemSix.setImageResource(R.drawable.berserkers_greaves_furor_item);
				break;
			case 3253:
				holder.itemSix.setImageResource(R.drawable.berserkers_greaves_distortion_item);
				break;
			case 3254:
				holder.itemSix.setImageResource(R.drawable.berserkers_greaves_alacrity_item);
				break;
			case 3255:
				holder.itemSix.setImageResource(R.drawable.sorcerers_shoes_homeguard_item);
				break;
			case 3256:
				holder.itemSix.setImageResource(R.drawable.sorcerers_shoes_captain_item);
				break;
			case 3257:
				holder.itemSix.setImageResource(R.drawable.sorcerers_shoes_furor_item);
				break;
			case 3258:
				holder.itemSix.setImageResource(R.drawable.sorcerers_shoes_distortion_item);
				break;
			case 3259:
				holder.itemSix.setImageResource(R.drawable.sorcerers_shoes_alacrity_item);
				break;
			case 3260:
				holder.itemSix.setImageResource(R.drawable.ninja_tabi_homeguard_item);
				break;
			case 3261:
				holder.itemSix.setImageResource(R.drawable.ninja_tabi_captain_item);
				break;
			case 3262:
				holder.itemSix.setImageResource(R.drawable.ninja_tabi_furor_item);
				break;
			case 3263:
				holder.itemSix.setImageResource(R.drawable.ninja_tabi_distortion_item);
				break;
			case 3264:
				holder.itemSix.setImageResource(R.drawable.ninja_tabi_alacrity_item);
				break;
			case 3265:
				holder.itemSix.setImageResource(R.drawable.mercurys_treads_homeguard_item);
				break;
			case 3266:
				holder.itemSix.setImageResource(R.drawable.mercurys_treads_captain_item);
				break;
			case 3267:
				holder.itemSix.setImageResource(R.drawable.mercurys_treads_furor_item);
				break;
			case 3268:
				holder.itemSix.setImageResource(R.drawable.mercurys_treads_distortion_item);
				break;
			case 3269:
				holder.itemSix.setImageResource(R.drawable.mercurys_treads_alacrity_item);
				break;
			case 3270:
				holder.itemSix.setImageResource(R.drawable.boots_of_mobility_homeguard_item);
				break;
			case 3271:
				holder.itemSix.setImageResource(R.drawable.boots_of_mobility_captain_item);
				break;
			case 3272:
				holder.itemSix.setImageResource(R.drawable.boots_of_mobility_furor_item);
				break;
			case 3273:
				holder.itemSix.setImageResource(R.drawable.boots_of_mobility_distortion_item);
				break;
			case 3274:
				holder.itemSix.setImageResource(R.drawable.boots_of_mobility_alacrity_item);
				break;
			case 3275:
				holder.itemSix.setImageResource(R.drawable.ionian_boots_of_lucidity_homeguard_item);
				break;
			case 3276:
				holder.itemSix.setImageResource(R.drawable.ionian_boots_of_lucidity_captain_item);
				break;
			case 3277:
				holder.itemSix.setImageResource(R.drawable.ionian_boots_of_lucidity_furor_item);
				break;
			case 3278:
				holder.itemSix.setImageResource(R.drawable.ionian_boots_of_lucidity_distortion_item);
				break;
			case 3279:
				holder.itemSix.setImageResource(R.drawable.ionian_boots_of_lucidity_alacrity_item);
				break;
			case 3280:
				holder.itemSix.setImageResource(R.drawable.boots_of_swiftness_homeguard_item);
				break;
			case 3281:
				holder.itemSix.setImageResource(R.drawable.boots_of_swiftness_captain_item);
				break;
			case 3282:
				holder.itemSix.setImageResource(R.drawable.boots_of_swiftness_furor_item);
				break;
			case 3283:
				holder.itemSix.setImageResource(R.drawable.boots_of_swiftness_distortion_item);
				break;
			case 3284:
				holder.itemSix.setImageResource(R.drawable.boots_of_swiftness_alacrity_item);
				break;
			default:
				holder.itemSix.setImageResource(R.drawable.ability);
				holder.itemSix.setVisibility(View.INVISIBLE);
				break;
			}
		} else {
			holder.itemSix.setImageResource(R.drawable.ability);
			holder.itemSix.setVisibility(View.INVISIBLE);
		}
		
		// Set Summoner Icon 1
		if (gs.getSpell1() != null) {
			switch (gs.getSpell1().intValue()) {
			case 4:
				
			}
		}

		// Set Champion Icons
		if (gs.getChampionId() != null) {
			switch (gs.getChampionId().intValue()) {
			case 1:
				holder.champIcon.setImageResource(R.drawable.anniesquare);
				break;
			case 2:
				holder.champIcon.setImageResource(R.drawable.olafsquare);
				break;
			case 3:
				holder.champIcon.setImageResource(R.drawable.galiosquare);
				break;
			case 4:
				holder.champIcon.setImageResource(R.drawable.twistedfatesquare);
				break;
			case 5:
				holder.champIcon.setImageResource(R.drawable.xinzhaosquare);
				break;
			case 6:
				holder.champIcon.setImageResource(R.drawable.urgotsquare);
				break;
			case 7:
				holder.champIcon.setImageResource(R.drawable.leblancsquare);
				break;
			case 8:
				holder.champIcon.setImageResource(R.drawable.vladimirsquare);
				break;
			case 9:
				holder.champIcon.setImageResource(R.drawable.fiddlestickssquare);
				break;
			case 10:
				holder.champIcon.setImageResource(R.drawable.kaylesquare);
				break;
			case 11:
				holder.champIcon.setImageResource(R.drawable.masteryisquare);
				break;
			case 12:
				holder.champIcon.setImageResource(R.drawable.alistarsquare);
				break;
			case 13:
				holder.champIcon.setImageResource(R.drawable.ryzesquare);
				break;
			case 14:
				holder.champIcon.setImageResource(R.drawable.sionsquare);
				break;
			case 15:
				holder.champIcon.setImageResource(R.drawable.sivirsquare);
				break;
			case 16:
				holder.champIcon.setImageResource(R.drawable.sorakasquare);
				break;
			case 17:
				holder.champIcon.setImageResource(R.drawable.teemosquare);
				break;
			case 18:
				holder.champIcon.setImageResource(R.drawable.tristanasquare);
				break;
			case 19:
				holder.champIcon.setImageResource(R.drawable.warwicksquare);
				break;
			case 20:
				holder.champIcon.setImageResource(R.drawable.nunusquare);
				break;
			case 21:
				holder.champIcon.setImageResource(R.drawable.missfortunesquare);
				break;
			case 22:
				holder.champIcon.setImageResource(R.drawable.ashesquare);
				break;
			case 23:
				holder.champIcon.setImageResource(R.drawable.tryndameresquare);
				break;
			case 24:
				holder.champIcon.setImageResource(R.drawable.jaxsquare);
				break;
			case 25:
				holder.champIcon.setImageResource(R.drawable.morganasquare);
				break;
			case 26:
				holder.champIcon.setImageResource(R.drawable.zileansquare);
				break;
			case 27:
				holder.champIcon.setImageResource(R.drawable.singedsquare);
				break;
			case 28:
				holder.champIcon.setImageResource(R.drawable.evelynnsquare);
				break;
			case 29:
				holder.champIcon.setImageResource(R.drawable.twitchsquare);
				break;
			case 30:
				holder.champIcon.setImageResource(R.drawable.karthussquare);
				break;
			case 31:
				holder.champIcon.setImageResource(R.drawable.chogathsquare);
				break;
			case 32:
				holder.champIcon.setImageResource(R.drawable.amumusquare);
				break;
			case 33:
				holder.champIcon.setImageResource(R.drawable.rammussquare);
				break;
			case 34:
				holder.champIcon.setImageResource(R.drawable.aniviasquare);
				break;
			case 35:
				holder.champIcon.setImageResource(R.drawable.shacosquare);
				break;
			case 36:
				holder.champIcon.setImageResource(R.drawable.drmundosquare);
				break;
			case 37:
				holder.champIcon.setImageResource(R.drawable.sonasquare);
				break;
			case 38:
				holder.champIcon.setImageResource(R.drawable.kassadinsquare);
				break;
			case 39:
				holder.champIcon.setImageResource(R.drawable.ireliasquare);
				break;
			case 40:
				holder.champIcon.setImageResource(R.drawable.jannasquare);
				break;
			case 41:
				holder.champIcon.setImageResource(R.drawable.gangplanksquare);
				break;
			case 42:
				holder.champIcon.setImageResource(R.drawable.corkisquare);
				break;
			case 43:
				holder.champIcon.setImageResource(R.drawable.karmasquare);
				break;
			case 44:
				holder.champIcon.setImageResource(R.drawable.taricsquare);
				break;
			case 45:
				holder.champIcon.setImageResource(R.drawable.veigarsquare);
				break;
			case 48:
				holder.champIcon.setImageResource(R.drawable.trundlesquare);
				break;
			case 50:
				holder.champIcon.setImageResource(R.drawable.swainsquare);
				break;
			case 51:
				holder.champIcon.setImageResource(R.drawable.caitlynsquare);
				break;
			case 53:
				holder.champIcon.setImageResource(R.drawable.blitzcranksquare);
				break;
			case 54:
				holder.champIcon.setImageResource(R.drawable.malphitesquare);
				break;
			case 55:
				holder.champIcon.setImageResource(R.drawable.katarinasquare);
				break;
			case 56:
				holder.champIcon.setImageResource(R.drawable.nocturnesquare);
				break;
			case 57:
				holder.champIcon.setImageResource(R.drawable.maokaisquare);
				break;
			case 58:
				holder.champIcon.setImageResource(R.drawable.renektonsquare);
				break;
			case 59:
				holder.champIcon.setImageResource(R.drawable.jarvanivsquare);
				break;
			case 60:
				holder.champIcon.setImageResource(R.drawable.elisesquare);
				break;
			case 61:
				holder.champIcon.setImageResource(R.drawable.oriannasquare);
				break;
			case 62:
				holder.champIcon.setImageResource(R.drawable.wukongsquare);
				break;
			case 63:
				holder.champIcon.setImageResource(R.drawable.brandsquare);
				break;
			case 64:
				holder.champIcon.setImageResource(R.drawable.leesinsquare);
				break;
			case 67:
				holder.champIcon.setImageResource(R.drawable.vaynesquare);
				break;
			case 68:
				holder.champIcon.setImageResource(R.drawable.rumblesquare);
				break;
			case 69:
				holder.champIcon.setImageResource(R.drawable.cassiopeiasquare);
				break;
			case 72:
				holder.champIcon.setImageResource(R.drawable.skarnersquare);
				break;
			case 74:
				holder.champIcon.setImageResource(R.drawable.heimerdingersquare);
				break;
			case 75:
				holder.champIcon.setImageResource(R.drawable.nasussquare);
				break;
			case 76:
				holder.champIcon.setImageResource(R.drawable.nidaleesquare);
				break;
			case 77:
				holder.champIcon.setImageResource(R.drawable.udyrsquare);
				break;
			case 78:
				holder.champIcon.setImageResource(R.drawable.poppysquare);
				break;
			case 79:
				holder.champIcon.setImageResource(R.drawable.gragassquare);
				break;
			case 80:
				holder.champIcon.setImageResource(R.drawable.pantheonsquare);
				break;
			case 81:
				holder.champIcon.setImageResource(R.drawable.ezrealsquare);
				break;
			case 82:
				holder.champIcon.setImageResource(R.drawable.mordekaisersquare);
				break;
			case 83:
				holder.champIcon.setImageResource(R.drawable.yoricksquare);
				break;
			case 84:
				holder.champIcon.setImageResource(R.drawable.akalisquare);
				break;
			case 85:
				holder.champIcon.setImageResource(R.drawable.kennensquare);
				break;
			case 86:
				holder.champIcon.setImageResource(R.drawable.garensquare);
				break;
			case 89:
				holder.champIcon.setImageResource(R.drawable.leonasquare);
				break;
			case 90:
				holder.champIcon.setImageResource(R.drawable.malzaharsquare);
				break;
			case 91:
				holder.champIcon.setImageResource(R.drawable.talonsquare);
				break;
			case 92:
				holder.champIcon.setImageResource(R.drawable.rivensquare);
				break;
			case 96:
				holder.champIcon.setImageResource(R.drawable.kogmawsquare);
				break;
			case 98:
				holder.champIcon.setImageResource(R.drawable.shensquare);
				break;
			case 99:
				holder.champIcon.setImageResource(R.drawable.luxsquare);
				break;
			case 101:
				holder.champIcon.setImageResource(R.drawable.xerathsquare);
				break;
			case 102:
				holder.champIcon.setImageResource(R.drawable.shyvanasquare);
				break;
			case 103:
				holder.champIcon.setImageResource(R.drawable.ahrisquare);
				break;
			case 104:
				holder.champIcon.setImageResource(R.drawable.gravessquare);
				break;
			case 105:
				holder.champIcon.setImageResource(R.drawable.fizzsquare);
				break;
			case 106:
				holder.champIcon.setImageResource(R.drawable.volibearsquare);
				break;
			case 107:
				holder.champIcon.setImageResource(R.drawable.rengarsquare);
				break;
			case 110:
				holder.champIcon.setImageResource(R.drawable.varussquare);
				break;
			case 111:
				holder.champIcon.setImageResource(R.drawable.nautilussquare);
				break;
			case 112:
				holder.champIcon.setImageResource(R.drawable.viktorsquare);
				break;
			case 113:
				holder.champIcon.setImageResource(R.drawable.sejuanisquare);
				break;
			case 114:
				holder.champIcon.setImageResource(R.drawable.fiorasquare);
				break;
			case 115:
				holder.champIcon.setImageResource(R.drawable.ziggssquare);
				break;
			case 117:
				holder.champIcon.setImageResource(R.drawable.lulusquare);
				break;
			case 119:
				holder.champIcon.setImageResource(R.drawable.dravensquare);
				break;
			case 120:
				holder.champIcon.setImageResource(R.drawable.hecarimsquare);
				break;
			case 121:
				holder.champIcon.setImageResource(R.drawable.khazixsquare);
				break;
			case 122:
				holder.champIcon.setImageResource(R.drawable.dariussquare);
				break;
			case 126:
				holder.champIcon.setImageResource(R.drawable.jaycesquare);
				break;
			case 127:
				holder.champIcon.setImageResource(R.drawable.lissandrasquare);
				break;
			case 131:
				holder.champIcon.setImageResource(R.drawable.dianasquare);
				break;
			case 133:
				holder.champIcon.setImageResource(R.drawable.quinnsquare);
				break;
			case 134:
				holder.champIcon.setImageResource(R.drawable.syndrasquare2);
				break;
			case 143:
				holder.champIcon.setImageResource(R.drawable.zyrasquare);
				break;
			case 154:
				holder.champIcon.setImageResource(R.drawable.zacsquare);
				break;
			case 238:
				holder.champIcon.setImageResource(R.drawable.zedsquare);
				break;
			case 254:
				holder.champIcon.setImageResource(R.drawable.visquare);
				break;
			case 266:
				holder.champIcon.setImageResource(R.drawable.aatroxsquare);
				break;
			case 267:
				holder.champIcon.setImageResource(R.drawable.namisquare);
				break;
			case 412:
				holder.champIcon.setImageResource(R.drawable.threshsquare);
				break;
			}
		}
		
		
		// Set KDA
		if (killsValue != null && deathsValue != null && assistsValue != null) {
			holder.winOrLose.setText(getKda());
			holder.winOrLose.setTypeface(MatchHistoryFragment.tf);
		}

		// Set Victory/Defeat
		if (win != null) {
			StateListDrawable states = new StateListDrawable();
			states.addState(
					new int[] { android.R.attr.state_pressed },
					convertView.getResources().getDrawable(
							R.drawable.gradient_bg_hover));
			
			states.addState(
					new int[] { android.R.attr.state_focused },
					convertView.getResources().getDrawable(
							R.drawable.gradient_bg_hover));
			
			states.addState(new int[] {}, convertView.getResources()
					.getDrawable(R.drawable.gradient_bg));
			
			holder.background.setBackgroundDrawable(states);
		} else {

			StateListDrawable states = new StateListDrawable();
			states.addState(
					new int[] { android.R.attr.state_pressed },
					convertView.getResources().getDrawable(
							R.drawable.gradient_bg_hover));
			
			states.addState(
					new int[] { android.R.attr.state_focused },
					convertView.getResources().getDrawable(
							R.drawable.gradient_bg_hover));
			
			states.addState(new int[] {}, convertView.getResources()
					.getDrawable(R.drawable.image_bg_defeat));
			
			holder.background.setBackgroundDrawable(states);
		}
	
		
		
		
		
		return convertView;
	}
	
	private String getKda() {
		String kda = "KDA: " + killsValue + " / " + deathsValue + " / " + assistsValue;
		return kda;
	}
	
}