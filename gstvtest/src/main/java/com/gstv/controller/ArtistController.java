package com.gstv.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gstv.dto.AlbumsInfoWrapper;
import com.gstv.service.Artist;
import com.gstv.service.exception.NoArtistFoundException;
import com.gstv.util.GlobalConstants;

@Controller
@RequestMapping("/album")
public class ArtistController {	
	private static final String UNKNOWN_ERROR = "Unknown Error";
	private static final String LIMIT_MUST_BE_NUMERIC = "Limit must be numeric";
	private static final String ARTIST_NOT_FOUND = "Artist Not Found";
	private static final String _12 = "12";
	private static final String _11 = "11";
	private static final String _10 = "10";
	@Resource
	private Artist artistImpl;
	
	@RequestMapping(value = "/topalbums", method = RequestMethod.GET)
	public @ResponseBody AlbumsInfoWrapper getTopAlbums(@RequestParam(GlobalConstants.ARTIST) String artist, @RequestParam(GlobalConstants.LIMIT) String limit) {
		 try {
			return artistImpl.getTopAlbums(artist, Integer.valueOf(limit));
		}catch(NoArtistFoundException e){
			return buildResult(_10,ARTIST_NOT_FOUND);			
		}
		 catch (NumberFormatException e) {
			 return buildResult(_11,LIMIT_MUST_BE_NUMERIC);
		}catch(RuntimeException e){
			return buildResult(_12,UNKNOWN_ERROR);
		}
	}

	private AlbumsInfoWrapper buildResult(String errorCode, String errorMessage) {
		AlbumsInfoWrapper albumsInfoWrapper = new AlbumsInfoWrapper();
		albumsInfoWrapper.setErrorCode(errorCode);
		albumsInfoWrapper.setErrorMessage(errorMessage);
		return albumsInfoWrapper;
	}

}
