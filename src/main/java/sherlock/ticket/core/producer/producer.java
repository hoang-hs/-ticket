package sherlock.ticket.core.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import sherlock.ticket.core.domain.MessageKafka;

import java.util.Properties;

public class producer {

    static KafkaProducer<String, String> producer = null;
    static ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Value("${kafka.host}")
    static String BOOTSTRAP_SERVERS_CONFIG;

    public static void send(MessageKafka msg) {
        String value;
        value = msg.toString();
        KafkaProducer<String, String> p = getProducer();
        ProducerRecord<String, String> record = new ProducerRecord<>(msg.topic(), 1, "a", value);
        p.send(record);
    }

    private static KafkaProducer<String, String> getProducer() {
        if (producer == null) {
            Properties props = new Properties();
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.24.32.11:9092");
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class.getName());
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            producer = new KafkaProducer<String, String>(props);
        }
        return producer;
    }
}
