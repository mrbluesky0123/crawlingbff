package toy.mrbluesky.crawlingbff.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import toy.mrbluesky.crawlingbff.vo.CrawlingRequest;
import toy.mrbluesky.crawlingbff.vo.CrawlingResponse;

@Service
@Data
@NoArgsConstructor
public class CrawlingRequestService {

    // Call external API
    public CrawlingResponse requestCrawling(CrawlingRequest crawlingRequest) {

    }


}
