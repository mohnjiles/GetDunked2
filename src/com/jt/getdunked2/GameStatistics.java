
package com.jt.getdunked2;

import java.util.List;

public class GameStatistics{
	private Number adjustedRating;
   	private boolean afk;
   	private Number boostIpEarned;
   	private Number boostXpEarned;
   	private Number championId;
   	private String createDate;
   	private Number dataVersion;
   	private String difficultyString;
   	private boolean eligibleFirstWinOfDay;
   	private Number eloChange;
   	private Number experienceEarned;
   	private List<FellowPlayers> fellowPlayers;
   	private String futureData;
   	private Number gameId;
   	private Number gameMapId;
   	private String gameMode;
   	private String gameType;
	private String gameTypeEnum;
   	private boolean invalid;
   	private String id;
   	private Number ipEarned;
   	private Number KCoefficient;
   	private boolean leaver;
   	private Number level;
   	private Number premadeSize;
   	private boolean premadeTeam;
   	private Number predictedWinPct;
   	private String queueType;
   	private boolean ranked;
   	private Number rating;
   	private String rawStatsJson;
   	private Number skinIndex;
   	private String skinName;
   	private Number spell1;
   	private Number spell2;
   	private List<Statistics> statistics;
   	private String subType;
   	private Number summonerId;
   	private Number teamId;
   	private Number teamRating;
   	private Number timeInQueue;
   	private Number userId;
   	private Number userServerPing;
   	
   	
   
   	
   	
   	

