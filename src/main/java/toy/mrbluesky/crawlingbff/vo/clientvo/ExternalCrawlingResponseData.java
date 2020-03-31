package toy.mrbluesky.crawlingbff.vo.clientvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import toy.mrbluesky.fwk.base.BaseResponseData;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExternalCrawlingResponseData implements BaseResponseData {

    private List<ResponseMessage> responseMessages;

}
