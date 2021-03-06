package textbook.manual.authorization.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import textbook.manual.authorization.exceptions.ServiceException;
import textbook.manual.authorization.shared.responses.ErrorResponse;

public class BaseController {
    protected ResponseEntity<?> buildResponse(Object data, HttpStatus httpStatus){
        return new ResponseEntity<>(data , httpStatus);
    }

    protected ResponseEntity<?> buildResponse(HttpStatus httpStatus){
        return new ResponseEntity<>(httpStatus);
    }

    protected ErrorResponse buildErrorResponse(ServiceException serviceException){
        return ErrorResponse.builder()
                .code(serviceException.getErrorCode())
                .message(serviceException.getMessage())
                .build();
    }
}
