package evrentan.accounting.accountingmanager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

/**
 * CreateAccountingResponse Class.
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
@Schema(description = "CreateAccountingResponse Class")
public class CreateAccountingResponse {
    /**
     * Accounting ID in UUID Type.
     * It will be filled if accounting is created successfully.
     *
     * @since 1.0.0
     */
    @Schema(description = "Accounting ID in UUID Type")
    private UUID id;
}
