package br.com.sobreiraromulo.picpay.controller.dtos;

import br.com.sobreiraromulo.picpay.entity.Wallet;
import br.com.sobreiraromulo.picpay.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(@NotBlank String fullName,
                             @NotBlank String cpfCnpj,
                             @NotBlank String email,
                             @NotBlank String password,
                             @NotNull WalletType.Enum walletTypeId) {

    public Wallet toWallet(){
     return new Wallet(fullName, cpfCnpj, email, password, walletTypeId.get());
    }
} 