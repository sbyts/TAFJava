package com.test.spring.ng.demo.integration.client;

public class AuthorizationService {
    public String getxApiKey() {
        return xApiKey;
    }

    public String getUrl() {
        return url;
    }

    private String xApiKey;
    private String url;

    public void setxApiKey(String xApiKey) {
        this.xApiKey = xApiKey;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
