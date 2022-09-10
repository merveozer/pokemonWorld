package merveozer.pokemonWorld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import merveozer.pokemonWorld.model.PokemonTrainer;
import merveozer.pokemonWorld.repository.PokemonTrainerRepository;
import merveozer.pokemonWorld.utility.result.DataResult;
import merveozer.pokemonWorld.utility.result.SuccessDataResult;

@Service
public class PokemonTrainerManager implements PokemonTrainerService {

	private PokemonTrainerRepository pokemonTrainerRepository;
	
	@Autowired
	public PokemonTrainerManager(PokemonTrainerRepository pokemonTrainerRepository) {
		super();
		this.pokemonTrainerRepository = pokemonTrainerRepository;
	}

	@Override
	public DataResult<List<PokemonTrainer>> getAll() {
		return new SuccessDataResult<List<PokemonTrainer>>
		(this.pokemonTrainerRepository.findAll(), "Pokemon trainers are listed.");
	}

}
