package site.metacoding.blogv3.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.post.PostRepository;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplySecvice {

    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    
    @Transactional
    public void saveReply(Integer id, ReplyRequest.SaveReplyDTO saveReplyDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));
        Post post = postRepository.findById(saveReplyDTO.getPostId()).orElseThrow(() -> new RuntimeException("게시글 정보가 존재하지 않습니다."));
        
        replyRepository.save(Reply.builder()
                .user(user)
                .post(post)
                .content(saveReplyDTO.getContent())
                .createdAt(LocalDateTime.now())
                .build());
    }

    @Transactional
    public void deleteReply(ReplyRequest.DeleteReplyDTO deleteReplyDTO, Integer id) {
        Reply reply = replyRepository.findById(deleteReplyDTO.getReplyId()).orElseThrow(() -> new RuntimeException("존재하지 않는 댓글입니다"));
        Post post = postRepository.findById(deleteReplyDTO.getPostId()).orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
        if (id != deleteReplyDTO.getUserId()) throw new RuntimeException("댓글 삭제 권한이 없습니다");

        replyRepository.deleteById(deleteReplyDTO.getReplyId());
    }

    @Transactional
    public void updateReply(Integer id, ReplyRequest.UpdateReplyDTO updateReplyDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));
        Post post = postRepository.findById(updateReplyDTO.getPostId()).orElseThrow(() -> new RuntimeException("게시글 정보가 존재하지 않습니다."));

        replyRepository.save(Reply.builder()
                .id(updateReplyDTO.getReplyId())
                .user(user)
                .post(post)
                .content(updateReplyDTO.getNewContent())
                .createdAt(LocalDateTime.now())
                .build());
    }
}
