package toy.mrbluesky.crawlingbff.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CrawlingResponse {

  private int code;
  private String message;
  private BaseData data;

  public static CrawlingResponseBuilder builder() {
    return new CrawlingResponseBuilder();
  }

  public static class CrawlingResponseBuilder {

    private int code;
    private String message;
    private BaseData data;

    public CrawlingResponseBuilder() {}

    public CrawlingResponseBuilder code(int code) {
      this.code = code;
      return this;
    }

    public CrawlingResponseBuilder message(String message) {
      this.message = message;
      return this;
    }

    public CrawlingResponseBuilder data(BaseData data) {
      this.data = data;
      return this;
    }

    public CrawlingResponse build() {
      return new CrawlingResponse(this.code, this.message, this.data);
    }

  }

}
