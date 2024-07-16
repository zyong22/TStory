package site.metacoding.blogv3.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;


@RequiredArgsConstructor
@Controller
public class UserController {

    private final HttpSession session;
    private final UserService userService;

    // 유저네임 중복체크
    @PostMapping("/user/check")
    public ResponseEntity<?> check(@RequestBody UserRequest.CheckIdDTO checkId ) {
        boolean check = userService.checkId(checkId.getUsername());
        return ResponseEntity.ok(check);
    }

    // 비밀번호 변경하기
    @PutMapping("/user/update")
    public ResponseEntity<String> updateUser(@RequestBody UserRequest.UpdatePasswordDTO updateDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        try {
            userService.update(sessionUser.getId(), updateDTO);
            session.invalidate(); // 로그아웃 시키고 다시 로그인 폼
            return ResponseEntity.ok().body("{\"message\": \"비밀번호 변경 완료\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    // 비밀번호 변경 폼 열기
    @GetMapping("/user/updateFrom")
    public String updateForm(Model model) throws Exception {
        User sessionUser = (User) session.getAttribute("sessionUser");

        UserResponse.ShowUpdateDTO updateDTO = userService.showUpdate(sessionUser.getId());

        model.addAttribute("user", updateDTO);

        return "/user/updateForm";
    }

    // join폼 열기
    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/joinForm";
    }

    // login폼 열기
    @GetMapping("/login-form")
    public String loginForm() {
        return "/user/loginForm";
    }

    // write폼 열기
    @GetMapping("/write-form")
    public String writeForm() {
        return "/post/writeForm";
    }

    // 회원가입
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO) {
        userService.join(requestDTO);

        return "redirect:/";
    }

    // 로그인
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {
        User sessionUser = userService.login(requestDTO);
        session.setAttribute("sessionUser", sessionUser);

        return "redirect:/";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

}
