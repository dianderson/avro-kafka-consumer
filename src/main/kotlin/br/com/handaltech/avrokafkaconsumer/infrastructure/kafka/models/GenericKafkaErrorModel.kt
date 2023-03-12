package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.models

data class GenericKafkaErrorModel(
    val className: Any,
    val errors: Set<Any>
) : HasKafkaError {
    override fun className() = className
    override fun errors() = errors
}
