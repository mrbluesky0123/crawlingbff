package toy.mrbluesky.crawlingbff.vo.clientvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import toy.mrbluesky.crawlingbff.vo.BaseData;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExternalCrawlingResponseData implements BaseData {

    private String product;
    private String description;
    private String stock;
    private String price;
    private String link;


}
