package site.metacoding.blogv3.reply;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    List<Reply> findByPostId(Integer postId);

    @Query("""
        SELECT new site.metacoding.blogv3.reply.ReplyResponse$ReplyDTO(r) 
        FROM Reply r 
        WHERE r.post.id = :postId
    """)
    List<ReplyResponse.ReplyDTO> findPostWithReplies(Integer postId);
}
