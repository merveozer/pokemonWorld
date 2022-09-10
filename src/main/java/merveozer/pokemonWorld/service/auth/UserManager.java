package merveozer.pokemonWorld.service.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import merveozer.pokemonWorld.model.auth.User;
import merveozer.pokemonWorld.repository.auth.UserDao;
import merveozer.pokemonWorld.utility.result.DataResult;
import merveozer.pokemonWorld.utility.result.SuccessDataResult;


@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public User saveOneUser(User newUser) {
		return userDao.save(newUser);
	}

	public User getOneUserById(Long userId) {
		return userDao.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = userDao.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			foundUser.setEMail(newUser.getEMail());
			userDao.save(foundUser);
			return foundUser;
		}else
			return null;
	}

	public User getOneUserByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(), "Users are listed");
	}

	
	public void deleteByUserName(String userName) {
		userDao.deleteByUserName(userName);
	}
	
}
