package br.com.sobreiraromulo.picpay.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sobreiraromulo.picpay.client.NotificationClient;
import br.com.sobreiraromulo.picpay.entity.Transaction;

@Service
public class NotificationService {

 private Logger logger = LoggerFactory.getLogger(NotificationService.class);
 
 @Autowired
 private NotificationClient notificationClient;

 public void sendNotification(Transaction transaction){

  try{
   logger.info("Sending notification.");

   var response = notificationClient.sendNotification(transaction);

   if(response.getStatusCode().isError()){
    logger.error("Error while send notification, status code is not OK.");
   }

  }catch (Exception e){
   logger.error("Error while sending notification.", e);
  }
 }
}
