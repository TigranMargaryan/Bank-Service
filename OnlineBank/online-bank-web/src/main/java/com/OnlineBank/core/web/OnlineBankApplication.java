package com.OnlineBank.core.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Instant;
import java.util.Arrays;

@ComponentScan({"com.OnlineBank.*"})
@EntityScan("com.OnlineBank.*")
@EnableConfigurationProperties
@EnableJpaRepositories("com.OnlineBank.*")
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = {"com.OnlineBank.*"})
public class OnlineBankApplication {

	public static void main(String... args) {
		new SpringApplicationBuilder()
				.sources(OnlineBankApplication.class)
				.run(applyCurrentTime(args));
	}

	private static String[] applyCurrentTime(String... args) {
		if (args != null) {
			int argsLength = args.length;
			String[] newArgs = Arrays.copyOf(args, argsLength + 1);
			newArgs[argsLength] = String.valueOf(Instant.now().toEpochMilli());
			args = newArgs;
		}

		return args;
	}
}
