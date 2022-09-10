package merveozer.pokemonWorld.service;

import java.util.List;

import merveozer.pokemonWorld.model.PokemonTrainer;
import merveozer.pokemonWorld.utility.result.DataResult;

public interface PokemonTrainerService {

	DataResult<List<PokemonTrainer>> getAll();
}
