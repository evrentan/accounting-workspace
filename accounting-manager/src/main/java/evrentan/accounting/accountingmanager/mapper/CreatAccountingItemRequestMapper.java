package evrentan.accounting.accountingmanager.mapper;

import evrentan.accounting.accountingmanager.dto.request.CreateAccountingItemRequest;
import evrentan.accounting.accountingmanager.entity.AccountingEntity;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreatAccountingItemRequestMapper {

    public static AccountingEntity toEntity(CreateAccountingItemRequest createAccountingItemRequest) {
        if (Objects.isNull(createAccountingItemRequest))
            return null;

        return AccountingEntity.builder()
                .firstName(createAccountingItemRequest.getFirstName())
                .lastName(createAccountingItemRequest.getLastName())
                .email(createAccountingItemRequest.getEmail())
                .amount(createAccountingItemRequest.getAmount())
                .productName(createAccountingItemRequest.getProductName())
                .billNo(createAccountingItemRequest.getBillNo())
                .active(Boolean.TRUE)
                .billDate(LocalDateTime.now())
                .build();
    }
}
