package evrentan.accounting.accountingmanager.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Custom Exception Handler Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
@RestControllerAdvice
public class CustomRestExceptionHandler {

    /**
     * Indicates that the request made is in an incorrect format.
     *
     * @param exception Bad Request Exception
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CustomError> badRequestException(final Exception exception, final HttpServletRequest httpServletRequest){
        var customRestError = CustomError.builder()
                .message(exception.getCause().getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return responseEntity(customRestError);
    }

    /**
     * Indicates that such a page does not exist on the server or that there is an error in the page path
     *
     * @param exception Bad Request Exception
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @ExceptionHandler({NotFoundException.class, RuntimeException.class})
    public ResponseEntity<CustomError> notFoundException(final Exception exception, final HttpServletRequest httpServletRequest){
        var customRestError = CustomError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return responseEntity(customRestError);
    }

    /**
     * Indicates that there is a situation that is not going well on the server
     *
     * @param exception Bad Request Exception
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<CustomError> internalServerException(final Exception exception,final  HttpServletRequest httpServletRequest){
        var customRestError = CustomError.builder()
                .message(exception.getCause().getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return responseEntity(customRestError);
    }

    /**
     * Create the response entity with CustomError object.
     *
     * @param customRestError object that includes error status and message. Please, see the {@link CustomError} class for details.
     * @return CustomError object within ResponseEntity. Please, see the {@link CustomError} & {@link ResponseEntity} classes for details.
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    private static ResponseEntity<CustomError> responseEntity(CustomError customRestError){
        return ResponseEntity.status(HttpStatus.valueOf(customRestError.getStatus()))
                .body(customRestError);
    }
}
