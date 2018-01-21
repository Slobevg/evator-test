package com.slobevg.evatortest.repository.application;

import com.slobevg.evatortest.model.application.Draft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DraftRepository extends JpaRepository<Draft, Long> {
}
