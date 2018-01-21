package com.slobevg.evatortest.controller;

import com.slobevg.evatortest.model.application.Application;
import com.slobevg.evatortest.model.application.Draft;
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
    public void create(@RequestBody Application application) {
        applicationService.create(application);
    }

    @RequestMapping(path = "/activate", method = RequestMethod.POST)
    public void activate(@RequestBody Draft draft) {
        applicationService.activate(draft);
    }
}
