package evrentan.accounting.accountingmanager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * ErrorResponse Class.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "ErrorResponse Class")
public class ErrorResponse {
    /**
     * Error Code in String Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Error Code in String Type")
    private String errorCode;

    /**
     * Error Message in String Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Error Message in String Type")
    private String errorMessage;
}
