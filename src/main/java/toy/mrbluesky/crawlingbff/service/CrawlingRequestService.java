package toy.mrbluesky.crawlingbff.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
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
  public ResponseEntity<CrawlingResponse> requestCrawling(CrawlingRequest crawlingRequest) {
    URI requestUri = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host("45.77.18.238")
            .port(8080)
            .path("/mock-mask")
            .queryParam("requestKeyword", crawlingRequest.getRequestKeyword())
            .queryParam("requestWebsite", crawlingRequest.getRequestWebsite())
            .queryParam("responseMedia", crawlingRequest.getResponseMedia())
            .build()
            .encode()
            .toUri();
    log.info(requestUri.toString());
    ExternalCrawlingResponse externalCrawlingResponse = restTemplate.getForObject(requestUri, ExternalCrawlingResponse.class);

    // exception handling should be added
    log.info(externalCrawlingResponse.toString());
    CrawlingResponse crawlingResponse = CrawlingResponse.builder()
                                                        .code(externalCrawlingResponse.getCode())
                                                        .message(externalCrawlingResponse.getMessage())
                                                        .data(externalCrawlingResponse.getData())
                                                        .build();
    return ResponseEntity.status(externalCrawlingResponse.getCode()).body(crawlingResponse);

  }

  // Call external API
  public String requestCrawling() {
    ExternalCrawlingResponse externalCrawlingResponse = restTemplate.getForObject("http://45.77.18.238:8080/mock-mask", ExternalCrawlingResponse.class);
//    String obj = restTemplate.getForObject("http://45.77.18.238:8080/mock-mask", String.class);
    log.info(externalCrawlingResponse.toString());
    return externalCrawlingResponse.toString();
  }

}