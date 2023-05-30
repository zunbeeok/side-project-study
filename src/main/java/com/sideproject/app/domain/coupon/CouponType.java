package com.sideproject.app.domain.coupon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CouponType {

    KOR("한국"),
    ENG("영어");

    private final String description;
}