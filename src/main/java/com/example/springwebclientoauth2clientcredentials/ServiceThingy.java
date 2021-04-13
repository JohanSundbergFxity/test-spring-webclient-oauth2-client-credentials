package com.example.springwebclientoauth2clientcredentials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

@Service
public class ServiceThingy {

    private final Logger log = LoggerFactory.getLogger(ServiceThingy.class);

    private final WebClient webClient;

    public ServiceThingy(WebClient webClient) {
        this.webClient = webClient;
    }

    public void test() {

        var asd = this.webClient
                .get()
                .uri("asd.com")
                .attributes(clientRegistrationId("myclient"))
                .retrieve()
                .bodyToMono(String.class);

        log.info("asd = " + asd);
    }
}
