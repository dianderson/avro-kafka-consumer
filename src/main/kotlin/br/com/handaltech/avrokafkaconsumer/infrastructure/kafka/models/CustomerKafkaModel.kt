package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF

data class CustomerKafkaModel(
    @field:NotBlank
    val customerCode: String,
    @field:NotBlank
    val customerName: String,
    @field:CPF
    @field:NotNull
    val customerDocument: String,
    @field:Email
    @field:NotNull
    val customerMail: String
) : HasKafkaModelValidate
