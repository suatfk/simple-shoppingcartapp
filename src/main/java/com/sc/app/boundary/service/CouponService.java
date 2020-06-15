package com.sc.app.boundary.service;

import com.sc.app.boundary.dto.CouponDto;
import com.sc.app.boundary.dto.ProductDto;
import com.sc.app.boundary.mapper.CouponMapper;
import com.sc.app.domain.discount.Coupon;
import com.sc.app.domain.discount.CouponRepository;
import com.sc.app.domain.product.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CouponService {

    private CouponRepository couponRepository;

    private CouponMapper couponMapper;

    public CouponService(CouponRepository couponRepository, CouponMapper couponMapper) {
        this.couponRepository = couponRepository;
        this.couponMapper = couponMapper;
    }

    public CouponDto findById(Long id) {
        Coupon coupon = couponRepository.findById(id).orElse(null);
        return couponMapper.map(coupon);
    }

    @Transactional
    public CouponDto save(CouponDto couponDto) {
        Coupon coupon = couponMapper.map(couponDto);
        coupon = couponRepository.save(coupon);
        return couponMapper.map(coupon);
    }
}
