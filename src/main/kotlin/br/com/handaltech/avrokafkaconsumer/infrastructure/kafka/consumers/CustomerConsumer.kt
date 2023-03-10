package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.consumers

import br.com.handaltech.avrokafkaproducer.avros.CustomerAvro
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.logging.log4j.LogManager
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class CustomerConsumer {
    private val logger = LogManager.getLogger(CustomerConsumer::class)

    @KafkaListener(
        topics = ["\${configs.kafka.topics.customer}"],
        groupId = "\${configs.kafka.groupId}"
    )
    fun onListener(message: ConsumerRecord<String, CustomerAvro>, ack: Acknowledgment) {
        logger.info(message.value())
    }
}