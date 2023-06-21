package evrentan.accounting.accountingmanager.spring.spring;

import evrentan.accounting.accountingmanager.spring.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(
        value = {
                CommonConfig.class,
                FeignClientConfig.class,
                SwaggerConfig.class,
                TransactionManagementConfig.class,
                WebConfig.class
        }
)
public class AccountingManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountingManagerApplication.class, args);
    }

}
