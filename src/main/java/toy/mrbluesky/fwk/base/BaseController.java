package toy.mrbluesky.fwk.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class BaseController extends BaseObject {

    public ResponseEntity<DefaultResponse> makeResponse(HttpStatus status, Exception exception, HttpServletRequest request) {
        DefaultResponse response = DefaultResponse.builder().code(status.value())
                .message(exception.getMessage()).build();

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<DefaultResponse> handleException(Exception exception, HttpServletRequest request) {
        return this.makeResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception, request);
    }

}
