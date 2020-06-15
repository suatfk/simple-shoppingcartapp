package com.sc.app.domain.delivery;

import com.sc.app.domain.cart.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeliveryRuleTest {

    @Test(expected = DeliveryRuleException.class)
    public void givenInvalidShoppingCartDisctinctCategoryCount_applyRule_shouldThrowException(){
        Deliverable shoppingCart = Mockito.mock(ShoppingCart.class);
        when(shoppingCart.getNumberOfDeliveries()).thenReturn(0);
        when(shoppingCart.getNumberOfProducts()).thenReturn(3);
        BigDecimal costPerDelivery = BigDecimal.valueOf(2);
        BigDecimal costPerProduct = BigDecimal.valueOf(3);
        BigDecimal fixedCost = BigDecimal.valueOf(2.99);

        DeliveryRule deliveryRule = DeliveryRule
                .from(costPerDelivery, costPerProduct, fixedCost);

        deliveryRule.apply(shoppingCart);
    }

    @Test(expected = DeliveryRuleException.class)
    public void givenInvalidShoppingCartNumberOfDifferentProduct_applyRule_shouldThrowException(){
        Deliverable shoppingCart = Mockito.mock(ShoppingCart.class);
        when(shoppingCart.getNumberOfDeliveries()).thenReturn(3);
        when(shoppingCart.getNumberOfProducts()).thenReturn(0);
        BigDecimal costPerDelivery = BigDecimal.valueOf(2);
        BigDecimal costPerProduct = BigDecimal.valueOf(3);
        BigDecimal fixedCost = BigDecimal.valueOf(2.99);

        DeliveryRule deliveryRule = DeliveryRule
                .from(costPerDelivery, costPerProduct, fixedCost);

        deliveryRule.apply(shoppingCart);
    }


    @Test
    public void givenValidShoppingCart_applyRule_shouldReturnValidAmount(){
        Deliverable shoppingCart = Mockito.mock(ShoppingCart.class);
        when(shoppingCart.getNumberOfDeliveries()).thenReturn(2);
        when(shoppingCart.getNumberOfProducts()).thenReturn(3);
        BigDecimal costPerDelivery = BigDecimal.valueOf(2);
        BigDecimal costPerProduct = BigDecimal.valueOf(3);
        BigDecimal fixedCost = BigDecimal.valueOf(2.99);

        DeliveryRule deliveryRule = DeliveryRule
                .from(costPerDelivery, costPerProduct, fixedCost);

        BigDecimal amount = deliveryRule.apply(shoppingCart);

        Assert.assertEquals(BigDecimal.valueOf(15.99), amount);
    }

    @Test
    public void givenNumberOfDeliveriesAndNumberOfProducts_applyRule_shouldReturnValidAmount(){
        BigDecimal costPerDelivery = BigDecimal.valueOf(2);
        BigDecimal costPerProduct = BigDecimal.valueOf(3);
        BigDecimal fixedCost = BigDecimal.valueOf(2.99);

        int numberOfDeliveries = 2;
        int numberOfProducts = 3;

        DeliveryRule deliveryRule = DeliveryRule
                .from(costPerDelivery, costPerProduct, fixedCost);

        BigDecimal amount = deliveryRule.apply(numberOfDeliveries, numberOfProducts);

        Assert.assertEquals(BigDecimal.valueOf(15.99), amount);
    }

}