package evrentan.accounting.accountingmanager.impl;

import evrentan.accounting.accountingmanager.constant.Constants;
import evrentan.accounting.accountingmanager.dto.entity.Accounting;
import evrentan.accounting.accountingmanager.dto.request.CreateAccountingItemRequest;
import evrentan.accounting.accountingmanager.dto.response.CreateAccountingItemResponse;
import evrentan.accounting.accountingmanager.dto.response.GetAccountingListResponse;
import evrentan.accounting.accountingmanager.entity.AccountingEntity;
import evrentan.accounting.accountingmanager.mapper.AccountingMapper;
import evrentan.accounting.accountingmanager.mapper.CreatAccountingItemRequestMapper;
import evrentan.accounting.accountingmanager.repository.AccountingRepository;
import evrentan.accounting.accountingmanager.service.AccountingService;
import jakarta.ws.rs.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountingServiceImpl implements AccountingService {

    @Value("${accountant.creditLimit}")
    private Integer accountantLimit;

    private final AccountingRepository accountingRepository;

    public AccountingServiceImpl(AccountingRepository accountingRepository) {
        this.accountingRepository = accountingRepository;
    }

    /**
     * Create an accounting item instance in the database
     *
     * @param createAccountingItemRequest accounting item to be created. Please, see the {@link CreateAccountingItemRequest} class for details.
     * @return CreateAccountingItemResponse which corresponds to the accounting item created. Please, see the {@link CreateAccountingItemResponse} class for details.
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @Override
    public CreateAccountingItemResponse createAccountingItem(CreateAccountingItemRequest createAccountingItemRequest) {
        BigDecimal totalExistingAccountantAmount = this.accountingRepository.findAllByEmailAndActive(createAccountingItemRequest.getEmail(), Boolean.TRUE)
                .stream()
                .map(AccountingEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (createAccountingItemRequest.getAmount().add(totalExistingAccountantAmount).compareTo(BigDecimal.valueOf(accountantLimit)) > 0)
            throw new BadRequestException(Constants.ACCOUNTANT_LIMIT_EXCEEDED);

        AccountingEntity accountingEntity = this.accountingRepository.save(CreatAccountingItemRequestMapper.toEntity(createAccountingItemRequest));
        CreateAccountingItemResponse createAccountingItemResponse = new CreateAccountingItemResponse();
        createAccountingItemResponse.setId(accountingEntity.getId());

        return createAccountingItemResponse;
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
