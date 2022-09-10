package merveozer.pokemonWorld.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import merveozer.pokemonWorld.model.auth.User;



@Repository
public interface UserDao extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	
	
	//önce refresh token tablosundan silmek gerektiği için şu anda bu metot çalışmıyor..
	@Query("delete from User u where u.userName = :userName")
	@Modifying
	@Transactional
	void deleteByUserName(String userName);
}
