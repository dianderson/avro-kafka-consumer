package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.consumers

import br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models.CustomerKafkaModel
import br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models.GenericKafkaErrorModel
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
        try {
            val data = message.value().buildModel()
            val errors = data.errors()
            when {
                errors.isEmpty() -> logger.info(data)
                else -> logger.error("Errors: $errors")
            }
            ack.acknowledge()
        } catch (ex: Exception) {
            val genericError = GenericKafkaErrorModel(
                className = this::class,
                errors = setOf(ex.javaClass, ex.message.toString())
            )
            logger.error(genericError)
        }
    }

    private fun CustomerAvro.buildModel() = CustomerKafkaModel(
        customerCode = customerCode,
        customerName = customerName,
        customerDocument = customerDocument,
        customerMail = customerMail
    )
}