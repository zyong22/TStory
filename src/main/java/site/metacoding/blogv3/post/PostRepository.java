package site.metacoding.blogv3.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    // 아이디로 내가 쓴 글 목록 찾음, 최신순으로 역정렬
    @Query("""
        SELECT new site.metacoding.blogv3.post.PostResponse$UserPostDTO(p.id, p.title, p.content, p.user) FROM Post p WHERE p.user.id = :userId ORDER BY p.id DESC
""")
    Page<PostResponse.UserPostDTO> findByUserId(Integer userId, Pageable pageable);

    @Query("""
        SELECT p FROM Post p LEFT JOIN FETCH p.replyList WHERE p.id = :postId
""")
    Post findByPostWithReply(Integer postId);

    // 게시글 ID와 사용자 ID를 기반으로 게시글 삭제
    void deleteByIdAndUserId(Integer postId, Integer userId);
}
