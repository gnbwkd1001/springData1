package com.david.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.lookify.models.Song;
import com.david.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs(){
		System.out.println("service listening!");
		return songRepository.findAll();
	}
	
	public Song createSong(Song s) {
		return songRepository.save(s);
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
	
	public List<Song> top5Songs(){
//		List<Song> topSongs = songRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"));
		List<Song> topSongs = songRepository.findTop5ByOrderByRatingDesc();
		
		return topSongs;
	}
	
	public List<Song> findArtist(String search) {
        List<Song> optionalSong = songRepository.findAllByArtist(search);
        return optionalSong;
    }
}
