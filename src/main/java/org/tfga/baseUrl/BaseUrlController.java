package org.tfga.baseUrl;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class BaseUrlController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
