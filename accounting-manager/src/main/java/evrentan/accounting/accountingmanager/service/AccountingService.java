package evrentan.accounting.accountingmanager.service;

import evrentan.accounting.accountingmanager.dto.request.CreateAccountingItemRequest;
import evrentan.accounting.accountingmanager.dto.response.CreateAccountingItemResponse;
import evrentan.accounting.accountingmanager.dto.response.GetAccountingListResponse;

/**
 * Accounting Service Interface Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public interface AccountingService {

    /**
     * Create an accounting item instance in the database
     *
     * @param createAccountingItemRequest accounting item to be created. Please, see the {@link CreateAccountingItemRequest} class for details.
     * @return CreateAccountingItemResponse which corresponds to the accounting item created. Please, see the {@link CreateAccountingItemResponse} class for details.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    CreateAccountingItemResponse createAccountingItem(CreateAccountingItemRequest createAccountingItemRequest);

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
