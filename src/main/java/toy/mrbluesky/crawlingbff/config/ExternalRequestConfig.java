package toy.mrbluesky.crawlingbff.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;



@Configuration
public class ExternalRequestConfig {

    @Value("${restTemplate.factory.readTimeout}")
    private int READ_TIMEOUT;

    @Value("${restTemplate.factory.connectTimeout}")
    private int CONNECT_TIMEOUT;

    @Value("${restTemplate.httpClient.maxConnTotal}")
    private int MAX_CONN_TOTAL;

    @Value("${restTemplate.httpClient.maxConnPerRoute}")
    private int MAX_CONN_PER_ROUTE;

    @Bean
    public RestTemplate getCustomRestTemplate() {
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpComponentsClientHttpRequestFactory.setConnectTimeout(CONNECT_TIMEOUT);
        httpComponentsClientHttpRequestFactory.setReadTimeout(READ_TIMEOUT);

        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(MAX_CONN_TOTAL)
                .setMaxConnPerRoute(MAX_CONN_PER_ROUTE)
                .build();

        httpComponentsClientHttpRequestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(httpComponentsClientHttpRequestFactory);

        return restTemplate;

    }

}
