package br.com.home.messaging.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.home.messaging.model.KafkaMessage;
import br.com.home.messaging.service.KafkaProducerService;

@RestController
public class ProduceMessageController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/produce")
    public void sendMessage(@RequestBody List<KafkaMessage> kafkaMessageList) {
        kafkaProducerService.sendMessage(kafkaMessageList);
    }

	/**
	 * @param kafkaProducerService
	 */
	public ProduceMessageController(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}
    
    
}