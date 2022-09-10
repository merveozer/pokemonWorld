package merveozer.pokemonWorld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import merveozer.pokemonWorld.model.PokemonTrainer;
import merveozer.pokemonWorld.service.PokemonTrainerService;
import merveozer.pokemonWorld.utility.result.DataResult;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080")
public class PokemonTrainerController implements PokemonTrainerService {

	private PokemonTrainerService pokemonTrainerService;
	
	@Autowired
	public PokemonTrainerController(PokemonTrainerService pokemonTrainerService) {
		super();
		this.pokemonTrainerService = pokemonTrainerService;
	}

	@GetMapping("pokemonTrainer")
	@Override
	public DataResult<List<PokemonTrainer>> getAll() {
		return this.pokemonTrainerService.getAll();
	}

}
