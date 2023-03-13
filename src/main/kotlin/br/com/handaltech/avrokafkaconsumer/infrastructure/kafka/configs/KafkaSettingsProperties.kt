package br.com.handaltech.avrokafkaconsumer.infrastructure.kafka.configs

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "configs.kafka")
data class KafkaSettingsProperties(
    var bootstrapServers: String = "",
    var schemaRegistryUrl: String = "",
    var groupId: String = "",
    var concurrency: Int = 1
)
