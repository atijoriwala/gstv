package com.gstv.lastfm.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author Alok Tijoriwala 
 * AlbumInfo Bean 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumInfo extends MusicItem {
	private String artist;
	private TrackWrapper tracks;

	public TrackWrapper getTracks() {
		return tracks;
	}

	public void setTracks(TrackWrapper tracks) {
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

}
