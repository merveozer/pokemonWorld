package merveozer.pokemonWorld.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import merveozer.pokemonWorld.model.auth.UsersRoles;

public interface UsersRolesDao extends JpaRepository<UsersRoles, Long> {
	 
}