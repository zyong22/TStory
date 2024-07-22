package site.metacoding.blogv3.reply;

import lombok.Data;

public class ReplyRequest {

    // 댓글 저장 DTO
    @Data
    public static class SaveReplyDTO {
        private Integer postId;
        private String content;

        public SaveReplyDTO(Integer postId, String content) {
            this.postId = postId;
            this.content = content;
        }
    }
}
