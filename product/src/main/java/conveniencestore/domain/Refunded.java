package conveniencestore.domain;

import conveniencestore.domain.*;
import conveniencestore.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Refunded extends AbstractEvent {

    private Long id;
}
