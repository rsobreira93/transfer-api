package br.com.sobreiraromulo.picpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sobreiraromulo.picpay.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

 Optional<Wallet> findBycpfCnpjOrEmail(String cpfCnpj, String email);
 
}
