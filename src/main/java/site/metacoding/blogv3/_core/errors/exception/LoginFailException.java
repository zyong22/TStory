package site.metacoding.blogv3._core.errors.exception;

import site.metacoding.blogv3._core.errors.ExceptionEnum;

public class LoginFailException extends RuntimeException {

    public LoginFailException() {
        super(ExceptionEnum.LOGIN_FAIL_EXCEPTION.getValue());
    }
}
