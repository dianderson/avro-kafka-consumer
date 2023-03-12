package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.ports

import br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models.CustomerKafkaModel
import br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models.HasKafkaError

interface KafkaPort {
    fun processCustomer(customerKafkaModel: CustomerKafkaModel)
    fun publishToErrorQueue(hasKafkaError: HasKafkaError)
}