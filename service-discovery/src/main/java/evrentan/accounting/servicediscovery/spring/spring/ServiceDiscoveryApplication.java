package evrentan.accounting.servicediscovery.spring.spring;

import evrentan.accounting.servicediscovery.spring.config.ServiceDiscoveryServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(
        value = {
                ServiceDiscoveryServerConfig.class
        })
public class ServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryApplication.class, args);
    }

}
