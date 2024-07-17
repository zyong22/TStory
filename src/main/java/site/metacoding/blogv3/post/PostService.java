package site.metacoding.blogv3.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.category.Category;
import site.metacoding.blogv3.category.CategoryRepository;
import site.metacoding.blogv3.reply.Reply;
import site.metacoding.blogv3.reply.ReplyRepository;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ReplyRepository replyRepository;

    // 게시글 쓰기
    @Transactional
    public void savePost(Integer id, PostRequest.AddPostDTO postDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));
        Category category = categoryRepository.findById(postDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

//        Comm comm = new Comm();
//        comm.setUser(user);
//        comm.setTitle(commDTO.getTitle());
//        comm.setContent(commDTO.getContent());
//        comm.setCategory(category);
//
//        commRepository.save(comm);

        postRepository.save(Post.builder()
                .user(user)
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .category(category)
                .build());
    }

    // 게시글 찾아오기
    @Transactional
    public List<Post> findPost(Integer id) {
        List<Post> posts = postRepository.findByUserId(id);
        // 최신순으로 정렬할거니까 역정렬
        Collections.reverse(posts);

        return posts;
    }

    // 게시글, 댓글도 가져와야할듯
    @Transactional
    public PostResponse.PostDetailDTO findPostDetail(Integer postId) {

        Post post = postRepository.findByPostWithReply(postId);
        List<Reply> replies = replyRepository.findByPostId(postId);

        return new PostResponse.PostDetailDTO(post, replies);
    }
}
