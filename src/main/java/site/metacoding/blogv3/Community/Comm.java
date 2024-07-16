package site.metacoding.blogv3.Community;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "comm_tb")
@Entity
public class Comm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    // Large Object, 큰 크기의 데이터를 담는데 사용됨. 내용 + 사진이라서 길다
    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Comm(Integer id, String title, String content, User user, Boolean isPostOwner, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.createdAt = createdAt;
    }
}
