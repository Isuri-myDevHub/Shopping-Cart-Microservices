package lk.isuri.devhub.Shopping.productservice.exception;

import lk.isuri.devhub.Shopping.productservice.payload.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles ProductServiceCustomException and returns a ResponseEntity with an ErrorResponse.
     *
     * @param exception The ProductServiceCustomException to be handled.
     * @return ResponseEntity containing an ErrorResponse and HTTP status code NOT_FOUND.
     */

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException exception) {

        // Return a ResponseEntity with the ErrorResponse and HTTP status code NOT_FOUND
        return new ResponseEntity<>(new ErrorResponse().builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .build(), HttpStatus.NOT_FOUND);
    }
}