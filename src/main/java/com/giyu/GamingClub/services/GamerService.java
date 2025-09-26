package com.giyu.GamingClub.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giyu.GamingClub.entities.Game;
import com.giyu.GamingClub.repository.GameRepository;

@Service
public class GamerService {
	@Autowired
	private GameRepository gameRepository;
	
	public Game saveGame(Game game) {
		return gameRepository.save(game);
	}
	public boolean deleteGame(int id) {
		Optional<Game> existingGame = gameRepository.findById(id);
		if(existingGame.isPresent()) {
			gameRepository.deleteById(id);
			return true;
		}
		return false;
	}
	public Game updateGame(int id) {
		Optional<Game> existingGame=gameRepository.findById(id);
		if(existingGame.isPresent()) {
			Game OldGame = existingGame.get();
			OldGame.setName(game.getName());
			OldGame.setDescription(game.getDescription());
			OldGame.setAmount(game.getAmount());
			OldGame.setStatus(game.getStatus());
			return gameRepository.save(OldGame);
		}
		return null;
	}
	}
}
