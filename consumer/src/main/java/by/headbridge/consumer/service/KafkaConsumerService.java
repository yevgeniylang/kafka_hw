package by.headbridge.consumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.listener.ConsumerAwareRebalanceListener.LOGGER;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {
    @KafkaListener(topics = "topicKafka")
    public void Lister(String message) {
        LOGGER.info(message);
    }
}