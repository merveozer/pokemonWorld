package merveozer.pokemonWorld.security.request;

import lombok.Data;

@Data
public class RefreshRequest {
	Long userId;
	String refreshToken;
}

