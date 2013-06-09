
package com.jt.getdunked2;

import java.util.List;

public class Data{
   	private Game game;
   	private String gameName;
   	private String lastModifiedDate;
   	private PlayerCredentials playerCredentials;

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
}
