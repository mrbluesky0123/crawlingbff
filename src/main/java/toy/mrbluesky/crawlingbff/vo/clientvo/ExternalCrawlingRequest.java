package toy.mrbluesky.crawlingbff.vo.clientvo;

import javax.validation.constraints.NotNull;

public class ExternalCrawlingRequest {
    @NotNull(message = "byung-shin")
    private String requestKeyword;
    @NotNull(message = "byung-shin2")
    private String requestWebsite;
    @NotNull(message = "byung-shin3")
    private String responseMedia;
}
