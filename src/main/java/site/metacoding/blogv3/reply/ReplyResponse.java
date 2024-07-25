package site.metacoding.blogv3.reply;

import lombok.Data;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.post.PostResponse;

import java.util.ArrayList;
import java.util.List;

public class ReplyResponse {

    // 댓글 출력용
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

