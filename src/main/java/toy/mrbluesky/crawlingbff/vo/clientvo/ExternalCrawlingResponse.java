package toy.mrbluesky.crawlingbff.vo.clientvo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalCrawlingResponse {

    private String code;
    private String status;
    private List<ExternalCrawlingResponseData> data;

}
