package toy.mrbluesky.crawlingbff.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import toy.mrbluesky.crawlingbff.vo.CrawlingRequest;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse;
import toy.mrbluesky.crawlingbff.vo.clientvo.ExternalCrawlingResponse;
import toy.mrbluesky.fwk.base.BaseService;

@Service
@NoArgsConstructor
@Slf4j
public class CrawlingRequestService extends BaseService {

    private RestTemplate restTemplate;

    @Autowired
    public CrawlingRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // Call external API
    public String requestCrawling(CrawlingRequest crawlingRequest) {
        ExternalCrawlingResponse externalCrawlingResponse = restTemplate.getForObject("http://45.77.18.238:8080/mock-mask", ExternalCrawlingResponse.class);
        return "SUCCESS";
    }

    // Call external API
    public String requestCrawling() {
        ExternalCrawlingResponse externalCrawlingResponse = restTemplate.getForObject("http://45.77.18.238:8080/mock-mask", ExternalCrawlingResponse.class);
//        String obj = restTemplate.getForObject("http://45.77.18.238:8080/mock-mask", String.class);
        log.info(externalCrawlingResponse.toString());
        return externalCrawlingResponse.toString();
    }

}
