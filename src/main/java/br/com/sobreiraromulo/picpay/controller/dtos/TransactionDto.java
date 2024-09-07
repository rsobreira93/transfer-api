package br.com.sobreiraromulo.picpay.controller.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record TransactionDto(@DecimalMin("0.1") @NotNull BigDecimal value,
                            @NotNull Long payer,
                            @NotNull Long payee) {
 
}
