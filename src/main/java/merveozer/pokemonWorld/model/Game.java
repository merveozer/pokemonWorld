package merveozer.pokemonWorld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Data
@Table(name = "game")
@AllArgsConstructor
@NoArgsConstructor
public class Game {

	@Id
	@Column(name = "id")
	private int gameId;
	
	@Column(name = "first_pokemon")
	private String firstPokemon;
	
	@Column(name = "second_pokemon")
	private String secondPokemon;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "winner")
	private String winner;
}
