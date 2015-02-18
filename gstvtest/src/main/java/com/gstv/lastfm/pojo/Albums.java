package com.gstv.lastfm.pojo;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Albums {
    private Collection<Album> album;

	public Collection<Album> getAlbum() {
		return album;
	}

	public void setAlbum(Collection<Album> album) {
		this.album = album;
	}


}
