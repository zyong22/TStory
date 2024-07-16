package site.metacoding.blogv3.Community;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

public class CommRequest {

    @Data
    public static class CommDTO{
        private Integer categoryId;
        private String content;
        private String title;
    }
}
