package toy.mrbluesky.crawlingbff.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrawlingRequest {

  @NotNull(message = "byung-shin")
  private String requestKeyword;
  @NotNull(message = "byung-shin2")
  private String requestWebsite;
  @NotNull(message = "byung-shin3")
  private String responseMedia;

}
