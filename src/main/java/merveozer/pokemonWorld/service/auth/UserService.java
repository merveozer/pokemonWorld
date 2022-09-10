package merveozer.pokemonWorld.service.auth;

import java.util.List;

import merveozer.pokemonWorld.model.auth.User;
import merveozer.pokemonWorld.utility.result.DataResult;

public interface UserService {
	
	DataResult<List<User>> getAll();
	void deleteByUserName(String userName);
}
