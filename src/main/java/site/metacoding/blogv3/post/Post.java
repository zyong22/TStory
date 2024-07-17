package site.metacoding.blogv3.post;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.metacoding.blogv3.category.Category;
import site.metacoding.blogv3.reply.Reply;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Table(name = "post_tb")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    // Large Object, 큰 크기의 데이터를 담는데 사용됨. 내용 + 사진이라서 길다
    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Reply> replyList = new ArrayList<>();

    @Builder
    public Post(Integer id, String title, String content, User user, Category category, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.category = category;
        this.createdAt = createdAt;
    }
}
