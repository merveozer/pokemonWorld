package merveozer.pokemonWorld.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PokemonConsumer {
    private final Logger logger = LoggerFactory.getLogger(PokemonConsumer.class);
    @KafkaListener(topics = "POKEMON_ADDED", groupId = "group-id")
    public void consume(String message){
        logger.info(message);
    }
}
