package br.com.sobreiraromulo.picpay.controller.dtos;

import br.com.sobreiraromulo.picpay.entity.Wallet;
import br.com.sobreiraromulo.picpay.entity.WalletType;

public record CreateWalletDto(String fullName,
                              String cpfCnpj,
                              String email,
                              String password,
                              WalletType.Enum walletTypeId) {

    public Wallet toWallet(){
     return new Wallet(fullName, cpfCnpj, email, password, walletTypeId.get());
    }
} 