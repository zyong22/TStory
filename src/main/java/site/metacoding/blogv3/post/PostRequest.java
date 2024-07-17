package site.metacoding.blogv3.post;

import lombok.Data;

public class PostRequest {

    @Data
    public static class AddPostDTO {
        private Integer categoryId;
        private String content;
        private String title;
    }

    // 게시글 + 댓글
    @Data
    public static class PostWithReplyDTO {

    }
}
