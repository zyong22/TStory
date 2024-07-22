package site.metacoding.blogv3.reply;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.metacoding.blogv3.user.User;

@RequiredArgsConstructor
@Controller
public class ReplyController {
    private final ReplySecvice replySecvice;
    private final HttpSession session;

    @PostMapping("/reply/save")
    public ResponseEntity<?> saveReply(@RequestBody ReplyRequest.SaveReplyDTO saveReplyDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        replySecvice.saveReply(sessionUser.getId(), saveReplyDTO);

        System.out.println("============================" + saveReplyDTO);

        return ResponseEntity.ok().body("{\"message\": \"댓글 등록 완료\"}");
    }

    // 삭제
    @DeleteMapping("/reply/delete/{replyId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer replyId) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        replySecvice.deleteReply(replyId, sessionUser.getId());

        return ResponseEntity.ok().body("{\"message\": \"게시글 삭제 완료\"}");
    }

}
