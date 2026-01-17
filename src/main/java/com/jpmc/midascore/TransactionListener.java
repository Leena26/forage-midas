package com.jpmc.midascore;
import com.jpmc.midascore.foundation.Transaction;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

@Component
public class TransactionListener {
//    private static final Logger logger = LoggerFactory.getLogger(TransactionListener.class);
    private int count = 0;

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(Transaction transaction) {
        if (count < 4) {
            System.out.println("----------------------------------------------------------");
            System.out.println("TRANSACTION " + (count + 1) + " DATA: " + transaction);
            System.out.println("----------------------------------------------------------");
            count++;
        }
    }


}
