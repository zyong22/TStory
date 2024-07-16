package site.metacoding.blogv3.email;

import lombok.Data;

public class EmailRequest {

    @Data
    public static class CheckCodeDTO {
        private String inputCode;
    }
}
