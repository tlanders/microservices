package biz.lci.springboot.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tlanders on 5/12/2017.
 */
@RefreshScope
@RestController
public class MessageController {

    @Value("${message:Default message}")
    protected String message;

    @RequestMapping("/message")
    public String message() {
        return this.message;
    }
}
