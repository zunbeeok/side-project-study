package com.sideproject.app.domain.coupon.service;

import com.sideproject.app.domain.coupon.dto.CouponDetailsDto;

public interface CouponService {
    CouponDetailsDto getCoupon(Long couponId);
}