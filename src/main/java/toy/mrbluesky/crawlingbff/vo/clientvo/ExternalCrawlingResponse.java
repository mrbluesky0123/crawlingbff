package toy.mrbluesky.crawlingbff.vo.clientvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalCrawlingResponse {

    private int code;
    private String message;
    private ExternalCrawlingResponseData data;

}
