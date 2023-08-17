package sherlock.ticket.present.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sherlock.ticket.core.domain.A;
import sherlock.ticket.core.producer.producer;

@RestController
@RequestMapping("/")
public class TestController {


    @PostMapping("/send/a")
    void Producer() {
//        A a = new A();
//        producer.send(a);
    }
}
