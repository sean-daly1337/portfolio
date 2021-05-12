package exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler {

    @ExceptionHandler(value = {CustomServiceException.class})
    public ResponseEntity<Object> handleInternalServerErrorExceptions(CustomServiceException usp, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage(new Date(), usp.getMessage()), new HttpHeaders(), usp.getHttpStatus());
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(CustomServiceException usp, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage(new Date(), usp.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
