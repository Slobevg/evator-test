package com.slobevg.evatortest.model.application;

import com.slobevg.evatortest.model.EnumTuplizer;
import org.hibernate.annotations.Tuplizer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Tuplizer(impl = EnumTuplizer.class)
public enum Genre {
    GAME, UTILITY, FILM, MUSIC;

    @Id
    public String name = toString();
}
