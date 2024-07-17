package site.metacoding.blogv3.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    // 아이디로 카테고리 목록 찾음
    List<Post> findByUserId(Integer userId);

    @Query("""
        SELECT p FROM Post p LEFT JOIN FETCH p.replyList WHERE p.id = :postId
""")
    Post findByPostWithReply(Integer postId);
}
