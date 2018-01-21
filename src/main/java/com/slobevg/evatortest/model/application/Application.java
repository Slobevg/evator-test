package com.slobevg.evatortest.model.application;

import com.slobevg.evatortest.model.publisher.Publisher;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Application {

    private Long id;
    private Publisher publisher;
    private List<Draft> drafts;
    private Whitish whitish;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @OneToMany(mappedBy = "application", cascade = CascadeType.PERSIST, orphanRemoval = true)
    public List<Draft> getDrafts() {
        return drafts;
    }

    public void setDrafts(List<Draft> drafts) {
        this.drafts = drafts;
    }

    @Embedded
    public Whitish getWhitish() {
        return whitish;
    }

    public void setWhitish(Whitish whitish) {
        this.whitish = whitish;
    }

}
