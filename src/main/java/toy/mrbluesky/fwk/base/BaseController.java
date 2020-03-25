package toy.mrbluesky.fwk.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController extends BaseObject {

    @Autowired
    public BaseController(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        super(httpServletRequest, httpServletResponse);
    }

    public ResponseEntity<String> makeResponse(HttpStatus status, Exception exception, HttpServletRequest request) {
        DefaultExceptionResponse response = new DefaultExceptionResponse(request, exception);
        return ResponseEntity.status(status).body(new Gson().toJson(response));
    }

}
