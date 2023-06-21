package evrentan.accounting.accountingmanager.service;

import evrentan.accounting.accountingmanager.dto.response.GetAccountingListResponse;

/**
 * Accounting Service Interface Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public interface AccountingService {

    /**
     * Return all accounting instances in the database
     *
     * @return GetAccountingListResponse. Please, see the {@link GetAccountingListResponse} class for details.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    GetAccountingListResponse getAllAccountingItems();
}
