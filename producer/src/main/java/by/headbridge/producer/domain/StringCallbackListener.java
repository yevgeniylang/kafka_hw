package by.headbridge.producer.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static org.springframework.kafka.listener.ConsumerAwareRebalanceListener.LOGGER;

@Slf4j
public class StringCallbackListener implements ListenableFutureCallback<SendResult<String, String>> {

    @Override
    public void onFailure(Throwable ex) {
        LOGGER.info("Failed: " + ex.getMessage());
    }

    @Override
    public void onSuccess(SendResult<String, String> result) {
        if (result == null || result.getRecordMetadata() == null) {
            throw new RuntimeException("Cannot");
        }
        LOGGER.info("Succees! " + result.getRecordMetadata().topic() + " Offset: " + result.getRecordMetadata().offset());
    }

}
