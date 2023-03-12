package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models

import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validation

interface HasKafkaModelValidate {
    fun validateModel() = Validation
        .buildDefaultValidatorFactory()
        .validator.validate(this)
        .takeIf { it.isNotEmpty() }
        ?.let { throw ConstraintViolationException(it) }
        ?: this
}