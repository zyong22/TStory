package site.metacoding.blogv3.Community;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.metacoding.blogv3.user.User;

@RequiredArgsConstructor
@Controller
public class CommController {

    private final CommService commService;
    private final HttpSession session;

    @PostMapping("/post/write")
    public @ResponseBody String writeTest(CommRequest.CommDTO commDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");

        commService.saveComm(sessionUser, commDTO);

        return commDTO.toString();
    }
}
