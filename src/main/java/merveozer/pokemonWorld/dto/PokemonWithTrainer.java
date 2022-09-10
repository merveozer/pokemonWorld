package merveozer.pokemonWorld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonWithTrainer {

	private int pokemonId;
	private String pokemonName;
	private int power;
	private String category;
	private String trainerName;
}
