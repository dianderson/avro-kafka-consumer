package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation

interface HasKafkaModelValidate {
    fun validateModel(): MutableSet<ConstraintViolation<HasKafkaModelValidate>> = Validation
        .buildDefaultValidatorFactory()
        .validator.validate(this)
}