package merveozer.pokemonWorld.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import merveozer.pokemonWorld.dto.PokemonWithTrainer;
import merveozer.pokemonWorld.model.Pokemon;
import merveozer.pokemonWorld.service.PokemonService;
import merveozer.pokemonWorld.utility.result.DataResult;
import merveozer.pokemonWorld.utility.result.Result;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080")
public class PokemonController implements PokemonService {

	private PokemonService pokemonService;
	
	@Autowired
	public PokemonController(PokemonService pokemonService) {
		super();
		this.pokemonService = pokemonService;
	}

	@GetMapping("pokemon")
	@Override
	public DataResult<List<Pokemon>> getAll() {
		return this.pokemonService.getAll();
	}

	@PostMapping("pokemon")
	@Override
	public Result add(@RequestBody Pokemon pokemon) throws Exception {
		return this.pokemonService.add(pokemon);
	}

	@DeleteMapping("pokemon")
	@Override
	public Result delete(int pokemon_id) {
		return this.pokemonService.delete(pokemon_id);
	}

	@PatchMapping("description/{pokemon_id}")
	@Override
	public Result updatePower(@PathVariable("pokemon_id") int pokemon_id, @RequestBody Map<String, Object> data) {
		return this.pokemonService.updatePower(pokemon_id, data);
	}

	@PatchMapping("trainer")
	@Override
	public Result updatePokemonTrainer(@RequestBody int pokemon_id, @RequestBody int trainer_id) {
		//System.out.print(pokemon_id + "and " + trainer_id);
		return this.pokemonService.updatePokemonTrainer(pokemon_id, trainer_id);
	}

	@GetMapping("pokemonsAndTrainers")
	@Override
	public DataResult<List<PokemonWithTrainer>> getPokemonWithTrainer() {
		return this.pokemonService.getPokemonWithTrainer();
	}

	@GetMapping("powerestFivePokemon")
	@Override
	public DataResult<List<Pokemon>> getPowerestFivePokemon() {
		return this.pokemonService.getPowerestFivePokemon();
	}

}
