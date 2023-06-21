package evrentan.accounting.accountingmanager.impl;

import evrentan.accounting.accountingmanager.constant.Constants;
import evrentan.accounting.accountingmanager.dto.entity.Accounting;
import evrentan.accounting.accountingmanager.dto.response.GetAccountingListResponse;
import evrentan.accounting.accountingmanager.mapper.AccountingMapper;
import evrentan.accounting.accountingmanager.repository.AccountingRepository;
import evrentan.accounting.accountingmanager.service.AccountingService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class AccountingServiceImpl implements AccountingService {

    private final AccountingRepository accountingRepository;

    public AccountingServiceImpl(AccountingRepository accountingRepository) {
        this.accountingRepository = accountingRepository;
    }

    /**
     * Return all accounting items in the database
     *
     * @return List<Event>. Please, see the {@link Accounting} class for details.
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @Override
    public GetAccountingListResponse getAllAccountingItems() {
        List<Accounting> accountingList = AccountingMapper.toDtoList(this.accountingRepository.findAll());

        if (accountingList.isEmpty())
            throw new NotFoundException(Constants.NO_ACCOUNTING_ITEM_FOUND);

        GetAccountingListResponse getAccountingListResponse = new GetAccountingListResponse();
        getAccountingListResponse.setAccountingList(accountingList);
        return getAccountingListResponse;
    }
}
