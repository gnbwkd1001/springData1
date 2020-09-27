package com.david.lookify.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.david.lookify.models.Song;
import com.david.lookify.services.SongService;

@Controller
public class LookifyController {
	
	private final SongService songService;
	
	public LookifyController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String main() {
		return "main.jsp";
	}
	
	@RequestMapping("/lookifyMain")
	public String lookifyMain(Model model) {
		List<Song> allSongs = songService.allSongs();
		model.addAttribute("songs", allSongs);
		return "lookifyMain.jsp";
	}
	
	@RequestMapping(value="/addNewSong", method=RequestMethod.POST)
	public String addNewSong(@RequestParam(value="title") String title,@RequestParam(value="artist") String artist,@RequestParam(value="rating") Integer rating) {
		System.out.println("api listening!");
		Song song = new Song(title, artist, rating);
		System.out.println("setting song info!");
		songService.createSong(song);
		System.out.println("passing song info to songService!");
		return "redirect:/lookifyMain";
	}
	
	@RequestMapping("/addNew")
	public String addNewSong() {
		return "addNew.jsp";
	}
	
	@RequestMapping("/song/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/lookifyMain";
	}
	
	@RequestMapping("/song/show/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "showSong.jsp";
	}
	
	@RequestMapping("/lookify/search")
	public String searchArtist(@RequestParam(value="searchArtist") String searchArtist, Model model) {
		List<Song> artist = songService.findArtist(searchArtist);
		model.addAttribute("artistInfo", artist);
		model.addAttribute("searchArtist", searchArtist);
		
		return "artist.jsp";
	}
	
	@RequestMapping("/tops")
	public String topSongs(Model model) {
		List<Song> topSongs = songService.top5Songs();
		model.addAttribute("topSongs", topSongs);
		return "topSongs.jsp";
	}
}
