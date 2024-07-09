package site.metacoding.blogv3.user;

import lombok.Data;

public class UserResponse {

    // 유저폼에서 username, email 출력 DTO
    @Data
    public static class ShowUpdateDTO{
        private Integer id;
        private String username;
        private String email;

        public ShowUpdateDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
        }
    }
}
