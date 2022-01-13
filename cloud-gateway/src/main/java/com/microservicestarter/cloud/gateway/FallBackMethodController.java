package com.microservicestarter.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    private final String defaultMessage = "Service is taking longer than expected, Please try again later";

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service " + defaultMessage;
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        return "Department " + defaultMessage;
    }
}
