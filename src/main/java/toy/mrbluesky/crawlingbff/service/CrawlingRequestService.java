package toy.mrbluesky.crawlingbff.service;

import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import toy.mrbluesky.crawlingbff.vo.CrawlingRequest;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse;
import toy.mrbluesky.fwk.base.BaseService;

@Service
@NoArgsConstructor
public class CrawlingRequestService extends BaseService {

    // Call external API
    public ResponseEntity<CrawlingResponse> requestCrawling(CrawlingRequest crawlingRequest) {

    }


}
