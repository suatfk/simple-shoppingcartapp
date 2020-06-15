package com.sc.app.boundary.mapper;

import com.sc.app.boundary.dto.CouponDto;
import com.sc.app.domain.discount.Coupon;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CouponMapper {

    Coupon map(CouponDto couponDto);

    CouponDto map(Coupon coupon);

    List<CouponDto> map(List<Coupon> coupons);

}
