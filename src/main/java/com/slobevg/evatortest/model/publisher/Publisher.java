package com.slobevg.evatortest.model.publisher;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
