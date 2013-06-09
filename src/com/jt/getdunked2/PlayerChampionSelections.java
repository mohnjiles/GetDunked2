
package com.jt.getdunked2;

import java.util.List;

public class PlayerChampionSelections{
   	private Number championId;
   	private Number selectedSkinIndex;
   	private Number spell1Id;
   	private Number spell2Id;
   	private String summonerInternalName;

 	public Number getChampionId(){
		return this.championId;
	}
	public void setChampionId(Number championId){
		this.championId = championId;
	}
 	public Number getSelectedSkinIndex(){
		return this.selectedSkinIndex;
	}
	public void setSelectedSkinIndex(Number selectedSkinIndex){
		this.selectedSkinIndex = selectedSkinIndex;
	}
 	public Number getSpell1Id(){
		return this.spell1Id;
	}
	public void setSpell1Id(Number spell1Id){
		this.spell1Id = spell1Id;
	}
 	public Number getSpell2Id(){
		return this.spell2Id;
	}
	public void setSpell2Id(Number spell2Id){
		this.spell2Id = spell2Id;
	}
 	public String getSummonerInternalName(){
		return this.summonerInternalName;
	}
	public void setSummonerInternalName(String summonerInternalName){
		this.summonerInternalName = summonerInternalName;
	}
}
