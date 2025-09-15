package org.api.friend.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerKafka {

   /* @KafkaListener(topics = "your_topic_name", groupId = "your_group_id")
    public void listen(String message) {
        log.info("Received Message: " + message);
    }*/
}
