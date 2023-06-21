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
