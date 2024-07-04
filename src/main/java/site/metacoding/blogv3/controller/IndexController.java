package site.metacoding.blogv3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String main() {

        return "main";
    }

    @GetMapping("/category/write-form")
    public String writeForm() {

        return "category/writeForm";
    }

    @GetMapping("/post/detail")
    public String postDetail() {

        return "post/detail";
    }

    @GetMapping("/post/list")
    public String postList() {

        return "post/list";
    }

    @GetMapping("/post/write-form")
    public String postWriteForm() {

        return "post/writeForm";
    }

    @GetMapping("/join-form")
    public String joinForm() {

        return "user/joinForm";
    }

    @GetMapping("/login-form")
    public String loginForm() {

        return "user/loginForm";
    }

    @GetMapping("/user/password-reset-form")
    public String passwordResetForm() {

        return "user/passwordResetForm";
    }

    @GetMapping("/user/update-form")
    public String updateForm() {

        return "user/updateForm";
    }
}
