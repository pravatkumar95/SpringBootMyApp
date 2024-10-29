package com.centroxy.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.config.AerospikeDataSettings;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import com.aerospike.client.Host;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.centroxy.repo.AerospikeUserRepository;
@Configuration
@EnableConfigurationProperties(AerospikeConfigurationProperties.class)
@EnableAerospikeRepositories(basePackageClasses = AerospikeUserRepository.class)
public class AerospikeConfiguration extends AbstractAerospikeDataConfiguration{
	
	
	@Autowired
    private AerospikeConfigurationProperties aerospikeConfigurationProperties;
    @Override
    protected Collection<Host> getHosts() {
        return Collections.singleton(new Host(aerospikeConfigurationProperties.getHost(), aerospikeConfigurationProperties.getPort()));
    }
    @Override
    protected String nameSpace() {
        return aerospikeConfigurationProperties.getNamespace();
    }
    
   

    @Override
    public ClientPolicy getClientPolicy() {
        var clientPolicy =  new ClientPolicy();
        clientPolicy.failIfNotConnected = true;
        clientPolicy.user = "";
        clientPolicy.password = "";
        clientPolicy.writePolicyDefault = fetchWritePolicy();
        clientPolicy.readPolicyDefault = fetchReadPolicy();
        clientPolicy.timeout = 100000;
        return clientPolicy;
    }

    private WritePolicy fetchWritePolicy(){
        var writePolicy = new WritePolicy();
        writePolicy.sendKey = true;
        writePolicy.recordExistsAction = RecordExistsAction.REPLACE;
        writePolicy.socketTimeout = 3000;
        writePolicy.totalTimeout = 6050;
        writePolicy.sleepBetweenRetries = 50;
        return writePolicy;
    }

    private Policy fetchReadPolicy(){
        var policy = new Policy();
        policy.socketTimeout = 1500;
        policy.totalTimeout = 3010;
        policy.sleepBetweenRetries = 10;
        return policy;
    } 
   
    @Bean
    public AerospikeDataSettings aerospikeDataSettings() {
      return AerospikeDataSettings.builder().scansEnabled(true).build();
   }


}
