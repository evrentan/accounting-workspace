package evrentan.accounting.accountingmanager.dto.entity;

import evrentan.accounting.accountingmanager.entity.AccountingEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Accounting Class.
 * It is equalized to the {@link AccountingEntity} in entity level.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode @ToString
@Builder
@Schema(description = "Accounting Class")
public class Accounting {

    /**
     * Accounting ID in UUID Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Accounting ID in UUID Type")
    private UUID id;

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

    /**
     * Indicates whether the accounting item is active or not.
     *
     * @since 1.0.0
     */
    @Schema(description = "Indicates whether the accounting item is active or not")
    private boolean isActive;

    /**
     * Bill Date in LocalDateTime Type.
     *
     * @since 1.0.0
     */
    @Schema(description = "Bill Date in LocalDateTime Type")
    private LocalDateTime billDate;
}
