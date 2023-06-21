package evrentan.accounting.accountingmanager.mapper;

import evrentan.accounting.accountingmanager.dto.entity.Accounting;
import evrentan.accounting.accountingmanager.entity.AccountingEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * {@link AccountingEntity} Mapper Class.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public class AccountingMapper {

    /**
     * Maps {@link Accounting} to {@link AccountingEntity}.
     * @param accounting Entity to be mapped. Please, see the {@link Accounting} class for details.
     * @return AccountingEntity. Please, see the {@link AccountingEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static AccountingEntity toEntity(Accounting accounting) {
        if (Objects.isNull(accounting))
            return null;

        return AccountingEntity.builder()
                .id(accounting.getId())
                .firstName(accounting.getFirstName())
                .lastName(accounting.getLastName())
                .email(accounting.getEmail())
                .amount(accounting.getAmount())
                .productName(accounting.getProductName())
                .billNo(accounting.getBillNo())
                .isActive(accounting.isActive())
                .billDate(accounting.getBillDate())
                .build();
    }

    /**
     * Maps {@link AccountingEntity} to {@link Accounting}.
     * @param accountingEntity Entity to be mapped. Please, see the {@link AccountingEntity} class for details.
     * @return Accounting. Please, see the {@link Accounting} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static Accounting toDto(AccountingEntity accountingEntity) {
        if(Objects.isNull(accountingEntity))
            return null;

        return Accounting.builder()
                .id(accountingEntity.getId())
                .firstName(accountingEntity.getFirstName())
                .lastName(accountingEntity.getLastName())
                .email(accountingEntity.getEmail())
                .amount(accountingEntity.getAmount())
                .productName(accountingEntity.getProductName())
                .billNo(accountingEntity.getBillNo())
                .isActive(accountingEntity.isActive())
                .billDate(accountingEntity.getBillDate())
                .build();
    }

    /**
     * Maps List of {@link Accounting} to List of {@link AccountingEntity}.
     *
     * @param accountingList List of entities to be mapped. Please, see the {@link Accounting} class for details.
     * @return List of AccountingEntity. Please, see the {@link AccountingEntity} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static List<AccountingEntity> toEntityList(List<Accounting> accountingList) {
        return accountingList.stream()
                .map(AccountingMapper::toEntity)
                .collect(Collectors.toList());
    }

    /**
     * Maps List of {@link AccountingEntity} to List of {@link Accounting}.
     *
     * @param accountingEntityList List of entities to be mapped. Please, see the {@link AccountingEntity} class for details.
     * @return List of Accounting. Please, see the {@link Accounting} class for details.
     *
     *  @author <a href="https://github.com/evrentan">Evren Tan</a>
     *  @since 1.0.0
     */
    public static List<Accounting> toDtoList(List<AccountingEntity> accountingEntityList) {
        return accountingEntityList.stream()
                .map(AccountingMapper::toDto)
                .collect(Collectors.toList());
    }
}
