package com.test.spring.ng.demo.integration.client;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import io.swagger.client.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClientConfiguration extends ApiClient {

    @Autowired
    @Qualifier("defaultUser")
    AuthorizationService authorizationService;


    public ClientConfiguration getApiClient() {
        System.out.println("getApiClient is set to  : " + authorizationService.getxApiKey());
        ClientConfiguration apiClient = new ClientConfiguration();
//        apiClient.setBasePath(authorizationService.getUrl());
        apiClient.addDefaultHeader("x-api-key", authorizationService.getxApiKey());
        apiClient.setHttpClient(buildHttpClient());
        return apiClient;
    }

    private OkHttpClient buildHttpClient() {
        OkHttpClient client = new OkHttpClient();
        //        if (Boolean.getBoolean("api.log.payload")) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(interceptor);
        //        }
        return client;
    }

}
