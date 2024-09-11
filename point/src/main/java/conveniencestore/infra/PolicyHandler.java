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
        condition = "headers['type']=='Refunded'"
    )
    public void wheneverRefunded_PointDecrease(@Payload Refunded refunded) {
        Refunded event = refunded;
        System.out.println(
            "\n\n##### listener PointDecrease : " + refunded + "\n\n"
        );

        // Sample Logic //
        Point.pointDecrease(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_PointIncrease(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener PointIncrease : " + paid + "\n\n"
        );

        // Sample Logic //
        Point.pointIncrease(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
