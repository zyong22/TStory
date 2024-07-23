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

    @PutMapping("/reply/update")
    public ResponseEntity<?> updateReply(@RequestBody ReplyRequest.UpdateReplyDTO updateReplyDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        replySecvice.updateReply(sessionUser.getId(), updateReplyDTO);

        return ResponseEntity.ok().body("{\"message\": \"댓글 수정 완료\"}");
    }

    @PostMapping("/reply/save")
    public ResponseEntity<?> saveReply(@RequestBody ReplyRequest.SaveReplyDTO saveReplyDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        replySecvice.saveReply(sessionUser.getId(), saveReplyDTO);

        return ResponseEntity.ok().body("{\"message\": \"댓글 등록 완료\"}");
    }

    // 삭제
    @DeleteMapping("/reply/delete")
    public ResponseEntity<?> deletePost(@RequestBody ReplyRequest.DeleteReplyDTO deleteReplyDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        replySecvice.deleteReply(deleteReplyDTO, sessionUser.getId());

        return ResponseEntity.ok().body("{\"message\": \"댓글 삭제 완료\"}");
    }

}
