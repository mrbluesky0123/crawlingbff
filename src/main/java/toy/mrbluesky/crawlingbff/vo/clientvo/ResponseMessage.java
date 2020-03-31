package toy.mrbluesky.crawlingbff.vo.clientvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

    private String product;
    private String description;
    private String stock;
    private String price;
    private String link;

}
