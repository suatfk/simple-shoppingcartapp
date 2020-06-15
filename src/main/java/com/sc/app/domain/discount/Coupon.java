package com.sc.app.domain.discount;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "coupon")
public class Coupon extends ApplicableDiscount {

    @Column(name = "title")
    private String title;

    @Column(name = "min_amount", scale = 2, precision = 5)
    private BigDecimal minAmount;

    @Embedded
    private Discount discount;

    public static Coupon from(String title, BigDecimal minAmount, Discount discount) {
        return new Coupon(title, minAmount, discount);
    }

    public Coupon(String title, BigDecimal minAmount, Discount discount) {
        this.title = title;
        this.minAmount = minAmount;
        this.discount = discount;
    }

    public Coupon() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
