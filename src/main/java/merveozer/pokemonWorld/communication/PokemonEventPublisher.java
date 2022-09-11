package merveozer.pokemonWorld.communication;

import merveozer.pokemonWorld.communication.model.EventType;
import merveozer.pokemonWorld.communication.model.KafkaTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class PokemonEventPublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(PokemonEventPublisher.class);

    public PokemonEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEvent(EventType eventType, KafkaTopic kafkaTopic, String message) {
        kafkaTemplate.send(kafkaTopic.name(), message);
        logger.info("A notification was published with this event type: {}", eventType);
    }
}
