package com.slobevg.evatortest.model;

import javax.persistence.*;

@Table
@Entity
public class Publisher {

    private Long id;
    private String name;

    public Publisher() { }

    public Publisher(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
