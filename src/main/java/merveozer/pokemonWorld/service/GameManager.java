package merveozer.pokemonWorld.service;

import java.util.List;

import org.springframework.stereotype.Service;

import merveozer.pokemonWorld.model.Game;
import merveozer.pokemonWorld.repository.GameRepository;
import merveozer.pokemonWorld.utility.result.DataResult;
import merveozer.pokemonWorld.utility.result.SuccessDataResult;

@Service
public class GameManager implements GameService {
	
	private GameRepository gameRepository;

	public GameManager(GameRepository gameRepository) {
		super();
		this.gameRepository = gameRepository;
	}

	@Override
	public DataResult<List<Game>> findAll() {
		return new SuccessDataResult<List<Game>>
		(this.gameRepository.findAll(), "");
	}

	@Override
	public void addNewGame(String firstPokemon, String secondPokemon, String date) {
		this.gameRepository.addNewGame(firstPokemon, secondPokemon, date);
	}

	@Override
	public void updateWinner(int id, String winner) {
		this.gameRepository.updateWinner(id, winner);
		
	}


}
