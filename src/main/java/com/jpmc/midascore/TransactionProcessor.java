package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.UserRepository;
import com.jpmc.midascore.entity.UserRecord;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionProcessor {
    private final UserRepository userRepository;
    public TransactionProcessor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void process(Transaction transaction) {
        UserRecord sender = userRepository.findById(transaction.getSenderId());
        UserRecord recipient = userRepository.findById(transaction.getRecipientId());

        // check if the users exists and sender has enough money 
        if (sender != null && recipient != null && sender.getBalance() >= transaction.getAmount()) {
            
            sender.setBalance(sender.getBalance()-transaction.getAmount());
            recipient.setBalance(recipient.getBalance()+transaction.getAmount());

            // save updates to db
            userRepository.save(sender);
            userRepository.save(recipient);
            
            // System.out.println("Transaction Successful: " + transaction.getAmount() + " moved from " + sender.getName() + " to " + recipient.getName());
            System.out.println(sender.getName() + "now has " + sender.getBalance() + "and" + recipient.getName() +"now has " + recipient.getBalance());
        } 
        else {
            System.out.println("Transaction Rejected: Invalid IDs or Insufficient Funds.");
        }
    }
}