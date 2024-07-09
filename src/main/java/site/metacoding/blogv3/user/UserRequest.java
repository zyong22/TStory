package site.metacoding.blogv3.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }

    @Data
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;
    }

    @Data
    public static class UpdatePasswordDTO {
        private String oldPassword;
        private String newPassword;
    }
}
