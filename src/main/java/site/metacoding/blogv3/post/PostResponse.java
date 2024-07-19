package site.metacoding.blogv3.post;

import lombok.Data;
import site.metacoding.blogv3.reply.Reply;
import site.metacoding.blogv3.user.User;

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
            private String title;
            private String content;

            public PostDTO(Post post) {
                this.id = post.getId();
                this.title = post.getTitle();
                this.content = post.getContent();
            }
        }

        @Data
        public static class ReplyDTO {
            private Integer id;
            private Integer userId;
            private String reply;

            public ReplyDTO(Reply reply) {
                this.id = reply.getId();
                this.reply = reply.getReply();
                this.userId = reply.getUser().getId();
            }
        }
    }
}
