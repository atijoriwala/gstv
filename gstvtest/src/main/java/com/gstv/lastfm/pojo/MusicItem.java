package com.gstv.lastfm.pojo;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class MusicItem {
	protected String name;
	protected String mbid;
	protected Collection<Image> image;
	protected int listeners;
	@JsonProperty("@attr")
	protected Rank rank;
	private int playcount;
	protected String url;
	
	public Collection<Image> getImage() {
		return image;
	}
	public void setImage(Collection<Image> image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMbid() {
		return mbid;
	}
	public void setMbid(String mbid) {
		this.mbid = mbid;
	}
	public int getListeners() {
		return listeners;
	}
	public void setListeners(int listeners) {
		this.listeners = listeners;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPlaycount() {
		return playcount;
	}
	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}
}
