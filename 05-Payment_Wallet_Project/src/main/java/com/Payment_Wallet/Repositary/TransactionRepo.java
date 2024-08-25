package com.Payment_Wallet.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Payment_Wallet.Model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
