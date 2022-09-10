package merveozer.pokemonWorld.controller.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import merveozer.pokemonWorld.model.auth.User;
import merveozer.pokemonWorld.service.auth.UserService;
import merveozer.pokemonWorld.utility.result.DataResult;


@RestController
@RequestMapping("/users/")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController implements UserService{
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("users")
	@Override
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}

	//refresh tokenda fk önce oradan silmek gerekiyor, şu an bu metot çalışmıyor
	@PostMapping("user")
	@Override
	public void deleteByUserName(String userName) {
		userService.deleteByUserName(userName);
	}


}
