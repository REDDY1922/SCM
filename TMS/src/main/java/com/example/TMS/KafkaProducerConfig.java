package com.example.TMS;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.example.TMS.Models.Shipment;
import com.fasterxml.jackson.databind.JsonSerializer;

@Configuration
public class KafkaProducerConfig {
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	@Bean
	public ProducerFactory<String, Shipment> producerFactory(){
		Map<String,Object> configProps=new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	@Bean
	public KafkaTemplate<String, Shipment> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
	@Bean
	public NewTopic orderTopic() {
		return TopicBuilder.name("shipment-events")
				.partitions(3)
				.replicas(1)
				.build();
		
	}
}
