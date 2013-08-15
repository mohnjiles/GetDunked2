package com.jt.getdunked2;

public class Player {
	private Number accountId;
	private Number summonerId;
	private String name;
	private Number icon;
	private String internalName;
	private Number level;
	
	public Number getAccountId() {
		return accountId;
	}
	public void setAccountId(Number accountId) {
		this.accountId = accountId;
	}
	public Number getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(Number summonerId) {
		this.summonerId = summonerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Number getIcon() {
		return icon;
	}
	public void setIcon(Number icon) {
		this.icon = icon;
	}
	public String getInternalName() {
		return internalName;
	}
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}
	public Number getLevel() {
		return level;
	}
	public void setLevel(Number level) {
		this.level = level;
	}
}
