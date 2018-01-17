package com.slobevg.evatortest.repository;

import com.slobevg.evatortest.model.publisher.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{
}
