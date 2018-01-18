package com.slobevg.evatortest.service.application;

import com.slobevg.evatortest.model.application.Application;
import com.slobevg.evatortest.model.application.ApplicationId;
import com.slobevg.evatortest.model.application.Genre;
import com.slobevg.evatortest.repository.application.ApplicationRepository;
import com.slobevg.evatortest.repository.publisher.PublisherRepository;
import com.slobevg.evatortest.service.validation.ApplicationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final PublisherRepository publisherRepository;
    private final ApplicationValidator applicationValidator;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository, PublisherRepository publisherRepository, ApplicationValidator applicationValidator) {
        this.applicationRepository = applicationRepository;
        this.publisherRepository = publisherRepository;
        this.applicationValidator = applicationValidator;
    }

    @Transactional
    public void create(Long publisherId, String name, Genre genre) {
        Application application = new Application();
        ApplicationId id = new ApplicationId();
        id.setPublisher(publisherRepository.getOne(publisherId));
        id.setName(name);
        application.setId(id);
        application.setGenre(genre);
        if (!applicationRepository.exists(id)) {
            applicationRepository.save(application);
        }
    }

    @Transactional(readOnly = true)
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Transactional
    public void update(Long publisherId, String name, Genre genre) {
        ApplicationId applicationId = new ApplicationId();
        applicationId.setName(name);
        applicationId.setPublisher(publisherRepository.getOne(publisherId));
        Application application = applicationRepository.findOne(applicationId);
        application.setGenre(genre);
    }
}
