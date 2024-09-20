package org.example.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "/testAPI")
    public String testAPI(){
        logger.info("Hello from user registration");
        logger.debug("Hello from user registration");
        logger.error("Hello from user registration");
        return "Hello from user Updated registration";
    }
}
