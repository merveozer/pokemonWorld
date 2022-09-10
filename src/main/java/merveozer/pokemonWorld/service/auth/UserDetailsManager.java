package merveozer.pokemonWorld.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import merveozer.pokemonWorld.model.auth.User;
import merveozer.pokemonWorld.repository.auth.UserDao;
import merveozer.pokemonWorld.security.JwtUserDetails;


@Service
public class UserDetailsManager implements UserDetailsService {

	private UserDao userDao;
	
	
	public UserDetailsManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUserName(username);
		return JwtUserDetails.create(user);
	}
	
	public UserDetails loadUserById(Long id) {
		User user = userDao.findById(id).get();
		return JwtUserDetails.create(user);
	}

}
