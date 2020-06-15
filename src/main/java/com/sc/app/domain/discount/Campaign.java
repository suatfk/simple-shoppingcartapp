package com.sc.app.domain.discount;

import com.sc.app.domain.category.Category;

import javax.persistence.*;


@Entity
@Table(name = "campaign")
public class Campaign extends ApplicableDiscount {

    @Column(name = "title")
    private String title;

    @Column(name = "min_quantity")
    private int minQuantity;

    @Embedded
    private Discount discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    public static Campaign from(String title, int minQuantity, Discount discount, Category category) {
        return new Campaign(title, minQuantity, discount, category);
    }

    public Campaign() {
    }

    public Campaign(String title, int minQuantity, Discount discount, Category category) {
        this.title = title;
        this.minQuantity = minQuantity;
        this.discount = discount;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

