package toy.mrbluesky.crawlingbff.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse;

@ControllerAdvice
@Slf4j
public class ExternalExceptionHandler {

  @ExceptionHandler(value = {HttpClientErrorException.class})
  public ResponseEntity<CrawlingResponse> handleHttpClientErrorException(HttpClientErrorException httpClientErrorException) {
    log.error(httpClientErrorException.getResponseBodyAsString(), httpClientErrorException);
    CrawlingResponse errorResponse = new CrawlingResponse(httpClientErrorException.getRawStatusCode(),
            httpClientErrorException.getResponseBodyAsString(), null);
    return new ResponseEntity<>(errorResponse, httpClientErrorException.getStatusCode());
  }

}
