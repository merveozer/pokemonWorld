package merveozer.pokemonWorld.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import merveozer.pokemonWorld.model.Game;
import merveozer.pokemonWorld.service.GameService;
import merveozer.pokemonWorld.utility.result.DataResult;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080")
public class GameController implements GameService {

	private GameService gameService;
	
	public GameController(GameService gameService) {
		super();
		this.gameService = gameService;
	}

	@Override
	@GetMapping("game")
	public DataResult<List<Game>> findAll() {
		return this.gameService.findAll();
	}

	@Override
	@PostMapping("game")
	public void addNewGame(String firstPokemon, String secondPokemon, String date) {
		this.gameService.addNewGame(firstPokemon, secondPokemon, date);

	}

	@Override
	@PatchMapping("updateWinner")
	public void updateWinner(int id, String winner) {
		this.gameService.updateWinner(id, winner);
		
	}

}
