package toy.mrbluesky.crawlingbff.controller;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toy.mrbluesky.crawlingbff.service.CrawlingRequestService;
import toy.mrbluesky.crawlingbff.vo.CrawlingRequest;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse;

@CrossOrigin
@RestController
@NoArgsConstructor
@Slf4j
public class CrawlingRequestController {

  private CrawlingRequestService crawlingRequestService;

  @Autowired
  public CrawlingRequestController(CrawlingRequestService crawlingRequestService) {
    this.crawlingRequestService = crawlingRequestService;
  }

  @PostMapping("/v1/crawlreq")
  public ResponseEntity<CrawlingResponse> requestCrawling(@RequestBody CrawlingRequest crawlingRequest) {
    return this.crawlingRequestService.requestCrawling(crawlingRequest);
  }

  @GetMapping("/v1/test")
  public String requestCrawling() {
    return this.crawlingRequestService.requestCrawling();
  }

}
