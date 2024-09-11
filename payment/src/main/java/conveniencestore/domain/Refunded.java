package conveniencestore.domain;

import conveniencestore.domain.*;
import conveniencestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Refunded extends AbstractEvent {

    private Long id;

    public Refunded(Payment aggregate) {
        super(aggregate);
    }

    public Refunded() {
        super();
    }
}
//>>> DDD / Domain Event
