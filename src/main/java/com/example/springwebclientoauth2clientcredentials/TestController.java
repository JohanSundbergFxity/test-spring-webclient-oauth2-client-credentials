package com.example.springwebclientoauth2clientcredentials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private final Logger log = LoggerFactory.getLogger(TestController.class);
    private ServiceThingy serviceThingy;

    public TestController(ServiceThingy serviceThingy) {
        this.serviceThingy = serviceThingy;
    }

    @GetMapping("/api/v1/test")
    public void test() {
        serviceThingy.test();
    }
}
