package br.com.sobreiraromulo.picpay.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "wallets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String fulName;

 @Column(unique = true)
 private String cpfCnpj;

 @Column(unique = true)
 private String email;

 private String password;

 private BigDecimal balance = BigDecimal.ZERO;

 @JoinColumn(name = "wallet_type_id")
 @ManyToOne
 private WalletType walletTypeId;


 public Wallet(String fullName, String cpfCnpj, String email, String password, WalletType walletTypeId){
  this.fulName = fullName;
  this.cpfCnpj = cpfCnpj;
  this.email = email;
  this.password = password;
  this.walletTypeId = walletTypeId;
 }

}
