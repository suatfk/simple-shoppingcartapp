package com.sc.app.domain.category;

import com.sc.app.domain.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Category extends BaseEntity {

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
