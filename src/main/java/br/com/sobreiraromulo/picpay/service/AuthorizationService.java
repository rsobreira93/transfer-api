package br.com.sobreiraromulo.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sobreiraromulo.picpay.client.AuthorizationClient;
import br.com.sobreiraromulo.picpay.controller.dtos.TransactionDto;
import br.com.sobreiraromulo.picpay.entity.Transaction;
import br.com.sobreiraromulo.picpay.exception.PicPayException;


@Service
public class AuthorizationService {
 
 @Autowired
 private AuthorizationClient authorizationClient;

 public boolean isAuthorized(TransactionDto transactionDto) {

  var resp = authorizationClient.isAuthorized();

  if (resp.getStatusCode().isError()) {
      throw new PicPayException();
  }

  return resp.getBody().authorization();
}

}
