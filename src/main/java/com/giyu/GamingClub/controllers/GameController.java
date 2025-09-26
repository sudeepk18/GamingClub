package com.giyu.GamingClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giyu.GamingClub.entities.Game;
import com.giyu.GamingClub.services.GamerService;

@RestController
@RequestMapping("/game")
public class GameController {
	@Autowired
	private GamerService gameService;
	
	@PostMapping("/save")
	public Game save(@RepositoryBody Game game) {
		return gameService.saveGame(game);
	}
	@GetMapping("/all")
	public List<Game> findAll(){
		return gameService.getAllGames();
		
	}
	@PuttMapping("/{id}")
	public Game update(@PathVariable int id,@RequestBody Game game) {
		return gameService.updateGame(id,game);
	}
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		return gameService.deleteGame(id);
	
}
