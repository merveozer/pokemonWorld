package merveozer.pokemonWorld.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pokemon_trainer")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","pokemon"})
public class PokemonTrainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trainer_id")
	private int trainerId;
	
	@Column(name = "name")
	private String trainerName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "degree")
	private int degree;
	
	@OneToMany(mappedBy = "trainer")
	private List<Pokemon> pokemon;
}
