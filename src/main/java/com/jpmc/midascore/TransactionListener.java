package com.jpmc.midascore;
import com.jpmc.midascore.foundation.Transaction;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
// import org.springframework.messaging.handler.annotation.Payload;

@Component
public class TransactionListener {
//    private static final Logger logger = LoggerFactory.getLogger(TransactionListener.class);
    private final TransactionProcessor transactionProcessor;
    public TransactionListener(TransactionProcessor transactionProcessor){
        this.transactionProcessor = transactionProcessor;
    }

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(Transaction transaction) {
        transactionProcessor.process(transaction);
    }


}
