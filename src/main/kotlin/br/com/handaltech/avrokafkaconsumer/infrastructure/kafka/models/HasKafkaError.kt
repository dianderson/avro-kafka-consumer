package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models

interface HasKafkaError : HasKafkaModelValidate {
    fun className(): Any
    fun errors(): Set<Any>
}