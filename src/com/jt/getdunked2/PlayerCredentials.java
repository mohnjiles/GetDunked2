
package com.jt.getdunked2;

import java.util.List;

public class PlayerCredentials{
   	private Number gameId;
   	private Number lastSelectedSkinIndex;
   	private boolean observer;
   	private String observerEncryptionKey;
   	private String observerServerIp;
   	private Number observerServerPort;
   	private Number playerId;

 	public Number getGameId(){
		return this.gameId;
	}
	public void setGameId(Number gameId){
		this.gameId = gameId;
	}
 	public Number getLastSelectedSkinIndex(){
		return this.lastSelectedSkinIndex;
	}
	public void setLastSelectedSkinIndex(Number lastSelectedSkinIndex){
		this.lastSelectedSkinIndex = lastSelectedSkinIndex;
	}
 	public boolean getObserver(){
		return this.observer;
	}
	public void setObserver(boolean observer){
		this.observer = observer;
	}
 	public String getObserverEncryptionKey(){
		return this.observerEncryptionKey;
	}
	public void setObserverEncryptionKey(String observerEncryptionKey){
		this.observerEncryptionKey = observerEncryptionKey;
	}
 	public String getObserverServerIp(){
		return this.observerServerIp;
	}
	public void setObserverServerIp(String observerServerIp){
		this.observerServerIp = observerServerIp;
	}
 	public Number getObserverServerPort(){
		return this.observerServerPort;
	}
	public void setObserverServerPort(Number observerServerPort){
		this.observerServerPort = observerServerPort;
	}
 	public Number getPlayerId(){
		return this.playerId;
	}
	public void setPlayerId(Number playerId){
		this.playerId = playerId;
	}
}
