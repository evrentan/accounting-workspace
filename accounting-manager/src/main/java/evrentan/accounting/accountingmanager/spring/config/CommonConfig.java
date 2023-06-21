package evrentan.accounting.accountingmanager.spring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(value = "evrentan.accounting.accountingmanager")
@EnableJpaRepositories(value = "evrentan.accounting.accountingmanager.repository")
@EntityScan(value = "evrentan.accounting.accountingmanager.entity")
public class CommonConfig {
}
