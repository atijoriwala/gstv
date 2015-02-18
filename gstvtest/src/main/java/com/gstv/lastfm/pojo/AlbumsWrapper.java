package com.gstv.lastfm.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumsWrapper {
    private Albums topalbums;

	public Albums getTopalbums() {
		return topalbums;
	}

	public void setTopalbums(Albums topalbums) {
		this.topalbums = topalbums;
	}


}
