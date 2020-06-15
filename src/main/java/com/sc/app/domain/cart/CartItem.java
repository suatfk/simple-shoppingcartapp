package com.sc.app.domain.cart;

import com.sc.app.domain.category.Category;
import com.sc.app.domain.model.BaseEntity;
import com.sc.app.domain.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cart_item")
public class CartItem extends BaseEntity {

    @Column(name = "quantity", precision = 3)
    private BigDecimal quantity;

    @Column(name = "unit_price", precision = 9, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "total_price", precision = 9, scale = 2)
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;

    public static CartItem from(Product product, ShoppingCart shoppingCart, BigDecimal quantity){
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setShoppingCart(shoppingCart);
        cartItem.setQuantity(quantity);
        cartItem.setUnitPrice(product.getPrice());
        cartItem.setTotalPrice(product.getPrice().multiply(quantity));
        return cartItem;
    }

    public boolean isSameProduct(Product product){
        return getProduct().equals(product);
    }

    public Category getCategory(){
        return product.getCategory();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
