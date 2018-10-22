package org.tfga.baseUrl.web;

import org.springframework.web.bind.annotation.RestController;
import org.tfga.baseUrl.BaseUrl;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class BaseUrlController {

    BaseUrl b = new BaseUrl();
    
    @RequestMapping("/tfga")
    public String index(HttpServletRequest request) throws MalformedURLException {
        
        return b.baseURL(request) + '\n';
    }
}
