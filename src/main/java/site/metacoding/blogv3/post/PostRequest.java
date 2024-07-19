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


}
