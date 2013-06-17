package com.jt.getdunked2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.integer;
import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.text.StaticLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LazyAdapter extends ArrayAdapter {

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
		TextView kills;
		TextView deaths;
		TextView assists;
		ImageView champIcon;
		ImageView itemOne;
		ImageView itemTwo;
		ImageView itemThree;
		ImageView itemFour;
		ImageView itemFive;
		ImageView itemSix;
		RelativeLayout background;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		GameStatistics gs = (GameStatistics) getItem(position);
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
			holder.kills = (TextView) convertView
					.findViewById(R.id.tvScoreKills);
			holder.deaths = (TextView) convertView
					.findViewById(R.id.tvScoreDeaths);
			holder.assists = (TextView) convertView
					.findViewById(R.id.tvScoreAssists);
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

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// define some shit
		Number timeDead = null;
		Number win = null;
		Number killsValue = null;
		Number deathsValue = null;
		Number assistsValue = null;
		Number itemOneId = null;
		Number itemTwoId = null;
		Number itemThreeId = null;
		Number itemFourId = null;
		Number itemFiveId = null;
		Number itemSixId = null;
		int itemNumber = 0;

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
			} else if (statistic.getStatType().equals("ITEM1")) {
				itemOneId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM2")) {
				itemTwoId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM3")) {
				itemThreeId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM4")) {
				itemFourId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM5")) {
				itemFiveId = statistic.getValue();
			} else if (statistic.getStatType().equals("ITEM6")) {
				itemSixId = statistic.getValue();
			}

		}
		// Set Game Mode

		if (gs.getGameType() != null) {
			holder.gameType.setText(gs.getGameType());
		}

		// Set Item Icons
		// Item 1
		if (itemOneId != null) {
			switch (itemOneId.intValue()) {
			case 1001:
				holder.itemOne.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1055:
				holder.itemOne.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 3070:
				holder.itemOne
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3072:
				holder.itemOne
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			}
		}
		// Item 2
		if (itemTwoId != null) {
			switch (itemTwoId.intValue()) {
			case 1001:
				holder.itemTwo.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1055:
				holder.itemTwo.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 3070:
				holder.itemTwo
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3072:
				holder.itemTwo
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			}
		}
		if (itemThreeId != null) {
			switch (itemThreeId.intValue()) {

			case 1001:
				holder.itemThree
						.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1055:
				holder.itemThree.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 3070:
				holder.itemThree
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3072:
				holder.itemThree
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			}
		}
		if (itemFourId != null) {
			switch (itemFourId.intValue()) {

			case 1001:
				holder.itemFour
						.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1055:
				holder.itemFour.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 3070:
				holder.itemFour
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3072:
				holder.itemFour
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			}
		}
		if (itemFiveId != null) {
			switch (itemFiveId.intValue()) {

			case 1001:
				holder.itemFive
						.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1055:
				holder.itemFive.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 3070:
				holder.itemFive
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3072:
				holder.itemFive
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
			}
		}
		if (itemSixId != null) {
			switch (itemSixId.intValue()) {

			case 1001:
				holder.itemSix.setImageResource(R.drawable.boots_of_speed_item);
				break;
			case 1055:
				holder.itemSix.setImageResource(R.drawable.dorans_blade_item);
				break;
			case 3070:
				holder.itemSix
						.setImageResource(R.drawable.tear_of_the_goddess_item);
				break;
			case 3072:
				holder.itemSix
						.setImageResource(R.drawable.the_bloodthirster_item);
				break;
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

		// Set Victory/Defeat
		if (win != null) {
			holder.winOrLose.setText("Victory");

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
			holder.winOrLose.setText("Defeat");

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

		// Set Kills
		if (killsValue != null) {
			holder.kills.setText(killsValue.toString());
		}

		// Set Deaths
		if (deathsValue != null) {
			holder.deaths.setText(deathsValue.toString());
		}

		// Set Assists
		if (assistsValue != null) {
			holder.assists.setText(assistsValue.toString());
		}

		return convertView;
	}

}