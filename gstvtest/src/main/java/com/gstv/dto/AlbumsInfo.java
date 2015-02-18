package com.gstv.dto;

import java.util.Collection;

import com.gstv.lastfm.pojo.AlbumInfo;

public class AlbumsInfo  {
	private Collection<AlbumInfo> albumsinfo;

	public Collection<AlbumInfo> getAlbumsInfo() {
		return albumsinfo;
	}

	public void setAlbumsInfo(Collection<AlbumInfo> albumsInfo) {
		this.albumsinfo = albumsInfo;
	}
}
