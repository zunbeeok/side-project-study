package com.sideproject.app.domain.coupon.service;

import com.sideproject.app.domain.coupon.dto.CouponDetailsDto;
import com.sideproject.app.domain.coupon.repository.CouponRepository;
import com.sideproject.app.domain.model.Coupon;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Transactional(readOnly = true)
    @Override
    public CouponDetailsDto getCoupon(Long couponId) {
        log.info("coupon service getCoupon run...");
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("쿠폰이 존재하지 않습니다."));
        return CouponDetailsDto.from(coupon);
    }

}