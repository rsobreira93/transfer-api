package br.com.sobreiraromulo.picpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.sobreiraromulo.picpay.controller.dtos.CreateWalletDto;
import br.com.sobreiraromulo.picpay.entity.Wallet;
import br.com.sobreiraromulo.picpay.service.WalletService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletController {
 
 @Autowired
 private WalletService walletService;



 @PostMapping("/wallets")
 public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto createWalletDto) {
     var wallet = walletService.createWallet(createWalletDto);  

     return ResponseEntity.ok(wallet);
 }
 
}
