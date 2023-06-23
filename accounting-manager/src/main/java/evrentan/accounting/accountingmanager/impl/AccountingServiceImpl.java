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
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @Override
    public CreateAccountingItemResponse createAccountingItem(CreateAccountingItemRequest createAccountingItemRequest) {
        final BigDecimal totalExistingAccountantAmount = calculateExistingAccountantAmount(createAccountingItemRequest.getEmail());

        this.checkAccountantAllowedAmountExceeded(createAccountingItemRequest.getAmount(), totalExistingAccountantAmount);

        return this.generateCreateAccountingItemResponse(createAccountingItemRequest);
    }

    /**
     * Return all accounting items in the database
     *
     * @return List<Event>. Please, see the {@link Accounting} class for details.
     *
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

    /**
     * Calculate existing amount of the related accountant.
     *
     * @param email email of the accountant.
     * @return BigDecimal which is the total existing amount of the related accountant calculated according to the accountant active accounting items.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    private BigDecimal calculateExistingAccountantAmount(final String email) {
        return this.accountingRepository.findAllByEmailAndActive(email, Boolean.TRUE)
                .stream()
                .map(AccountingEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Check whether accountant allowed amount is exceeded or not.
     *
     * @param requestedAmount amount that is requested in the API call.
     * @param totalExistingAccountantAmount amount that is the existing total amount of the accountant which is calculated according to the accountant active accounting items.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    private void checkAccountantAllowedAmountExceeded(BigDecimal requestedAmount, BigDecimal totalExistingAccountantAmount) {
        if (requestedAmount.add(totalExistingAccountantAmount).compareTo(BigDecimal.valueOf(accountantLimit)) > 0)
            throw new BadRequestException(Constants.ACCOUNTANT_LIMIT_EXCEEDED);
    }

    /**
     * Generate CreateAccountingItemResponse object after saving the requested accounting item to the DB.
     *
     * @param createAccountingItemRequest object that is requested accounting item to the DB. Please check {@link CreateAccountingItemRequest}.
     * @return CreateAccountingItemResponse object that is generated for the response for creating the accounting item to the DB. Please check {@link CreateAccountingItemResponse}.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    private CreateAccountingItemResponse generateCreateAccountingItemResponse(CreateAccountingItemRequest createAccountingItemRequest) {
        final AccountingEntity accountingEntity = this.accountingRepository.save(CreatAccountingItemRequestMapper.toEntity(createAccountingItemRequest));

        CreateAccountingItemResponse createAccountingItemResponse = new CreateAccountingItemResponse();
        createAccountingItemResponse.setId(accountingEntity.getId());

        return createAccountingItemResponse;
    }
}
