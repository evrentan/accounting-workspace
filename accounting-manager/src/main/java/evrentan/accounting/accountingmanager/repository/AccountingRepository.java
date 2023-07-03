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

    /**
     * Find all items according to email and isActive.
     *
     * @param email string that is the email of the accountant
     * @param isActive boolean type that shows whether the items are active or not.
     * @return List of AccountingEntity. Please, see the {@link AccountingEntity} for more details.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    List<AccountingEntity> findAllByEmailAndActive(String email, Boolean isActive);
}
