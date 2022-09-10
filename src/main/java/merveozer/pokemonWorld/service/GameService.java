package merveozer.pokemonWorld.service;

import java.util.List;

import merveozer.pokemonWorld.model.Game;
import merveozer.pokemonWorld.utility.result.DataResult;

public interface GameService {

	DataResult<List<Game>> findAll();
	void addNewGame(String firstPokemon, String secondPokemon, String date);
	void updateWinner(int id, String winner);
}
