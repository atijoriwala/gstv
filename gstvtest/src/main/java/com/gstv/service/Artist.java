package com.gstv.service;

import com.gstv.dto.AlbumsInfoWrapper;

/**
 * This interface represents API methods relating to artists.
 *  @author Alok
 */

public interface Artist {
	/**
	 * 
	 * @param artist - Artist
	 * @param limit - Number of Albums to return
	 * @return - Top Albums
	 * 
	 * Gets top albums for an artist ordered by popularity and individual tracks for each album.
	 */
	public AlbumsInfoWrapper getTopAlbums(String artist, int limit); 
}
