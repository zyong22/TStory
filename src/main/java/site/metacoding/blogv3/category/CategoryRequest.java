package site.metacoding.blogv3.category;

import lombok.Builder;
import lombok.Data;

public class CategoryRequest {

    @Data
    public static class addCategoryDTO{
        private String categoryName;
    }

}
