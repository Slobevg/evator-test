package com.slobevg.evatortest.controller;

import com.slobevg.evatortest.model.application.Application;
import com.slobevg.evatortest.model.application.Genre;
import com.slobevg.evatortest.model.publisher.Publisher;
import com.slobevg.evatortest.service.application.ApplicationService;
import com.slobevg.evatortest.service.publisher.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Application> list() {
        return applicationService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void create(@RequestBody ApplicationCreateRequest request) {
        applicationService.create(request.getPublisherId(), request.getName(), request.getGenre());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void update(@RequestBody ApplicationCreateRequest request) {
        applicationService.update(request.getPublisherId(), request.getName(), request.getGenre());
    }

    private static class ApplicationCreateRequest {
        private Long publisherId;
        private String name;
        private Genre genre;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getPublisherId() {
            return publisherId;
        }

        public void setPublisherId(Long publisherId) {
            this.publisherId = publisherId;
        }

        public Genre getGenre() {
            return genre;
        }

        public void setGenre(Genre genre) {
            this.genre = genre;
        }
    }
}
