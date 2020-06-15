package com.sc.app.boundary.controller;

import com.sc.app.boundary.dto.CartItemDto;
import com.sc.app.boundary.dto.DeliveryRuleDto;
import com.sc.app.boundary.dto.ShoppingCartDto;
import com.sc.app.boundary.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/shoppingCart")
@RestController
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping(value = "/print", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ShoppingCartDto> print() {
        ShoppingCartDto output = shoppingCartService.print();
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/addItem", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ShoppingCartDto> addItem(@RequestBody CartItemDto cartItemDto) {
        ShoppingCartDto output = shoppingCartService.addItem(cartItemDto);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/removeItem", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ShoppingCartDto> removeItem(@RequestBody CartItemDto cartItemDto) {
        ShoppingCartDto output = shoppingCartService.removeItem(cartItemDto);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/applyCampaign", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ShoppingCartDto> applyCampaign(@RequestBody Long campaignId) {
        ShoppingCartDto output = shoppingCartService.applyCampaign(campaignId);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/applyCoupon", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ShoppingCartDto> applyCoupon(@RequestBody Long couponId) {
        ShoppingCartDto output = shoppingCartService.applyCoupon(couponId);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/applyDelivery", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ShoppingCartDto> applyDelivery(@RequestBody DeliveryRuleDto deliveryRuleDto) {
        ShoppingCartDto output = shoppingCartService.applyDelivery(deliveryRuleDto);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
