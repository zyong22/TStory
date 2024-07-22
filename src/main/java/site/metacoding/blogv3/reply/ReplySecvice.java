package site.metacoding.blogv3.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.post.PostRepository;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserRepository;

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
                .build());
    }

    @Transactional
    public void deleteReply(Integer replyId, Integer id) {
        replyRepository.deleteByIdAndUserId(replyId, id);
    }
}
