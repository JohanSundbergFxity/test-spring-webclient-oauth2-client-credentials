package com.example.springwebclientoauth2clientcredentials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ServiceThingy {

    private final Logger log = LoggerFactory.getLogger(ServiceThingy.class);

    private WebClient.Builder webClientBuilder;

    public ServiceThingy(WebClient.Builder wcb) {
        this.webClientBuilder = wcb;
    }

    public void test() {

        webClientBuilder.build()
                .get()
                .uri("https://asd")
//                .attributes(WebClientSecurityConfig.getExchangeFilterWith("myclient"))
//                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .map(string -> "We retrieved the following resource using Client Credentials Grant Type: " + string)
                .subscribe(log::info);

    }
}