 	public boolean getAfk(){
		return this.afk;
	}
	public void setAfk(boolean afk){
		this.afk = afk;
	}
 	public Number getBoostIpEarned(){
		return this.boostIpEarned;
	}
	public void setBoostIpEarned(Number boostIpEarned){
		this.boostIpEarned = boostIpEarned;
	}
 	public Number getBoostXpEarned(){
		return this.boostXpEarned;
	}
	public void setBoostXpEarned(Number boostXpEarned){
		this.boostXpEarned = boostXpEarned;
	}
 	public Number getChampionId(){
		return this.championId;
	}
	public void setChampionId(Number championId){
		this.championId = championId;
	}
 	public String getCreateDate(){
		return this.createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
 	public boolean getEligibleFirstWinOfDay(){
		return this.eligibleFirstWinOfDay;
	}
	public void setEligibleFirstWinOfDay(boolean eligibleFirstWinOfDay){
		this.eligibleFirstWinOfDay = eligibleFirstWinOfDay;
	}
 	public Number getExperienceEarned(){
		return this.experienceEarned;
	}
	public void setExperienceEarned(Number experienceEarned){
		this.experienceEarned = experienceEarned;
	}
	public List<FellowPlayers> getFellowPlayers() {
		return fellowPlayers;
	}
	public void setFellowPlayers(List<FellowPlayers> fellowPlayers) {
		this.fellowPlayers = fellowPlayers;
	}
	public Number getGameId(){
		return this.gameId;
	}
	public void setGameId(Number gameId){
		this.gameId = gameId;
	}
 	public Number getGameMapId(){
		return this.gameMapId;
	}
	public void setGameMapId(Number gameMapId){
		this.gameMapId = gameMapId;
	}
 	public String getGameMode(){
		return this.gameMode;
	}
	public void setGameMode(String gameMode){
		this.gameMode = gameMode;
	}
 	public String getGameType(){
		return this.gameType;
	}
	public void setGameType(String gameType){
		this.gameType = gameType;
	}
 	public boolean getInvalid(){
		return this.invalid;
	}
	public void setInvalid(boolean invalid){
		this.invalid = invalid;
	}
 	public Number getIpEarned(){
		return this.ipEarned;
	}
	public void setIpEarned(Number ipEarned){
		this.ipEarned = ipEarned;
	}
 	public boolean getLeaver(){
		return this.leaver;
	}
	public void setLeaver(boolean leaver){
		this.leaver = leaver;
	}
 	public Number getLevel(){
		return this.level;
	}
	public void setLevel(Number level){
		this.level = level;
	}
 	public Number getPremadeSize(){
		return this.premadeSize;
	}
	public void setPremadeSize(Number premadeSize){
		this.premadeSize = premadeSize;
	}
 	public boolean getPremadeTeam(){
		return this.premadeTeam;
	}
	public void setPremadeTeam(boolean premadeTeam){
		this.premadeTeam = premadeTeam;
	}
 	public String getQueueType(){
		return this.queueType;
	}
	public void setQueueType(String queueType){
		this.queueType = queueType;
	}
 	public boolean getRanked(){
		return this.ranked;
	}
	public void setRanked(boolean ranked){
		this.ranked = ranked;
	}
 	public Number getSkinIndex(){
		return this.skinIndex;
	}
	public void setSkinIndex(Number skinIndex){
		this.skinIndex = skinIndex;
	}
 	public Number getSpell1(){
		return this.spell1;
	}
	public void setSpell1(Number spell1){
		this.spell1 = spell1;
	}
 	public Number getSpell2(){
		return this.spell2;
	}
	public void setSpell2(Number spell2){
		this.spell2 = spell2;
	}
 	public String getSubType(){
		return this.subType;
	}
	public List<Statistics> getStatistics() {
		return statistics;
	}
	public void setStatistics(List<Statistics> statistics) {
		this.statistics = statistics;
	}
	public void setSubType(String subType){
		this.subType = subType;
	}
 	public Number getSummonerId(){
		return this.summonerId;
	}
	public void setSummonerId(Number summonerId){
		this.summonerId = summonerId;
	}
 	public Number getTeamId(){
		return this.teamId;
	}
	public void setTeamId(Number teamId){
		this.teamId = teamId;
	}
 	public Number getTimeInQueue(){
		return this.timeInQueue;
	}
	public void setTimeInQueue(Number timeInQueue){
		this.timeInQueue = timeInQueue;
	}
 	public Number getUserId(){
		return this.userId;
	}
	public void setUserId(Number userId){
		this.userId = userId;
	}
 	public Number getUserServerPing(){
		return this.userServerPing;
	}
	public void setUserServerPing(Number userServerPing){
		this.userServerPing = userServerPing;
	}
	public Number getAdjustedRating() {
		return adjustedRating;
	}
	public void setAdjustedRating(Number adjustedRating) {
		this.adjustedRating = adjustedRating;
	}
	public Number getDataVersion() {
		return dataVersion;
	}
	public void setDataVersion(Number dataVersion) {
		this.dataVersion = dataVersion;
	}
	public String getDifficultyString() {
		return difficultyString;
	}
	public void setDifficultyString(String difficultyString) {
		this.difficultyString = difficultyString;
	}
	public Number getEloChange() {
		return eloChange;
	}
	public void setEloChange(Number eloChange) {
		this.eloChange = eloChange;
	}
	public String getFutureData() {
		return futureData;
	}
	public void setFutureData(String futureData) {
		this.futureData = futureData;
	}
	public String getGameTypeEnum() {
		return gameTypeEnum;
	}
	public void setGameTypeEnum(String gameTypeEnum) {
		this.gameTypeEnum = gameTypeEnum;
	}
	public Number getKCoefficient() {
		return KCoefficient;
	}
	public void setKCoefficient(Number kCoefficient) {
		KCoefficient = kCoefficient;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Number getPredictedWinPct() {
		return predictedWinPct;
	}
	public void setPredictedWinPct(Number predictedWinPct) {
		this.predictedWinPct = predictedWinPct;
	}
	public Number getRating() {
		return rating;
	}
	public void setRating(Number rating) {
		this.rating = rating;
	}
	public String getRawStatsJson() {
		return rawStatsJson;
	}
	public void setRawStatsJson(String rawStatsJson) {
		this.rawStatsJson = rawStatsJson;
	}
	public String getSkinName() {
		return skinName;
	}
	public void setSkinName(String skinName) {
		this.skinName = skinName;
	}
	public Number getTeamRating() {
		return teamRating;
	}
	public void setTeamRating(Number teamRating) {
		this.teamRating = teamRating;
	}


}
