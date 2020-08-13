package com.rabbit.rabbit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbit.rabbit.model.Employee;





@Component
public class RabbitMQConsumer {
	   private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
	   
	   
	@RabbitListener(queues = "${javainuse.rabbitmq.queue}")
	public void recievedMessage(Employee employee) {
		System.out.println("Recieved Message From RabbitMQ: " + employee);
		
		logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
	}
}