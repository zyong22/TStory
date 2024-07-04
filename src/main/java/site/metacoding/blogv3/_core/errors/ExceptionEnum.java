package site.metacoding.blogv3._core.errors;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    LOGIN_FAIL_EXCEPTION("아이디 혹은 비밀번호가 일치하지 않습니다");

    private String value;

    ExceptionEnum(String value) {
        this.value = value;
    }
}
