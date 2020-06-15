package com.sc.app.domain.discount;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Embeddable
public class Discount {

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type")
    private DiscountType discountType;

    @Column(name = "discount_amount", precision = 10)
    private BigDecimal discountAmount = BigDecimal.ZERO;

    public static Discount from(DiscountType discountType, BigDecimal discountAmount) {
        return new Discount(discountType, discountAmount);
    }

    public Discount(DiscountType discountType, BigDecimal discountAmount) {
        this.discountType = discountType;
        this.discountAmount = discountAmount;
    }

    public Discount() {
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }
}
