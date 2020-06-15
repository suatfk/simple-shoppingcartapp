package com.sc.app.domain.delivery;

import java.math.BigDecimal;


public class DeliveryRule {

    private BigDecimal costPerDelivery;

    private BigDecimal costPerProduct;

    private BigDecimal fixedCost;

    public static DeliveryRule from(BigDecimal costPerDelivery, BigDecimal costPerProduct, BigDecimal fixedCost) {
        return new DeliveryRule(costPerDelivery, costPerProduct, fixedCost);
    }

    private DeliveryRule(BigDecimal costPerDelivery, BigDecimal costPerProduct, BigDecimal fixedCost) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
        this.fixedCost = fixedCost;
    }

    public BigDecimal apply(Deliverable deliverable) {
        return apply(deliverable.getNumberOfDeliveries(), deliverable.getNumberOfProducts());
    }

    public BigDecimal apply(int numberOfDeliveries, int numberOfProducts) {
        validate(numberOfDeliveries, numberOfProducts);
        BigDecimal deliveryCost = costPerDelivery.multiply(BigDecimal.valueOf(numberOfDeliveries));
        BigDecimal productCost = costPerProduct.multiply(BigDecimal.valueOf(numberOfProducts));
        return deliveryCost.add(productCost).add(fixedCost);
    }

    private void validate(int numberOfDeliveries, int numberOfProducts) {
        if (numberOfDeliveries == 0 || numberOfDeliveries < 0) {
            throw new DeliveryRuleException();
        }

        if (numberOfProducts == 0 || numberOfProducts < 0) {
            throw new DeliveryRuleException();
        }
    }
}
