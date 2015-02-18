package com.gstv.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gstv.dto.AlbumsInfo;
import com.gstv.dto.AlbumsInfoWrapper;
import com.gstv.lastfm.pojo.Album;
import com.gstv.lastfm.pojo.AlbumInfo;
import com.gstv.lastfm.pojo.AlbumInfoWrapper;
import com.gstv.lastfm.pojo.Albums;
import com.gstv.lastfm.pojo.AlbumsWrapper;
import com.gstv.service.Artist;
import com.gstv.service.exception.NoArtistFoundException;
import com.gstv.util.GlobalConstants;
import com.gstv.util.UrlUtil;

@Service
public class ArtistImpl implements Artist {
	private static final String ALBUM_GETINFO = "album.getinfo";
	private static final String ARTIST_GETTOPALBUMS = "artist.gettopalbums";

	@Resource
	private RestTemplate restTemplate;

	public AlbumsInfoWrapper getTopAlbums(String artist, int limit) {
		Map<String, String> paramsTopAlbums = new HashMap<String, String>();
		paramsTopAlbums.put(GlobalConstants.ARTIST, artist);
		paramsTopAlbums.put(GlobalConstants.LIMIT, String.valueOf(limit));
		AlbumsWrapper topAlbumsWrapper = restTemplate.getForObject(
				UrlUtil.buildUri(ARTIST_GETTOPALBUMS, paramsTopAlbums),
				AlbumsWrapper.class);
		if(topAlbumsWrapper
				.getTopalbums().getAlbum() == null){
			throw new NoArtistFoundException();
		}
		AlbumsInfoWrapper albumsInfoWrapper = new AlbumsInfoWrapper();
		albumsInfoWrapper.setTopalbums(getAlbumInfo(topAlbumsWrapper
				.getTopalbums()));
		return albumsInfoWrapper;
	}

	private AlbumsInfo getAlbumInfo(Albums albums) {
		AlbumsInfo albumsInfo = new AlbumsInfo();
		Map<String, String> paramsAlbumInfo = new HashMap<String, String>();
		List<AlbumInfo> list = new ArrayList<AlbumInfo>();
		for (Album album : albums.getAlbum()) {
			paramsAlbumInfo.put(GlobalConstants.ALBUM, album.getName());
			paramsAlbumInfo.put(GlobalConstants.ARTIST, album.getArtist()
					.getName());
			AlbumInfoWrapper albumInfoWrapper = restTemplate.getForObject(
					UrlUtil.buildUri(ALBUM_GETINFO, paramsAlbumInfo),
					AlbumInfoWrapper.class);
			list.add(albumInfoWrapper.getAlbum());
		}
		albumsInfo.setAlbumsInfo(list);
		return albumsInfo;
	}

}
