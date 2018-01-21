package com.slobevg.evatortest.service.application;

import com.slobevg.evatortest.model.application.*;
import com.slobevg.evatortest.repository.application.ApplicationRepository;
import com.slobevg.evatortest.repository.application.DraftRepository;
import com.slobevg.evatortest.repository.publisher.PublisherRepository;
import com.slobevg.evatortest.service.validation.ApplicationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final PublisherRepository publisherRepository;
    private final ApplicationValidator applicationValidator;
    private final DraftRepository draftRepository;

    @Autowired
    public ApplicationService(
            ApplicationRepository applicationRepository
            , PublisherRepository publisherRepository
            , ApplicationValidator applicationValidator
            , DraftRepository draftRepository
    ) {

        this.applicationRepository = applicationRepository;
        this.publisherRepository = publisherRepository;
        this.applicationValidator = applicationValidator;
        this.draftRepository = draftRepository;
    }

    @Transactional
    public void create(Application application) {
        Whitish whitish = application.getWhitish();
        if (applicationValidator.validate(whitish)) {
            application.getDrafts()
                    .forEach(draft -> draft.setApplication(application));
            applicationRepository.save(application);
        }
    }

    @Transactional(readOnly = true)
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Transactional
    public void activate(Draft request) {
        Draft draft = draftRepository.findOne(request.getId());
        if (draft == null) {
            return;
        }

        Whitish whitish = draft.getWhitish();
        if (!applicationValidator.validate(whitish)) {
            return;
        }
        Application application = draft.getApplication();
        List<Draft> drafts = application.getDrafts();
        drafts.removeIf(next -> next.getId().equals(draft.getId()));
        drafts.add(new Draft(application));
        application.setWhitish(whitish);
    }

    @Transactional
    public void update(Draft request) {
        Draft draft = draftRepository.findOne(request.getId());
        if (draft != null) {
            draft.setWhitish(request.getWhitish());
        }
    }
}
