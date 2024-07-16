package site.metacoding.blogv3.email;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private HttpSession session;


    @GetMapping("/email/send")
    public ResponseEntity<?> sendVerificationEmail(@RequestParam String email) {

        try {
            String emailCode = emailService.sendEmail(email);

            session.setAttribute("emailCode", emailCode);
            
            return ResponseEntity.ok().body("전송 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    // 세션에 저장된 코드 값, 입력한 코드 값 비교
    @PostMapping("/email/check")
    public ResponseEntity<?> checkEmailCode(@RequestBody EmailRequest.CheckCodeDTO checkCodeDTO) {
        String emailCode = (String) session.getAttribute("emailCode");

        if (emailCode == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"세션을 찾을 수 없음\"}");
        }

        if (emailCode.equals(checkCodeDTO.getInputCode())) {
            return ResponseEntity.ok().body("{\"sessionCode\": \"인증 완료\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"인증 실패\"}");
        }
    }
}
