package toy.mrbluesky.crawlingbff.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrawlingRequest {

  @NotNull(message = "byung-shin")
  @NotEmpty(message = "fuck")
  private String requestKeyword;
  @NotNull(message = "byung-shin2")
  private String requestWebsite;
  @NotNull(message = "byung-shin3")
  private String responseMedia;

}
