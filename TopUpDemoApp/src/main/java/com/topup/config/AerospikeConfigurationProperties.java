package com.topup.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="config.aerospike")
@Data
public class AerospikeConfigurationProperties {

    private String host;
    private int port;
    private String namespace;

}
