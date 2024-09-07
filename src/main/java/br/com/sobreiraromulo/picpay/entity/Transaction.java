package br.com.sobreiraromulo.picpay.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "transactions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
 @Id
 @GeneratedValue(strategy = GenerationType.UUID)
 private UUID id;

 @ManyToOne
 @JoinColumn(name = "wallet_sender_id")
 private Wallet sender;

 @ManyToOne
 @JoinColumn(name = "wallet_receiver_id")
 private Wallet receiver;

 private BigDecimal value;

 public Transaction(Wallet sender, Wallet receiver, BigDecimal value){
  this.sender = sender;
  this.receiver = receiver;
  this.value = value;
 }
 
}
