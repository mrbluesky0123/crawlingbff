package toy.mrbluesky.crawlingbff.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import toy.mrbluesky.crawlingbff.vo.clientvo.ExternalCrawlingResponseData;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CrawlingResponse {

  private String code;
  private String message;
  private List<ExternalCrawlingResponseData> data;

  public static CrawlingResponseBuilder builder() {
    return new CrawlingResponseBuilder();
  }

  public static class CrawlingResponseBuilder {

    private String code;
    private String message;
    private List<ExternalCrawlingResponseData> data;

    public CrawlingResponseBuilder() {}

    public CrawlingResponseBuilder code(String code) {
      this.code = code;
      return this;
    }

    public CrawlingResponseBuilder message(String message) {
      this.message = message;
      return this;
    }

    public CrawlingResponseBuilder data(List<ExternalCrawlingResponseData> data) {
      this.data = data;
      return this;
    }

    public CrawlingResponse build() {
      return new CrawlingResponse(this.code, this.message, this.data);
    }

  }

}
