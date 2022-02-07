package br.com.home.messaging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.com.home.messaging.model.KafkaMessage;

@Service
public class KafkaConsumerService {
	Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}")
	public void listen(@Payload KafkaMessage kafkaMessage) {
		logger.info("Message received. MessageID : {} Message: {} Date : {}", kafkaMessage.getId(),
				kafkaMessage.getMessage(), kafkaMessage.getMessageDate());
//      System.out.println("Message received. MessageID  " + kafkaMessage.getMessage() );
	}
	
	

}