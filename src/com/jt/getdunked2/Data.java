
package com.jt.getdunked2;

import java.util.List;

public class Data{
   	private Game game;
   	private String gameName;
   	private String lastModifiedDate;
   	private PlayerCredentials playerCredentials;
   	private Number acctId;
   	private String internalName;
   	private String name;
   	private Number profileIconId;
   	private String revisionDate;
   	private Number summonerId;
   	private Number summonerLevel;
   	private List<GameStatistics> gameStatistics;
   	private Number userId;

 	public Game getGame(){
		return this.game;
	}
	public void setGame(Game game){
		this.game = game;
	}
 	public String getGameName(){
		return this.gameName;
	}
	public void setGameName(String gameName){
		this.gameName = gameName;
	}
 	public String getLastModifiedDate(){
		return this.lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate){
		this.lastModifiedDate = lastModifiedDate;
	}
 	public PlayerCredentials getPlayerCredentials(){
		return this.playerCredentials;
	}
	public void setPlayerCredentials(PlayerCredentials playerCredentials){
		this.playerCredentials = playerCredentials;
	}
	public Number getAcctId(){
		return this.acctId;
	}
	public void setAcctId(Number acctId){
		this.acctId = acctId;
	}
 	public String getInternalName(){
		return this.internalName;
	}
	public void setInternalName(String internalName){
		this.internalName = internalName;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Number getProfileIconId(){
		return this.profileIconId;
	}
	public void setProfileIconId(Number profileIconId){
		this.profileIconId = profileIconId;
	}
 	public String getRevisionDate(){
		return this.revisionDate;
	}
	public void setRevisionDate(String revisionDate){
		this.revisionDate = revisionDate;
	}
 	public Number getSummonerId(){
		return this.summonerId;
	}
	public void setSummonerId(Number summonerId){
		this.summonerId = summonerId;
	}
 	public Number getSummonerLevel(){
		return this.summonerLevel;
	}
	public void setSummonerLevel(Number summonerLevel){
		this.summonerLevel = summonerLevel;
	}

 	public List<GameStatistics> getGameStatistics() {
		return gameStatistics;
	}
	public void setGameStatistics(List<GameStatistics> gameStatistics) {
		this.gameStatistics = gameStatistics;
	}
	public Number getUserId(){
		return this.userId;
	}
	public void setUserId(Number userId){
		this.userId = userId;
	}
}
