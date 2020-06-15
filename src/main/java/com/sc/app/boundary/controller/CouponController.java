package com.sc.app.boundary.controller;

import com.sc.app.boundary.dto.CouponDto;
import com.sc.app.boundary.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/coupons")
@RestController
public class CouponController {

    private CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CouponDto> findCouponById(@PathVariable Long id) {
        CouponDto output = couponService.findById(id);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CouponDto> save(@RequestBody CouponDto couponDto) {
        CouponDto output = couponService.save(couponDto);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
