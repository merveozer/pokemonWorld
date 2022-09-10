package merveozer.pokemonWorld.repository.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import merveozer.pokemonWorld.model.auth.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

}
