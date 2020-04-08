package toy.mrbluesky.crawlingbff.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class NotFoundException extends HttpClientErrorException {

  private HttpClientErrorException httpClientErrorException;

  public NotFoundException(HttpClientErrorException httpClientErrorException) {
      super(HttpStatus.NOT_FOUND);
      this.httpClientErrorException = httpClientErrorException;
  }

  public String getResponseBodyAsString() {
    return httpClientErrorException.getResponseBodyAsString();
  }

}
