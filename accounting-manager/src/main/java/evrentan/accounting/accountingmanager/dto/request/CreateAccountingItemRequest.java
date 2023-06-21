package evrentan.accounting.accountingmanager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

/**
 * CreateAccountingItemRequest Class.
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
@Schema(description = "CreateAccountingItemRequest Class")
public class CreateAccountingItemRequest {
    /**
     * First Name of the Accountant in String Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "First Name of the Accountant in String Type")
    private String firstName;

    /**
     * Last Name of the Accountant in String Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Last Name of the Accountant in String Type")
    private String lastName;

    /**
     * Email of the Accountant in String Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Email of the Accountant in String Type")
    private String email;

    /**
     * Amount of the Bill in Double Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Amount of the Bill in Double Type")
    private BigDecimal amount;

    /**
     * Product Name in String Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Product Name in String Type")
    private String productName;

    /**
     * Bill No in String Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Bill No in String Type")
    private String billNo;
}
