package merveozer.pokemonWorld.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pokemon")
@AllArgsConstructor
@NoArgsConstructor

public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pokemon_id")
	private int pokemonId;
	
	@Column(name = "name")
	private String pokemonName;
	
	@Column(name = "power")
	private int power;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne()
	@JoinColumn(name = "trainer_id")
	@JsonIgnore
	private PokemonTrainer trainer;
}
