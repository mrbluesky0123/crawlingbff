package toy.mrbluesky.crawlingbff.exception.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import toy.mrbluesky.crawlingbff.exception.NotFoundException;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse;

@ControllerAdvice
@Slf4j
public class ExternalExceptionHandler {

  @ExceptionHandler(value = {NotFoundException.class})
  public ResponseEntity<CrawlingResponse> handleHttpClientErrorException(NotFoundException notFoundException)
      throws JsonProcessingException {
    log.error(notFoundException.getResponseBodyAsString(), notFoundException);
    ObjectMapper o = new ObjectMapper();

//    CrawlingResponse errorResponse = new CrawlingResponse(httpClientErrorException.getRawStatusCode(),
//            httpClientErrorException.getResponseBodyAsString(), null);
    CrawlingResponse errorResponse = o.readValue(notFoundException.getResponseBodyAsString(), CrawlingResponse.class);
    return new ResponseEntity<>(errorResponse, notFoundException.getStatusCode());
  }

}
