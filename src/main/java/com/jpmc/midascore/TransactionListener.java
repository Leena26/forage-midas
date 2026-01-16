package com.jpmc.midascore;
// import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
// import org.springframework.messaging.handler.annotation.Payload;

@Component
public class TransactionListener {
    private int count = 0;
    @Value("${general.kafka-topic}")
    private String topicName;


    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-group")
    public void listen(String message) {
        System.out.println("Raw message: " + message);
    }
    // public void listen(@Payload Transaction transaction){
    //     if (count < 4) {                // only for the first 4
    //         System.out.println("Transaction " + (count + 1) + ": " + transaction.getAmount());
    //         count++;
    //     }
    //     // System.out.println("Recieved transaction: " + transaction);
    // }

}
