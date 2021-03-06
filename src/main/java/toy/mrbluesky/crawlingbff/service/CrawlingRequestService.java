package toy.mrbluesky.crawlingbff.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import toy.mrbluesky.crawlingbff.exception.NotFoundException;
import toy.mrbluesky.crawlingbff.vo.CrawlingRequest;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse.CrawlingResponseBuilder;
import toy.mrbluesky.crawlingbff.vo.clientvo.ExternalCrawlingResponse;

import java.net.URI;


@Service
@Slf4j
@NoArgsConstructor
public class CrawlingRequestService {

  private RestTemplate restTemplate;

  @Autowired
  public CrawlingRequestService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  // Call external API
  public ResponseEntity<CrawlingResponse> requestCrawling(CrawlingRequest crawlingRequest) throws HttpClientErrorException {
    URI requestUri = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host("45.32.29.18")
            .port(3000)
            .path("/mask")
            .queryParam("requestKeyword", crawlingRequest.getRequestKeyword())
            .queryParam("requestWebsite", crawlingRequest.getRequestWebsite())
            .queryParam("responseMedia", crawlingRequest.getResponseMedia())
            .build()
            .encode()
            .toUri();
    log.info(requestUri.toString());
    ExternalCrawlingResponse externalCrawlingResponse = null;
    try {
      externalCrawlingResponse = restTemplate
          .getForObject(requestUri, ExternalCrawlingResponse.class);
    } catch(HttpClientErrorException httpClientErrorException) {
      throw new NotFoundException(httpClientErrorException);
    }

    // exception handling should be added
    log.info(externalCrawlingResponse.toString());
    CrawlingResponse crawlingResponse = CrawlingResponse.builder()
                                                        .code(externalCrawlingResponse.getCode())
                                                        .message(externalCrawlingResponse.getStatus())
                                                        .data(externalCrawlingResponse.getData())
                                                        .build();
    return ResponseEntity.status(HttpStatus.OK).body(crawlingResponse);

  }

  // Call external API
  public String requestCrawling() {
    ExternalCrawlingResponse externalCrawlingResponse = restTemplate.getForObject("http://45.32.29.18:3000/mask", ExternalCrawlingResponse.class);
//    String obj = restTemplate.getForObject("http://45.77.18.238:8080/mock-mask", String.class);
    log.info(externalCrawlingResponse.toString());
    return externalCrawlingResponse.toString();
  }

}