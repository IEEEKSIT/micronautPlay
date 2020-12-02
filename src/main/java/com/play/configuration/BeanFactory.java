package com.play.configuration;

import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;
import java.net.http.HttpClient;

@Factory
public class BeanFactory {

    @Singleton
    public HttpClient createHttpClient(){
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }
}
