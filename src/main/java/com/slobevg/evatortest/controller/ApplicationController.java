package com.slobevg.evatortest.controller;

import com.slobevg.evatortest.model.publisher.Publisher;
import com.slobevg.evatortest.service.publisher.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Publisher> list() {
        return publisherService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Publisher create(@RequestBody PublisherCreateRequest request) {
        return publisherService.create(request.getName());
    }

    private static class PublisherCreateRequest {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
