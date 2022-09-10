package merveozer.pokemonWorld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import merveozer.pokemonWorld.model.PokemonTrainer;

public interface PokemonTrainerRepository extends JpaRepository<PokemonTrainer, Integer> {

	PokemonTrainer findById(int trainer_id);
}
