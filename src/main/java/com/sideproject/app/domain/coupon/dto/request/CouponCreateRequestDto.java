package com.sideproject.app.domain.coupon.dto.request;

import com.sideproject.app.domain.coupon.enums.CouponStatus;
import com.sideproject.app.domain.coupon.enums.CouponType;
import com.sideproject.app.domain.model.Coupon;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CouponCreateRequestDto {

    private String couponCode;

    private String couponName;

    private CouponType couponType;

    public Coupon toEntity() {
        return Coupon.builder()
                .couponCode(couponCode)
                .couponName(couponName)
                .couponStatus(CouponStatus.UNUSED)
                .couponType(couponType)
                .build();
    }
}