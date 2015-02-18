package com.gstv.lastfm.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Streamable {
	@JsonProperty("#text")
	private String text;
	private String fulltrack;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFulltrack() {
		return fulltrack;
	}
	public void setFulltrack(String fulltrack) {
		this.fulltrack = fulltrack;
	}
}
