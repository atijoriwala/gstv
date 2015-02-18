package com.gstv.lastfm.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
	@JsonProperty("#text")
	private String text;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	private String size;

}
