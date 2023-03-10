package br.com.handaltech.avrokafkaconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AvroKafkaConsumerApplication

fun main(args: Array<String>) {
	runApplication<AvroKafkaConsumerApplication>(*args)
}
