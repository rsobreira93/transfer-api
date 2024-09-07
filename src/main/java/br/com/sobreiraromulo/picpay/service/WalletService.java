package br.com.sobreiraromulo.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sobreiraromulo.picpay.controller.dtos.CreateWalletDto;
import br.com.sobreiraromulo.picpay.entity.Wallet;
import br.com.sobreiraromulo.picpay.exception.WalletDataAlreadyExistsException;
import br.com.sobreiraromulo.picpay.repository.WalletRepository;

@Service
public class WalletService {

 @Autowired
 private WalletRepository walletRepository;

 public Wallet createWallet(CreateWalletDto createWalletDto) {
  var walletAlreadyExists = walletRepository.findBycpfCnpjOrEmail(createWalletDto.cpfCnpj(), createWalletDto.email());

  if(walletAlreadyExists.isPresent()){
    throw new WalletDataAlreadyExistsException("cpfCnpj or email alreadyExists.");
  }

  return walletRepository.save(createWalletDto.toWallet());
 }
 
}
