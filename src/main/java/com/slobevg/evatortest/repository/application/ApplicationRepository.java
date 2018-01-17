package com.slobevg.evatortest.repository.application;

import com.slobevg.evatortest.model.application.Application;
import com.slobevg.evatortest.model.application.ApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, ApplicationId> {
}
