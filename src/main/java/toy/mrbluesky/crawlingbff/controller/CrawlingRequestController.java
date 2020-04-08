package toy.mrbluesky.crawlingbff.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toy.mrbluesky.crawlingbff.service.CrawlingRequestService;
import toy.mrbluesky.crawlingbff.vo.CrawlingRequest;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse;

import javax.validation.Valid;

@CrossOrigin
@RestController
@NoArgsConstructor
@Slf4j
@Api(value = "CrawlingRequestController")
public class CrawlingRequestController {

  private CrawlingRequestService crawlingRequestService;

  @Autowired
  public CrawlingRequestController(CrawlingRequestService crawlingRequestService) {
    this.crawlingRequestService = crawlingRequestService;
  }

  @PostMapping("/v1/crawlreq")
  @ApiOperation(value="Crawling 요청 전송", notes="Crawling 요청을 전송한다.")
  public ResponseEntity<CrawlingResponse> requestCrawling(@RequestBody @Valid CrawlingRequest crawlingRequest) {
    return this.crawlingRequestService.requestCrawling(crawlingRequest);
  }

  @GetMapping("/v1/test")
  @ApiOperation(value="테스트용 요청 전송", notes="테스트용 Crawling 요청을 전송한다. requestParam은 모두 default 값으로 전송된다")
  public String requestCrawling() {
    return this.crawlingRequestService.requestCrawling();
  }

}
