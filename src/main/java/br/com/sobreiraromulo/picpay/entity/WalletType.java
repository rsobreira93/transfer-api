package br.com.sobreiraromulo.picpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "wallet_types")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletType {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String description;

 public enum Enum {

  USER(1L, "USER"),
  MERCHANT(2L, "MERCHANT");

  Enum(Long id, String description){
   this.id = id;
   this.description = description;
  }

  private Long id;
  private String description;

  public WalletType get(){
   return new WalletType(id, description);
  }
 }
}
