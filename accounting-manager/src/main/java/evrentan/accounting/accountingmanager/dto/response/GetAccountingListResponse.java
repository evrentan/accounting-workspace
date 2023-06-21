package evrentan.accounting.accountingmanager.dto.response;

import evrentan.accounting.accountingmanager.dto.entity.Accounting;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

/**
 * GetAccountingListResponse Class.
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
@Schema(description = "GetAccountingListResponse Class")
public class GetAccountingListResponse {
    private List<Accounting> accountingList;
}
