package evrentan.accounting.accountingmanager.controller;

import evrentan.accounting.accountingmanager.dto.request.CreateAccountingItemRequest;
import evrentan.accounting.accountingmanager.dto.response.CreateAccountingItemResponse;
import evrentan.accounting.accountingmanager.dto.response.GetAccountingListResponse;
import evrentan.accounting.accountingmanager.service.AccountingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * REST Controller for accounting related API end-points.
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/accounting", consumes = "application/json", produces = "application/json")
public class AccountingController {

    private final AccountingService accountingService;

    public AccountingController(AccountingService accountingService) {
        this.accountingService = accountingService;
    }

    /**
     * REST end-point in order to create an accounting item.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @param createAccountingItemRequest object that is going to be created. Please, see the {@link CreateAccountingItemRequest} class for details.
     * @return CreateAccountingItemResponse Object within ResponseEntity. Please, see the {@link CreateAccountingItemResponse} & {@link ResponseEntity} classes for details.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @PostMapping
    @Operation(summary = "Create Accounting Item")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "201", description  = "Accounting Item Created Successfully"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<CreateAccountingItemResponse> createAccountingItem(@RequestBody @NotNull CreateAccountingItemRequest createAccountingItemRequest) {
        final CreateAccountingItemResponse createAccountingItemResponse = this.accountingService.createAccountingItem(createAccountingItemRequest);
        return ResponseEntity.created(URI.create(createAccountingItemResponse.getId().toString())).body(createAccountingItemResponse);
    }

    /**
     * REST end-point in order to get all accounting items.
     * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
     *
     * @return GetAccountingListResponse Object within ResponseEntity. Please, see the {@link GetAccountingListResponse} & {@link ResponseEntity} classes for details.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @GetMapping
    @Operation(summary = "Get All Accounting Items")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully Get All Accounting Items"),
            @ApiResponse(responseCode  = "400", description  = "Bad Request"),
            @ApiResponse(responseCode  = "404", description  = "Not Found"),
            @ApiResponse(responseCode  = "500", description  = "Internal Server Error")
    })
    public ResponseEntity<GetAccountingListResponse> getAllAccountingItems() {
        return ResponseEntity.ok(this.accountingService.getAllAccountingItems());
    }
}
