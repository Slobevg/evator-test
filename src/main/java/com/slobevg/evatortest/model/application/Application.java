package com.slobevg.evatortest.model.application;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Table
@Entity
@Audited
public class Application {

    private ApplicationId id;
    private Genre genre;

    @EmbeddedId
    public ApplicationId getId() {
        return id;
    }

    public void setId(ApplicationId id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
