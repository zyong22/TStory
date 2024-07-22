package site.metacoding.blogv3.post;

import lombok.Data;

public class PostRequest {

    @Data
    public static class AddPostDTO {
        private Integer categoryId;
        private String content;
        private String title;

        public AddPostDTO(Integer categoryId, String content, String title) {
            this.categoryId = categoryId;
            this.content = content;
            this.title = title;
        }
    }

    // 수정 DTO
    @Data
    public static class UpdatePostDTO {
        private Integer PostId;
        private String newTitle;
        private String newContent;

        public UpdatePostDTO(Integer PostId, String newTitle, String newContent) {
            this.PostId = PostId;
            this.newTitle = newTitle;
            this.newContent = newContent;
        }
    }
}
