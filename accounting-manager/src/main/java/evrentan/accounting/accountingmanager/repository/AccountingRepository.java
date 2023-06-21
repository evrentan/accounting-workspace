package evrentan.accounting.accountingmanager.repository;

import evrentan.accounting.accountingmanager.entity.AccountingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repository for {@link AccountingEntity}.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@Repository
public interface AccountingRepository extends JpaRepository<AccountingEntity, UUID> {
    List<AccountingEntity> findAllByEmailAndActive(String email, Boolean isActive);
}
