package com.abc.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.bankapp.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
