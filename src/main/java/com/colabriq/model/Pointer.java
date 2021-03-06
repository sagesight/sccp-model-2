package com.colabriq.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Pointer {
	@Expose
	@SerializedName("container_key")
	private String containerKey;
	
	@Expose
	@SerializedName("container_location")
	private String containerLocation;
	
	@Expose
	@SerializedName("nonce")
	private long nonce;
	
	public Pointer() {
	}
	
	public Pointer(String containerKey, String containerLocation, long nonce) {
		this.containerKey = containerKey;
		this.containerLocation = containerLocation;
		this.nonce = nonce;
	}
	
	public String getContainerKey() {
		return containerKey;
	}
	
	public String getContainerLocation() {
		return containerLocation;
	}
	
	public long getNonce() {
		return nonce;
	}
	
	@Override
	public int hashCode() {
		return containerLocation.hashCode() ^ containerKey.hashCode() ^ Long.hashCode(nonce);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o instanceof Pointer) {
			var p = (Pointer)o;
			return containerLocation.equals(p.containerLocation) && containerKey.equals(p.containerKey) && (nonce == p.nonce);
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Pointer(" + containerLocation + ")";
	}
}
