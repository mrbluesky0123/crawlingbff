package toy.mrbluesky.crawlingbff.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toy.mrbluesky.crawlingbff.vo.CrawlingRequest;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse;

@CrossOrigin
@RestController
public class CrawlingRequestController {


  @PostMapping("/v1/crawlreq")
  public ResponseEntity<CrawlingResponse> requestCrawling(@RequestBody CrawlingRequest crawlingRequest){
    return null;
  }

}
