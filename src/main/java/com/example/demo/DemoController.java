package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
public class DemoController {


    
    //ganna was here
    @RequestMapping("/hello")
    public String hello() throws IOException {
        // Load the content of the "home.html" file from the classpath
        Resource resource = new ClassPathResource("static/home.html");
        InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
        try {
            // Read the content of the file as a string
            String content = FileCopyUtils.copyToString(reader);
            return content;
        } finally {
            reader.close();
        }
    }
}
