package org.api.manapool.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String email;
	private boolean verified;
	@SerializedName(value = "singles_live")  boolean singlesLive;
	@SerializedName(value = "sealed_live")  boolean sealedLive;
	@SerializedName(value = "payouts_enabled")  boolean payoutEnabled;
	
	@Override
	public String toString() {
		return getUsername();
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public boolean isSinglesLive() {
		return singlesLive;
	}
	public void setSinglesLive(boolean singlesLive) {
		this.singlesLive = singlesLive;
	}
	public boolean isSealedLive() {
		return sealedLive;
	}
	public void setSealedLive(boolean sealedLive) {
		this.sealedLive = sealedLive;
	}
	public boolean isPayoutEnabled() {
		return payoutEnabled;
	}
	public void setPayoutEnabled(boolean payoutEnabled) {
		this.payoutEnabled = payoutEnabled;
	}
	
	

}
