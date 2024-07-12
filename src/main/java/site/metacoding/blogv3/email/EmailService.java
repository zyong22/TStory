package site.metacoding.blogv3.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private static final Random random = new Random();
    private static final int CODE_LENGTH = 6;

    // 메일 보낸 후 코드 반환
    public String sendEmail(String email) {
        String code = checkRandomCode();
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email); // 이메일 수신자
        message.setSubject("인증번호 메일입니다."); // 제목
        message.setText("인증번호 : " + code); // 본문
        mailSender.send(message);

        return code;
    }

    // 6자리 랜덤수 String 변환
    private String checkRandomCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);

        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(random.nextInt(10)); // 0에서 9 사이의 무작위 숫자 추가
        }

        return code.toString();
    }
}
