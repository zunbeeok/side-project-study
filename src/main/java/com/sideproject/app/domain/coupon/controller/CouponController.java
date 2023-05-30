package com.sideproject.app.domain.coupon.controller;

import com.sideproject.app.domain.coupon.dto.CouponDetailsDto;
import com.sideproject.app.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/coupon")
@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/{couponId}")
    public ResponseEntity<?> getCoupon(@PathVariable Long couponId) {
        CouponDetailsDto detailsDto = couponService.getCoupon(couponId);
        return new ResponseEntity<>(detailsDto, HttpStatus.OK);
    }
}