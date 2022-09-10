package merveozer.pokemonWorld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import merveozer.pokemonWorld.dto.PokemonWithTrainer;
import merveozer.pokemonWorld.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
	
	Pokemon findById(int pokemon_id);
	
	 @Query("SELECT new merveozer.pokemonWorld.dto.PokemonWithTrainer"
		  		+ "(p.pokemonId, p.pokemonName, p.power, p.category, t.trainerName) "
		  		+ "FROM PokemonTrainer t Inner Join t.pokemon p")
	 List<PokemonWithTrainer> getPokemonWithOwnerName();
	 
	 @Query(nativeQuery = true, value = "SELECT * FROM Pokemon ORDER BY power DESC LIMIT 5 ")
	 List<Pokemon> getPowerestFivePokemon();
}