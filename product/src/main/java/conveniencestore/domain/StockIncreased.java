package conveniencestore.domain;

import conveniencestore.domain.*;
import conveniencestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;

    public StockIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
