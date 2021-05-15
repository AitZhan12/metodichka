package textbook.manual.authorization.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import textbook.manual.authorization.exceptions.ServiceException;

@ControllerAdvice
@RestController
public class ErrorController extends BaseController{
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> resourceNotFoundException(ServiceException e) {
        return buildResponse(buildErrorResponse(e), HttpStatus.NOT_FOUND);
    }
}
