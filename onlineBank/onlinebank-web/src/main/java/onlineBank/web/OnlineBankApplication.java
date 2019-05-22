package onlineBank.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableAutoConfiguration
@EntityScan("onlineBank.*")
@EnableConfigurationProperties
@EnableJpaRepositories("onlineBank.*")
@EnableTransactionManagement(proxyTargetClass = true)
public class OnlineBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankApplication.class, args);
	}

}
