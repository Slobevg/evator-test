package com.slobevg.evatortest.model.application;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table
@Entity
public class Draft {

    private Long id;
    private Whitish whitish;
    private Application application;

    public Draft() {}

    public Draft(Application application) {
        this.whitish = application.getWhitish();
        this.application = application;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Embedded
    public Whitish getWhitish() {
        return whitish;
    }

    public void setWhitish(Whitish whitish) {
        this.whitish = whitish;
    }

    @ManyToOne
    @JsonIgnore
    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

}
