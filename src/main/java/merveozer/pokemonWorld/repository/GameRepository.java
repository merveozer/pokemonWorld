package merveozer.pokemonWorld.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import merveozer.pokemonWorld.model.Game;

@Repository
public class GameRepository {
	
	@PersistenceContext
	@Autowired
	public EntityManager entityManager;

	public List<Game> findAll() {

		TypedQuery<Game> query = entityManager.createQuery("SELECT g FROM Game g",
				Game.class);
		return query.getResultList();
	}
	
	@Transactional
	public void addNewGame(String firstPokemon, String secondPokemon, String date) {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO game(first_pokemon, second_pokemon, date, winner) values( '' || :firstPokemon|| '', '' || :secondPokemon|| '', '' || :date|| '', null)");

		entityManager.createNativeQuery(query.toString()).setParameter("firstPokemon", firstPokemon)
				.setParameter("secondPokemon", secondPokemon).setParameter("date", date).executeUpdate();
	}
	
	@Transactional
	public void updateWinner(int id, String winner) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE game SET winner = '' || :winner|| '' WHERE id =:id");

		entityManager.createNativeQuery(query.toString()).setParameter("id", id).setParameter("winner", winner).executeUpdate();
	}
}
