package site.metacoding.blogv3.reply;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "reply_tb")
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reply;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
