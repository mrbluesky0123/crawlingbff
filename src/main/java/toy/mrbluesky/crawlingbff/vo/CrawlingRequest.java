package toy.mrbluesky.crawlingbff.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrawlingRequest {

  private String requestKeyword;
  private String requestWebsite;
  private String responseMedia;

}
