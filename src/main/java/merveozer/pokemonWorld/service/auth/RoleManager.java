package merveozer.pokemonWorld.service.auth;

import org.springframework.stereotype.Service;

import merveozer.pokemonWorld.model.auth.Role;
import merveozer.pokemonWorld.repository.auth.RoleDao;



@Service
public class RoleManager implements RoleService{
	
	private RoleDao roleDao;
	

	public RoleManager(RoleDao roleDao) {
		super();
		this.roleDao = roleDao;
	}


	public Iterable<Role> getAll() {
		return roleDao.findAll();
	}
	

	
}
