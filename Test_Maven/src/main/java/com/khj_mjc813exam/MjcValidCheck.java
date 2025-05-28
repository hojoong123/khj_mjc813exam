package com.khj_mjc813exam;

import java.util.regex.Pattern;

public class MjcValidCheck {
    public boolean isValidPhoneNumber(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return Pattern.matches("^010-\\d{4}-\\d{4}$", text);
    }

    // 우편번호: 5자리 숫자이고 0으로 시작하지 않는 경우 확인
    public boolean isValidZipNumber(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return Pattern.matches("^[1-9]\\d{4}$", text);
    }

    // 이메일: 일반적인 형식을 만족하는지 확인
    public boolean isValidEmail(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", text);
    }
}
