package br.com.sobreiraromulo.picpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.sobreiraromulo.picpay.controller.dtos.TransactionDto;
import br.com.sobreiraromulo.picpay.entity.Transaction;
import br.com.sobreiraromulo.picpay.service.TransactionService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TransactionController {

 @Autowired
 private TransactionService transactionService;

 @PostMapping("/transfer")
 public ResponseEntity<Transaction> transfer(@RequestBody @Valid TransactionDto transactionDto) {

     var resp = transactionService.transaction(transactionDto);

     return ResponseEntity.ok(resp);
 }
 
}
