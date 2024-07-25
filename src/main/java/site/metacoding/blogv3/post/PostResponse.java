package site.metacoding.blogv3.post;

import lombok.Data;
import site.metacoding.blogv3.reply.Reply;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostResponse {

    @Data
    public static class MainPageDTO {
        private Integer id;
        private String title;
        private String content;
        private String userName;
        private LocalDateTime createdAt;

        public MainPageDTO(Integer id, String title, String content, String userName, LocalDateTime createdAt) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.userName = userName;
            this.createdAt = createdAt;
        }

        public String getFormattedDate() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return this.createdAt.format(formatter);
        }
    }

    // 유저 게시글, 리스트 DTO
    @Data
    public static class UserPostDTO {
        private Integer id;
        private String title;
        private String content;
        private User user;

        public UserPostDTO(Integer id, String title, String content, User user) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.user = user;
        }
    }

    // 게시글 + 댓글 DTO
    @Data
    public static class PostDetailDTO {
        private PostDTO post;

        public PostDetailDTO(Post post, List<Reply> replies) {
            this.post = new PostDTO(post);
        }

        @Data
        public static class PostDTO {
            private Integer id;
            private String userName;
            private String title;
            private String content;
            private String  createdAt;

            public PostDTO(Post post) {
                this.id = post.getId();
                this.userName = post.getUser().getUsername();
                this.title = post.getTitle();
                this.content = post.getContent();
                this.createdAt = formatDate(post.getCreatedAt());
            }

            private String formatDate(LocalDateTime dateTime) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return dateTime.format(formatter);
            }
        }
    }
}
