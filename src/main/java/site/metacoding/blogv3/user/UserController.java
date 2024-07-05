package site.metacoding.blogv3.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class UserController {

    private final HttpSession session;
    private final UserService userService;

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO) {
        userService.join(requestDTO);

        return "redirect:/";
    }

    // join폼 열기
    @GetMapping("/join-form")
    public String joinForm() {

        return "user/joinForm";
    }

    // login폼 열기
    @GetMapping("/login-form")
    public String loginForm() {

        return "user/loginForm";
    }

    // 로그인하기
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {
        User sessionUser = userService.login(requestDTO);
        session.setAttribute("sessionUser", sessionUser);

        return "redirect:/";
    }

    @GetMapping("/user/password-reset-form")
    public String passwordResetForm() {

        return "user/passwordResetForm";
    }

    @GetMapping("/user/update-form")
    public String updateForm() {

        return "user/updateForm";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

}
