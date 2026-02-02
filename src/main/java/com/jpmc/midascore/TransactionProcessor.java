package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.UserRepository;
import com.jpmc.midascore.entity.UserRecord;
import org.springframework.stereotype.Component;

@Component
public class TransactionProcessor {
    private final UserRepository userRepository;

    // We inject the Repository here so the Processor can talk to the database
    public TransactionProcessor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void process(Transaction transaction) {

    }
}