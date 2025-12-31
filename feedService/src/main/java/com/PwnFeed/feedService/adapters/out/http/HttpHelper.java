package com.PwnFeed.feedService.adapters.out.http;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class HttpHelper {
    public static HttpHeaders head(
            String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .headForHeaders(url);
    }
}
