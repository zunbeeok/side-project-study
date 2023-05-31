package com.sideproject.app.domain.coupon.service;

import com.sideproject.app.domain.coupon.dto.response.CouponDetailsDto;

public interface CouponService {
    CouponDetailsDto getCoupon(Long couponId);
}