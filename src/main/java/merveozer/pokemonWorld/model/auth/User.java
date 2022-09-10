package merveozer.pokemonWorld.model.auth;

import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
@Data
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	Long id;
	@Column(name = "user_name")
	String userName;
	
	@Column(name = "user_password")
	String password;
	
	@Column(name = "user_email")
	String eMail;

	  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "users_roles",
	            joinColumns = {
	                    @JoinColumn(name = "user_id")
	            },
	            inverseJoinColumns = {
	                    @JoinColumn(name = "role_id")
	            }
	    )
	    private Set<Role> role;
	
}
