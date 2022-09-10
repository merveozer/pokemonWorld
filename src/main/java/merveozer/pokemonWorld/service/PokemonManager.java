package merveozer.pokemonWorld.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import merveozer.pokemonWorld.dto.PokemonWithTrainer;
import merveozer.pokemonWorld.model.Pokemon;
import merveozer.pokemonWorld.model.PokemonTrainer;
import merveozer.pokemonWorld.repository.PokemonRepository;
import merveozer.pokemonWorld.repository.PokemonTrainerRepository;
import merveozer.pokemonWorld.utility.result.DataResult;
import merveozer.pokemonWorld.utility.result.Result;
import merveozer.pokemonWorld.utility.result.SuccessDataResult;
import merveozer.pokemonWorld.utility.result.SuccessResult;

@Service
public class PokemonManager implements PokemonService {

	private PokemonRepository pokemonRepository;
	private PokemonTrainerRepository pokemonTrainerRepository;
	
	@Autowired
	public PokemonManager(PokemonRepository pokemonRepository, PokemonTrainerRepository pokemonTrainerRepository) {
		super();
		this.pokemonRepository = pokemonRepository;
		this.pokemonTrainerRepository = pokemonTrainerRepository;
	}

	@Override
	public DataResult<List<Pokemon>> getAll() {
		return new SuccessDataResult<List<Pokemon>>
		(this.pokemonRepository.findAll(), "Pokemons are listed...");
	}

	@Override
	public Result add(Pokemon pokemon) {
		this.pokemonRepository.save(pokemon);
		return new SuccessResult("Pokemon is added.");
	}

	@Override
	public Result delete(int pokemon_id) {
		this.pokemonRepository.deleteById(pokemon_id);
		return new SuccessResult("Pokemon is deleted.");
	}

	@Override
	public Result updatePower(int pokemon_id, Map<String, Object> data) {
		Pokemon pokemon = pokemonRepository.findById(pokemon_id);
		String newDescription = (String) data.get("description");
		pokemon.setDescription(newDescription);
		pokemonRepository.save(pokemon);
		return new SuccessResult("Description is updated");
	}

	@Override
	public Result updatePokemonTrainer(int pokemon_id, int trainer_id) {
		Pokemon pokemon = pokemonRepository.findById(pokemon_id);
		PokemonTrainer newPokemonTrainer = pokemonTrainerRepository.findById(trainer_id);
		
		pokemon.setTrainer(newPokemonTrainer);
		pokemonRepository.save(pokemon);
		return new SuccessResult("Trainer is updated");
	}

	@Override
	public DataResult<List<PokemonWithTrainer>> getPokemonWithTrainer() {
		return new SuccessDataResult<List<PokemonWithTrainer>>
		(this.pokemonRepository.getPokemonWithOwnerName(), "Pokemon and their trainer names are listed.");
	}

	@Override
	public DataResult<List<Pokemon>> getPowerestFivePokemon() {
		return new SuccessDataResult<List<Pokemon>>
		(this.pokemonRepository.getPowerestFivePokemon(), "");
	}



}
