package site.metacoding.blogv3.post;

import lombok.Data;
import site.metacoding.blogv3.reply.Reply;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostResponse {

    // 유저 게시글 리스트 DTO
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
        private List<ReplyDTO> replies = new ArrayList<>();

        public PostDetailDTO(Post post, List<Reply> replies) {
            this.post = new PostDTO(post);
            this.replies = replies.stream()
                    .map(ReplyDTO::new)
                    .toList();
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

        @Data
        public static class ReplyDTO {
            private Integer id;
            private Integer userId;
            private String userName;
            private String content;

            public ReplyDTO(Reply reply) {
                this.id = reply.getId();
                this.userId = reply.getUser().getId();
                this.content = reply.getContent();
                this.userName = reply.getUser().getUsername();
            }
        }
    }
}
