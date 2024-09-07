package br.com.sobreiraromulo.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sobreiraromulo.picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long>{
 
}
