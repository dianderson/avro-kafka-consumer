package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models

import br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.consumers.CustomerConsumer
import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation
import org.apache.logging.log4j.LogManager

interface HasKafkaModelValidate {
    fun validateModel(): MutableSet<ConstraintViolation<HasKafkaModelValidate>> = Validation
        .buildDefaultValidatorFactory()
        .validator.validate(this)
        .also { LogManager.getLogger(HasKafkaModelValidate::class).info("Logou na validação") }
}