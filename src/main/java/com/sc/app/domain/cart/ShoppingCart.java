package com.sc.app.domain.cart;


import com.sc.app.domain.category.Category;
import com.sc.app.domain.delivery.Deliverable;
import com.sc.app.domain.delivery.DeliveryRule;
import com.sc.app.domain.model.BaseEntity;
import com.sc.app.domain.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart extends BaseEntity implements Deliverable {

    @Column(name = "campaign_discount")
    private BigDecimal campaignDiscount = BigDecimal.ZERO;

    @Column(name = "coupon_discount")
    private BigDecimal couponDiscount = BigDecimal.ZERO;

    @Column(name = "delivery_cost", precision = 9, scale = 2)
    private BigDecimal deliveryCost;

    @Column(name = "total_price", scale = 2, precision = 9)
    private BigDecimal totalPrice;

    @Column(name = "final_price", scale = 2, precision = 9)
    private BigDecimal finalPrice;

    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CartItem> cartItems = new HashSet<>();

    @Transient
    private DeliveryRule deliveryRule;

    @Override
    public int getNumberOfDeliveries() {
        return getDistinctItemCategories().size();
    }

    @Override
    public int getNumberOfProducts() {
        return cartItems.size();
    }

    public Set<Category> getDistinctItemCategories() {
        return cartItems.stream().map(CartItem::getCategory).collect(Collectors.toSet());
    }

    public void addToCart(Product product, BigDecimal quantity) {
        Optional<CartItem> first = cartItems.stream().filter(cartItem -> cartItem.isSameProduct(product)).findFirst();
        if (first.isPresent()){
            CartItem cartItem = first.get();
            cartItem.setQuantity(cartItem.getQuantity().add(quantity));
        }else{
            cartItems.add(CartItem.from(product, this, quantity));
        }
    }

    private void calculatePrices() {
        setTotalPrice(getCartItems().stream().map(CartItem::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        setDeliveryCost(deliveryRule.apply(this));
        setFinalPrice(getTotalPrice().add(getDeliveryCost()).subtract(getCampaignDiscount()).subtract(getCouponDiscount()));
    }

    public BigDecimal getCampaignDiscount() {
        return campaignDiscount;
    }

    public void setCampaignDiscount(BigDecimal campaignDiscount) {
        this.campaignDiscount = campaignDiscount;
    }

    public BigDecimal getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(BigDecimal couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
