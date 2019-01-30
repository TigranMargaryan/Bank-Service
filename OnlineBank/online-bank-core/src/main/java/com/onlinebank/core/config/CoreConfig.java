package com.onlinebank.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = {"classpath:db/db-dev.properties", "classpath:db/db-${spring.profiles.active}.properties"}, ignoreResourceNotFound = true)
//@EntityScan("com.OnlineBank.core.data.domain")
//@EnableJpaRepositories("com.OnlineBank.core")
@EnableTransactionManagement
public class CoreConfig {

}

