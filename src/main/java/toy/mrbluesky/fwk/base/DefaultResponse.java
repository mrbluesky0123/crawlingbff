package toy.mrbluesky.fwk.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class DefaultResponse {

    private int code;
    private String message;
    private BaseResponseData baseResponseData;

    public DefaultResponse(int code, String message, BaseResponseData baseResponseData) {
        this.code = code;
        this.message = message;
        this.baseResponseData = baseResponseData;
    }

    public static DefaultResponseBuilder builder() {
        return new DefaultResponseBuilder();
    }

    public static class DefaultResponseBuilder {

        private int code;
        private String message;
        private BaseResponseData baseResponseData;

        public DefaultResponseBuilder() {}

        public DefaultResponseBuilder code(int code) {
            this.code = code;
            return this;
        }

        public DefaultResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public DefaultResponseBuilder data(BaseResponseData baseResponseData) {
            this.baseResponseData = baseResponseData;
            return this;
        }

        public DefaultResponse build() {
            return new DefaultResponse(this.code, this.message, this.baseResponseData);
        }
    }

}
