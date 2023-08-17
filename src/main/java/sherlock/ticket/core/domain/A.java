package sherlock.ticket.core.domain;

import lombok.Data;

@Data
public class A implements MessageKafka {
    private int a;

    public A() {
        this.a = 10;
    }

    public String topic() {
        return "ticket";
    }

    public int getA() {
        return a;
    }


}
