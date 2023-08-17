package sherlock.ticket.present.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sherlock.ticket.core.domain.A;

@RestController
@RequestMapping("/")
public class BaseController {

    //    private final KafkaProducer<String, String> producer;
//    private static ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//
//    @Autowired
//    public BaseController(KafkaProducer<String, String> producer) {
//        this.producer = producer;
//    }
    KafkaController k;

    public BaseController(KafkaController c) {
        this.k = c;
    }


    @GetMapping("/ping")
    String Ping() {
        return "pong";
    }

//    @PostMapping("/send")
//    void Producer() {
//        A a = new A();
//        ProducerRecord<String, String> msg = new ProducerRecord<>(a.topic(), Json.ToValue(a));
//        producer.send(msg);
//    }

    //    @PostMapping("/send/b")
//    void ProducerMsg() throws JsonProcessingException {
//        B b = new B(123);
//        String value = ow.writeValueAsString(b);
//        ProducerRecord<String, String> msg = new ProducerRecord<>("ticket", value);
//        producer.send(msg);
//    }
    @PostMapping("/send/c")
    void ProducerMsg() {
        A b = new A();
        k.send(b);
    }
}