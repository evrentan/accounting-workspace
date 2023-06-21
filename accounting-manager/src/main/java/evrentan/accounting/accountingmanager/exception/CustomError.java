package evrentan.accounting.accountingmanager.exception;

import lombok.Builder;
import lombok.Data;

/**
 * Custom Error Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Data
@Builder
public class CustomError {

    private Integer status;

    private String message;
}
