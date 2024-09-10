package dev.hexa.productservice.infrastructure.adapters.primary;

import dev.hexa.productservice.domain.exeption.ProductNotFoundException;
import dev.hexa.productservice.domain.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GloabalRestControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerProductNotFound() {
        return ErrorResponse.builder()
                .code("PRODUCT_NOT_FOUND")
                .message("Product not found")
                .timestamp(LocalDateTime.now())
                .build();


    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse handleStudentBadRequestException(MethodArgumentNotValidException ex) {
//        BindingResult result = ex.getBindingResult();
//        return ErrorResponse.builder()
//                .code(INVALID_REQUEST_BODY.getCode())
//                .message(INVALID_REQUEST_BODY.getMessage())
//                .details(result.getFieldErrors().stream()
//                        .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()
//                )
//                .timestamp(LocalDateTime.now())
//                .build();
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorResponse handleStudentGenericError(Exception ex) {
//        return ErrorResponse.builder()
//                .code(GENERIC_ERROR.getCode())
//                .message(GENERIC_ERROR.getMessage())
//                .details(Collections.singletonList(ex.getMessage()))
//                .timestamp(LocalDateTime.now())
//                .build();
//    }
//}
}