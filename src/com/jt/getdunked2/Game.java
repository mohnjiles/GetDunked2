
package com.jt.getdunked2;

import java.util.List;

public class Game{
   	private List bannedChampions;
   	private String gameMode;
   	private String gameStartTime;
   	private String gameState;
   	private String gameType;
   	private Number gameTypeConfigId;
   	private Number id;
   	private Number mapId;
   	private Number maxNumPlayers;
   	private String name;
   	private List observers;
   	private Number optimisticLock;
   	private boolean passwordSet;
   	private Number pickTurn;
   	private List playerChampionSelections;
   	private Number queuePosition;
   	private String queueTypeName;
   	private Number spectatorDelay;
   	private String spectatorsAllowed;
   	private String statusOfParticipants;
   	private List teamOne;
   	private List teamTwo;
   	private String terminatedCondition;

 	public List getBannedChampions(){
		return this.bannedChampions;
	}
	public void setBannedChampions(List bannedChampions){
		this.bannedChampions = bannedChampions;
	}
 	public String getGameMode(){
		return this.gameMode;
	}
	public void setGameMode(String gameMode){
		this.gameMode = gameMode;
	}
 	public String getGameStartTime(){
		return this.gameStartTime;
	}
	public void setGameStartTime(String gameStartTime){
		this.gameStartTime = gameStartTime;
	}
 	public String getGameState(){
		return this.gameState;
	}
	public void setGameState(String gameState){
		this.gameState = gameState;
	}
 	public String getGameType(){
		return this.gameType;
	}
	public void setGameType(String gameType){
		this.gameType = gameType;
	}
 	public Number getGameTypeConfigId(){
		return this.gameTypeConfigId;
	}
	public void setGameTypeConfigId(Number gameTypeConfigId){
		this.gameTypeConfigId = gameTypeConfigId;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public Number getMapId(){
		return this.mapId;
	}
	public void setMapId(Number mapId){
		this.mapId = mapId;
	}
 	public Number getMaxNumPlayers(){
		return this.maxNumPlayers;
	}
	public void setMaxNumPlayers(Number maxNumPlayers){
		this.maxNumPlayers = maxNumPlayers;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public List getObservers(){
		return this.observers;
	}
	public void setObservers(List observers){
		this.observers = observers;
	}
 	public Number getOptimisticLock(){
		return this.optimisticLock;
	}
	public void setOptimisticLock(Number optimisticLock){
		this.optimisticLock = optimisticLock;
	}
 	public boolean getPasswordSet(){
		return this.passwordSet;
	}
	public void setPasswordSet(boolean passwordSet){
		this.passwordSet = passwordSet;
	}
 	public Number getPickTurn(){
		return this.pickTurn;
	}
	public void setPickTurn(Number pickTurn){
		this.pickTurn = pickTurn;
	}
 	public List getPlayerChampionSelections(){
		return this.playerChampionSelections;
	}
	public void setPlayerChampionSelections(List playerChampionSelections){
		this.playerChampionSelections = playerChampionSelections;
	}
 	public Number getQueuePosition(){
		return this.queuePosition;
	}
	public void setQueuePosition(Number queuePosition){
		this.queuePosition = queuePosition;
	}
 	public String getQueueTypeName(){
		return this.queueTypeName;
	}
	public void setQueueTypeName(String queueTypeName){
		this.queueTypeName = queueTypeName;
	}
 	public Number getSpectatorDelay(){
		return this.spectatorDelay;
	}
	public void setSpectatorDelay(Number spectatorDelay){
		this.spectatorDelay = spectatorDelay;
	}
 	public String getSpectatorsAllowed(){
		return this.spectatorsAllowed;
	}
	public void setSpectatorsAllowed(String spectatorsAllowed){
		this.spectatorsAllowed = spectatorsAllowed;
	}
 	public String getStatusOfParticipants(){
		return this.statusOfParticipants;
	}
	public void setStatusOfParticipants(String statusOfParticipants){
		this.statusOfParticipants = statusOfParticipants;
	}
 	public List getTeamOne(){
		return this.teamOne;
	}
	public void setTeamOne(List teamOne){
		this.teamOne = teamOne;
	}
 	public List getTeamTwo(){
		return this.teamTwo;
	}
	public void setTeamTwo(List teamTwo){
		this.teamTwo = teamTwo;
	}
 	public String getTerminatedCondition(){
		return this.terminatedCondition;
	}
	public void setTerminatedCondition(String terminatedCondition){
		this.terminatedCondition = terminatedCondition;
	}
}
