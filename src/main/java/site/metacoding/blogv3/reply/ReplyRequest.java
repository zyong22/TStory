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

    // 댓글 삭제 DTO
    @Data
    public static class DeleteReplyDTO {
        private Integer postId;
        private Integer userId;
        private Integer replyId;
    }

    // 댓글 수정 DTO
    @Data
    public static class UpdateReplyDTO {
        private Integer postId;
        private Integer replyId;
        private String newContent;
    }
}
