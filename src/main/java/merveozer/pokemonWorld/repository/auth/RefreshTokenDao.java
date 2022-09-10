package merveozer.pokemonWorld.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import merveozer.pokemonWorld.model.auth.RefreshToken;

public interface RefreshTokenDao extends JpaRepository<RefreshToken, Long>{
	
	RefreshToken findByUserId(Long userId);
}
