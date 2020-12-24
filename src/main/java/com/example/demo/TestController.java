package com.example.demo;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(path = "/")
public class TestController {

    @PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String postAnyJson(@RequestBody String body) {
        log.info("Received JSON payload:\n{}", body);
        return body;
    }

    @SneakyThrows
    @PostMapping(value = "/xml", consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String postAnyXml(@RequestBody String body) {
        log.info("Received XML payload:\n{}", body);
        return body;
    }

}
