package sherlock.ticket.present.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sherlock.ticket.core.domain.MessageKafka;

@Service
@Slf4j
public class KafkaController {
    private final KafkaProducer<String, String> producer;
    private static ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Autowired
    public KafkaController(KafkaProducer<String, String> producer) {
        this.producer = producer;
    }

    void send(MessageKafka msg) {
        String value;
        try {
            value = ow.writeValueAsString(msg);
        } catch (JsonProcessingException exp) {
            return;
        }
        ProducerRecord<String, String> record = new ProducerRecord<>(msg.topic(), value);
        producer.send(record);
    }
}
