package conveniencestore.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import conveniencestore.config.kafka.KafkaProcessor;
import conveniencestore.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_StockDecrease(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener StockDecrease : " + paid + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Refunded'"
    )
    public void wheneverRefunded_StockIncrease(@Payload Refunded refunded) {
        Refunded event = refunded;
        System.out.println(
            "\n\n##### listener StockIncrease : " + refunded + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
