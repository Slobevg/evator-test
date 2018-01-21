package com.slobevg.evatortest.model.application;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Whitish {

    private Genre genre;
    private String name;

    public Whitish() {}

    public Whitish(Genre genre, String name) {
        this.genre = genre;
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
