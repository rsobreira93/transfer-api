package br.com.sobreiraromulo.picpay.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sobreiraromulo.picpay.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID>{
 
}
