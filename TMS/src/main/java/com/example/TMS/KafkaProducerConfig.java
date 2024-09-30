package com.example.TMS;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	

}
