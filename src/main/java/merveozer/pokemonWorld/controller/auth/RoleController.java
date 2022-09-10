package merveozer.pokemonWorld.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import merveozer.pokemonWorld.model.auth.Role;
import merveozer.pokemonWorld.service.auth.RoleService;


@RestController
@RequestMapping("/roles/")
@CrossOrigin(origins = "http://localhost:8080")
public class RoleController implements RoleService {
	
	private RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}


	@GetMapping("roles")
	@Override
	public Iterable<Role> getAll() {
		return this.roleService.getAll();
	}

}
