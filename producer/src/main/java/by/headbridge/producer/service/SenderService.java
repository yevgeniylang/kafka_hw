package by.headbridge.producer.service;

import by.headbridge.producer.config.KafkaConfig;
import by.headbridge.producer.domain.StringCallbackListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.listener.ConsumerAwareRebalanceListener.LOGGER;

@Service
@RequiredArgsConstructor
@Slf4j
public class SenderService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final StringCallbackListener stringCallbackListener;

    public void sendMessage(String message) {
        val parts = message.split(";");

        String key = null;
        String value;

        if (parts.length > 1) {
            key = parts[0];
            value = parts[1];
        } else {
            value = message;
        }

        LOGGER.info("" + kafkaTemplate);
        LOGGER.info("" + stringCallbackListener);

        LOGGER.info("Key: " + key);
        val future = kafkaTemplate.send(KafkaConfig.TOPIC_NAME, key, value);
    }

}
