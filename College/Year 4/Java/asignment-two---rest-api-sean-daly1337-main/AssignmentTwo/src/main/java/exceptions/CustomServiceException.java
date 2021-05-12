package exceptions;

import org.springframework.http.HttpStatus;

public class CustomServiceException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public CustomServiceException(String ex, HttpStatus status) {
        super(ex);
        this.message = ex;
        this.httpStatus = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
