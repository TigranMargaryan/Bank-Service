package onlineBank.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan("onlineBank.*")
@EnableConfigurationProperties
@EnableJpaRepositories("onlineBank.*")
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = {"onlineBank.*"})
public class OnlineBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankApplication.class, args);
	}

}
