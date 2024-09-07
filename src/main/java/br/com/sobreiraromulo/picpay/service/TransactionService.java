package br.com.sobreiraromulo.picpay.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sobreiraromulo.picpay.controller.dtos.TransactionDto;
import br.com.sobreiraromulo.picpay.entity.Transaction;
import br.com.sobreiraromulo.picpay.entity.Wallet;
import br.com.sobreiraromulo.picpay.exception.WalletNotFoundException;
import br.com.sobreiraromulo.picpay.exception.InsufficientBalanceException;
import br.com.sobreiraromulo.picpay.exception.TransferNotAllowedForWalletTypeException;
import br.com.sobreiraromulo.picpay.exception.TransferNotAuthorizedException;
import br.com.sobreiraromulo.picpay.repository.TransactionRepository;
import br.com.sobreiraromulo.picpay.repository.WalletRepository;
import jakarta.validation.Valid;

@Service
public class TransactionService {

 @Autowired
 private AuthorizationService authorizationService;

 @Autowired
 private NotificationService notificationService;

 @Autowired
 private TransactionRepository transactionRepository;

 @Autowired
 private WalletRepository walletRepository;

 public Transaction transaction(@Valid TransactionDto transactionDto) {

  var sender =  walletRepository.findById(transactionDto.payer())
                   .orElseThrow(() -> new WalletNotFoundException(transactionDto.payer()));

  var receiver = walletRepository.findById(transactionDto.payee())
                   .orElseThrow(() -> new WalletNotFoundException(transactionDto.payee()));

  validateTransfer(transactionDto, sender);

  sender.debit(transactionDto.value());
  receiver.credit(transactionDto.value());

  var transfer = new Transaction(sender, receiver, transactionDto.value());

  walletRepository.save(receiver);
  walletRepository.save(sender);

  var transferResult = transactionRepository.save(transfer);

  CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

  return transferResult;
 }

  private void validateTransfer(TransactionDto transactionDto, Wallet sender) {

        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalancerEqualOrGreatherThan(transactionDto.value())) {
            throw new InsufficientBalanceException();
        }

        if (!authorizationService.isAuthorized(transactionDto)) {
            throw new TransferNotAuthorizedException();
        }

    }
 
}
