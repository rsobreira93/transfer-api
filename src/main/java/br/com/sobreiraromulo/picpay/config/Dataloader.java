package br.com.sobreiraromulo.picpay.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.sobreiraromulo.picpay.entity.WalletType;
import br.com.sobreiraromulo.picpay.repository.WalletTypeRepository;

@Configuration
public class Dataloader implements CommandLineRunner {

 
 private final WalletTypeRepository walletTypeRepository;

 public Dataloader(WalletTypeRepository walletTypeRepository){
  this.walletTypeRepository = walletTypeRepository;
 }


 @Override
 public void run(String... args) throws Exception {
  Arrays.stream(WalletType.Enum.values())
  .forEach(walletType -> walletTypeRepository.save(walletType.get()));
 }
 
}
