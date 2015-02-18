package com.gstv.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gstv.lastfm.pojo.AlbumInfo;
import com.gstv.service.exception.NoArtistFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
public class ArtistServiceImplTest {
	
	@Resource
	ArtistImpl artistImpl;
	
	@Test
	public void testGetTopAlbumsForValidArtist(){
		assertNotNull(artistImpl.getTopAlbums("Pink Floyd", 10));
		assertTrue(artistImpl.getTopAlbums("Pink Floyd", 10).getTopalbums().getAlbumsInfo().size()>0);
		for (Iterator<AlbumInfo> it = artistImpl.getTopAlbums("Pink Floyd", 10).getTopalbums().getAlbumsInfo().iterator(); it
				.hasNext();) {
			assertTrue(it.next().getTracks().getTrack().size()>0);
		}
	}
	
	@Test
	public void testGetTopAlbumsForInvalidValidArtist(){
		try{
			artistImpl.getTopAlbums("aba", 10);
			fail("Must throw an exception");
		}catch(NoArtistFoundException na){
			
		}
	}

}
