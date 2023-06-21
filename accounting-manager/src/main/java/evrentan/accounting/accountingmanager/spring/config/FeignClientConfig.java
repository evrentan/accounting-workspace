package evrentan.accounting.accountingmanager.spring.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "evrentan.accounting.accountingmanager")
public class FeignClientConfig {
}
