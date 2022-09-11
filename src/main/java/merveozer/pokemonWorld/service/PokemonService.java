package merveozer.pokemonWorld.service;

import java.util.List;
import java.util.Map;

import merveozer.pokemonWorld.dto.PokemonWithTrainer;
import merveozer.pokemonWorld.model.Pokemon;
import merveozer.pokemonWorld.utility.result.DataResult;
import merveozer.pokemonWorld.utility.result.Result;

public interface PokemonService {

	DataResult<List<Pokemon>> getAll();
	Result add(Pokemon pokemon) throws Exception;
	Result delete(int pokemon_id);
	Result updatePower(int pokemon_id, Map<String, Object> data);
	Result updatePokemonTrainer(int pokemon_id, int trainer_id);
	DataResult<List<PokemonWithTrainer>> getPokemonWithTrainer();
	DataResult<List<Pokemon>> getPowerestFivePokemon();
}
