package site.metacoding.blogv3.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    // 아이디로 카테고리 목록 찾음, 최신순으로 역정렬
    @Query("SELECT p FROM Post p WHERE p.user.id = :userId ORDER BY p.id DESC")
    Page<Post> findByUserId(Integer userId, Pageable pageable);

    @Query("""
        SELECT p FROM Post p LEFT JOIN FETCH p.replyList WHERE p.id = :postId
""")
    Post findByPostWithReply(Integer postId);
}
