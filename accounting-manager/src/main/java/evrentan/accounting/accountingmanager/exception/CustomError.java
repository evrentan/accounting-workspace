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

    /**
     * Status in Integer Type.
     *
     * @since 1.0.0
     */
    private Integer status;

    /**
     * Message in String Type.
     *
     * @since 1.0.0
     */
    private String message;
}
