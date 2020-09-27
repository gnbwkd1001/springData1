package com.david.lookify.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll(Sort sort);
	
	List<Song> findAll();
	
	void deleteById(Long id);
	
	List<Song> findAllByArtist(String search);
	
	List<Song> findTop5ByOrderByRatingDesc(); 
	
}	
