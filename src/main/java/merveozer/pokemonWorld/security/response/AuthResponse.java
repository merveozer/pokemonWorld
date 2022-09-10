package merveozer.pokemonWorld.security.response;

import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthResponse {
	
	String message;
	Long userId;
	String accessToken;
	String refreshToken;
	Set role;
}
